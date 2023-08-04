import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BracketsTest {

    @Test
    public void testEmpty() {
        String seq = "";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testRight() {
        String seq = ")";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testLeft() {
        String seq = "(";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testBalanced() {
        String seq = "()";
        assertTrue(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced() {
        String seq = "())";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced2() {
        String seq = "(()";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced3() {
        String seq = "(()))";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced4() {
        String seq = ")(())";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced5() {
        String seq = "((())(";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced6() {
        String seq = "())(";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced7() {
        String seq = "))((";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testUnbalanced8() {
        String seq = "((())";
        assertFalse(Brackets.isBalanced(seq));
    }

    @Test
    public void testBalanced9() {
        String seq = "(()((())()))";
        assertTrue(Brackets.isBalanced(seq));
    }

    @Test
    public void testBalanced10() {
        String seq = "(()()(()))";
        assertTrue(Brackets.isBalanced(seq));
    }
}
