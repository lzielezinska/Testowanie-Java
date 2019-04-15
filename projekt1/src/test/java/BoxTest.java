import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoxTest {

    Box box, box1;

    @BeforeEach
    void setUp() {
        box = new Box(1, 1);
    }

    @AfterEach
    void tearDown() {
        box = null;
    }

    @Test
    void checkIfExceptionIsThrownWhenRowIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    box1 = new Box(-9, 2);
                });
    }

    @Test
    void checkIfExceptionIsThrownWhenRowIsGreaterThanSix() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    box1 = new Box(100, 2);
                });

    }

    @Test
    void checkIfExceptionIsThrownWhenColumnIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    box1 = new Box(2, -100);
                });
    }

    @Test
    void checkIfExceptionIsThrownWhenColumnIsGreaterThanSix() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    box1 = new Box(2, 7);
                });

    }

    @Test
    void signIsCross() {
       String expected = "X";
       box.sign = Sign.cross;
       String actual = box.printSymbol();
       assertEquals(expected,actual);
    }

    @Test
    void signIsCircle() {
        String expected = "O";
        box.sign = Sign.circle;
        String actual = box.printSymbol();
        assertEquals(expected,actual);
    }

    @Test
    void signIsCEmpty() {
        String expected = " ";
        box.sign = Sign.empty;
        String actual = box.printSymbol();
        assertEquals(expected,actual);
    }





}
