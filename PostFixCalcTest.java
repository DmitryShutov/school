import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PostFixCalcTest {

    @Test
    public void testCalc() {
        String seq = "8 2 + 5 * 9 + =";
        PostFixCalc calculator = new PostFixCalc();
        assertEquals(calculator.calc(seq), 59);
    }
}
