package Blatt_4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.Level;

enum LogLevel {
    Trace,
    Debug,
    Info,
    Warn,
    Error;
}

interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }

    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }

    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }

    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }

    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }

    void setLogLevel(LogLevel level);

    void log(LogLevel level, String format, Object... args);
}

class Logging {
    public abstract static class LoggerDecorator implements Logger {
        protected Logger wrappedLogger;

        public LoggerDecorator(Logger wrappedLogger) {
            this.wrappedLogger = wrappedLogger;
        }

        @Override
        public void setLogLevel(LogLevel level) {
            wrappedLogger.setLogLevel(level);
        }

        @Override
        public void log(LogLevel level, String format, Object... args) {
            wrappedLogger.log(level, format, args);
        }

    }

    public static void main(String[] args) {
        String testFilePath = "test.txt";
        System.out.println("=== Running Logger Tests ===");

        testLeveledLogger();
        //testFileLogger(testFilePath);

        System.out.println("=== Tests Completed ===");
    }

    private static void testLeveledLogger() {
        System.out.println("\n> Testing LeveledLogger:");
        Logger baseLogger = new ConsoleLogger();
        Logger timedLogger = new TimestampedLogger(baseLogger);
        Logger leveledLogger = new LeveledLogger(LogLevel.Warn, timedLogger);
        System.out.println("Log level set to WARN. The following DEBUG message should NOT appear:");
        leveledLogger.debug("This debug message should not be visible");
        System.out.println("The following ERROR message should appear:");
        leveledLogger.error("This is an error message that should be visible");
    }

    private static void testFileLogger(String filePath) {
        System.out.println("\n> Testing FileLogger:");
        Logger fileLogger = new FileLogger(filePath);

        fileLogger.info("This log message should be written to the file");
        fileLogger.error("This is an error message also written to file (timestamp: %s)",
                java.time.LocalDateTime.now().toString());
        try {
            if (Files.exists(Paths.get(filePath))) {
                System.out.println("Success: Log messages written to " + filePath);
                System.out.println("File content (last 2 lines):");
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                String[] lines = content.split("\n");
                if (lines.length > 0) {
                    int start = Math.max(0, lines.length - 2);
                    for (int i = start; i < lines.length; i++) {
                        System.out.println("  " + lines[i]);
                    }
                }
            } else {
                System.out.println("Error: File " + filePath + " not found after logging");
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}