import FlowControl.FlowController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowControllerTests {

    FlowController controller = new FlowController();

    @Test
    void testSwitchItLikeInJava8() {
        assertDoesNotThrow(() -> controller.switchItLikeInJava8(1));
    }

    @Test
    void testSwitchItLikeInJava17() {
        assertDoesNotThrow(() -> controller.switchItLikeInJava17(5));
    }

    @Test
    void testPlayWithForLoop() {
        assertDoesNotThrow(() -> controller.playWithForLoop());
    }

    @Test
    void testPlayWithNestedWhileLoops() {
        assertDoesNotThrow(() -> controller.playWithNestedWhileLoops());
    }
}