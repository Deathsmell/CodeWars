import org.junit.jupiter.api.Test;
import strings.Strings;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    private final int[] array = new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20,21};
    private final int[] primeArray = new int[] {-6, -3, -2, -1, 0, 1, 3, 34};

    @Test
    void rangeExtraction() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-21", Strings.rangeExtraction(array));
    }

    @Test
    void rangePrimeExtraction() {
        assertEquals("-6,-3-1,3,34",Strings.rangeExtraction(primeArray));
    }


    @Test
    void stringMergerTest(){
        assertTrue(Strings.isMerge("jd*1\"e%bh3XewKe\\Nc?a", "1%3XewK?", "jd*\"ebhe\\Nca"));
        assertTrue(Strings.isMerge("Can we merge it? Yes, we can!", "Cn w ege Yes n", "aemr it?,we ca!"));
        assertTrue(Strings.isMerge("_f@/e`j7\\:(>CNhbfj(epuh=%lF,_f@/e`j7\\:(gJ#L[uVUR4v*%)?--NRfaq*eH?FJ`D:7<>NE$%_Np]",
                "_f@/e`j7\\:(gJ#L[uVUR4v*%", "_f@/e`j7\\:(>CNhbfj(epuh=%lF,)?--NRfaq*eH?FJ`D:7<>NE$%_Np]"));
        assertFalse(Strings.isMerge("codewars", "code", "wasr"));

    }

    @Test
    void twoMergeTest (){
        assertTrue(Strings.isMerge("%L2asL`)&W\\L\\Ped/:Y@Y*no]KCZDsBqm%L2asL`)&W\\L\\Ped/:Y@YN&5<m7,Vut10IK<!eBBAXB,mI52D]E <\\v(cqh*sx",
                "%L2asL`)&W\\L\\Ped/:Y@YN&5<m7,Vut10IK<!eBBAX", "%L2asL`)&W\\L\\Ped/:Y@Y*no]KCZDsBqmB,mI52D]E <\\v(cqh*sx"));

    }
}