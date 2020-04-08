import org.apache.batik.swing.JSVGCanvas;
import java.awt.*;
import java.io.File;
import java.util.Objects;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JFileChooser fileChooser = null;

    private MainFrame() {

        super("Управление атакой форсонов");

        setExtendedState(MAXIMIZED_BOTH);

        //Создаем панель-контейнер с фоном
        JImagePanel panelFull = new JImagePanel();
        panelFull.setLayout(null);
        panelFull.setSize(1280,658);
        panelFull.setLocation(0,0);

        //создаем кнопку меню
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(45,25);
        menuBar.setLocation(0,0);
        panelFull.add(menuBar);

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

        //Создаем скрол-таблицу журнала
        JTable journalTable = new JTable();
        JScrollPane journalTableScroll = new JScrollPane(journalTable);
        panelFull.add(journalTableScroll);
        journalTableScroll.setSize(1050, 533);
        journalTableScroll.setLocation(0,25);

        //Создаем скрол-список форсонов
        DefaultListModel<String> forconsListModel = new DefaultListModel<>();
        forconsListModel.addElement("1, Бард, Горшок, 3, 6");
        forconsListModel.addElement("2, Самурай, Дыо, 2, 2");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Бард, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Инсектоид, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");
        forconsListModel.addElement("3, Самурай, Гатс, 3, 5");

        JList<String> forconsList = new JList<>(forconsListModel);
        forconsList.setCellRenderer(new ForconsRenderer());
        forconsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane forconsListScroll = new JScrollPane(forconsList);
        panelFull.add(forconsListScroll);
        forconsListScroll.setSize(220, 533);
        forconsListScroll.setLocation(1060,25);

        //Создаем пикчу класса

        //Создаем надпись имени

        //Создаем кнопки-способности
        JButton butSkill1 = new JButton();
        JButton butSkill2 = new JButton();
        JButton butSkill3 = new JButton();
        JButton butSkill4 = new JButton();
        JButton butSkill5 = new JButton();
        JButton butSkill6 = new JButton();
        butSkill1.setLayout(null);
        butSkill2.setLayout(null);
        butSkill3.setLayout(null);
        butSkill4.setLayout(null);
        butSkill5.setLayout(null);
        butSkill6.setLayout(null);
        panelFull.add(butSkill1);
        panelFull.add(butSkill2);
        panelFull.add(butSkill3);
        panelFull.add(butSkill4);
        panelFull.add(butSkill5);
        panelFull.add(butSkill6);
        int interval = 50;
        butSkill1.setSize(50,50);
        butSkill1.setLocation((panelFull.getWidth()-(butSkill1.getWidth()+interval)*6+interval)/2,583);
        butSkill2.setSize(butSkill1.getSize());
        butSkill2.setLocation(butSkill1.getX()+butSkill1.getWidth()+interval,butSkill1.getY());
        butSkill3.setSize(butSkill1.getSize());
        butSkill3.setLocation(butSkill2.getX()+butSkill1.getWidth()+interval,butSkill1.getY());
        butSkill4.setSize(butSkill1.getSize());
        butSkill4.setLocation(butSkill3.getX()+butSkill1.getWidth()+interval,butSkill1.getY());
        butSkill5.setSize(butSkill1.getSize());
        butSkill5.setLocation(butSkill4.getX()+butSkill1.getWidth()+interval,butSkill1.getY());
        butSkill6.setSize(butSkill1.getSize());
        butSkill6.setLocation(butSkill5.getX()+butSkill1.getWidth()+interval,butSkill1.getY());


        JSVGCanvas svgCanvas1 = new JSVGCanvas();
        JSVGCanvas svgCanvas2 = new JSVGCanvas();
        JSVGCanvas svgCanvas3 = new JSVGCanvas();
        JSVGCanvas svgCanvas4 = new JSVGCanvas();
        JSVGCanvas svgCanvas5 = new JSVGCanvas();
        JSVGCanvas svgCanvas6 = new JSVGCanvas();
        svgCanvas1.setURI("file:/D:/Джава/Forcons/Skill1.svg");
        svgCanvas2.setURI("file:/D:/Джава/Forcons/Skill2.svg");
        svgCanvas3.setURI("file:/D:/Джава/Forcons/Skill3.svg");
        svgCanvas4.setURI("file:/D:/Джава/Forcons/Skill4.svg");
        svgCanvas5.setURI("file:/D:/Джава/Forcons/Skill5.svg");
        svgCanvas6.setURI("file:/D:/Джава/Forcons/Skill6.svg");
        svgCanvas1.setSize(50,50);
        svgCanvas1.setLocation(0,0);
        svgCanvas2.setSize(50,50);
        svgCanvas2.setLocation(0,0);
        svgCanvas3.setSize(50,50);
        svgCanvas3.setLocation(0,0);
        svgCanvas4.setSize(50,50);
        svgCanvas4.setLocation(0,0);
        svgCanvas5.setSize(50,50);
        svgCanvas5.setLocation(0,0);
        svgCanvas6.setSize(50,50);
        svgCanvas6.setLocation(0,0);

        butSkill1.add(svgCanvas1);
        butSkill2.add(svgCanvas2);
        butSkill3.add(svgCanvas3);
        butSkill4.add(svgCanvas4);
        butSkill5.add(svgCanvas5);
        butSkill6.add(svgCanvas6);

        //Создаем пикчи кол-ва действий

        getContentPane().setLayout(null);
        getContentPane().add(panelFull);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}