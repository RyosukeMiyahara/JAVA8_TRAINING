package ch03.ex03_14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
  Color apply(int x, int y, PixelReader reader);
}
