package ee.taltech.iti0202.files.input;
import ee.taltech.iti0202.files.exception.FileReaderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> text = new ArrayList<>();
        File file =new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            throw new FileReaderException("No such file", e.getCause());
        }
        while(sc.hasNextLine()){
            text.add(sc.nextLine());
        }
        return text;
    }
}
