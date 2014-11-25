package ch03.ex03_13;

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
   for (ColorTransformer f : pendingOperations)
     for (int x = 0; x < width; x++)
       for (int y = 0; y < height; y++) {
         out.getPixelWriter().setColor(x,  y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
      }
   return out;
}

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage){
    Image image = new Image("ch03/ex03_13/queen-mary.png");

    Image framedImage = LatentImage.from(image).transform(
        (x, y, c) -> {
          Color n = null;
          Color e = null;
          Color s = null;
          Color w = null;
          if (x == 0) {
            w = c;
          } else {
            w = image.getPixelReader().getColor(x - 1, y);
          }
          if (y == 0) {
            n = c;
          } else {
            n = image.getPixelReader().getColor(x, y - 1);
          }
          if (x == image.getWidth() - 1) {
            e = c;
          } else {
            e = image.getPixelReader().getColor(x + 1, y);
          }
          if (y == image.getHeight() - 1) {
            s = c;
          } else {
            s = image.getPixelReader().getColor(x, y + 1);
          }
          int newR = (int)((c.getRed() * 4 - n.getRed() - e.getRed() - s.getRed() - w.getRed())*255);
          int newG = (int)((c.getRed() * 4 - n.getRed() - e.getRed() - s.getRed() - w.getRed())*255);
          int newB = (int)((c.getRed() * 4 - n.getRed() - e.getRed() - s.getRed() - w.getRed())*255);
          if (newR < 0) {
            newR = 0;
          } else if (newR > 255) {
            newR = 255;
          }
          if (newG < 0) {
            newG = 0;
          } else if (newG > 255) {
            newG = 255;
          }
          if (newB < 0) {
            newB = 0;
          } else if (newB > 255) {
            newB = 255;
          }
          return Color.rgb(newR, newG, newB);
        }).toImage();
    stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
    stage.show();

  }

}
