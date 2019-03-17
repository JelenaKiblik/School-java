package ee.taltech.iti0202.files.input;
import ee.taltech.iti0202.files.exception.FileReaderException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> text = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text.add(sb.toString());
        } catch (IOException e) {
            throw new FileReaderException("No such file", e.getCause());
        }
        return text;
    }
}
