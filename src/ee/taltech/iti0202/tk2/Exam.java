package ee.taltech.iti0202.tk2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Exam {


    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
     * except ignoring the largest and smallest values in the array. If there are multiple copies of the
     * smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce
     * the final average. You may assume that the array is length 3 or more.
     * <p>
     * centeredAverage([1, 2, 3, 4, 100]) → 3
     * centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
     * centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */
    public static int centeredAverage(List<Integer> nums) {
        return 2;
    }


    /**
     * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
     * Return 0 if they both go over.
     * <p>
     * blackjack(19, 21) → 21
     * blackjack(21, 19) → 21
     * blackjack(19, 22) → 19
     */
    public static int blackjack(int a, int b) {
        return 0;
    }


    /**

     Given a string and an int n, return a string made of n repetitions of the last n characters
     of the string. You may assume that n is between 0 and the length of the string, inclusive.

     repeatEnd("Hello", 3) → "llollollo"
     repeatEnd("Hello", 2) → "lolo"
     repeatEnd("Hello", 1) → "o"
     */
    public static String repeatEnd(String str, int n) {
        return "";

    }

    /**

     Modify and return the given map as follows: if the keys "a" and "b" are both in the map
     and have equal values, remove them both.

     mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
     mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
     mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
     */
    public static Map<String, String> mapAB(Map<String, String> map) {
        return null;
    }


    public static void main(String[] args) {

//        Painting painting1 = new Painting("The last supper", "Leonardo");
//        System.out.println(painting1);
//        Painting painting2 = new Painting("Woman with Red Head Scarf");
//        System.out.println(painting2);
//
//        Painting forgery = new Painting("The last supper", "Leonerdo");
//        System.out.println(forgery);
//        System.out.println();
//
//        Collector collector1 = new Collector();
//        Collector collector2 = new Collector();
//
//        System.out.println(collector1.addPainting(painting1)); // true
//        System.out.println(collector1.addPainting(painting1)); // false
//        System.out.println(collector1.addPainting(painting2)); // true
//        System.out.println();
//        System.out.println(collector2.getPaintings()); // []
//        System.out.println(collector1.getPaintings()); // [painting1, painting2]
//        System.out.println();
//        System.out.println(collector1.sellPainting(painting1, collector2)); // true
//        System.out.println(collector2.sellPainting(painting2, collector1)); // false
//        System.out.println(collector1.sellPainting(painting2, collector1)); // false
//        System.out.println();
//        System.out.println(collector1.getPaintings()); // [painting2]
//        System.out.println(collector2.getPaintings()); // [painting1]
//        System.out.println(collector2.addPainting(forgery)); // false

    }


}

