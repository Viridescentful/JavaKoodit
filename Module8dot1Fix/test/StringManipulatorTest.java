import Task2.StringManipulator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    @Test
    void canConcatenate() {
        StringManipulator sm = new StringManipulator();
        assertEquals("Goodbye!", sm.concatenate("Good", "bye!"));
    }

    @Test
    void canFindLength() {
        StringManipulator sm = new StringManipulator();
        assertEquals(30, sm.findLength("Thistaskwasveryconfusingsurely"));
    }

    @Test
    void canConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("FEAR ME!", sm.convertToUpperCase("fear me!"));
    }

    @Test
    void canConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("bnuuy!", sm.convertToLowerCase("BNuUY!"));
    }

    @Test
    void canCheckIfContainsSubstring() {
        StringManipulator sm = new StringManipulator();
        assertTrue(sm.containsSubstring("Hellofatime!", "Hello"));
    }
}
