package tetris;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Point) {
            Point other = (Point) obj;
            return this.row == other.row && this.col == other.col;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
