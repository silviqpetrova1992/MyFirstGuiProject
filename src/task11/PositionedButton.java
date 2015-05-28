package task11;

import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/19/15.
 */
public class PositionedButton {

  public final JButton button;
  public final Point point;

  PositionedButton(JButton button, Point point) {
    this.button = button;
    this.point = point;
  }
}

class Point {
  public final int i;
  public final int x;
  public final int y;
  public final int z;

  public Point(int i, int x, int y, int z) {
    this.i = i;
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

