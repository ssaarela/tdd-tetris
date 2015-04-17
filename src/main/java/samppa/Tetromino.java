package samppa;

import java.util.List;

public class Tetromino {

    public static final Tetromino I = define('I',
            new Shape(0, -2, 0, -1, 0, 0, 0, 1),
            new Shape(-1, 1, 0, 1, 1, 1, 2, 1)
    );

    public static final Tetromino O = define('O',
            new Shape(0, 0, 0, 1, 1, 0, 1, 1)
    );

    private static Tetromino define(char ch, Shape... shapes) {
        Tetromino first = new Tetromino(ch, shapes[0]);
        Tetromino prev = first;
        Tetromino next = prev;
        for (int i=1; i < shapes.length; i++) {
            next = new Tetromino(ch, shapes[i]);
            prev.right = next;
            next.left = prev;
        }
        next.right = first;
        first.left = next;
        return first;
    }

    public final char ch;

    public final Shape shape;

    private Tetromino left;

    private Tetromino right;

    private Tetromino(char ch, Shape shape) {
        this.ch = ch;
        this.shape = shape;
    }

    public Tetromino rotateRight() {
        return right;
    }

    public Tetromino rotateLeft() {
        return left;
    }

    public List<Point> getPoints() {
        return shape.points;
    }
}
