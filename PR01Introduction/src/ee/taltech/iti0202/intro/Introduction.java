package ee.taltech.iti0202.intro;


public class Introduction {

    /**
     * Method gets a string containing word Java in different cases.
     * Method must be case-insensitive to recognize all the Java words.
     *
     * @param stringWithJava the string to find words Java from.
     * @return The number of word Java occurrences.
     */
    public static int countJava(String stringWithJava) {
        String findStr = "java";

        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = stringWithJava.toLowerCase().indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }


    /**
     * Method gets an array of numbers and another number.
     * The second integer's value must equal to the number of its occurrences in the given array.
     *
     * @param inputNumbers int array
     * @param sneakyNumber int
     * @return true if sneakyNumber's value equals its number of occurrences
     */
    public static boolean doubleNumber(int[] inputNumbers, int sneakyNumber) {
        int sum = 0;
        for (int item : inputNumbers) {
            if (item == sneakyNumber) {
                sum++;
            }
        }

        return sum == sneakyNumber;
    }


    /**
     * Method gets two numbers as parameters.
     * Method must answer if the given pair gives bad, normal or good outcome.
     * Outcome is "ok" if both values equal at least 5.
     * Outcome is "bad" if any of values is less than 5.
     * Outcome is "good" if one value equals doubled second value.
     * The priority is as follows: "bad", "good", "ok" (if several cases apply, take the higher / earlier).
     *
     * @param valueOne int
     * @param valueTwo int
     * @return true if sneakyNumber's value equals its number of occurrences
     */
    public static String howIsOutcome(int valueOne, int valueTwo) {
        if (valueOne < 5 && valueTwo < 5) {
            return "bad";
        } else if (valueOne >= 5 && valueTwo >= 5) {
            return "ok";
        } else if ((valueOne == valueTwo * 2 || valueTwo == valueOne * 2) && (valueOne < 5 ||  valueTwo < 5)) {
            return "good";
        }
        return "bad";
    }

    public static void main(String[] args) {
        // static method we can call directly from static method (main)
        System.out.println(countJava("javaJavaJAVA"));  // 3
        System.out.println(countJava("Nothing here"));  // 0
    }
}
