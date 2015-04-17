package samppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BoardTest {

    private Board board = new Board(6, 6);

    @Test
    public void empty_board() {
        assertThat(board.toString(),
                equalTo("" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n"));
    }

    @Test
    public void drop_I() {
        board.drop(Tetromino.I);
        assertThat(board.toString(),
                equalTo("" +
                        ".IIII.\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n"));
    }

    @Test
    public void move_I_right() {
        board.drop(Tetromino.I);
        board.moveRight();
        assertThat(board.toString(),
                equalTo("" +
                        "..IIII\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n"));
    }

}
