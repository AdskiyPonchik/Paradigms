package pgp_buttons;
import java.awt.Point;

public class PrintPositionPGPButton extends PGPButton {
    public PrintPositionPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        Point position = this.getLocation();
        System.out.println("Button position: X = " + position.x + ", Y = " + position.y);
    }
}
