import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

class MyScrollbarUI extends BasicScrollBarUI {

    private ImageIcon downArrow, upArrow, leftArrow, rightArrow;
    private Image imageTumb = new ImageIcon("fon2.jpg").getImage();
    private Image imageTrack = new ImageIcon("fon.jpg").getImage();

    MyScrollbarUI(){
        try {
            upArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-up-icon.png"));
            downArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-down-icon.png"));
            rightArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-right-icon.png"));
            leftArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-left-icon.png"));
        }
        catch (java.net.MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton decreaseButton = new JButton(getAppropriateIcon(orientation)) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(22, 22);
            }
        };
        decreaseButton.setBorderPainted(false);
        decreaseButton.setContentAreaFilled(false);
        return decreaseButton;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton increaseButton = new JButton(getAppropriateIcon(orientation)){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(22, 22);
            }
        };
        increaseButton.setBorderPainted(false);
        increaseButton.setContentAreaFilled(false);
        return increaseButton;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

        g.drawImage(imageTrack,0,0, null);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {

        g.drawImage(imageTumb,r.x, r.y, r.width, r.height, null);
        System.out.println(r.width);

    }

    @Override
    protected void layoutHScrollbar(JScrollBar sb) {
        //TODO Auto-generated method stub
        sb.setBackground(Color.RED);
        sb.setBorder(BorderFactory.createEmptyBorder());
        sb.setOpaque(true);
        super.layoutHScrollbar(sb);
    }

    private ImageIcon getAppropriateIcon(int orientation) {
        switch(orientation){
            case SwingConstants.SOUTH:
                return downArrow;
            case SwingConstants.NORTH:
                return upArrow;
            case SwingConstants.EAST:
                return rightArrow;
            default:
                return leftArrow;
        }
    }
}
