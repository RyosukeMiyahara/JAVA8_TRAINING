package ch04.ex04_09;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetTransition extends Application {
  private static final int SUN_SIZE = 10;
  private static final int EARTH_SIZE = 5;

  private static final double WIDTH = 480;
  private static final double HEIGHT = 320;
  private static final double RADIUS_X = 200;
  private static final double RADIUS_Y = 100;

  private static final int DURATION_MILL = 4000;

  public void start(Stage stage) {
    Pane pane = new Pane();
    Scene scene = new Scene(pane, WIDTH, HEIGHT);

    Circle sun = new Circle(WIDTH/2.0, HEIGHT/2.0, SUN_SIZE);
    sun.setFill(Color.RED);
    pane.getChildren().add(sun);

    Circle earth = new Circle(WIDTH/2.0, HEIGHT/2.0, EARTH_SIZE);
    earth.setFill(Color.BLUE);
    pane.getChildren().add(earth);

    Ellipse path = new Ellipse();
    path.setRadiusX(RADIUS_X);
    path.setRadiusY(RADIUS_Y);
    path.setCenterX(WIDTH/2.0);
    path.setCenterY(HEIGHT/2.0);

    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration(Duration.millis(DURATION_MILL));
    pathTransition.setPath(path);
    pathTransition.setNode(earth);
    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pathTransition.setCycleCount(Timeline.INDEFINITE);
    pathTransition.setAutoReverse(false);
    pathTransition.play();

    stage.setScene(scene);
    stage.show();
 }

 public static void main(String[] args) {
   launch(args);
 }
}
