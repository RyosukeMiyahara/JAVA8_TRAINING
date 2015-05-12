package digitalClock;

import java.awt.GraphicsEnvironment;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.prefs.Preferences;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

  Scene scene;
  VBox root;
  Label time;
  Text timeForFontMetrics;

  String fontType;
  int    fontSize;
  String fontColor;
  String backgroundColor;

  String tmpFontType;
  int    tmpFontSize;
  String tmpFontColor;
  String tmpBackgroundColor;

  double sideFrame;
  double topFrame;


  private Preferences prefs = Preferences.userNodeForPackage(this.getClass());


  public void start(Stage stage) {
    // Load params
    fontType = prefs.get("miyahara_font_type", "Times New Roman");
    fontSize = prefs.getInt("miyahara_font_size", 128);
    fontColor = prefs.get("miyahara_font_color", "Black");
    backgroundColor = prefs.get("miyahara_bg_color", "White");
    tmpFontType = fontType;
    tmpFontSize = fontSize;
    tmpFontColor = fontColor;
    tmpBackgroundColor = backgroundColor;
    stage.setX(prefs.getDouble("miyahara_window_x", 100.0));
    stage.setY(prefs.getDouble("miyahara_window_y", 100.0));
    stage.setWidth(prefs.getDouble("miyahara_window_width", 467.125));
    stage.setHeight(prefs.getDouble("miyahara_window_height", 208.75));

    // Create setting dialog
    Dialog<ButtonType> dialog = createSettingDialog();

    // Create Menu bar
    MenuBar menuBar = createMenuBar(dialog, stage);

    // Initialize clock
    formattedPrintTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(ZonedDateTime.now());
    time = new Label(formattedPrintTime);
    time.setFont(new Font(fontType, fontSize));
    time.setTextFill(Color.web(fontColor));
    timeForFontMetrics = new Text(formattedPrintTime);

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

    // To handle closing window
    stage.setOnCloseRequest((eh) -> {
      saveParams(stage);
    });

    // Get frame size
    sideFrame = scene.getWindow().getWidth() - scene.getWidth();
    topFrame = scene.getWindow().getHeight() - scene.getHeight();

    // For update
    Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), (eh) -> {
      formattedPrintTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(ZonedDateTime.now());
      time.setText(formattedPrintTime);
      timeForFontMetrics.setText(formattedPrintTime);
      time.setFont(new Font(fontType, fontSize));
      time.setTextFill(Color.web(fontColor));
      timeForFontMetrics.setFont(new Font(fontType, fontSize));
      stage.setWidth(timeForFontMetrics.getLayoutBounds().getWidth() + sideFrame * 2);
      stage.setHeight(timeForFontMetrics.getLayoutBounds().getHeight() + topFrame + menuBar.getHeight());
      root.setStyle("-fx-background-color: " + backgroundColor + ";");
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();
  }

  /**
   * Save setting and window params
   * @param stage get window params from stage
   */
  private void saveParams(Stage stage) {
    prefs.putDouble("miyahara_window_x", stage.getX());
    prefs.putDouble("miyahara_window_y", stage.getY());
    prefs.putDouble("miyahara_window_width", stage.getWidth());
    prefs.putDouble("miyahara_window_height", stage.getHeight());

    prefs.put("miyahara_font_type", fontType);
    prefs.putInt("miyahara_font_size", fontSize);
    prefs.put("miyahara_font_color", fontColor);
    prefs.put("miyahara_bg_color", backgroundColor);
  }

  /**
   * Create setting dialog for digital clock
   * @return created dialog
   */
  private Dialog<ButtonType> createSettingDialog() {
    Dialog<ButtonType> dialog;
    dialog = new Dialog<>();
    dialog.setTitle("Setting");

    GridPane dialogPane = new GridPane();

    // Font type
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    ObservableList<String> fontTypeOptions = FXCollections.observableArrayList(fonts);
    ComboBox<String> fontTypeComboBox = new ComboBox<String>(fontTypeOptions);
    fontTypeComboBox.setValue(fontType);
    Label fontTypeLabel = new Label("Font type: ");
    dialogPane.add(fontTypeLabel, 0, 0);
    dialogPane.add(fontTypeComboBox, 1, 0);
    GridPane.setHalignment(fontTypeLabel, HPos.RIGHT);
    GridPane.setHalignment(fontTypeComboBox, HPos.LEFT);

    // Font size
    ObservableList<Integer> fontSizeOptions = FXCollections.observableArrayList(
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    ComboBox<Integer> fontSizeComboBox = new ComboBox<Integer>(fontSizeOptions);
    fontSizeComboBox.setValue(fontSize);
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
    fontColorComboBox.setValue(fontColor);
    Label fontColorLabel = new Label("Font color: ");
    dialogPane.add(fontColorLabel, 0, 2);
    dialogPane.add(fontColorComboBox, 1, 2);
    GridPane.setHalignment(fontColorLabel, HPos.RIGHT);
    GridPane.setHalignment(fontColorComboBox, HPos.LEFT);

    // Background color
    ComboBox<String> backgroundColorComboBox = new ComboBox<String>(colorOptions);
    backgroundColorComboBox.setCellFactory((list)->{return new ColorListCell();});
    backgroundColorComboBox.setValue(backgroundColor);
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
  private MenuBar createMenuBar(Dialog<ButtonType> dialog, Stage stage) {
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
    exitItem.setOnAction((eh)-> {
      saveParams(stage);
      Platform.exit();
    });

    return menuBar;

  }

  public static void main(String[] args) {
    launch(args);
  }

}
