package Blatt_4;

public class ConsoleLogger extends BaseLogger {

    @Override
    protected void writeLog(String format, Object... args) {
        System.out.println(String.format(format, args));  // Выводим в консоль
    }
}
