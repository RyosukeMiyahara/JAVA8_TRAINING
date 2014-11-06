package ch03.ex03_08;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
  Color apply(int x, int y, Color colorAtXY);

  /**
   * Create ColorTransformer to frame image by provided width
   * @param image An image to be framed
   * @param width frame width
   * @param color frame color
   * @return Color Transformer to frame
   */
  public static ColorTransformer createColorTransformerToFrame(Image image, int width, Color color) {
    return (
        (x, y, c) -> {
          if (x < width
              || x > image.getWidth() - width
              || y < width
              || y > image.getHeight() -width) {
            return color;
          } else {
            return c;
          }
        });
  }
}
