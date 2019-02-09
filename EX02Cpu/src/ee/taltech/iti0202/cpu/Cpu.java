package ee.taltech.iti0202.cpu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cpu {
    private static final int VALUE_TO_BE_MODIFIED = 0;
    private static final int ARITHMETIC_FUNCTION = 1;
    private static final int ARITHMETIC_VALUE = 2;
    private static final int COMPARATOR_KEY = 4;
    private static final int  COMPARATOR_FUNCTION = 5;
    private static final int PRE_COMPARATOR_VALUE =6;

    static Map<String, Integer> registerValues = new HashMap<>();
    static ArrayList<Integer> allValues = new ArrayList<>();

    public static Map<String, Integer> compute(String instructions) {

        String[] lines = instructions.split(" ");
        for (int i = 0; i < lines.length; i++) {

            String valueToBeModified = lines[VALUE_TO_BE_MODIFIED];
            String arithmeticFunction = lines[ARITHMETIC_FUNCTION];
            int arithmeticValue = Integer.parseInt(lines[ARITHMETIC_VALUE]);
            String comparatorKey = lines[COMPARATOR_KEY];
            String comparatorFunction = lines[COMPARATOR_FUNCTION];
            String preComparatorValue = lines[PRE_COMPARATOR_VALUE];
            int comparatorValue = Integer.parseInt(String.valueOf(preComparatorValue.charAt(0)));

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

        Collections.sort(allValues);
        Collections.reverse(allValues);
//        System.out.println(registerValues);
//        System.out.println(allValues);
        return registerValues;
    }

    private static void implementOperation(String valueToBeModified, String arithmeticFunction, int arithmeticValue,
                                           String comparatorFunction, int comparatorValue, int checkValue) {
        if (">".equals(comparatorFunction)) {
            largerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        } else if ("<".equals(comparatorFunction)) {
            smallerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        } else if (">=".equals(comparatorFunction)) {
            largerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        } else if ("<=".equals(comparatorFunction)) {
            smallerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        } else if ("==".equals(comparatorFunction)) {
            equalToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        } else if ("!=".equals(comparatorFunction)) {
            notEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue,
                    arithmeticValue);
        }
    }

    private static void performAction(String valueToBeModified, String arithmeticFunction, int arithmeticValue) {
        int newValue = registerValues.get(valueToBeModified);

        if (arithmeticFunction.equals("inc")) {
            registerValues.put(valueToBeModified, newValue + arithmeticValue);
            allValues.add(newValue + arithmeticValue);
        } else if (arithmeticFunction.equals("dec")) {
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

        res = compute(
                "b inc 7 if a > 4\n"
                        + "a inc 1 if c < 13\n"
                        + "c dec -10 if a >= 1\n"
                        + "c inc -20 if c == 10\n"
                        + "abc inc 100 if a != -23\n"
                        + "a inc 2 if a <= 0"
        );
        System.out.println(res); // {a=1, b=0, c=-10, abc=100}
    }

}
