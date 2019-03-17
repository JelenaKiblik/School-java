package ee.taltech.iti0202.files.morse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MorseTranslator {

    private Map<String, String> morseCode = new HashMap<>();

    public Map<String, String> addMorseCodes(List<String> lines) {
//        Iterator<String> it = lines.iterator();
//        while (it.hasNext()) {
//            morseCode.put(it.next(), it.next());
//        }
//        return morseCode;
        for (int i = 0; i < lines.size()-1; i ++) {
            morseCode.put(lines.get(i), lines.get(i+1));
        }
        return morseCode;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> toMorseCode = new ArrayList<>();
        for (String line : lines) {
            toMorseCode.add(translateLineToMorse(line));
        }
        return toMorseCode;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> fromMorse = new ArrayList<>();
        for (String line: lines) {
            fromMorse.add(translateLineFromMorse(line));
        }
        return fromMorse;
    }

    private String translateLineToMorse(String line) {
        String newText = "";
        String selectedChar;
        String convertedChar;
        for (int i = 0; i < line.length(); i++) {
            selectedChar = line.charAt(i) + "";
            convertedChar = encode(selectedChar);
            if (convertedChar.equals(" ")) {
                newText = newText + "\t";
            } else {
                newText = newText + convertedChar;
                if (!convertedChar.equals(" ")) {
                    newText = newText + " ";
                }
            }
        }
        return newText;
    }

    private String translateLineFromMorse(String line) {
        String text = "";
        String selectedChar;
        String convertedChar;
        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : line.trim().split(" ")) {
            if (!word.equals("")) {
                wordsList.add(word);
            }
        }
        for (String s : wordsList) {
            selectedChar = s;
            convertedChar = decode(selectedChar);
            if (convertedChar.equals(" ")) {
                text = text + " ";
            } else {
                text = text + convertedChar;
                if (!convertedChar.equals(" ")) {
                    text = text;
                }
            }
        }
        return text;

    }

    private String encode(String toEncode) {
        StringBuilder morse = new StringBuilder();
        for (Map.Entry<String, String> codes : morseCode.entrySet()) {
            if (codes.getKey().toLowerCase().contains(toEncode.toLowerCase())) {
                morse.append(codes.getValue());
            }
        }
        return morse.toString();
    }
    private String decode(String toDecode) {
        StringBuilder decode = new StringBuilder();
        ArrayList<String> something = new ArrayList<>();
        for (Map.Entry<String, String> codes : morseCode.entrySet()) {
            if (!something.contains(codes.getValue())) {
                something.add(codes.getValue());
            }
            if (something.contains(toDecode)) {
                decode.append(codes.getKey());
            }
        }
        return Character.toString(decode.charAt(0)).toLowerCase();
    }
}
