import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {
    SafeInputObj p1, p2;

    @BeforeEach
    void setUp() {
        p1 = new SafeInputObj();
        p2 = new SafeInputObj();
    }

    @Test
    void getNonZeroLenString() {
        //assertEquals("Hello", p1.getNonZeroLenString("Write me a message"));
    }

    @Test
    void getRangedInt() {
        //assertEquals(1, p1.getRangedInt("Write an int between", 1, 10));
    }

    @Test
    void getInt() {
    }

    @Test
    void getRangedDouble() {
    }

    @Test
    void getDouble() {
    }

    @Test
    void getYNConfirm() {
    }

    @Test
    void getRegExString() {
    }
}