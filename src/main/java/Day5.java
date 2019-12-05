import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    public static int INPUT = 5;

    public static int intCode(String input) {
        return intCode(getList(input));
    }

    private static int intCode(List<Integer> memory) {
        int pc = 0;
        Mode modeOfFirstParameter = null;
        Mode modeOfSecondParameter = null;
        Mode modeOfThirdParameter = null;
        int output = Integer.MIN_VALUE;
        while (true) {
            int opcodeParameterModes = memory.get(pc);
            int opcode = opcodeParameterModes % 100;
            if (opcode == 99) {
                return output;
            }

            modeOfFirstParameter = parseMode((opcodeParameterModes % 1000) / 100);
            modeOfSecondParameter = parseMode((opcodeParameterModes % 10000) / 1000);
            modeOfThirdParameter = parseMode((opcodeParameterModes % 100000) / 10000);

            int op1 = memory.get(pc + 1);

            if (opcode == 3) {
                memory.set(op1, INPUT);
                pc += 2;
                continue;
            }
            int op1Value = get(memory, op1, modeOfFirstParameter);

            if (opcode == 4) {
                output = op1Value;
                System.out.println("Output: " + op1Value);
                pc += 2;
                continue;
            }
            int op2 = memory.get(pc + 2);
            int op2Value = get(memory, op2, modeOfSecondParameter);


            if (opcode == 5) {
                if (op1Value != 0) {
                    pc = op2Value;
                } else {
                    pc += 3;
                }
                continue;
            }
            if (opcode == 6) {
                if (op1Value == 0) {
                    pc = op2Value;
                } else {
                    pc += 3;
                }
                continue;
            }
            int pos = memory.get(pc + 3);
            int posValue = pos;//get(memory, pos, modeOfThirdParameter);

            if (opcode == 7) {
                int newValue = op1Value < op2Value ? 1 : 0;
                memory.set(posValue, newValue);
                pc += 4;
                continue;
            }
            if (opcode == 8) {
                int newValue = op1Value == op2Value ? 1 : 0;
                memory.set(posValue, newValue);
                pc += 4;
                continue;
            }
            if (opcode == 1) {
                memory.set(pos, op1Value + op2Value);
                pc += 4;
                continue;
            }
            if (opcode == 2) {
                memory.set(pos, op1Value * op2Value);
                pc += 4;
                continue;
            }
        }
    }


    private static List<Integer> getList(String input) {
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        String input = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
//                "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
//                "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99";
        String input = "3,225,1,225,6,6,1100,1,238,225,104,0,1102,7,85,225,1102,67,12,225,102,36,65,224,1001,224,-3096,224,4,224,1002,223,8,223,101,4,224,224,1,224,223,223,1001,17,31,224,1001,224,-98,224,4,224,1002,223,8,223,101,5,224,224,1,223,224,223,1101,86,19,225,1101,5,27,225,1102,18,37,225,2,125,74,224,1001,224,-1406,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,1102,13,47,225,1,99,14,224,1001,224,-98,224,4,224,102,8,223,223,1001,224,2,224,1,224,223,223,1101,38,88,225,1102,91,36,224,101,-3276,224,224,4,224,1002,223,8,223,101,3,224,224,1,224,223,223,1101,59,76,224,1001,224,-135,224,4,224,102,8,223,223,1001,224,6,224,1,223,224,223,101,90,195,224,1001,224,-112,224,4,224,102,8,223,223,1001,224,7,224,1,224,223,223,1102,22,28,225,1002,69,47,224,1001,224,-235,224,4,224,1002,223,8,223,101,5,224,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,107,226,226,224,102,2,223,223,1006,224,329,1001,223,1,223,1107,677,226,224,1002,223,2,223,1005,224,344,101,1,223,223,108,677,226,224,102,2,223,223,1006,224,359,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,374,101,1,223,223,1008,677,226,224,1002,223,2,223,1006,224,389,1001,223,1,223,7,226,677,224,102,2,223,223,1005,224,404,101,1,223,223,1007,226,226,224,102,2,223,223,1006,224,419,101,1,223,223,7,226,226,224,102,2,223,223,1005,224,434,1001,223,1,223,8,226,226,224,1002,223,2,223,1006,224,449,101,1,223,223,1007,677,677,224,102,2,223,223,1006,224,464,101,1,223,223,1007,226,677,224,1002,223,2,223,1006,224,479,101,1,223,223,108,226,226,224,102,2,223,223,1005,224,494,1001,223,1,223,1108,677,677,224,102,2,223,223,1005,224,509,1001,223,1,223,107,226,677,224,1002,223,2,223,1005,224,524,101,1,223,223,1108,677,226,224,1002,223,2,223,1005,224,539,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,554,101,1,223,223,1008,226,226,224,102,2,223,223,1005,224,569,1001,223,1,223,8,677,226,224,102,2,223,223,1006,224,584,101,1,223,223,107,677,677,224,102,2,223,223,1006,224,599,101,1,223,223,8,226,677,224,102,2,223,223,1006,224,614,101,1,223,223,1107,226,677,224,102,2,223,223,1006,224,629,101,1,223,223,108,677,677,224,1002,223,2,223,1005,224,644,1001,223,1,223,1107,226,226,224,102,2,223,223,1005,224,659,101,1,223,223,1108,226,677,224,102,2,223,223,1005,224,674,101,1,223,223,4,223,99,226";
        int s = intCode(input);
        System.out.println(s);
    }

    static Mode parseMode(int modeCode) {
        if (modeCode == 0) {
            return Mode.POSITION;
        }
        if (modeCode == 1) {
            return Mode.IMMEDIATE;
        }
        throw new RuntimeException();
    }

    static int get(List<Integer> memory, int operand, Mode mode) {
        if (mode == Mode.IMMEDIATE) {
            return operand;
        }
        if (mode == Mode.POSITION) {
            return memory.get(operand);
        }
        throw new RuntimeException();
    }

    enum Mode {
        IMMEDIATE, POSITION
    }
}
