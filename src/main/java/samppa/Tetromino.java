package samppa;

public class Tetromino {

    public static final Tetromino I = define(
            new Shape(0, -1, 0, 0, 0, 1, 0, 2),
            new Shape(-1, 2, 0, 2, 1, 2, 2, 2)
    );

    public static final Tetromino O = define(
            new Shape(0, 0, 0, 1, 1, 0, 1, 1)
    );

    private static Tetromino define(Shape... shapes) {
        Tetromino first = new Tetromino(shapes[0]);
        Tetromino prev = first;
        Tetromino next = prev;
        for (int i=1; i < shapes.length; i++) {
            next = new Tetromino(shapes[i]);
            prev.right = next;
        }
        next.right = first;
        return first;
    }

    public final Shape shape;

    private Tetromino right;

    private Tetromino(Shape shape) {
        this.shape = shape;
    }

    public Tetromino rotateRight() {
        return right;
    }

}
