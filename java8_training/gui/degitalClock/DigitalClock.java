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
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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

  int fontSize = 128;
  Scene scene;
  Text text;

  double sideFrame;

  public void start(Stage stage) {
    // Create setting dialog
    Dialog<Pair<String, String>> dialog = createSettingDialog();

    // Create Menu bar
    MenuBar menuBar = createMenuBar(dialog);

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



    sideFrame = scene.getWindow().getWidth() - scene.getWidth();
  }

  private Dialog<Pair<String, String>> createSettingDialog() {
    Dialog<Pair<String, String>> dialog;
    dialog = new Dialog<>();

    GridPane dialogPane = new GridPane();

    // Font type
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    ObservableList<String> fontTypeOptions = FXCollections.observableArrayList(fonts);
    ComboBox<String> fontTypeComboBox = new ComboBox<String>(fontTypeOptions);
    fontTypeComboBox.setValue("Times New Roman");
    fontTypeComboBox.setOnAction((t) -> System.out.println(fontTypeComboBox.getValue()));
    Label fontTypeLabel = new Label("Font type: ");
    dialogPane.add(fontTypeLabel, 0, 0);
    dialogPane.add(fontTypeComboBox, 1, 0);
    GridPane.setHalignment(fontTypeLabel, HPos.RIGHT);
    GridPane.setHalignment(fontTypeComboBox, HPos.LEFT);

    // Font size
    ObservableList<Integer> fontSizeOptions = FXCollections.observableArrayList(
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    ComboBox<Integer> fontSizeComboBox = new ComboBox<Integer>(fontSizeOptions);
    fontSizeComboBox.setValue(128);
    fontSizeComboBox.setOnAction((t) -> System.out.println(fontSizeComboBox.getValue()));
    Label fontSizeLabel = new Label("Font size: ");
    dialogPane.add(fontSizeLabel, 0, 1);
    dialogPane.add(fontSizeComboBox, 1, 1);
    GridPane.setHalignment(fontSizeLabel, HPos.RIGHT);
    GridPane.setHalignment(fontSizeComboBox, HPos.LEFT);

    // Common color options
    ObservableList<String> colorOptions = FXCollections.observableArrayList(
        "Red", "Green", "Blue", "Yellow", "Magenta", "Cyan", "Black", "White");

    // Font color
    ComboBox<String> fontColorComboBox = new ComboBox<String>(colorOptions);
    fontColorComboBox.setCellFactory((list) -> {return new ColorListCell();});
    fontColorComboBox.setValue("Black");
    Label fontColorLabel = new Label("Font color: ");
    dialogPane.add(fontColorLabel, 0, 2);
    dialogPane.add(fontColorComboBox, 1, 2);
    GridPane.setHalignment(fontColorLabel, HPos.RIGHT);
    GridPane.setHalignment(fontColorComboBox, HPos.LEFT);

    // Background color
    ComboBox<String> backgroundColorComboBox = new ComboBox<String>(colorOptions);
    backgroundColorComboBox.setCellFactory((list)->{return new ColorListCell();});
    backgroundColorComboBox.setValue("White");
    Label backgroundColorLabel = new Label("Background color: ");
    dialogPane.add(backgroundColorLabel, 0, 3);
    dialogPane.add(backgroundColorComboBox, 1, 3);
    GridPane.setHalignment(backgroundColorLabel, HPos.RIGHT);
    GridPane.setHalignment(backgroundColorComboBox, HPos.LEFT);

    // Buttons
    ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
    dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);

    dialog.getDialogPane().setContent(dialogPane);

    return dialog;
  }

  private MenuBar createMenuBar(Dialog<Pair<String, String>> dialog) {
    MenuBar menuBar = new MenuBar();

    // Menu
    Menu menu = new Menu("Menu");

    // MenuItem
    MenuItem settingItem = new MenuItem("Setting...");
    MenuItem exitItem = new MenuItem("Exit");

    // registration
    menu.getItems().add(settingItem);
    menu.getItems().add(exitItem);
    menuBar.getMenus().add(menu);

    // Set action
    settingItem.setOnAction((eh)->dialog.show());
    exitItem.setOnAction((eh)->Platform.exit());

    return menuBar;

  }

  public static void main(String[] args) {
    launch(args);
  }

}
