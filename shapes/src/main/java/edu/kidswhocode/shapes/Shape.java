package edu.kidswhocode.shapes;

/**
 * Shape.
 *
 * @author Zakir Magdum
 */
public abstract class Shape {
    protected String color;
    protected int x;
    protected int y;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract double area();

    public double area(int scale) {
        double value = area() / scale;
        return value;
    }

    @Override
    public String toString() {
        return ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", area=" + area() ;
    }
}
