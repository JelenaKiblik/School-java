package ee.taltech.iti0202.files.input;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> text = new ArrayList<>();
        try (Scanner scanner = new Scanner(filename)) {
            while (scanner.hasNextLine()) {
                text.add(scanner.nextLine());
            }
        }
        return text;
    }
}
