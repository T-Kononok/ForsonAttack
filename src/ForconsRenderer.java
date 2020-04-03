import javax.swing.*;
import java.awt.*;

public class ForconsRenderer implements ListCellRenderer<String> {

    private JPanel fon = new JPanel();
    private JLabel n = new JLabel();
    private JLabel name = new JLabel();
    private JLabel level = new JLabel();
    private JLabel point = new JLabel();
    private JLabel jpg = new JLabel();

    ForconsRenderer() {
        fon.setOpaque(true);
        name.setOpaque(true);
        n.setOpaque(true);
        level.setOpaque(true);
        point.setOpaque(true);

        fon.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        n.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        name.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        level.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        point.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        jpg.setBorder(
                BorderFactory.createLineBorder(Color.RED));

        Box naLe = Box.createHorizontalBox();
        naLe.add(Box.createHorizontalStrut(10));
        naLe.add(name);
        naLe.add(Box.createHorizontalGlue());
        naLe.add(level);
        naLe.add(Box.createHorizontalStrut(10));
        naLe.setBorder(
                BorderFactory.createLineBorder(Color.RED));

        Box naLePo = Box.createVerticalBox();
        naLePo.add(Box.createVerticalStrut(5));
        naLePo.add(naLe);
        naLePo.add(Box.createVerticalStrut(5));
        naLePo.add(point);
        naLePo.add(Box.createVerticalStrut(5));
        naLePo.setBorder(
                BorderFactory.createLineBorder(Color.RED));

        Box full = Box.createHorizontalBox();
        full.add(Box.createHorizontalGlue());
        full.add(n);
        full.add(Box.createHorizontalStrut(10));
        full.add(jpg);
        full.add(naLePo);
        full.add(Box.createHorizontalGlue());
        full.setBorder(
                BorderFactory.createLineBorder(Color.RED));

        fon.add(full);
    }

    public Component getListCellRendererComponent(JList<? extends String> list, String string, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        String[] subStr;
        String delimeter = ", ";
        subStr = string.split(delimeter);
        n.setText(subStr[0]);
        jpg.setText(subStr[1]);
        name.setText(subStr[2]);
        level.setText(subStr[3]);
        point.setText(subStr[4] + "дейстивий");

        Color fonFors = new Color(192, 192, 192);
        if (isSelected) {
            fonFors = new Color(218, 165, 32);
        } else {
            fonFors = new Color(192,192,192);
        }
        fon.setBackground(fonFors);
        name.setBackground(fonFors);
        n.setBackground(fonFors);
        level.setBackground(fonFors);
        point.setBackground(fonFors);

        return fon;
    }
}