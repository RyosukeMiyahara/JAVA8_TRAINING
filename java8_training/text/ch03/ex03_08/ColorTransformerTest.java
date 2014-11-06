package ch03.ex03_08;

import static org.junit.Assert.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.junit.BeforeClass;
import org.junit.Test;

public class ColorTransformerTest extends Application{

  private static int TRIAL_MAX = 5;
  private static int WIDTH = 20;
  private static Color color = Color.BLUE;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Runnable r = ()->launch(ColorTransformerTest.class, new String[0]);
    Thread thread = new Thread(r);
    thread.setDaemon(true);
    thread.start();
  }

  @Test
  public void transformModifiedTest() {
    Image tempImage = null;
    for (int i = 0; i < TRIAL_MAX; i++) {
      try {
        tempImage = new Image("ch03/ex03_08/queen-mary.png");
      } catch (RuntimeException e) {
        try {
          if (i == TRIAL_MAX - 1) {
            throw new RuntimeException("Internal graphics could not be initialized");
          }
          Thread.sleep(500);
        } catch(Exception e2) {
          e2.printStackTrace();
        }
        continue;
      }
    }
    Image image = tempImage;

    Image framedImage = ColorTransformerMain.transformModified(image, ColorTransformer.createColorTransformerToFrame(image, WIDTH, color));

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        if (x < WIDTH
            || x > image.getWidth() - WIDTH
            || y < WIDTH
            || y > image.getHeight() - WIDTH) {
            assertEquals(color, framedImage.getPixelReader().getColor(x,  y));
          } else {
            assertEquals(image.getPixelReader().getColor(x, y), framedImage.getPixelReader().getColor(x,  y));
          }
      }
    }
  }

  @Override
  public void start(Stage arg0) throws Exception {
    // Do nothing
  }

}
