package samppa;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShapeTest {

    @Test
    public void create_shape() {
        Shape shape = new Shape(0, -1, 0, 0, 0, 1, 0, 2);
        List<Point> points = shape.points;
        assertThat(points.get(0), equalTo(new Point(0, -1)));
        assertThat(points.get(1), equalTo(new Point(0, 0)));
        assertThat(points.get(2), equalTo(new Point(0, 1)));
        assertThat(points.get(3), equalTo(new Point(0, 2)));
    }
}
