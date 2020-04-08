import javax.swing.*;
import java.awt.*;

class JImagePanel extends JPanel {

    private Image backgroundImage = new ImageIcon("fon.jpg").getImage();

    public void paintComponent(Graphics g)
    {
        g.drawImage(backgroundImage, 0, 0, null);
    }

}

