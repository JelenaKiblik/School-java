package ee.taltech.iti0202.kt2;

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
        int count = 0;

        for (int i = 0; i < a.size(); i++) {
            if (Math.abs(a.get(i) - b.get(i)) <= 2 && a.get(i) != b.get(i)) {
                count++;
            }
        }
        return count;
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
        String result = word;
        if (count == 0) {
            return "";
        }
        for (int i = 1; i < count; i++) {
            result = result + sep + word;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.print(repeatSeparator("This", "And", -1));
//        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
//        List<Integer> b = new ArrayList<Integer>(Arrays.asList(6, 6, 8));
//        System.out.print(matchUp(a, b));
    }

}
