package samppa;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    private final List<Point> points;

    public Shape(int... coordinates) {
        List<Point> points = new ArrayList<>();
        for (int i=0; i < coordinates.length; i+=2) {
            points.add(new Point(coordinates[i], coordinates[i+1]));
        }
        this.points = unmodifiableList(points);
    }

    public List<Point> points() {
        return points;
    }
}
