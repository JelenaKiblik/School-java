package ee.taltech.iti0202.files.output;
import ee.taltech.iti0202.files.exception.FileReaderException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OutputFilesWriter {

    public boolean writeLinesToFile(List<String> lines, String filename) {
        try {
            Path file = Paths.get(filename);
            Files.write(file, lines, Charset.forName("UTF-8"));
            return true;
        } catch (IOException e) {
            throw new FileReaderException("No such file", e.getCause());
        }
    }
}
