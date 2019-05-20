package ee.taltech.iti0202.kt5;

import java.util.ArrayList;
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
        Boolean found = false;

        for (int i = 0; i < nrs.size(); i++) {
            if (nrs.get(i) == 3 && found == true) {
                return false;
            }
            if (nrs.get(i) != 3) {
                found = false;
            }
            if (nrs.get(i) == 3 && found == false) {
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

        for (int i = 0; i < a.length(); i++) {
            result = result + a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            result = result + b.charAt(i);
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(2);
        System.out.println(haveThree(arrayList));

        System.out.println(mixString("abc", "xyz"));
        System.out.println(mixString("Hi", "There"));
    }

}
