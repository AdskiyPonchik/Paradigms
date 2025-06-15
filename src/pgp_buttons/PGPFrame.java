package pgp_buttons;
import javax.swing.*;
import java.awt.*;

public class PGPFrame extends JFrame {

    public PGPFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(5, 0));
        this.setTitle("My PGP-Frame");
        // set frame visible
        this.setVisible(true);
    }

    public void addNewButton(PGPButton button) {
        this.add(button);
        this.pack();
        this.repaint();
    }

    public static void main(String... args) {
        PGPFrame frame = new PGPFrame();

        for (int i = 0; i < 20; i++) {
            String label = String.format("Button_%d", i);
            if (i < 5) {
                frame.addNewButton(new PGPButton(label));
            } else if (i < 10) {
                frame.addNewButton(new RecolorPGPButton(label));
            } else if (i < 15) {
                frame.addNewButton(new PrintPositionPGPButton(label));
            } else if (i < 20) {
                frame.addNewButton(new PrintClickHistoryPGPButton(label));
            }
        }
    }
}