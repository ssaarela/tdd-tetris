package samppa;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TetrominoTest {

    @Test
    public void create_tetromino() {
        assertThat(Tetromino.I, not(nullValue()));
    }
}
