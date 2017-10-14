package edu.kidswhocode.shapes;

/**
 * Rectangle.
 *
 * @author Zakir Magdum
 */
public class Rectangle extends Shape {
    protected int width;
    private int height;

    public Rectangle(int width, int height, int x, int y, String color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                super.toString() +
                '}';
    }
}
