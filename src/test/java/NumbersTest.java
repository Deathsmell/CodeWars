import numbers.Numbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    public void returnMinusOneBecauseDontHaveNextBiggerNumber() {
        assertEquals(Numbers.nextBigger(3000),-1);
    }

    @Test
    public void returnNextBiggerNumber (){
        assertEquals(4530,Numbers.nextBigger(4503));
    }

    @Test
    public void biggerTests() {
        assertEquals(123456798, Numbers.nextBigger(123456789));
        assertEquals(1234567908, Numbers.nextBigger(1234567890));
        assertEquals(-1, Numbers.nextBigger(9876543210L));
        assertEquals(-1, Numbers.nextBigger(9999999999L));
        assertEquals(59884848483559L, Numbers.nextBigger(59884848459853L));
    }
}