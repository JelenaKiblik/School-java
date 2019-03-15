package ee.taltech.iti0202.logger.formatter;
import ee.taltech.iti0202.logger.log.Log;

public class SimpleFormatter implements LogFormatter {

    @Override
    public String format(Log log) {
        return String.format(log.level.name + "\t" + log.tag + "\t" + log.message);
    }

}
