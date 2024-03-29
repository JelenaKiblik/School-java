package ee.taltech.iti0202.kt5;

import java.util.List;

public class Exam {

    /**
     * Given an array of ints,
     * return true if the value 3 appears in the array exactly 3 times,
     * and no 3's are next to each other.
     *
     * haveThree([3, 1, 3, 1, 3]) => true
     * haveThree([3, 1, 3, 3]) => false
     * haveThree([3, 4, 3, 3, 4]) => false
     */
    public static boolean haveThree(List<Integer> nrs) {
        int count = 0;
        boolean found = false;

        for (Integer nr : nrs) {
            if ((nr == 3) && (found)) {
                return false;
            }
            if (nr != 3) {
                found = false;
            }
            if ((nr == 3) && (!found)) {
                found = true;
                count++;
            }
        }
        return count == 3;
    }

    /**
     * Given two strings, a and b,
     * create a bigger string made of the first char of a, the first char of b,
     * the second char of a, the second char of b, and so on.
     * Any leftover chars go at the end of the result.
     *
     * mixString("abc", "xyz") => "axbycz"
     * mixString("Hi", "There") => "HTihere"
     * mixString("xxxx", "There") => "xTxhxexre"
     */
    public static String mixString(String a, String b) {
        String result = "";

        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                result = result + a.charAt(i);
                result = result + b.charAt(i);
            }
        } else if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                result = result + a.charAt(i);
                result = result + b.charAt(i);
            }
            result = result + a.substring(b.length());

        } else if (a.length() < b.length()) {
            for (int i = 0; i < a.length(); i++) {
                result = result + a.charAt(i);
                result = result + b.charAt(i);
            }
            result = result + b.substring(a.length());   ///   b.sub(5 - 4)  1 ...
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(mixString("abc", "xyz"));
        System.out.println(mixString("Hi", "There"));  //"HT ih ere"
        System.out.println(mixString("xxxx", "There")); //"xT xh xe xr e"
    }

}
