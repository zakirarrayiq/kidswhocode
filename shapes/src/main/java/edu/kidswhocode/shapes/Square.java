package edu.kidswhocode.shapes;

/**
 * Square.
 *
 * @author Zakir Magdum
 */
public class Square extends Rectangle {
    public Square(int width, int x, int y, String color) {
        super(width, width, x, y, color);
    }

    @Override
    public String toString() {
        //return "Square{" + super.toString() + "}";
        return "Square{" +
                "width=" + width +
                ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", area=" + area()
                + "}";
    }
}
