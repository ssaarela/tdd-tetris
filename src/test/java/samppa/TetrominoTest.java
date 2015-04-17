package samppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TetrominoTest {

    @Test
    public void create_I() {
        assertThat(Tetromino.I, not(nullValue()));
    }

    @Test
    public void rotate_I_right() {
        Tetromino t = Tetromino.I.rotateRight();
        assertThat(t, not(nullValue()));
        assertThat(t, not(sameInstance(Tetromino.I)));
        assertThat(t, sameInstance(Tetromino.I.rotateRight()));
    }

    @Test
    public void rotate_I_right_around() {
        assertThat(Tetromino.I.rotateRight().rotateRight(), sameInstance(Tetromino.I));
    }

    @Test
    public void rotate_I_left() {
        Tetromino t = Tetromino.I.rotateLeft();
        assertThat(t, not(nullValue()));
        assertThat(t, not(sameInstance(Tetromino.I)));
        assertThat(t, sameInstance(Tetromino.I.rotateLeft()));
    }

    @Test
    public void create_O() {
        assertThat(Tetromino.O, not(nullValue()));
    }

    @Test
    public void rotate_O_right() {
        assertThat(Tetromino.O.rotateRight(), sameInstance(Tetromino.O));
    }
}
