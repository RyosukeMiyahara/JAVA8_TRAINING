package ch03.ex03_10;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Sample {

  public static void main(String[] args) {
    Image image = new Image("test");
    UnaryOperator op = Color::brighter;
    Image finalImage = transform(image, op.compose(Color::grayscale));)
  }

}
