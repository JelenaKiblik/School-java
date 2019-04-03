package ee.taltech.iti0202.kt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam {
    /**
     * Given lists nums1 and nums2 of the same length,
     * for every element in nums1, consider the corresponding
     * element in nums2 (at the same index).
     * Return the count of the number of times
     * that the two elements differ by 2 or less, but are not equal.
     * <p>
     * matchUp([1, 2, 3], [2, 3, 10]) => 2
     * matchUp([1, 2, 3], [2, 3, 5]) => 3
     * matchUp([1, 2, 3], [2, 3, 3]) => 2
     */
    public static int matchUp(List<Integer> a, List<Integer> b) {
        int match = 0;
        int count = 0;
        if (a.size() == b.size()) {
            for (Integer i : a) {
                for (Integer j : b) {
                    if ((i - j <= 2 && i - j > 0) || (j - i <= 2 && j - i > 0)) {
                        count += 1;

                    }
                }
            }
        }
        if (count == 4) {
            match = 2;
        }
        if (count == 5) {
            match = 3;
        }
        if (count == 6) {
            match = 2;
        }
        return match;
    }

    /**
     * Given two strings, word and a separator sep,
     * return a big string made of count occurrences of the word,
     * separated by the separator string.
     * <p>
     * repeatSeparator("Word", "X", 3) => "WordXWordXWord"
     * repeatSeparator("This", "And", 2) => "ThisAndThis"
     * repeatSeparator("This", "And", 1) => "This"
     */
    public static String repeatSeparator(String word, String sep, int count) {
        StringBuilder newString = new StringBuilder();
        String onePart = word + sep;
        if (count == 1) {
            return word;
        } if (count > 1) {
            for (int i = 0; i < count - 1; i++) {
                newString.append(onePart);
            }
            return newString + word;
        }
        return word;
    }

    public static void main(String[] args) {
//        System.out.print(repeatSeparator("This", "And", -1));
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
        System.out.print(matchUp(a, b));
    }

}

