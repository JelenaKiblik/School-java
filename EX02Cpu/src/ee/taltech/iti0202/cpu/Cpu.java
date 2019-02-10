package ee.taltech.iti0202.cpu;
import java.util.*;

public class Cpu {

    private static final int VALUE_TO_BE_MODIFIED = 0;
    private static final int ARITHMETIC_FUNCTION = 1;
    private static final int ARITHMETIC_VALUE = 2;
    private static final int COMPARATOR_KEY = 4;
    private static final int COMPARATOR_FUNCTION = 5;
    private static final int COMPARATOR_VALUE = 6;

    static HashMap<String, Integer> registerValues = new HashMap<>();
    static ArrayList<Integer> allValues = new ArrayList<>();

    public static Map<String, Integer> compute(String instructions) {
        List<String> registers = Arrays.asList(instructions);
        for(String s : registers) {
            String[] steps = s.split("\\s");
            String valueToBeModified = steps[VALUE_TO_BE_MODIFIED];
            String arithmeticFunction = steps[ARITHMETIC_FUNCTION];
            int arithmeticValue = Integer.parseInt(steps[ARITHMETIC_VALUE]);
            String comparatorKey = steps[COMPARATOR_KEY];
            String comparatorFunction = steps[COMPARATOR_FUNCTION];
            int comparatorValue = Integer.parseInt(steps[COMPARATOR_VALUE]);
            if (!registerValues.containsKey(valueToBeModified)) {
                registerValues.put(valueToBeModified, 0);
            }
            if (!registerValues.containsKey(comparatorKey)) {
                registerValues.put(comparatorKey, 0);
            }

            int checkValue = registerValues.get(comparatorKey);
            implementOperation(valueToBeModified, arithmeticFunction, arithmeticValue, comparatorFunction,
                    comparatorValue, checkValue);
        }
        return registerValues;
    }

    private static void implementOperation(String valueToBeModified, String arithmeticFunction, int arithmeticValue,
                                           String comparatorFunction, int comparatorValue, int checkValue) {
        switch (comparatorFunction) {
            case ">":
                largerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            case "<":
                smallerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            case ">=":
                largerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            case "<=":
                smallerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            case "==":
                equalToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            case "!=":
                notEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                        arithmeticValue);
                break;
            default:
                throw new RuntimeException("Unexpected operator");
        }
    }

    private static void performAction(String valueToBeModified, String arithmeticFunction, int arithmeticValue) {
        int newValue = registerValues.get(valueToBeModified);

        if(arithmeticFunction.equals("inc")) {
            registerValues.put(valueToBeModified, newValue + arithmeticValue);
            allValues.add(newValue + arithmeticValue);
        } else if(arithmeticFunction.equals("dec")) {
            registerValues.put(valueToBeModified, newValue - arithmeticValue);
            allValues.add(newValue - arithmeticValue);
        }

    }

    private static void largerThanImplementation(String valueToBeModified, String arithmeticFunction,
                                                 int comparatorValue, int checkValue, int arithmeticValue) {
        if (checkValue > comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
    }

    private static void smallerThanImplementation(String valueToBeModified, String arithmeticFunction,
                                                  int comparatorValue, int checkValue, int arithmeticValue) {
        if (checkValue < comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
    }

    private static void largerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction,
                                                          int comparatorValue, int checkValue, int arithmeticValue) {
        if (checkValue >= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
    }

    private static void smallerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction,
                                                           int comparatorValue, int checkValue, int arithmeticValue) {
        if (checkValue <= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
    }

    private static void equalToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue,
                                              int checkValue, int arithmeticValue) {
        if (checkValue == comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
    }

    private static void notEqualToImplementation(String valueToBeModified, String arithmeticFunction,
                                                 int comparatorValue, int checkValue, int arithmeticValue) {
        if (checkValue != comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arithmeticValue);
        }
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