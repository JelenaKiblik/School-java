package ee.taltech.iti0202.tk1;
import java.util.List;
import java.util.Map;

public class Exam {


    /**
     * Return a list that contains the exact same numbers as the given list, but rearranged so that
     * all the even numbers come before all the odd numbers. Other than that, the numbers can be in
     * any order. You may modify and return the given list, or make a new list.
     * <p>
     * <p>
     * evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
     * evenOdd([3, 3, 2]) → [2, 3, 3]
     * evenOdd([2, 2, 2]) → [2, 2, 2]
     */
    public static List<Integer> evenOdd(List<Integer> nums) {
        int temp;
        int evenIndex = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums.get(i) % 2 == 0)
            {
                temp = nums.get(i);
                nums.set(i, evenIndex);
                nums.set(i, temp);
                evenIndex++;
            }
        }
        return nums;
    }


    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
     * it does not count towards the sum.
     * <p>
     * loneSum(1, 2, 3) → 6
     * loneSum(3, 2, 3) → 2
     * loneSum(3, 3, 3) → 0
     */
    public static int loneSum(int a, int b, int c) {
        int sum = a + b + c;
        if ( a == b) { sum = sum - a - b; }
        if ( a == c) { sum = sum - a - c; }
        if( b == c) { sum = sum - b - c; }
        if (( a == b ) && (b==c)) { sum = 0; }
        return sum;
    }


    /**
     * A sandwich is two pieces of bread with something in between. Return the string that is between the first and
     * last appearance of "bread" in the given string, or return the empty string ""
     * if there are not two pieces of bread.
     * <p>
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */
    public static String getSandwich(String str) {
        int first = -1;
        int last = -1;

        for(int i = 0; i < str.length() - 5; i++) {
            if(str.substring(i, i + 5).equals("bread")) {
                first = i;
                break;
            }
        }

        for(int i = str.length() - 5; i >= 0; i--) {
            if(str.substring(i, i + 5).equals("bread")) {
                last = i;
                break;
            }
        }

        if(first != -1 && last != -1 && first != last)
            return str.substring(first + 5, last);

        return "";
    }


    /**
     * Given a map of food keys and topping values, modify and return the map as follows: if the key
     * "ice cream" is present, set its value to "cherry". In all cases, set the key "bread"
     * to have the value "butter".
     * <p>
     * <p>
     * topping({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
     * topping({}) → {"bread": "butter"}
     * topping({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
     */
    public static Map<String, String> topping(Map<String, String> map) {
        map.put("bread", "butter");
        if (map.containsKey("ice cream"))
            map.put("ice cream", "cherry");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(loneSum(3, 2, 3));
    }
}
