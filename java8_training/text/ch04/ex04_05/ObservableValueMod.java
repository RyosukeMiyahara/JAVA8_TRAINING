package ch04.ex04_05;

import static javafx.beans.binding.Bindings.*;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ObservableValueMod extends Application{
  public static  <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
    return new ObservableValue<R>() {

      @Override
      public void addListener(InvalidationListener arg0) {
        t.addListener(arg0);
      }

      @Override
      public void removeListener(InvalidationListener arg0) {
        t.removeListener(arg0);
      }

      @SuppressWarnings("unchecked")
      @Override
      public void addListener(ChangeListener<? super R> arg0) {
        t.addListener((ChangeListener<? super T>) arg0);
      }

      @Override
      public R getValue() {
        return f.apply(t.getValue());
      }

      @SuppressWarnings("unchecked")
      @Override
      public void removeListener(ChangeListener<? super R> arg0) {
        t.removeListener((ChangeListener<? super T>) arg0);
      }
    };
  }

  public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
    return new ObservableValue<R>() {

      @Override
      public void addListener(InvalidationListener arg0) {
        t.addListener(arg0);
      }

      @Override
      public void removeListener(InvalidationListener arg0) {
        t.addListener(arg0);
      }

      @SuppressWarnings("unchecked")
      @Override
      public void addListener(ChangeListener<? super R> arg0) {
        t.addListener((ChangeListener<? super T>) arg0);
      }

      @Override
      public R getValue() {
        return f.apply(t.getValue(), u.getValue());
      }

      @SuppressWarnings("unchecked")
      @Override
      public void removeListener(ChangeListener<? super R> arg0) {
        t.removeListener((ChangeListener<? super T>) arg0);
      }

    };
  }

  public void start(Stage stage) {
    Button smaller = new Button("Smaller");
    Button larger = new Button("Larger");
    Rectangle gauge = new Rectangle(0, 5, 50, 15);
    Rectangle outline = new Rectangle(0, 5, 100, 15);
    outline.setFill(null);
    outline.setStroke(Color.BLACK);
    Pane pane = new Pane();
    pane.getChildren().addAll(gauge, outline);
    smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 10));
    larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 10));
    smaller.disableProperty().bind(lessThanOrEqual(gauge.widthProperty(), 0));
    // larger.disableProperty().bind(greaterThanOrEqual(gauge.widthProperty(), 100));
    // larger.disableProperty().bind(observe(t -> t >= 100, gauge.widthProperty()));
    larger.disableProperty().bind(observe((t) -> (double)t >= 100, gauge.widthProperty()));



    HBox box = new HBox(10);
    box.getChildren().addAll(smaller, pane, larger);
    Scene scene = new Scene(box);
    stage.setScene(scene);
    stage.show();
 }

  public static void main(String[] args) {
    launch(args);
  }
}
