package Blatt_4;

public abstract class BaseLogger implements Logger {
    protected LogLevel currentLevel = LogLevel.Trace;  // Начальный уровень логирования

    @Override
    public void setLogLevel(LogLevel level) {
        this.currentLevel = level;
    }

    protected boolean shouldLog(LogLevel level) {
        return level.ordinal() >= currentLevel.ordinal();
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if (shouldLog(level)) {
            writeLog(format, args);  // В разных логгерах это будет реализовано по-разному
        }
    }
    protected abstract void writeLog(String format, Object... args);
}
