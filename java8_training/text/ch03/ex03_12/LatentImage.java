package ch03.ex03_12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LatentImage extends Application {
  private Image in;
  private List<ColorTransformer> pendingOperations;

  /**
   * Create LatentImage from Image
   * 
   * @param in LatentImage is created from this
   * @return LatentImage for specified Image
   */
  public static LatentImage from(Image in) {
    LatentImage result = new LatentImage();
    result.in = in;
    result.pendingOperations = new ArrayList<>();
    return result;
  }

  /**
   * Specify operation to be applied to Image as UnaryOperator<Color>
   * 
   * @param f operation to be applied to Image
   * @return LatentImage which includes specified operation
   */
  public LatentImage transform(UnaryOperator<Color> f) {
    pendingOperations.add((x, y, c) -> f.apply(c));
    return this;
  }

  /**
   * Specify operation to be applied to Image as ColorTransformer
   * 
   * @param f operation to be applied to Image
   * @return LatentImage which includes specified operation
   */
  public LatentImage transform(ColorTransformer f) {
    pendingOperations.add(f);
    return this;
  }

  /**
   * Convert LatentImage to Image
   * 
   * @return Image from LatantImage which applied specifed operations
   */
  public Image toImage() {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++) {
        Color c = in.getPixelReader().getColor(x, y);
        for (ColorTransformer f : pendingOperations) {
          c = f.apply(x, y, c);
        }
        out.getPixelWriter().setColor(x, y, c);
      }
    return out;
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Image image = new Image("ch03/ex03_12/queen-mary.png");

    Image framedImage = LatentImage.from(image).transform((x, y, c) -> {
      if (x < 10 || x > image.getWidth() - 10 || y < 10 || y > image.getHeight() - 10) {
        return Color.GRAY;
      } else {
        return c;
      }
    }).toImage();
    stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
    stage.show();

  }

}
