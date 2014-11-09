package ch03.ex03_11;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
  Color apply(int x, int y, Color colorAtXY);

  /**
   * Combine two ColorTransformers
   * @param f1 1st ColorTransformer
   * @param f2 2nd ColorTransformer
   * @return Combined ColorTransformer
   */
  static public ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
    return (x, y, c) -> f1.apply(x, y, f2.apply(x, y, c));
  }

  /**
   * Change UnaryOperator to ColorTransformer which ignores x and y
   * @param op To be changed to ColorTransformer
   * @return ColorTransformer changed from UnaryOperator
   */
  static public ColorTransformer unaryOperatorToColorTransformer(UnaryOperator<Color> op) {
    return (x, y, c) -> op.apply(c);
  }
}
