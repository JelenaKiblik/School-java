package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {

    private Map<String, String> morseCodeMap = new HashMap<>();

    public Map<String, String> addMorseCodes(List<String> lines) {
        Iterator<String> it = lines.iterator();
        while(it.hasNext()) {
            morseCodeMap.put(it.next(), it.next());
        }
        return morseCodeMap;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> morseCodeList = new ArrayList<>();
        for (String line : lines) {
            morseCodeList.add(translateLineToMorse(line));
        }
        return morseCodeList;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> fromMorse = new ArrayList<>();
        for (String line: lines) {
            fromMorse.add(translateLineFromMorse(line));
        }
        return fromMorse;
    }

    private String translateLineToMorse(String line) {
        StringBuilder text = new StringBuilder();
        String selectedChar;
        String convertedChar;
        for (int i = 0; i < line.length(); i++) {
            selectedChar = line.charAt(i) + "";
            convertedChar = encode(selectedChar);
            if (convertedChar.equals(" ")) {
                text.append("\t");
            } else {
                text.append(convertedChar);
                text.append(" ");
            }
        }
        return text.toString();
    }

    private String translateLineFromMorse(String line) {
        StringBuilder text = new StringBuilder();
        String selectedChar;
        String convertedChar;
        ArrayList<String> wordArrayList = new ArrayList<>();
        for (String word : line.trim().split(" ")) {
            if (!word.equals("")) {
                wordArrayList.add(word);
            }
        }
        for (String s : wordArrayList) {
            selectedChar = s;
            convertedChar = decode(selectedChar);
            if (convertedChar.equals(" ")) {
                text.append(" ");
            } else {
                text.append(convertedChar);
            }
        }
        return text.toString();

    }

    private String encode(String toEncode) {
        StringBuilder morse = new StringBuilder();
        for (Map.Entry<String, String> codes : morseCodeMap.entrySet()) {
            if (codes.getKey().toLowerCase().contains(toEncode.toLowerCase())) {
                morse.append(codes.getValue());
            }
        }
        return morse.toString();
    }
    private String decode(String toDecode) {
        StringBuilder decode = new StringBuilder();
        ArrayList<String> something = new ArrayList<>();
        for (Map.Entry<String, String> codes : morseCodeMap.entrySet()) {
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
