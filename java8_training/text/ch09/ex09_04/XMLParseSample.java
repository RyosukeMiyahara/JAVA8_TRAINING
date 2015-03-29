package ch09.ex09_04;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParseSample {
  public static void main(String filename) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    DocumentBuilder builder;
    Document doc = null;
    try {
      builder = factory.newDocumentBuilder();
      doc = builder.parse(filename);
    } catch (ParserConfigurationException | IOException | SAXException e) {
      e.printStackTrace();
    }
    System.out.println(doc);


  }
}
