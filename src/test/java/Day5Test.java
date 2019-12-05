import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Day5Test {

    @Test
    public void testIntCode() {
        String input = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99";
        test(input, -12, 999);
        test(input, 8, 1000);
        test(input, 12, 1001);
    }

    @Test
    public void testJump() {
        Day5.INPUT = 0;
        String input = "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9";
        int output = Day5.intCode(input);
        Assert.assertEquals(output, 0);

        Day5.INPUT = -1324;
        output = Day5.intCode(input);
        Assert.assertEquals(output, 1);

        Day5.INPUT = 0;
        input = "3,3,1105,-1,9,1101,0,0,12,4,12,99,1";
        output = Day5.intCode(input);
        Assert.assertEquals(output, 0);

        Day5.INPUT = -1324;
        output = Day5.intCode(input);
        Assert.assertEquals(output, 1);
    }

    @Test
    public void testEqualsLess() {
        test("3,9,8,9,10,9,4,9,99,-1,8", 8, 1);
        test("3,9,8,9,10,9,4,9,99,-1,8", -123, 0);
        test("3,9,7,9,10,9,4,9,99,-1,8", -123, 1);
        test("3,9,7,9,10,9,4,9,99,-1,8", 123, 0);
        test("3,3,1108,-1,8,3,4,3,99", 8, 1);
        test("3,3,1108,-1,8,3,4,3,99", 1235, 0);
        test("3,3,1107,-1,8,3,4,3,99", 2, 1);
        test("3,3,1107,-1,8,3,4,3,99", 431, 0);
    }

    private void test(String input, int inputInstruction, int expectedOutput) {
        Day5.INPUT = inputInstruction;
        int output = Day5.intCode(input);
        Assert.assertEquals(output, expectedOutput);

    }
}