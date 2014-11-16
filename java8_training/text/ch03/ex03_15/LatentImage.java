package ch03.ex03_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
  private List<UnaryOperator<Color>> pendingOperations;

  public static LatentImage from(Image in) {
    LatentImage result = new LatentImage();
    result.in = in;
    result.pendingOperations = new ArrayList<>();
    return result;
 }

  public LatentImage transform(UnaryOperator<Color> f) {
    pendingOperations.add(f);
    return this;
 }

  public Image toImageParallel() {
    int n = Runtime.getRuntime().availableProcessors();
    Color[][] pixels = convertImageToPixels(in);
    int height = pixels.length;
    int width = pixels[0].length;
    Color[][] out = new Color[height][width];
    try {
       ExecutorService pool = Executors.newCachedThreadPool();
       for (int i = 0; i < n; i++) {
          int fromY = i * height / n;
          int toY = (i + 1) * height / n;
          pool.submit(() -> {
                for (int x = 0; x < width; x++)
                   for (int y = fromY; y < toY; y++)
                     for (UnaryOperator<Color> f : pendingOperations)
                      out[y][x] = f.apply(pixels[y][x]);
             });
       }
       pool.shutdown();
       pool.awaitTermination(1, TimeUnit.HOURS);
    }
    catch (InterruptedException ex) {
       ex.printStackTrace();
    }
    return convertPixelsToImage(out);
 }

  public static Color[][] convertImageToPixels(Image image) {
    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    Color[][] pixels = new Color[height][width];
    for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++)
         pixels[y][x] = image.getPixelReader().getColor(x, y);
    return pixels;
  }

  public Image convertPixelsToImage(Color[][] c) {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int x = 0; x < width; x++)
       for (int y = 0; y < height; y++) {
          out.getPixelWriter().setColor(x, y, c[y][x]);
       }
    return out;
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage){
    Image image = new Image("ch03/ex03_15/eiffel-tower.jpg");
    LatentImage.from(image).transform(Color::brighter).transform(Color::grayscale).toImageParallel();

    Image finalImage = LatentImage.from(image).transform(Color::brighter).transform(Color::grayscale).toImageParallel();
    stage.setScene(new Scene(new HBox(
       new ImageView(image),
       new ImageView(finalImage))));
    stage.show();

  }

}
