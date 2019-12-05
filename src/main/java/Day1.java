import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1 {
    public static final String INPUT = "142388\n" +
            "128965\n" +
            "137791\n" +
            "93517\n" +
            "98732\n" +
            "83948\n" +
            "64037\n" +
            "124603\n" +
            "61093\n" +
            "132020\n" +
            "99227\n" +
            "73227\n" +
            "75536\n" +
            "53249\n" +
            "149300\n" +
            "75975\n" +
            "146023\n" +
            "117855\n" +
            "105380\n" +
            "127149\n" +
            "146894\n" +
            "73257\n" +
            "69233\n" +
            "67090\n" +
            "87932\n" +
            "107473\n" +
            "127873\n" +
            "132999\n" +
            "139324\n" +
            "92861\n" +
            "83651\n" +
            "91064\n" +
            "137074\n" +
            "94188\n" +
            "96969\n" +
            "96592\n" +
            "116019\n" +
            "52969\n" +
            "125456\n" +
            "97428\n" +
            "112642\n" +
            "99901\n" +
            "89405\n" +
            "91983\n" +
            "56445\n" +
            "64917\n" +
            "72393\n" +
            "127679\n" +
            "122430\n" +
            "142036\n" +
            "87228\n" +
            "118322\n" +
            "51965\n" +
            "67787\n" +
            "130183\n" +
            "124044\n" +
            "101324\n" +
            "107800\n" +
            "85585\n" +
            "67886\n" +
            "140772\n" +
            "138280\n" +
            "73183\n" +
            "116096\n" +
            "79239\n" +
            "105958\n" +
            "92719\n" +
            "70896\n" +
            "115279\n" +
            "51912\n" +
            "74396\n" +
            "75121\n" +
            "131819\n" +
            "67970\n" +
            "96436\n" +
            "107074\n" +
            "135588\n" +
            "97510\n" +
            "57877\n" +
            "114504\n" +
            "50521\n" +
            "100144\n" +
            "67840\n" +
            "51319\n" +
            "73801\n" +
            "128333\n" +
            "123521\n" +
            "105916\n" +
            "92601\n" +
            "146340\n" +
            "135355\n" +
            "51461\n" +
            "95648\n" +
            "92635\n" +
            "126711\n" +
            "75717\n" +
            "136114\n" +
            "106814\n" +
            "89913\n" +
            "119734\n";


    public static void main(String[] args) {

        int fuel1969 = calculateFuelWithFuel(1969);
        System.out.println("fuel1969 = " + fuel1969);
        int fuel100756 = calculateFuelWithFuel(100756);
        System.out.println("fuel100756 = " + fuel100756);


        IntStream input = Day1.parse();
        int sum = input.map(Day1::calculateFuel).sum();
        System.out.println("fuel sum = " + sum);
        input = Day1.parse();
        sum = input.map(Day1::calculateFuelWithFuel).sum();
        System.out.println("fuel with fuel sum = " + sum);
    }

    private static IntStream parse() {
        return Stream.of(INPUT.split("\n")).mapToInt(s -> Integer.parseInt(s));
    }

    private static int calculateFuel(int mass) {
        return mass / 3 - 2;
    }

    private static int calculateFuelWithFuel(int mass) {
        int fuel = mass / 3 - 2;
        return fuel > 0 ? fuel + calculateFuelWithFuel(fuel) : 0;
    }
}
