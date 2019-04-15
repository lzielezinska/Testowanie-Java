import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

public class GameStatusTest {
    @ParameterizedTest
    @EnumSource(value = GameStatus.class)
    void testEnumarationWithStatuses(GameStatus status) {
        assertTrue(EnumSet.of(GameStatus.tie, GameStatus.circleWon, GameStatus.crossWon, GameStatus.play).contains(status));
    }
}

