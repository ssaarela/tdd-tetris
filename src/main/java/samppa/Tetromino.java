package samppa;

public class Tetromino {

    public static final Tetromino I = new Tetromino(new Shape(0, -1, 0, 0, 0, 1, 0, 2));

    public final Shape shape;

    private Tetromino(Shape shape) {
        this.shape = shape;
    }

}
