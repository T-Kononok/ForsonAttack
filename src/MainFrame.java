import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class MainFrame extends JFrame {

    private JFileChooser fileChooser = null;

    private MainFrame() {

        super("Управление атакой форсонов");

        setExtendedState(MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);

        JMenu openJournalMenu = new JMenu("Открыть журнал");
        fileMenu.add(openJournalMenu);
        JMenuItem openJournal_10FM3_Menu = openJournalMenu.add("10 ФМ-3");
        openJournal_10FM3_Menu.addActionListener(ev -> {
            if (fileChooser==null) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
            }
            //if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
                //openGraphics(fileChooser.getSelectedFile());
        });
        JMenuItem openJournal_11FM2_Menu = openJournalMenu.add("11 ФМ-2");
        openJournal_11FM2_Menu.addActionListener(ev -> {
            if (fileChooser==null) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
            }
            //if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
            //openGraphics(fileChooser.getSelectedFile());
        });
        JMenuItem openJournal_11FM3_Menu = openJournalMenu.add("11 ФМ-3");
        openJournal_11FM3_Menu.addActionListener(ev -> {
            if (fileChooser==null) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
            }
            //if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
            //openGraphics(fileChooser.getSelectedFile());
        });

        JMenuItem openForconsMenu = fileMenu.add("Открыть форсонов");
        openForconsMenu.addActionListener(ev -> {
            if (fileChooser==null) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
            }
            //if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
            //openGraphics(fileChooser.getSelectedFile());
        });

        JMenuItem saveMenu = fileMenu.add("Сохранить");
        saveMenu.addActionListener(ev -> {
            if (fileChooser==null) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
            }
            //if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
            //saveToGraphicsFile(fileChooser.getSelectedFile());
        });

        JTable journalTable = new JTable();
        JScrollPane journalTableScroll = new JScrollPane(journalTable);
        journalTableScroll.setPreferredSize(new Dimension(1050, 1000));

        JList ForconsList = new JList();
        JScrollPane ForconsListScroll = new JScrollPane(ForconsList);
        ForconsListScroll.setPreferredSize(new Dimension(250, 1000));


        Box hboxJandF = Box.createHorizontalBox();
        hboxJandF.add(Box.createHorizontalGlue());
        hboxJandF.add(new JScrollPane(journalTableScroll));
        hboxJandF.add(new JScrollPane(ForconsListScroll));
        hboxJandF.add(Box.createHorizontalGlue());

        Box hboxSkills = Box.createHorizontalBox();
        hboxSkills.add(Box.createHorizontalStrut(100));
        hboxSkills.add(new JLabel("Способность"));
        hboxSkills.add(Box.createHorizontalStrut(10));
        hboxSkills.add(new JLabel("Способность"));
        hboxSkills.add(Box.createHorizontalStrut(10));
        hboxSkills.add(new JLabel("Способность"));
        hboxSkills.add(Box.createHorizontalStrut(10));
        hboxSkills.add(new JLabel("Способность"));
        hboxSkills.add(Box.createHorizontalGlue());

        Box contentBox = Box.createVerticalBox();
        contentBox.add(hboxJandF);
        contentBox.add(Box.createVerticalStrut(20));
        contentBox.add(hboxSkills);
        contentBox.add(Box.createVerticalStrut(20));
        getContentPane().add(contentBox, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
