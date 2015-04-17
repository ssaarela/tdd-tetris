package samppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PointTest {

    @Test
    public void create_point() {
        Point point = new Point(1, 1);
        assertEquals(point.row, 1);
        assertEquals(point.col, 1);
    }

    @Test
    public void add_points() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point sum = p1.plus(p2);
        assertEquals(sum.row, 0);
        assertEquals(sum.col, 2);
        assertThat(sum, not(sameInstance(p1)));
        assertThat(sum, not(sameInstance(p2)));
    }
}
