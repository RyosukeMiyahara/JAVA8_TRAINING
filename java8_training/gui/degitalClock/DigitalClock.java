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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DigitalClock extends Application {
  String formattedPrintTime = "00:00:00";
  Label time;

  VBox root;

  String fontType = "Times New Roman";
  int    fontSize = 128;
  String fontColor = "Black";
  String backgroundColor = "White";

  String tmpFontType = "Times New Roman";
  int    tmpFontSize = 128;
  String tmpFontColor = "Black";
  String tmpBackgroundColor = "White";

  Scene scene;
  Text timeForFontMetrics;

  double sideFrame;
  double topFrame;

  public void start(Stage stage) {
    // Create setting dialog
    // Dialog<Pair<String, String>> dialog = createSettingDialog();
    Dialog<ButtonType> dialog = createSettingDialog();

    // Create Menu bar
    MenuBar menuBar = createMenuBar(dialog);

    // Initialize clock
    ZonedDateTime currentTime = ZonedDateTime.now();
    formattedPrintTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(currentTime);
    time = new Label(formattedPrintTime);
    time.setFont(new Font(fontType, fontSize));
    time.setTextFill(Color.web(fontColor));
    timeForFontMetrics = new Text(formattedPrintTime);

    // For update
    Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        // printTime = DateTimeFormatter.ISO_LOCAL_TIME.format(currentTime);
        formattedPrintTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(currentTime);
        time.setText(formattedPrintTime);
        timeForFontMetrics.setText(formattedPrintTime);
        time.setFont(new Font(fontType, fontSize));
        time.setTextFill(Color.web(fontColor));
        timeForFontMetrics.setFont(new Font(fontType, fontSize));
        stage.setWidth(timeForFontMetrics.getLayoutBounds().getWidth() + sideFrame * 2);
        stage.setHeight(timeForFontMetrics.getLayoutBounds().getHeight() + topFrame + menuBar.getHeight());
        root.setStyle("-fx-background-color: " + backgroundColor + ";");
      }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();

    // Show
    root = new VBox();
    root.setStyle("-fx-background-color: " + backgroundColor + ";");
    root.setFillWidth(true);
    root.getChildren().add(menuBar);
    root.getChildren().add(time);
    scene = new Scene(root);
    stage.setResizable(false);
    stage.setScene(scene);
    stage.setTitle("Digital Clock 8");
    stage.show();

    // Get frame size
    sideFrame = scene.getWindow().getWidth() - scene.getWidth();
    topFrame = scene.getWindow().getHeight() - scene.getHeight();
  }

  /**
   * Create setting dialog for digital clock
   * @return created dialog
   */
  // private Dialog<Pair<String, String>> createSettingDialog() {
  private Dialog<ButtonType> createSettingDialog() {
    // Dialog<Pair<String, String>> dialog;
    Dialog<ButtonType> dialog;
    dialog = new Dialog<>();

    GridPane dialogPane = new GridPane();

    // Font type
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    ObservableList<String> fontTypeOptions = FXCollections.observableArrayList(fonts);
    ComboBox<String> fontTypeComboBox = new ComboBox<String>(fontTypeOptions);
    fontTypeComboBox.setValue("Times New Roman");
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
    dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
    dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

    // Set content
    dialog.getDialogPane().setContent(dialogPane);



    // Set actions
    dialog.setOnCloseRequest((eh)-> {
      switch (dialog.getResult().getButtonData()) {
      case OK_DONE:
        fontType = fontTypeComboBox.getValue();
        fontSize = fontSizeComboBox.getValue();
        fontColor = fontColorComboBox.getValue();
        backgroundColor = backgroundColorComboBox.getValue();
        break;
      case CANCEL_CLOSE:
        fontTypeComboBox.setValue(tmpFontType);
        fontSizeComboBox.setValue(tmpFontSize);
        fontColorComboBox.setValue(tmpFontColor);
        backgroundColorComboBox.setValue(tmpBackgroundColor);
        break;
      default:
        System.err.println("Unexpected case...");
      }
    });


    return dialog;
  }

  /**
   * Create menu bar for digital clock
   * @param dialog this dialog is shown when "Setting" on menu is clicked
   * @return created menu bar
   */
  // private MenuBar createMenuBar(Dialog<Pair<String, String>> dialog) {
  private MenuBar createMenuBar(Dialog<ButtonType> dialog) {
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
    settingItem.setOnAction((eh) -> {
      tmpFontType = fontType;
      tmpFontSize = fontSize;
      tmpFontColor = fontColor;
      tmpBackgroundColor = backgroundColor;
      dialog.show();
    });
    exitItem.setOnAction((eh)->Platform.exit());

    return menuBar;

  }

  public static void main(String[] args) {
    launch(args);
  }

}
