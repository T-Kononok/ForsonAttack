import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;

public class ForconsRenderer implements ListCellRenderer<String> {

    private JPanel fon2 = new JPanel();
    private JLabel number = new JLabel();
    private JSVGCanvas svgBard = new JSVGCanvas();
    private JSVGCanvas svgInsectoid = new JSVGCanvas();
    private JSVGCanvas svgSamurai = new JSVGCanvas();
    private JSVGCanvas svgSmotritel = new JSVGCanvas();
    private JLabel name = new JLabel();
    private JLabel level = new JLabel();
    private JSVGCanvas svgPoint0 = new JSVGCanvas();
    private JSVGCanvas svgPoint1 = new JSVGCanvas();
    private JSVGCanvas svgPoint2 = new JSVGCanvas();
    private JSVGCanvas svgPoint3 = new JSVGCanvas();
    private JSVGCanvas svgPoint4 = new JSVGCanvas();
    private JSVGCanvas svgPoint5 = new JSVGCanvas();
    private JSVGCanvas svgPoint6 = new JSVGCanvas();
    private JSVGCanvas svgPoint7 = new JSVGCanvas();
    private JLabel point = new JLabel();
    private Font fontName = new Font("Verdana", Font.BOLD, 15);

    ForconsRenderer() {

        Font fontN = new Font("Verdana", Font.BOLD, 10);
        Font font = new Font("Verdana", Font.BOLD, 15);
        number.setFont(fontN);
        number.setVerticalAlignment(JLabel.CENTER);
        number.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(fontName);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.CENTER);
        level.setFont(font);
        level.setVerticalAlignment(JLabel.CENTER);
        level.setHorizontalAlignment(JLabel.CENTER);
        point.setFont(font);
        point.setVerticalAlignment(JLabel.CENTER);
        point.setHorizontalAlignment(JLabel.CENTER);
        svgBard.setURI("file:/D:/Джава/Forcons/b.svg");
        svgSamurai.setURI("file:/D:/Джава/Forcons/s.svg");
        svgInsectoid.setURI("file:/D:/Джава/Forcons/i.svg");
        svgSmotritel.setURI("file:/D:/Джава/Forcons/sm.svg");

        svgBard.setBackground(new Color(0,0,0,0));
        svgSamurai.setBackground(new Color(0,0,0,0));
        svgInsectoid.setBackground(new Color(0,0,0,0));
        svgSmotritel.setBackground(new Color(0,0,0,0));

        svgBard.setSize(60, 60);
        svgSamurai.setSize(60, 60);
        svgInsectoid.setSize(60, 60);
        svgSmotritel.setSize(60, 60);

        JPanel fon = new JPanel();
        fon.add(svgBard);
        fon.add(svgSamurai);
        fon.add(svgInsectoid);
        fon.add(svgSmotritel);

        svgPoint0.setURI("file:/D:/Джава/Forcons/point0.svg");
        svgPoint1.setURI("file:/D:/Джава/Forcons/point1.svg");
        svgPoint2.setURI("file:/D:/Джава/Forcons/point2.svg");
        svgPoint3.setURI("file:/D:/Джава/Forcons/point3.svg");
        svgPoint4.setURI("file:/D:/Джава/Forcons/point4.svg");
        svgPoint5.setURI("file:/D:/Джава/Forcons/point5.svg");
        svgPoint6.setURI("file:/D:/Джава/Forcons/point6.svg");
        svgPoint7.setURI("file:/D:/Джава/Forcons/point7.svg");

        svgPoint0.setBackground(new Color(0,0,0,0));
        svgPoint1.setBackground(new Color(0,0,0,0));
        svgPoint2.setBackground(new Color(0,0,0,0));
        svgPoint3.setBackground(new Color(0,0,0,0));
        svgPoint4.setBackground(new Color(0,0,0,0));
        svgPoint5.setBackground(new Color(0,0,0,0));
        svgPoint6.setBackground(new Color(0,0,0,0));
        svgPoint7.setBackground(new Color(0,0,0,0));

        svgPoint0.setSize(110,30);
        svgPoint1.setSize(110,30);
        svgPoint2.setSize(110,30);
        svgPoint3.setSize(110,30);
        svgPoint4.setSize(110,30);
        svgPoint5.setSize(110,30);
        svgPoint6.setSize(110,30);
        svgPoint7.setSize(110,30);

        fon.add(svgPoint0);
        fon.add(svgPoint1);
        fon.add(svgPoint2);
        fon.add(svgPoint3);
        fon.add(svgPoint4);
        fon.add(svgPoint5);
        fon.add(svgPoint6);
        fon.add(svgPoint7);

        fon.setPreferredSize(new Dimension(190,60));
        fon.setLayout(null);
        fon.add(number);
        number.setSize(20,60);
        number.setLocation(0,0);

        fon.add(name);
        name.setSize(80,30);
        name.setLocation(80,0);
        fon.add(level);
        level.setSize(30,30);
        level.setLocation(160,0);
        fon.add(point);
        point.setSize(110,30);
        point.setLocation(80,30);
        fon2.add(fon);
    }

    public Component getListCellRendererComponent(JList<? extends String> list, String string, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        String[] subStr;
        String delimeter = ", ";
        subStr = string.split(delimeter);

        number.setText(subStr[0]);

        switch (subStr[1]) {
            case ("b"):
                svgBard.setLocation(20, 0);
                svgSamurai.setLocation(20, 1000);
                svgInsectoid.setLocation(20, 1000);
                svgSmotritel.setLocation(20, 1000);
                break;
            case ("s"):
                svgBard.setLocation(20, 1000);
                svgSamurai.setLocation(20, 0);
                svgInsectoid.setLocation(20, 1000);
                svgSmotritel.setLocation(20, 1000);
                break;
            case ("i"):
                svgBard.setLocation(20, 1000);
                svgSamurai.setLocation(20, 1000);
                svgInsectoid.setLocation(20, 0);
                svgSmotritel.setLocation(20, 1000);
                break;
            case ("sm"):
                svgBard.setLocation(20, 1000);
                svgSamurai.setLocation(20, 1000);
                svgInsectoid.setLocation(20, 1000);
                svgSmotritel.setLocation(20, 0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Не правильно написано навзание класса!",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }

        name.setText(subStr[2]);

        if ((double)name.getFontMetrics(fontName).stringWidth(name.getText()) > (double)name.getWidth()) {
            int newFontSize = (int) (fontName.getSize() * (double) name.getWidth() /
                    ((double) name.getFontMetrics(fontName).stringWidth(name.getText()) + 20));
            name.setFont(new Font(fontName.getName(), Font.BOLD, newFontSize));
        }
        else
            name.setFont(fontName);

        switch (subStr[3]) {
            case ("1"):
                level.setText("I");
                break;
            case ("2"):
                level.setText("II");
                break;
            case ("3"):
                level.setText("III");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Не правильно написан уровень!",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }

        int pointInt = Integer.parseInt(subStr[4]);
        switch (pointInt) {
            case (0):
                svgPoint0.setLocation(80,30);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (1):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,30);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (2):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,30);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (3):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,30);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (4):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,30);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (5):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,30);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (6):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,30);
                svgPoint7.setLocation(80,1000);
                point.setText("");
                break;
            case (7):
                svgPoint0.setLocation(80,1000);
                svgPoint1.setLocation(80,1000);
                svgPoint2.setLocation(80,1000);
                svgPoint3.setLocation(80,1000);
                svgPoint4.setLocation(80,1000);
                svgPoint5.setLocation(80,1000);
                svgPoint6.setLocation(80,1000);
                svgPoint7.setLocation(80,30);
                point.setText("");
                break;
            default:
                if (pointInt > 0) {
                    svgPoint0.setLocation(80,1000);
                    svgPoint1.setLocation(80,1000);
                    svgPoint2.setLocation(80,1000);
                    svgPoint3.setLocation(80,1000);
                    svgPoint4.setLocation(80,1000);
                    svgPoint5.setLocation(80,1000);
                    svgPoint6.setLocation(80,1000);
                    svgPoint7.setLocation(80,1000);
                    point.setText(subStr[4] + " о. д.");
                }
                else
                    JOptionPane.showMessageDialog(null, "Не правильно написано кол-во действий!",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                break;
        }

        Color fonFors;
        if (isSelected) {
            fonFors = new Color(218, 165, 32);
        } else {
            fonFors = new Color(192,192,192);
        }
        fon2.setBackground(fonFors);

        return fon2;
    }

    String getNumber() {
        return number.getText();
    }
}