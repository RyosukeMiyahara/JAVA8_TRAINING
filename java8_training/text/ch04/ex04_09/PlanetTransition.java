package ch04.ex04_09;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetTransition extends Application {
  public void start(Stage stage) {
    Circle sun = new Circle(10, 10, 10);
    sun.setFill(Color.RED);
    Pane pane = new Pane();
    pane.getChildren().add(sun);
    Scene scene = new Scene(pane);
    sun.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
    sun.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));

    Circle earth = new Circle(5, 5, 5);

    pane.getChildren().add(earth);

    Path path = new Path();
    path.getElements().add(new MoveTo(20, 20));
    path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
    path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));

    // Sample
    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration(Duration.millis(4000));
    pathTransition.setPath(path);
    pathTransition.setNode(earth);
    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pathTransition.setCycleCount(Timeline.INDEFINITE);
    pathTransition.setAutoReverse(true);
    pathTransition.play();

    stage.setScene(scene);
    stage.show();
 }

 public static void main(String[] args) {
   launch(args);
 }
}
