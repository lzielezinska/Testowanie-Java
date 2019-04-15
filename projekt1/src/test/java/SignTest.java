import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

public class SignTest {

    @ParameterizedTest
    @EnumSource(value = Sign.class)
    void testEnumaratonWithSigns(Sign symbol) {
        assertTrue(EnumSet.of(Sign.circle, Sign.cross, Sign.empty).contains(symbol));
    }
}
