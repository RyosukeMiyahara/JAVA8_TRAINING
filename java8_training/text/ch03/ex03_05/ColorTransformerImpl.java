package ch03.ex03_05;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class ColorTransformerImpl extends Application{

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

  /**
   * Transform image using provided operation
   * @param in image to be transformed
   * @param f operation to transform
   * @return transformed image
   */
  public static Image transformModified(Image in, ColorTransformer f) {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        out.getPixelWriter().setColor(x,  y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
      }
    }
    return out;
  }

  public void start(Stage stage) {
    Image image = new Image("ch03/ex03_05/queen-mary.png");
    Image framedImage = transformModified(image,
        (x, y, c) -> {
          if (x < 10
              || x > image.getWidth() - 10
              || y < 10
              || y > image.getHeight() -10) {
            return Color.GRAY;
          } else {
            return c;
          }
        });
    stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
