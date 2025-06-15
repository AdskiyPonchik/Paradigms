package pgp_buttons;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class PrintClickHistoryPGPButton extends PGPButton {
    public PrintClickHistoryPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("I was clicked at: " + now.format(formatter));
    }
}