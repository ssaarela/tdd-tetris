package samppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TetrominoTest {

    @Test
    public void create_tetromino() {
        assertThat(Tetromino.I, not(nullValue()));
    }

    @Test
    public void rotate_tetromino_right() {
        Tetromino t = Tetromino.I.rotateRight();
        assertThat(t, not(nullValue()));
        assertThat(t, not(sameInstance(Tetromino.I)));
        assertThat(t, sameInstance(Tetromino.I.rotateRight()));
        assertThat(t.rotateRight(), sameInstance(Tetromino.I));
    }
}
