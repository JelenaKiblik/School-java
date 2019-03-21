package ee.taltech.iti0202.geometry;
import ee.taltech.iti0202.geometry.shape.Shape;
import java.util.HashSet;
import java.util.Set;

public class Canvas {
    public Set<Shape> shapes = new HashSet<>();

    public boolean drawShape(Shape shape) {
        shapes.add(shape);
        return false;
    }
}
