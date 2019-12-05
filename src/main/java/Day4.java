import java.util.stream.IntStream;

public class Day4 {
    public static long findNumberOfPassword(int first, int last) {
        return IntStream.rangeClosed(first, last).filter(Day4::isPassword).count();
    }

    public static boolean isPassword(int candidate) {
        return isNeverDecreasing(candidate) && hasTwoAdjacentDigitsSame(candidate);
    }

    private static boolean isNeverDecreasing(int candidate) {
        while (true) {
            if (candidate == 0) {
                return true;
            }
            int leastSignificant = candidate % 10;
            int secondLeastSignificant = (candidate % 100) / 10;
            if (secondLeastSignificant > leastSignificant) {
                return false;
            }
            candidate = candidate/10;
        }
    }

    private static boolean hasTwoAdjacentDigitsSame(int candidate) {
        int adjacentSameCount = 1;
        while (true) {
            if (candidate == 0) {
                return adjacentSameCount == 2;
            }
            int leastSignificant = candidate % 10;
            int secondLeastSignificant = (candidate % 100) / 10;
            if (leastSignificant == secondLeastSignificant) {
                adjacentSameCount++;
            } else {
                if (adjacentSameCount == 2) {
                    return true;
                }
                adjacentSameCount = 1;
            }
            candidate = candidate/10;
        }
    }

    public static void main(String[] args) {
        long numberOfPassword = Day4.findNumberOfPassword(125730, 579381);
        System.out.println("numberOfPassword = " + numberOfPassword);
    }
}
