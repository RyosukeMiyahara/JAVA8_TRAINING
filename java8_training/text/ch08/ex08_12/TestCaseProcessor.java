package ch08.ex08_12;

import java.lang.reflect.Method;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes({ "ch08.ex08_12.TestCase", "ch08.ex08_12.TestCases" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TestCaseProcessor extends AbstractProcessor
{

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
  {
    ClassLoader cl = this.getClass().getClassLoader();
    for (TypeElement t : annotations) {
      for (Element e : roundEnv.getElementsAnnotatedWith(t)) {
        // System.out.println(e + " " + t);
        try {
          Class<?> c = cl.loadClass(e.getEnclosingElement().toString());
          Method method = c.getMethod(e.getSimpleName().toString(), new Class[] {int.class});
          for (TestCase tc : e.getAnnotationsByType(TestCase.class)) {
            int result = Integer.valueOf(method.invoke(c.newInstance(), tc.params()).toString());
            if (result == tc.expected()) {
              System.out.println("OK");
            } else {
              System.out.println("NG, expected = " + tc.expected() + ", but actual = " + result + " from param: " + tc.params());
            }
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    return true;
  }
}
