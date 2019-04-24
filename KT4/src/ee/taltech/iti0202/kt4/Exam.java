package ee.taltech.iti0202.kt4;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    /**
     * Return a version of the given list
     * where each zero value in the list is replaced
     * by the largest odd value to the right of the zero in the list.
     * If there is no odd value to the right of the zero, leave the zero as a zero.
     *
     * zeroMax([0, 5, 0, 3]) => [5, 5, 3, 3]
     * zeroMax([0, 4, 0, 3]) => [3, 4, 3, 3]
     * zeroMax([0, 1, 0]) => [1, 1, 0]
     */
    public static List<Integer> zeroMax(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0) {
                list.add(nums.get(i + 1));
            } else {
                list.add(nums.get(i));
        }
        return list;
        }

    /**
     * Given a string and a non-empty word string,
     * return a version of the original String
     * where all chars have been replaced by pluses ("+"),
     * except for appearances of the word string which are preserved unchanged.
     *
     * plusOut("12xy34", "xy") => "++xy++"
     * plusOut("12xy34", "1") => "1+++++"
     * plusOut("12xy34xyabcxy", "xy") => "++xy++xy+++xy"
     */
    public static String plusOut(String str, String word) {
        if (word.length() == 0) {
            return "";
        }
        String newStr = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, word.length() + i).equals(word)) {
                newStr += word;
            } else {
                newStr += "+";
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(plusOut("12xy34", "xy"));
    }
}
