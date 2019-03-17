package ee.taltech.iti0202.files.input;
import ee.taltech.iti0202.files.exception.FileReaderException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> text = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            throw new FileReaderException("No such file", e.getCause());
        }
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }
        return text;
    }
}
