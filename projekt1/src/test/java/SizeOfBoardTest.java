import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

public class SizeOfBoardTest {


    @ParameterizedTest
    @EnumSource(value = SizeOfBoard.class)
    void testEnumarationWithBoardSizes(SizeOfBoard size) {
        assertTrue(EnumSet.of(SizeOfBoard.five, SizeOfBoard.three).contains(size));
    }
}
