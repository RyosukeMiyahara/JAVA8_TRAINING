package ch04.ex04_06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneSample extends Application{
  public void start(Stage stage) {
    BorderPane pane = new BorderPane();

    Button topButton = new Button("Top");
    BorderPane.setAlignment(topButton, Pos.CENTER);
    pane.setTop(topButton);

    pane.setLeft(new Button("Left"));
    pane.setCenter(new Button("Center"));
    pane.setRight(new Button("Right"));

    Button bottomButton = new Button("Bottom");
    BorderPane.setAlignment(bottomButton, Pos.CENTER);
    pane.setBottom(bottomButton);

    stage.setScene(new Scene(pane));
    stage.show();
 }

  public static void main(String[] args) {
    launch(args);
  }
}
