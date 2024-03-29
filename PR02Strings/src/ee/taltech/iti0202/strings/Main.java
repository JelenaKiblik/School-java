package ee.taltech.iti0202.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    private static String maxRepeated;

    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String name : sentence) {
            wordMap.put(name, wordMap.getOrDefault(name, 0) + 1);
        }
        return wordMap;
    }

    /**
     * Find the most frequent word in given array of strings.
     *
     * If there are multiple most frequent words to choose from pick any of them.
     *
     * @param sentence array of strings, can't be null.
     * @return most frequent word in the sentence
     */
    public static String mostFrequentWord(String[] sentence) {
        Map<String, Integer> wordMap = new HashMap<>();

        for (String name : sentence) {
            wordMap.put(name, wordMap.getOrDefault(name, 0) + 1);
        }

        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue()) {
                mostRepeated = e;
            }
        }

        if (mostRepeated != null) {
            maxRepeated = mostRepeated.getKey();
        }
        return maxRepeated;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        List<String> evenWordsList = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

        for (String currentWord : words) {
            int i = 0;
            if (wordMap.containsKey(currentWord)) {
                i = wordMap.get(currentWord) + 1;
                wordMap.put(currentWord, i);
                if (i % 2 == 0) {
                    evenWordsList.add(currentWord);
                }
            } else {
                wordMap.put(currentWord, i + 1);
            }
        }
        return evenWordsList;
    }

    /**
     * Loop over the given string to build a result string like this:
     * when a character appears the 2nd, 4th, 6th, etc. time in the string, append the character to the result.
     * <p>
     * Return the empty string if no character appears a 2nd time.
     * <p>
     * Use map to count times that character has appeared.
     * Easy way to get char array (char[]) from string: input.toCharArray();
     *
     * @param input string
     * @return string
     */
    public static String onlyEvenCharacters(String input) {
        String[] charactersList = input.split("");
        String result = "";
        Map<String, Integer> characterMap = new HashMap<>();

        for (String currentCharacter : charactersList) {
            int i = 0;
            if (characterMap.containsKey(currentCharacter)) {
                i = characterMap.get(currentCharacter) + 1;
                characterMap.put(currentCharacter, i);
                if (i % 2 == 0) {
                    result = result + currentCharacter;
                }
            } else {
                characterMap.put(currentCharacter, i + 1);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(wordCount(new String[]{})); // empty
        System.out.println(wordCount(new String[]{"eggs", "SPAM", "eggs", "bacon", "SPAM", "bacon", "SPAM"}));
       //  {bacon=2, eggs=2, SPAM=3}

        System.out.println();
        System.out.println(mostFrequentWord(new String[]{})); // null
        System.out.println(mostFrequentWord(new String[]{"SPAM", "SPAM", "eggs", "bacon", "and", "SPAM"})); // SPAM

        System.out.println();
        System.out.println(onlyEvenWords(Arrays.asList("tere", "tere", "vanakere"))); // [tere]
        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "a", "b"))); // [a, b]
        System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]

        System.out.println();
        System.out.println(onlyEvenCharacters("aaa")); // a
        System.out.println(onlyEvenCharacters("aabbcaca")); // abca
        System.out.println(onlyEvenCharacters("bob")); // b
        System.out.println("\"" + onlyEvenCharacters("abc") + "\""); // ""
    }
}
