import org.apache.batik.swing.JSVGCanvas;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {

    private JFileChooser fileChooser = null;
    private ForconsRenderer rend;

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
        forconsListModel.addElement("1, Bard, Горшок, 3, 6");
        forconsListModel.addElement("2, Самурай, АскаМисатоРей, 2, 2");
        forconsListModel.addElement("3, Инсектоид, Стив, 1, 2");
        forconsListModel.addElement("4, Смотритель, Стив, 1, 0");
        forconsListModel.addElement("5, Bard, Горшок, 3, 6");
        forconsListModel.addElement("6, Инсектоид, Аска, 2, 2");
        forconsListModel.addElement("7, Инсектоид, Стив, 1, 8");
        forconsListModel.addElement("8, Смотритель, Стив, 1, 11");
        forconsListModel.addElement("9, Bard, Горшок, 3, 6");
        forconsListModel.addElement("10, Самурай, Аска, 2, 2");
        forconsListModel.addElement("11, Самурай, Стив, 1, 5");
        forconsListModel.addElement("12, Смотритель, Стив, 1, 4");

        JList<String> forconsList = new JList<>(forconsListModel);
        forconsList.setCellRenderer(new ForconsRenderer());
        forconsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane forconsListScroll = new JScrollPane(forconsList);
        panelFull.add(forconsListScroll);
        forconsListScroll.setSize(220, 533);
        forconsListScroll.setLocation(1060,25);

        //создаем пикчи
        JSVGCanvas svgCanvas1 = new JSVGCanvas();
        JSVGCanvas svgCanvas2 = new JSVGCanvas();
        JSVGCanvas svgCanvas3 = new JSVGCanvas();
        JSVGCanvas svgCanvas4 = new JSVGCanvas();
        JSVGCanvas svgCanvas5 = new JSVGCanvas();
        JSVGCanvas svgCanvas6 = new JSVGCanvas();

        svgCanvas1.setURI("file:/D:/Джава/Forcons/bardSkill1.svg");
        svgCanvas2.setURI("file:/D:/Джава/Forcons/bardSkill2.svg");
        svgCanvas3.setURI("file:/D:/Джава/Forcons/bardSkill3.svg");
        svgCanvas4.setURI("file:/D:/Джава/Forcons/bardSkill4.svg");
        svgCanvas5.setURI("file:/D:/Джава/Forcons/bardSkill5.svg");
        svgCanvas6.setURI("file:/D:/Джава/Forcons/bardSkill6.svg");
        svgCanvas1.setSize(70,70);
        svgCanvas1.setLocation(0,0);
        svgCanvas2.setSize(svgCanvas1.getSize());
        svgCanvas2.setLocation(0,0);
        svgCanvas3.setSize(svgCanvas1.getSize());
        svgCanvas3.setLocation(0,0);
        svgCanvas4.setSize(svgCanvas1.getSize());
        svgCanvas4.setLocation(0,0);
        svgCanvas5.setSize(svgCanvas1.getSize());
        svgCanvas5.setLocation(0,0);
        svgCanvas6.setSize(svgCanvas1.getSize());
        svgCanvas6.setLocation(0,0);

        //создаем слушателей мыши и списка
        forconsList.addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                String val = forconsList.getSelectedValue().toString();
                System.out.println(val);
                String[] subStr = val.split(", ");
                switch (subStr[1]) {
                    case ("Бард"):
                    case ("Bard"):
                        svgCanvas1.setURI("file:/D:/Джава/Forcons/bardSkill1.svg");
                        svgCanvas2.setURI("file:/D:/Джава/Forcons/bardSkill2.svg");
                        svgCanvas3.setURI("file:/D:/Джава/Forcons/bardSkill3.svg");
                        svgCanvas4.setURI("file:/D:/Джава/Forcons/bardSkill4.svg");
                        svgCanvas5.setURI("file:/D:/Джава/Forcons/bardSkill5.svg");
                        svgCanvas6.setURI("file:/D:/Джава/Forcons/bardSkill6.svg");
                        break;
                    case ("Самурай"):
                    case ("Samurai"):
                        svgCanvas1.setURI("file:/D:/Джава/Forcons/samuraiSkill1.svg");
                        svgCanvas2.setURI("file:/D:/Джава/Forcons/samuraiSkill2.svg");
                        svgCanvas3.setURI("file:/D:/Джава/Forcons/samuraiSkill3.svg");
                        svgCanvas4.setURI("file:/D:/Джава/Forcons/samuraiSkill4.svg");
                        svgCanvas5.setURI("file:/D:/Джава/Forcons/samuraiSkill5.svg");
                        svgCanvas6.setURI("file:/D:/Джава/Forcons/samuraiSkill6.svg");
                        break;
                    case ("Инсектоид"):
                    case ("Indectoid"):
                        svgCanvas1.setURI("file:/D:/Джава/Forcons/insectSkill1.svg");
                        svgCanvas2.setURI("file:/D:/Джава/Forcons/insectSkill2.svg");
                        svgCanvas3.setURI("file:/D:/Джава/Forcons/insectSkill3.svg");
                        svgCanvas4.setURI("file:/D:/Джава/Forcons/insectSkill4.svg");
                        svgCanvas5.setURI("file:/D:/Джава/Forcons/insectSkill5.svg");
                        svgCanvas6.setURI("file:/D:/Джава/Forcons/insectSkill6.svg");
                        break;
                    case ("Смотритель"):
                    case ("Smotritel"):
                        svgCanvas1.setURI("file:/D:/Джава/Forcons/smotritelSkill1.svg");
                        svgCanvas2.setURI("file:/D:/Джава/Forcons/smotritelSkill2.svg");
                        svgCanvas3.setURI("file:/D:/Джава/Forcons/smotritelSkill3.svg");
                        svgCanvas4.setURI("file:/D:/Джава/Forcons/smotritelSkill4.svg");
                        svgCanvas5.setURI("file:/D:/Джава/Forcons/smotritelSkill5.svg");
                        svgCanvas6.setURI("file:/D:/Джава/Forcons/smotritelSkill6.svg");
                        break;
                }
            }
        });

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
        butSkill1.setSize(70,70);
        butSkill1.setLocation((panelFull.getWidth()-(butSkill1.getWidth()+interval)*6+interval)/2,573);
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