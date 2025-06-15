package pgp_buttons;
import java.awt.Color;
public class RecolorPGPButton extends PGPButton {
    public RecolorPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        Color newColor = getRandomColor();
        this.setBackground(newColor);
    }

    private Color getRandomColor(){
        // random generates number from 0.0 to 1.0
        int r =(int)(Math.random() * 256);
        int g =(int)(Math.random() * 256);
        int b =(int)(Math.random() * 256);
        return new Color(r, g, b);
    }
}