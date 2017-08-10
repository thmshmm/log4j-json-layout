package de.thmshmm.log4j;

/**
 * Created by Thomas Hamm on 27.07.17.
 */
public class LogItem {
    private final String timestamp;
    private final String level;
    private final String logger;
    private final String thread;
    private final String message;

    public LogItem(String timestamp, String level, String logger, String thread, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.logger = logger;
        this.thread = thread;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getLogger() {
        return logger;
    }

    public String getThread() {
        return thread;
    }

    public String getMessage() {
        return message;
    }
}
