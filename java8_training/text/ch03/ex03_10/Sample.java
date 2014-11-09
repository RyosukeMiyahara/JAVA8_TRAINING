package ch03.ex03_10;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Sample {

  /**
   * Transform image using provided oeration
   * This function is written in text
   * @param in image to be transformed
   * @param f operation to transform
   * @return transformed image
   */
  public static Image transform(Image in, UnaryOperator<Color> f) {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        out.getPixelWriter().setColor(x,  y, f.apply(in.getPixelReader().getColor(x, y)));
      }
    }
    return out;
  }

  public static void main(String[] args) {
    Image image = new Image("test");
    UnaryOperator<Color> op = Color::brighter;
    // Image finalImage1 = transform(image, op.compose(Color::grayscale));)
    @SuppressWarnings("unused")
    Image finalImage2 = transform(image, op);
  }

}
