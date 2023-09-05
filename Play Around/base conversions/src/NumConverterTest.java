import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class NumConverterTest {
    String a = "0.25";
    String b = "0.01";
    String c = "12.25";
    String d = "1100.01";
    String e = "3421";
    String f = "110101011101";

    @Test
    public void testBinaryToNum() {
        assertEquals(b + " is " + a + " in base10.", NumConverter.binaryToNum(b));
         assertEquals(d + " is " + c + " in base10.", NumConverter.binaryToNum(d));
          assertEquals(f + " is " + e + " in base10.", NumConverter.binaryToNum(f));
    }

    @Test
    public void testNumToBinary() {
        assertEquals(a + " is " + b + " in binary.", NumConverter.numToBinary(a));
        assertEquals(c + " is " + d + " in binary.", NumConverter.numToBinary(c));
        assertEquals(e + " is " + f + " in binary.", NumConverter.numToBinary(e));
    }
}
