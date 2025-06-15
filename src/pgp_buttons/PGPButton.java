package pgp_buttons;

import javax.swing.*;
import java.awt.*;

public class PGPButton extends JButton {
    /* static constants to define width and height of buttons */
    private final static int BUT_WIDTH = 200;
    private final static int BUT_HEIGHT = 25;

    /* several constructors */
    public PGPButton() {
        this(null, null);
    }

    public PGPButton(String label) {
        this(label, null);
    }

    public PGPButton(Icon icon) {
        this(null, icon);
    }

    public PGPButton(String label, Icon icon) {
        super(label, icon);
        // set button size
        this.setPreferredSize(new Dimension(BUT_WIDTH, BUT_HEIGHT));

        // add action listener which calls the click method if button is clicked
        this.addActionListener(actionListener -> this.click());
        this.setVisible(true);
    }

    public void click() {
        System.out.println("Button was clicked!");
    }
}