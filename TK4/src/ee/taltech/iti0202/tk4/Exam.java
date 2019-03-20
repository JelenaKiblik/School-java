package ee.taltech.iti0202.tk4;

import java.util.List;
import java.util.Map;

public class Exam {

    /**
     * For each multiple of 10 in the given array,
     * change all the values following it to be that multiple of 10,
     * until encountering another multiple of 10.
     * So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     *
     * tenRun([2, 10, 3, 4, 20, 5]) => [2, 10, 10, 10, 20, 20]
     * tenRun([10, 1, 20, 2]) => [10, 10, 20, 20]
     * tenRun([10, 1, 9, 20]) => [10, 10, 10, 20]
     */
    public static List<Integer> tenRun(List<Integer> nums) {
        return null;
    }

    /**
     * Given three ints, a b c,
     * return true if one of b or c is "close" (differing from a by at most 1),
     * while the other is "far", differing from both other values by 2 or more.
     *
     * closeFar(1, 2, 10) => true
     * closeFar(1, 2, 3) => false
     * closeFar(4, 1, 3) => true
     */
    public static boolean closeFar(int a, int b, int c) {
        if (a - b <= 1 || b - a <= 1) {
            if ((c - b > 1 || b - c > 1) && (c - a > 1 || a - c > 1)) {
                return true;
            }
        }
        if (a - c <= 1 || c - a <= 1) {
            if ((c - b > 1 || b - c > 1) && (b - a > 1 || a - b > 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a version of the given string,
     * where for every star (*) in the string
     * the star and the chars immediately to its left and right are gone.
     * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     *
     * starOut("ab*cd") => "ad"
     * starOut("ab**cd") => "ad"
     * starOut("sm*eilly") => "silly
     */
    public static String starOut(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {

            }
        }
        return newStr;
    }

    /**
     * Modify and return the given map as follows:
     * if the keys "a" and "b" have values that have different lengths,
     * then set "c" to have the longer value.
     * If the values exist and have the same length,
     * change them both to the empty string in the map.
     *
     * mapABLonger({"a": "aaa", "b": "bb", "c": "cake"}) => {"a": "aaa", "b": "bb", "c": "aaa"}
     * mapABLonger({"a": "aa", "b": "bbb", "c": "cake"}) => {"a": "aa", "b": "bbb", "c": "bbb"}
     * mapABLonger({"a": "aa", "b": "bbb"}) => {"a": "aa", "b": "bbb", "c": "bbb"}
     */
    public static Map<String, String> mapABLonger(Map<String, String> map) {
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(tenRun([2, 10, 3, 4, 20, 5]));
        System.out.println(closeFar(1, 2, 10));
        System.out.println(closeFar(1, 2, 3));
        System.out.println(closeFar(4, 1, 3));
        System.out.println(starOut("ab*cd"));
//        System.out.println(mapABLonger({"a": "aaa", "b": "bb", "c": "cake"}));
    }
}
