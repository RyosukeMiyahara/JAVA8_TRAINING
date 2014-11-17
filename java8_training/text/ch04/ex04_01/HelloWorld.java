package ch04.ex04_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {
  public void start(Stage stage) {
    String content = "Hello, JavaFX!";
    Label message = new Label(content);
      message.setFont(new Font(100));

      TextField textField = new TextField(content);
      message.textProperty().bind(textField.textProperty());

      VBox root = new VBox();
      root.getChildren().addAll(message, textField);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Hello");
      stage.show();
   }

  public static void main(String[] args) {
    launch(args);
  }
}
