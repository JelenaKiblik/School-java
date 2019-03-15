package ee.taltech.iti0202.logger;
import ee.taltech.iti0202.logger.filter.LogFilter;
import ee.taltech.iti0202.logger.formatter.LogFormatter;
import ee.taltech.iti0202.logger.level.Level;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogger extends Logger {

    public FileLogger(String tag, String logFilePath) {
        super(tag);
        Path path = Paths.get(logFilePath, "to", "example.txt");
        // super + do something with logFilePath
    }

    public FileLogger(String tag, String logFilePath, Level level) {
        super(tag, level);
        Path path = Paths.get(logFilePath, "to", "example.txt");
        // super + do something with logFilePath
    }

    public FileLogger(String tag, String logFilePath, Level level, LogFormatter formatter) {
        super(tag, level, formatter);
        Path path = Paths.get(logFilePath, "to", "example.txt");
        // super + do something with logFilePath
    }

    public FileLogger(String tag, String logFilePath, LogFilter filter, LogFormatter formatter) {
        super(tag, filter, formatter);
        Path path = Paths.get(logFilePath, "to", "example.txt");
        // super + do something with logFilePath
    }

    @Override
    protected void writeLog(String message) {
        Path path = Paths.get("path", "to", "example.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(message);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
        // append to log file if exists
        // if doesn't exist create file
    }
}