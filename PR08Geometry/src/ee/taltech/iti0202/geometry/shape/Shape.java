package ee.taltech.iti0202.geometry.shape;

public class Shape {

    private String name;
    private int angles;
    private Color color;
    private int size;

    public enum Color {
        Blue, Green, Red, Yellow, Black
    }

    public Shape(String name, int angles, Color color, int size) {
        this.name = name;
        this.angles = angles;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getAngles() {
        return angles;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "Shape: " + name + ", Number of angles: " + angles + ", Color: " + color + ", Size: " + size;
    }

}
