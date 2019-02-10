package ee.taltech.iti0202.cpu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cpu {

    private static final int VALUE_TO_BE_MODIFIED = 0;
    private static final int ARITHMETIC_FUNCTION = 1;
    private static final int ARITHMETIC_VALUE = 2;
    private static final int COMPARATOR_KEY = 4;
    private static final int COMPARATOR_FUNCTION = 5;
    private static final int COMPARATOR_VALUE = 6;
    private static boolean condition;

    public static Map<String, Integer> compute(String instructions) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> registers = Arrays.asList(instructions);

        for (String s : registers) {
            String[] steps = s.split("\\s");
            String valueToBeModified = steps[0];
            int arithmeticFunction = (steps[1].equals("inc") ? 1 : -1);
            int arithmeticValue = Integer.parseInt(steps[2]);
            String comparatorKey = steps[4];
            String comparatorFunction = steps[5];
            int comparatorValue = Integer.parseInt(steps[6]);

            if (!map.containsKey(comparatorKey)) {
                map.put(comparatorKey, 0);
            }
            if (!map.containsKey(valueToBeModified)) {
                map.put(valueToBeModified, 0);
            }

            switch (comparatorFunction) {
                case "==":
                    if (map.get(comparatorKey) == comparatorValue) {
                        condition = true;
                    }
                    break;
                case "!=":
                    if (map.get(comparatorKey) != comparatorValue) {
                        condition = true;
                    }
                    break;
                case "<":
                    if (map.get(comparatorKey) < comparatorValue) {
                        condition = true;
                    }
                    break;
                case "<=":
                    if (map.get(comparatorKey) <= comparatorValue) {
                        condition = true;
                    }
                    break;
                case ">":
                    if (map.get(comparatorKey) > comparatorValue) {
                        condition = true;
                    }
                    break;
                case ">=":
                    if (map.get(comparatorKey) >= comparatorValue) {
                        condition = true;
                    }
                    break;
                    default:
                        throw new RuntimeException("Unexpected operator");
            }

            if (condition) {
                map.replace(valueToBeModified, map.get(valueToBeModified) + (arithmeticFunction * arithmeticValue));
            }

            System.out.println(valueToBeModified);
            System.out.println(arithmeticFunction);
            System.out.println(arithmeticValue);
            System.out.println(comparatorKey);
            System.out.println(comparatorFunction);
            System.out.println(comparatorValue);
            System.out.println(Arrays.toString(steps));
        }
        return map;
    }


    public static void main(String[] args) {
        Map<String, Integer> res = compute(
                "b inc 5 if a > 1\n"
                        + "a inc 1 if b < 5\n"
                        + "c dec -10 if a >= 1\n"
                        + "c inc -20 if c == 10"
        );
        System.out.println(res); // {a=1, b=0, c=-10}

//        res = compute(
//                "b inc 7 if a > 4\n" +
//                        "a inc 1 if c < 13\n" +
//                        "c dec -10 if a >= 1\n" +
//                        "c inc -20 if c == 10\n" +
//                        "abc inc 100 if a != -23\n" +
//                        "a inc 2 if a <= 0"
//        );
//        System.out.println(res); // {a=1, b=0, c=-10, abc=100}
    }
}
