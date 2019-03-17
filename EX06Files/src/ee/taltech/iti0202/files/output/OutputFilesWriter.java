package ee.taltech.iti0202.files.output;
import ee.taltech.iti0202.files.exception.FileReaderException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.io.IOException;

public class OutputFilesWriter {

    public boolean writeLinesToFile(List<String> lines, String filename) {
        BufferedWriter bufferedWriter;
        try {
            FileOutputStream output = new FileOutputStream(filename);

            Writer writer = new OutputStreamWriter(new GZIPOutputStream(output), StandardCharsets.UTF_8);

            bufferedWriter = new BufferedWriter(writer);
            for (String arrayListItem : lines) {
                bufferedWriter.write(arrayListItem);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            throw new FileReaderException("No such file", e.getCause());
        }
    }
}
