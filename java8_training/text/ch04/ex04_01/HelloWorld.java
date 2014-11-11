package ch04.ex04_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {
  public void start(Stage stage) {
    Label message = new Label("Hello, JavaFX!");
      message.setFont(new Font(100));

      TextArea textArea = new TextArea();
      textArea.textProperty().bindBidirectional(message.textProperty());

      VBox root = new VBox();
      root.getChildren().addAll(message, textArea);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Hello");
      stage.show();
   }

  public static void main(String[] args) {
    launch(args);
  }
}
