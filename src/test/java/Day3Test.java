import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Day3Test {
    @Test
    public void testDistance() {
        String firstPath = "R8,U5,L5,D3";
        String secondPath = "U7,R6,D4,L4";

        int distance = Day3.calcDistance(firstPath, secondPath, false);

        Assert.assertEquals(6, distance);
    }

    @Test
    public void test2() {
        int distance = Day3.calcDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", false);
        Assert.assertEquals(distance, 159   );

    }

    @Test
    public void test3() {
        int distance = Day3.calcDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", false);
        Assert.assertEquals(distance, 135);

    }

    @Test
    public void testbF() {
        String firstPath = "R8,U5,L5,D3";
        String secondPath = "U7,R6,D4,L4";

        int distance = Day3.calcDistance(firstPath, secondPath, true);

        Assert.assertEquals(distance, 30);
    }
    @Test
    public void testb() {
        int distance = Day3.calcDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", true);
        Assert.assertEquals(distance, 610);
    }
}