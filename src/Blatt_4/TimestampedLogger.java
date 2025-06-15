package Blatt_4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedLogger extends BaseLogger {
    private final Logger wrappedLogger;
    public TimestampedLogger(Logger wrappedLogger){
        this.wrappedLogger = wrappedLogger;
    }

    @Override
    protected void writeLog(String format, Object... args) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String messageWithTimestamp = "[" + timestamp + "] " + format;
        wrappedLogger.log(currentLevel, messageWithTimestamp, args);
    }
}

