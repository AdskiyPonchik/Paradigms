package Blatt_4;

import java.util.logging.Level;

public class LeveledLogger extends BaseLogger {
    private final Logger wrappedLogger;

    public LeveledLogger(LogLevel level, Logger wrappedLogger){
        this.wrappedLogger = wrappedLogger;
        this.currentLevel = level;
    }
    @Override
    protected void writeLog(String format, Object... args){
        wrappedLogger.log(this.currentLevel, format, args);
    }
}
