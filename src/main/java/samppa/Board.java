package samppa;

public class Board {
    public static final Point MOVE_RIGHT = new Point(0, 1);
    public static final Point MOVE_LEFT = new Point(0, -1);
    public static final Point MOVE_DOWN = new Point(1, 0);
    private final char EMPTY = '.';
    private final int rows;
    private final int cols;
    private char[][] board;
    private Tetromino current;
    private Point location;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows][cols];
    }


    public String toString() {
        char[][] board = currentBoard();
        StringBuilder sb = new StringBuilder(rows * cols + rows);
        for (int row=0; row < rows; row++) {
            for (int col=0; col < cols; col++) {
                char c = board[row][col];
                sb.append(c > 0 ? c : EMPTY);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private char[][] currentBoard() {
        if (current == null) {
            return board;
        }
        final char[][] board = this.board.clone();
        current.getPoints().stream().forEach(p -> {
                Point at = location.plus(p);
                board[at.row][at.col] = current.ch;
        });
        return board;
    }

    public boolean drop(Tetromino t) {
        if (current != null) {
            throw new IllegalStateException("falling already");
        }
        this.current = t;
        this.location = new Point(0, cols / 2);
        if (!allow(location)) {
            clear();
            return false;
        }
        return true;
    }

    public void moveRight() {
        move(this.location.plus(MOVE_RIGHT));
    }

    private boolean move(Point newLocation) {
        if (allow(newLocation)) {
            this.location = newLocation;
            return true;
        }
        return false;
    }

    private boolean allow(Point newLocation) {
        return allow(current.shape, newLocation);
    }

    private boolean allow(Shape shape, Point location) {
        return shape.points.stream()
                .map(p -> p.plus(location))
                .allMatch(p -> isWithinBoard(p) && isBlank(p));
    }

    private boolean isBlank(Point p) {
        return board[p.row][p.col] == 0;
    }

    private boolean isWithinBoard(Point p) {
        return p.row >= 0 && p.col >= 0 &&
                p.row < rows && p.col < cols;
    }

    public void moveLeft() {
        move(this.location.plus(MOVE_LEFT));
    }

    public void moveDown() {
        if (!move(this.location.plus(MOVE_DOWN))) {
            stickIt();
        }
    }

    private void stickIt() {
        current.getPoints().stream()
                .map(p -> p.plus(location))
                .forEach(p -> board[p.row][p.col] = this.current.ch);
        clear();
    }

    private void clear() {
        current = null;
        location = null;
    }

    public boolean hasFalling() {
        return this.current != null;
    }

    public void rotateRight() {
        Tetromino next = current.rotateRight();
        if (allow(next)) {
            current = next;
        }
    }

    private boolean allow(Tetromino tetromino) {
        return allow(tetromino.shape, location);
    }
}
