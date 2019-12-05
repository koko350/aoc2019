import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static String intCode(String input) {
        return intCode(getList(input));
    }

    private static String intCode(List<Integer> split) {
        for (int i = 0; true; i += 4) {
            int opcode = split.get(i);
            if (opcode == 99) {
                break;
            }
            int op1 = split.get(i + 1);
            int op2 = split.get(i + 2);
            int pos = split.get(i + 3);

            if (opcode == 1) {
                split.set(pos, split.get(op1) + split.get(op2));
            }
            if (opcode == 2) {
                split.set(pos, split.get(op1) * split.get(op2));
            }

        }

        return split.stream().map(Object::toString).collect(Collectors.joining(","));

    }

    private static List<Integer> getList(String input) {
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,5,23,1,23,5,27,2,27,10,31,1,31,9,35,1,35,5,39,1,6,39,43,2,9,43,47,1,5,47,51,2,6,51,55,1,5,55,59,2,10,59,63,1,63,6,67,2,67,6,71,2,10,71,75,1,6,75,79,2,79,9,83,1,83,5,87,1,87,9,91,1,91,9,95,1,10,95,99,1,99,13,103,2,6,103,107,1,107,5,111,1,6,111,115,1,9,115,119,1,119,9,123,2,123,10,127,1,6,127,131,2,131,13,135,1,13,135,139,1,9,139,143,1,9,143,147,1,147,13,151,1,151,9,155,1,155,13,159,1,6,159,163,1,13,163,167,1,2,167,171,1,171,13,0,99,2,0,14,0";
        String s = intCode(input);
        System.out.println(s);

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                List<Integer> inputList = getList(input);
                inputList.set(1, noun);
                inputList.set(2, verb);
                String result = intCode(inputList);
                if (result.startsWith("19690720")) {
                    System.out.println("noun = " + noun);
                    System.out.println("verb = " + verb);;
                    return;
                }
            }
        }
    }
}
