package samppa;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import net.orfjackal.nestedjunit.NestedJUnit;

@RunWith(NestedJUnit.class)
public class BoardTest {

    private Board board = new Board(3, 6);

    public class Drop {
        @Test
        public void empty_board() {
            assertThat(board.toString(),
                    equalTo("" +
                            "......\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void no_falling_on_empty_board() {
            assertThat(board.hasFalling(), equalTo(false));
        }

        @Test
        public void drop_I() {
            board.drop(Tetromino.I);
            assertThat(board.hasFalling(), equalTo(true));
            assertThat(board.toString(),
                    equalTo("" +
                            ".IIII.\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void drop_while_another_is_droping() {
            board.drop(Tetromino.I);
            try {
                board.drop(Tetromino.I);
            } catch (IllegalStateException e) {
                assertThat(e.getMessage(), equalTo("falling already"));
            }
        }
    }

    public class Move {

        @Test
        public void move_I_right() {
            board.drop(Tetromino.I);
            board.moveRight();
            assertThat(board.toString(),
                    equalTo("" +
                            "..IIII\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void stay_on_board_on_right() {
            board.drop(Tetromino.I);
            board.moveRight();
            board.moveRight();
            board.moveRight();
            assertThat(board.toString(),
                    equalTo("" +
                            "..IIII\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void move_I_left() {
            board.drop(Tetromino.I);
            board.moveLeft();
            assertThat(board.toString(),
                    equalTo("" +
                            "IIII..\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void stay_on_board_on_left() {
            board.drop(Tetromino.I);
            board.moveLeft();
            board.moveLeft();
            board.moveLeft();
            assertThat(board.toString(),
                    equalTo("" +
                            "IIII..\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void move_down() {
            board.drop(Tetromino.I);
            board.moveDown();
            assertThat(board.toString(),
                    equalTo("" +
                            "......\n" +
                            ".IIII.\n" +
                            "......\n"));
        }

        @Test
        public void stick_to_bottom() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();
            board.moveDown();
            assertThat(board.toString(),
                    equalTo("" +
                            "......\n" +
                            "......\n" +
                            ".IIII.\n"));
            assertThat(board.hasFalling(), equalTo(false));
        }
    }
}
