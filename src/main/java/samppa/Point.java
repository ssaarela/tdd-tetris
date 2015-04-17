package samppa;

public class Point {
    public final int row;
    public final int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Point plus(Point other) {
        return new Point(this.row + other.row, this.col + other.col);
    }
}
