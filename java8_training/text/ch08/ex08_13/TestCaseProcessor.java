package ch08.ex08_13;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes({ "ch08.ex08_13.TestCase", "ch08.ex08_13.TestCases" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TestCaseProcessor extends AbstractProcessor
{

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
  {
    ClassLoader cl = this.getClass().getClassLoader();
    for (TypeElement t : annotations) {
      List<Pair<TestCases, Method>> testCases = new LinkedList<Pair<TestCases, Method>>();
      for (Element e : roundEnv.getElementsAnnotatedWith(t)) {
        Method method = null;
        try {
          Class<?> c = cl.loadClass(e.getEnclosingElement().toString());
          method = c.getMethod(e.getSimpleName().toString(), new Class[] {int.class});
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        testCases.add(new Pair<TestCases, Method>(e.getAnnotation(TestCases.class), method));
      }
      if (testCases.size() > 0) {
        try {
          createTester(testCases, t.getSimpleName().toString());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    return true;
  }

  private void createTester(List<Pair<TestCases, Method>> list, String annotation) throws IOException {
    String testerClassName = annotation + "Tester";
    JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(this.getClass().getPackage().getName() +""
        + "." + testerClassName);
    PrintWriter out = new PrintWriter(sourceFile.openWriter());

    out.println("package " + this.getClass().getPackage().getName() + ";");
    out.println("");
    out.println("public class " + testerClassName + " {");
    out.println("  public static void main(String[] args) {");
    for (Pair<TestCases, Method> p: list) {
      String method = p.getValue().getDeclaringClass().getName() +"." + p.getValue().getName();
      for (TestCase t: p.getKey().value()) {
        out.println("    System.out.println(\"params = " + t.params() + ", expected = " + t.expected() + " actual = \" + " + method + "(" + t.params() + "));");
      }
    }
    out.println("  }");
    out.println("}");
    out.close();
    return;
  }
}
