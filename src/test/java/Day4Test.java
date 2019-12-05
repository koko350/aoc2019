import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Day4Test {

    @Test
    public void testIsPassword() {
//        Assert.assertTrue(Day4.isPassword(111111));
    }

    @Test
    public void testIsPasswordTwoTriplets() {
        Assert.assertFalse(Day4.isPassword(111222));
    }

    @Test
    public void testIsPasswordOneTriplet() {
        Assert.assertFalse(Day4.isPassword(123444));
    }

    @Test
    public void testIsPasswordThreeDouble() {
        Assert.assertTrue(Day4.isPassword(112233));
    }

    @Test
    public void testIsPassword4P2() {
        Assert.assertTrue(Day4.isPassword(112222));
    }

    @Test
    public void testIsPassword2P4() {
        Assert.assertTrue(Day4.isPassword(111122));
    }

    @Test
    public void testIsPassword51() {
        Assert.assertFalse(Day4.isPassword(111113));
    }

    @Test
    public void testIsPassword1() {
        Assert.assertFalse(Day4.isPassword(223450));
    }

    @Test
    public void testIsPassword2() {
        Assert.assertFalse(Day4.isPassword(123789));
    }

}