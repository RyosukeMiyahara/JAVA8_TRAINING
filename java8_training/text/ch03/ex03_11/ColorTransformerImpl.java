package ch03.ex03_11;

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
    Image image = new Image("ch03/ex03_11/queen-mary.png");
    ColorTransformer combined = ColorTransformer.compose(
        (x, y, c) -> {
          if (x < 10
              || x > image.getWidth() - 10
              || y < 10
              || y > image.getHeight() -10) {
            return Color.GRAY;
          } else {
            return c;
          }
        },
        ColorTransformer.unaryOperatorToColorTransformer(Color::brighter));
    Image changedImage = transformModified(image, combined);
    stage.setScene(new Scene(new HBox(new ImageView(changedImage))));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
