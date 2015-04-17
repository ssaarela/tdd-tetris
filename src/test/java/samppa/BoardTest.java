package samppa;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import net.orfjackal.nestedjunit.NestedJUnit;

@RunWith(NestedJUnit.class)
public class BoardTest {

    public class Drop {

        private Board board = new Board(3, 6);

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

        private Board board = new Board(3, 6);

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
        public void allow_move_at_bottom() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();
            assertThat(board.hasFalling(), equalTo(true));
        }

        @Test
        public void stick_to_bottom() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();
            board.moveDown();
            assertThat(board.hasFalling(), equalTo(false));
            assertThat(board.toString(),
                    equalTo("" +
                            "......\n" +
                            "......\n" +
                            ".IIII.\n"));
        }

        @Test
        public void stick_on_top_of_another() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();
            board.moveDown();

            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();

            assertThat(board.toString(),
                    equalTo("" +
                            "......\n" +
                            ".IIII.\n" +
                            ".IIII.\n"));
            assertThat(board.hasFalling(), equalTo(false));
        }

        @Test
        public void end_when_full() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();
            board.moveDown();

            board.drop(Tetromino.I);
            board.moveDown();
            board.moveDown();

            board.drop(Tetromino.I);
            board.moveDown();

            assertThat(board.toString(),
                    equalTo("" +
                            ".IIII.\n" +
                            ".IIII.\n" +
                            ".IIII.\n"));
            assertThat(board.drop(Tetromino.I), equalTo(false));
        }
    }

    public class Rotate {

        private Board board = new Board(4, 6);

        @Test
        public void cannot_rotate_I_right_at_top() {
            board.drop(Tetromino.I);
            board.rotateRight();
            assertThat(board.toString(),
                    equalTo("" +
                            ".IIII.\n" +
                            "......\n" +
                            "......\n" +
                            "......\n"));
        }

        @Test
        public void rotate_I_right() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.rotateRight();
            assertThat(board.toString(),
                    equalTo("" +
                            "...I..\n" +
                            "...I..\n" +
                            "...I..\n" +
                            "...I..\n"));
        }

        @Test
        public void rotate_I_left() {
            board.drop(Tetromino.I);
            board.moveDown();
            board.rotateLeft();
            assertThat(board.toString(),
                    equalTo("" +
                            "...I..\n" +
                            "...I..\n" +
                            "...I..\n" +
                            "...I..\n"));
        }
    }
}
