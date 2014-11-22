package ch04.ex04_10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SimpleWebBrowser extends Application {
  @Override public void start(Stage stage) {
    TextField URLBar = new TextField("http://panda.holy.jp");

    String location = "http://horstmann.com";
    WebView browser = new WebView();
    WebEngine engine = browser.getEngine();
    engine.load(location);

    VBox root = new VBox();
    HBox URLControl = new HBox();

    Button goButton = new Button("Go");
    goButton.setOnAction(event-> {
      engine.load(URLBar.textProperty().getValue());
    });

    Button backButton = new Button("Back");
    backButton.setOnAction(event -> {
      engine.load(engine.getHistory().getEntries().get(engine.getHistory().getCurrentIndex() - 1).getUrl());
    });

    URLControl.getChildren().addAll(URLBar, goButton, backButton);
    root.getChildren().addAll(URLControl, browser);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setWidth(500);
    stage.setHeight(500);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
