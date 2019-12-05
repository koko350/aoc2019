import org.testng.Assert;
import org.testng.annotations.Test;

public class Day2Test {

    @Test
    public void testA() {
        String input = "1,9,10,3,2,3,11,0,99,30,40,50";
        String expectedOutput = "3500,9,10,70," +
                "2,3,11,0," +
                "99," +
                "30,40,50";

        String result = Day2.intCode(input);
        Assert.assertEquals(result, expectedOutput);
    }
}