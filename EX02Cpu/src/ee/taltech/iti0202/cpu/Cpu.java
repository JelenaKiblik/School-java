package ee.taltech.iti0202.cpu;

import java.util.*;

public class Cpu {

    static Map<String, Integer> registerValues = new HashMap<>();
    static ArrayList<Integer> allValues = new ArrayList<>();

    public static Map<String, Integer> compute(String instructions) {

        String[] lines = instructions.split( " ");
        for (int i = 0; i < lines.length; i++) {

            String valueToBeModified = lines[0];
            String arithmeticFunction = lines[1];
            int arithmeticValue = Integer.parseInt(lines[2]);
            String comparatorKey = lines[4];
            String comparatorFunction = lines[5];
            String preComparatorValue = lines[6];
            int comparatorValue = Integer.parseInt(String.valueOf(preComparatorValue.charAt(0)));


            if(!registerValues.containsKey(valueToBeModified)) {
                registerValues.put(valueToBeModified, 0);
            }
            if(!registerValues.containsKey(comparatorKey)) {
                registerValues.put(comparatorKey, 0);
            }

            int checkValue = registerValues.get(comparatorKey);

            implementOperation(valueToBeModified, arithmeticFunction, arithmeticValue, comparatorFunction, comparatorValue, checkValue);

        }

        Collections.sort(allValues);
        Collections.reverse(allValues);
//        System.out.println(registerValues);
//        System.out.println(allValues);
        return registerValues;

    }

    private static void implementOperation(String valueToBeModified, String arithmeticFunction, int arthmeticValue, String comparatorFunction, int comparatorValue, int checkValue) {
        switch (comparatorFunction) {
            case ">":
                largerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
            case "<":
                smallerThanImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
            case ">=":
                largerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
            case "<=":
                smallerThanOrEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
            case "==":
                equalToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
            case "!=":
                notEqualToImplementation(valueToBeModified, arithmeticFunction, comparatorValue, checkValue, arthmeticValue);
                break;
        }
    }

    private static void performAction(String valueToBeModified, String arithmeticFunction, int arthmeticValue) {
        int newValue = registerValues.get(valueToBeModified);

        if(arithmeticFunction.equals("inc")) {
            registerValues.put(valueToBeModified, newValue + arthmeticValue);
            allValues.add(newValue + arthmeticValue);
        } else if(arithmeticFunction.equals("dec")) {
            registerValues.put(valueToBeModified, newValue - arthmeticValue);
            allValues.add(newValue - arthmeticValue);
        }

    }

    private static void largerThanImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue > comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private static void smallerThanImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue < comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private static void largerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue >= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private static void smallerThanOrEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue <= comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private static void equalToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue == comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    private static void notEqualToImplementation(String valueToBeModified, String arithmeticFunction, int comparatorValue, int checkValue, int arthmeticValue) {
        if(checkValue != comparatorValue) {
            performAction(valueToBeModified, arithmeticFunction, arthmeticValue);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> res = compute(
                "b inc 5 if a > 1\n" +
                        "a inc 1 if b < 5\n" +
                        "c dec -10 if a >= 1\n" +
                        "c inc -20 if c == 10"
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