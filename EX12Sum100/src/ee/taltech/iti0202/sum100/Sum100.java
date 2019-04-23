package ee.taltech.iti0202.sum100;

import java.util.ArrayList;
import java.util.List;

public class Sum100 {

    public static List<String> calcSums() {
        List<String> result = new ArrayList<>();
        helpFunction("123456789", new StringBuilder(), 0, 0, result);

        for (String str : result) {
            System.out.println(str);
        }
        return result;
    }

    static void helpFunction(String str, StringBuilder builder, int sumInProcess, int sum, List<String> result) {
        if (sumInProcess == str.length()) {
            if (sum == 100) {
                result.add(builder.toString());
            }
            return;
        }

        int length = builder.length();

        for (int i = sumInProcess; i < str.length(); i++) {
            int number = Integer.parseInt(str.substring(sumInProcess, i + 1));

            if (sumInProcess == 0) {
                builder.append(number);
                helpFunction(str, builder, i + 1, sum + number, result);

            } else {
                builder.append("+").append(number);
                helpFunction(str, builder, i + 1, sum + number, result);
                builder.setLength(length);

                builder.append("-").append(number);
                helpFunction(str, builder, i + 1, sum - number, result);
            }
            builder.setLength(length);
        }
    }

    public static void main(String[] args) {
        calcSums();
    }
}
