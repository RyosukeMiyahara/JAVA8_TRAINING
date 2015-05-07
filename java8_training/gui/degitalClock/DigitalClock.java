package degitalClock;

import java.awt.GraphicsEnvironment;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

public class DigitalClock extends Application {
  String printTime;
  Label time;
  Dialog<Pair<String, String>> dialog;
  int fontSize = 128;
  Scene scene;
  Text text;

  double sideFrame;

  public void start(Stage stage) {
    dialog = new Dialog<>();
    dialog.show();



    // Menu
    Menu settingMenu = new Menu("Setting");
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().add(settingMenu);

    MenuItem exitItem = new MenuItem("Exit");
    settingMenu.getItems().add(exitItem);

    exitItem.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent t) {
        Platform.exit();
      }
    });

    ZonedDateTime currentTime = ZonedDateTime.now();
    printTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(currentTime);

    time = new Label(printTime);
    time.setFont(new Font(fontSize));

    text = new Text(printTime);

    Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        // printTime = DateTimeFormatter.ISO_LOCAL_TIME.format(currentTime);
        printTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(currentTime);
        time.setText(printTime);
        text.setText(printTime);
        time.setFont(new Font(fontSize));
        text.setFont(new Font(fontSize));
        stage.setWidth(text.getLayoutBounds().getWidth() + sideFrame * 2);

      }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();




    VBox root = new VBox();
    root.setFillWidth(true);
    root.getChildren().add(menuBar);
    root.getChildren().add(time);
    scene = new Scene(root);
    stage.setResizable(false);
    stage.setScene(scene);
    stage.setTitle("Digital Clock 8");
    stage.show();


    GridPane dialogPane = new GridPane();

    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    ObservableList<String> fontTypeOptions = FXCollections.observableArrayList(fonts);
    ComboBox<String> fontTypeComboBox = new ComboBox<String>(fontTypeOptions);
    fontTypeComboBox.setOnAction((t) -> System.out.println(fontTypeComboBox.getValue()));
    dialogPane.add(new Label("Font type:"), 0, 0);
    dialogPane.add(fontTypeComboBox, 1, 0);

    ObservableList<Integer> fontSizeOptions = FXCollections.observableArrayList(
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    ComboBox<Integer> fontSizeComboBox = new ComboBox<Integer>(fontSizeOptions);
    fontSizeComboBox.getSelectionModel().select(32);
    fontSizeComboBox.setOnAction((t) -> System.out.println(fontSizeComboBox.getValue()));
    dialogPane.add(new Label("Font size:"), 0, 1);
    dialogPane.add(fontSizeComboBox, 1, 1);
    dialog.getDialogPane().setContent(dialogPane);

    sideFrame = scene.getWindow().getWidth() - scene.getWidth();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
