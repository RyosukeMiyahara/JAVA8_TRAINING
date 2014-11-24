package ch04.ex04_08;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLNoJavaFX extends Application implements Initializable{
  @FXML private Label label;
  @FXML private TextField textField;

  public void initialize(URL url, ResourceBundle rb) {
    // label.textProperty().bind(textField.textProperty());
  }

  @Override
  public void start(Stage stage) {
     try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLNoJavaFX.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
     } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(0);
     }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
