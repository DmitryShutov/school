import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPop() {
        Stack<Double> stack = new Stack<>();
        assertNull(stack.pop());
        stack.push(1.2);
        stack.push(2.3);
        assertEquals(stack.size(), 2);
        assertEquals(stack.pop(), 2.3);
        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), 1.2);
        assertEquals(stack.size(), 0);
        assertNull(stack.pop());
    }

    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(stack.size(), 3);
        assertEquals(stack.list.getFirst(), 3);
    }

    @Test
    public void testPeek() {
        Stack<String> stack = new Stack<>();
        assertNull(stack.peek());
        stack.push("1");
        stack.push("2");
        assertEquals(stack.peek(), "2");
        assertEquals(stack.size(), 2);
    }

}
