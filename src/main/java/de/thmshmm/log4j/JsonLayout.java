package de.thmshmm.log4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Thomas Hamm on 27.07.17.
 */
public class JsonLayout extends Layout {
    private final ObjectMapper om;
    private SimpleDateFormat dateFormat;

    private static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

    public JsonLayout() {
        this.om = new ObjectMapper();
        this.dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
    }

    public void activateOptions() {
    }

    public boolean ignoresThrowable() {
        return true;
    }

    @Override
    public String format(LoggingEvent loggingEvent) {
        Date timestamp = new Date(loggingEvent.getTimeStamp());

        LogItem li = new LogItem(
                this.dateFormat.format(timestamp),
                loggingEvent.getLevel().toString(),
                loggingEvent.getLoggerName(),
                loggingEvent.getThreadName(),
                loggingEvent.getMessage().toString()
        );

        String out;

        try {
            out = om.writeValueAsString(li);
        } catch (JsonProcessingException e) {
            return "JsonLayout - ERROR formatting log message\n";
        }

        return out + "\n";
    }

    public void setDatePattern(String pattern) {
        try {
            this.dateFormat = new SimpleDateFormat(pattern);
        } catch (Exception e) {
            this.dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
        }
    }
}
