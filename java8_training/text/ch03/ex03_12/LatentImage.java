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

public class LatentImage extends Application{
  private Image in;
  private List<ColorTransformer> pendingOperations;

  public static LatentImage from(Image in) {
    LatentImage result = new LatentImage();
    result.in = in;
    result.pendingOperations = new ArrayList<>();
    return result;
 }

  public LatentImage transform(UnaryOperator<Color> f) {
    pendingOperations.add((x, y, c) ->f.apply(c));
    return this;
 }

 public LatentImage transform(ColorTransformer f) {
   pendingOperations.add(f);
   return this;
}

 public Image toImage() {
   int width = (int) in.getWidth();
   int height = (int) in.getHeight();
   WritableImage out = new WritableImage(width, height);
   for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++) {
         // Color c = in.getPixelReader().getColor(x, y);
         for (ColorTransformer f : pendingOperations)
         out.getPixelWriter().setColor(x,  y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
      }
   return out;
}

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage){
    Image image = new Image("ch03/ex03_12/queen-mary.png");

    Image framedImage = LatentImage.from(image).transform(
        (x, y, c) -> {
          if (x < 10
              || x > image.getWidth() - 10
              || y < 10
              || y > image.getHeight() -10) {
            return Color.GRAY;
          } else {
            return c;
          }
        }).toImage();
    stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
    stage.show();

  }

}
