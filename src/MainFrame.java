import org.apache.batik.swing.JSVGCanvas;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ScrollBarUI;

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

        //создаем меню
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
        journalTableScroll.getVerticalScrollBar().setUI(new MyScrollbarUI());
        journalTableScroll.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        journalTableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        journalTableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JImagePanel corner = new JImagePanel();
        journalTableScroll.setCorner(journalTableScroll.LOWER_RIGHT_CORNER, corner);
        journalTableScroll.setBorder(BorderFactory.createEmptyBorder());

        journalTableScroll.setSize(1050, 533);
        journalTableScroll.setLocation(0,25);

        panelFull.add(journalTableScroll);

        //создаем холсты для способностей
        JSVGCanvas svgCanvas1 = new JSVGCanvas();
        JSVGCanvas svgCanvas2 = new JSVGCanvas();
        JSVGCanvas svgCanvas3 = new JSVGCanvas();
        JSVGCanvas svgCanvas4 = new JSVGCanvas();
        JSVGCanvas svgCanvas5 = new JSVGCanvas();
        JSVGCanvas svgCanvas6 = new JSVGCanvas();

        svgCanvas1.setBackground(new Color(0,0,0,0));
        svgCanvas2.setBackground(new Color(0,0,0,0));
        svgCanvas3.setBackground(new Color(0,0,0,0));
        svgCanvas4.setBackground(new Color(0,0,0,0));
        svgCanvas5.setBackground(new Color(0,0,0,0));
        svgCanvas6.setBackground(new Color(0,0,0,0));
        
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

        //Создаем холст класса
        JSVGCanvas svgCanvasClass = new JSVGCanvas();
        svgCanvasClass.setSize(90,90);
        svgCanvasClass.setLocation(5,563);

        svgCanvasClass.setBackground(new Color(0,0,0,0));

        panelFull.add(svgCanvasClass);

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

        butSkill1.setBorderPainted(false);
        butSkill1.setContentAreaFilled(false);
        butSkill2.setBorderPainted(false);
        butSkill2.setContentAreaFilled(false);
        butSkill3.setBorderPainted(false);
        butSkill3.setContentAreaFilled(false);
        butSkill4.setBorderPainted(false);
        butSkill4.setContentAreaFilled(false);
        butSkill5.setBorderPainted(false);
        butSkill5.setContentAreaFilled(false);
        butSkill6.setBorderPainted(false);
        butSkill6.setContentAreaFilled(false);

        panelFull.add(butSkill1);
        panelFull.add(butSkill2);
        panelFull.add(butSkill3);
        panelFull.add(butSkill4);
        panelFull.add(butSkill5);
        panelFull.add(butSkill6);

        //Создаем надпись имени
        JLabel labelName = new JLabel();
        System.out.println(butSkill1.getX());
        labelName.setSize(butSkill1.getX()-125,50);
        labelName.setLocation(105,608-(labelName.getHeight()/2));

        Font fontName = new Font("Verdana", Font.BOLD, 30);
        labelName.setFont(fontName);
        labelName.setVerticalAlignment(JLabel.CENTER);
        labelName.setHorizontalAlignment(JLabel.CENTER);

        labelName.setBorder(BorderFactory.createLineBorder(Color.RED));

        panelFull.add(labelName);

        //Создаем холст и надпись кол-ва действий
        JSVGCanvas svgCanvasPoint = new JSVGCanvas();
        int widthPoint = 1280 - butSkill6.getX() - butSkill6.getWidth() - 20;
        svgCanvasPoint.setSize(widthPoint, 100);
        svgCanvasPoint.setLocation(butSkill6.getX()+butSkill6.getWidth()+10,608-(svgCanvasPoint.getHeight()/2));

        svgCanvasPoint.setBackground(new Color(0,0,0,0));

        JLabel lebelPoint = new JLabel();
        lebelPoint.setSize(svgCanvasPoint.getSize());
        lebelPoint.setLocation(svgCanvasPoint.getLocation());

        Font fontPoint = new Font("Verdana", Font.BOLD, 40);
        lebelPoint.setFont(fontPoint);
        lebelPoint.setVerticalAlignment(JLabel.CENTER);
        lebelPoint.setHorizontalAlignment(JLabel.CENTER);

        //lebelPoint.setBorder(BorderFactory.createLineBorder(Color.RED));

        panelFull.add(lebelPoint);
        panelFull.add(svgCanvasPoint);

        //создаем вектор форсонов
        Vector<String> vectorForsons = new Vector<>();
        vectorForsons.addElement(",ba,Горшок,3,6");
        vectorForsons.addElement(",sa,АскаМисатоРей,2,12");
        vectorForsons.addElement(",in,Стив,1,2");
        vectorForsons.addElement(",sm,Стив,1,0");
        vectorForsons.addElement(",ba,Горшок,3,6");
        vectorForsons.addElement(",in,Аска,2,2");
        vectorForsons.addElement(",in,Стив,1,8");
        vectorForsons.addElement(",sa,Стив,1,11");
        vectorForsons.addElement(",ba,Горшок,3,6");
        vectorForsons.addElement(",sa,Аска,2,2");
        vectorForsons.addElement(",sa,Стив,1,5");
        vectorForsons.addElement(",sm,Стив,1,4");
        vectorForsons.addElement(",ba,Горшок,3,6");
        vectorForsons.addElement(",sa,Аска,2,2");
        vectorForsons.addElement(",sa,Стив,1,5");
        vectorForsons.addElement(",sm,Стив,1,4");
        vectorForsons.addElement(",sa,Аска,2,2");
        vectorForsons.addElement(",sa,Стив,1,5");
        vectorForsons.addElement(",sm,Стив,1,4");
        vectorForsons.addElement(",ba,Горшок,3,6");
        vectorForsons.addElement(",sa,Аска,2,2");
        vectorForsons.addElement(",sa,Стив,1,5");
        vectorForsons.addElement(",sm,Стив,1,4");
        sortPoint(vectorForsons);


        //Создаем скрол-список форсонов
        DefaultListModel<String> forconsListModel = new DefaultListModel<>();
        vectorForsons.forEach(forconsListModel::addElement);

        JList<String> forconsList = new JList<>(forconsListModel);
        forconsList.setCellRenderer(new ForconsRenderer());
        forconsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane forconsListScroll = new JScrollPane(forconsList);
        forconsListScroll.getVerticalScrollBar().setUI(new MyScrollbarUI());
        forconsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        forconsListScroll.setBorder(BorderFactory.createEmptyBorder());
        panelFull.add(forconsListScroll);
        forconsListScroll.setSize(220, 533);
        forconsListScroll.setLocation(1060,25);

        //создаем слушателей мыши и списка
        forconsList.addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                if (forconsList.getSelectedIndex() != -1) {
                    String val = forconsList.getSelectedValue();
                    System.out.println(val);
                    String[] subStr = val.split(",");

                    svgCanvas1.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill1.svg");
                    svgCanvas2.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill2.svg");
                    svgCanvas3.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill3.svg");
                    svgCanvas4.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill4.svg");
                    svgCanvas5.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill5.svg");
                    svgCanvas6.setURI("file:/D:/Джава/Forcons/" + subStr[1] + "Skill6.svg");

                    svgCanvasClass.setURI("file:/D:/Джава/Forcons/" + subStr[1] + ".svg");

                    labelName.setText(subStr[2]);

                    if ((double) labelName.getFontMetrics(fontName).stringWidth(labelName.getText()) > (double) labelName.getWidth()) {
                        int newFontSize = (int) (fontName.getSize() * (double) labelName.getWidth() /
                                ((double) labelName.getFontMetrics(fontName).stringWidth(labelName.getText()) + 20));
                        labelName.setFont(new Font(fontName.getName(), Font.BOLD, newFontSize));
                    } else
                        labelName.setFont(fontName);

                    int pointInt = Integer.parseInt(subStr[4]);
                    if (pointInt < 8) {
                        svgCanvasPoint.setURI("file:/D:/Джава/Forcons/point" + subStr[4] + ".svg");
                        lebelPoint.setText("");
                    } else {
                        svgCanvasPoint.setURI("file:/D:/Джава/Forcons/point0.svg");
                        lebelPoint.setText(subStr[4] + " о. д.");
                    }
                } else {
                    svgCanvas1.setURI(null);
                    svgCanvas2.setURI(null);
                    svgCanvas3.setURI(null);
                    svgCanvas4.setURI(null);
                    svgCanvas5.setURI(null);
                    svgCanvas6.setURI(null);
                    svgCanvasClass.setURI(null);
                    labelName.setText("");
                    svgCanvasPoint.setURI(null);
                    lebelPoint.setText("");
                }
            }
        });

        //создаем кнопки для сортировки
        JButton butSortPoint = new JButton();
        JButton butSortClass = new JButton();

        butSortPoint.setText("p");
        butSortClass.setText("c");

        butSortPoint.setSize(45,20); //1060 1263
        butSortPoint.setLocation(1263-(butSortPoint.getWidth()*2),5);
        butSortClass.setSize(butSortPoint.getSize());
        butSortClass.setLocation(butSortPoint.getX()+butSortPoint.getWidth(),butSortPoint.getY());

        panelFull.add(butSortPoint);
        panelFull.add(butSortClass);

        //создаем слушателей сортировки
        butSortPoint.addActionListener(ev -> {
            butSortPoint.setSize(45,5); //1060 1263
            butSortPoint.setLocation(1263-(butSortPoint.getWidth()*2),20);
            butSortClass.setSize(45,20);
            butSortClass.setLocation(butSortPoint.getX()+butSortPoint.getWidth(),5);

            forconsList.clearSelection();
            forconsListModel.clear();

            sortPoint(vectorForsons);
            vectorForsons.forEach(forconsListModel::addElement);

        });
        butSortClass.addActionListener(ev -> {
            butSortPoint.setSize(45,20); //1060 1263
            butSortPoint.setLocation(1263-(butSortPoint.getWidth()*2),5);
            butSortClass.setSize(45,5);
            butSortClass.setLocation(butSortPoint.getX()+butSortPoint.getWidth(),20);

            forconsList.clearSelection();
            forconsListModel.clear();

            sortClass(vectorForsons);
            vectorForsons.forEach(forconsListModel::addElement);
        });

        //добавляем все в фрейм
        getContentPane().setLayout(null);
        getContentPane().add(panelFull);

    }
    //"12, sm, Стив, 1, 4"

    private void sortPoint(Vector<String> vector) {
        Comparator<String> comparatorPoint = (s, t1) -> {
            int is = Integer.parseInt(s.substring(s.lastIndexOf(",")+1));
            int it = Integer.parseInt(t1.substring(t1.lastIndexOf(",")+1));
            if (is >= it)
                if (is == it)
                    return 0;
                else
                    return -1;
            else
                return 1;
        };
        vector.sort(comparatorPoint);
        for (int i = 0; i < vector.size(); i++)
            vector.set(i, (i+1) + vector.get(i).substring(vector.get(i).indexOf(",")));
    }

    private void sortClass(Vector<String> vector) {
        Comparator<String> comparatorClass = (s, t1) -> {
            String ss = s.substring(s.indexOf(",")+1,s.indexOf(",")+3);
            String st = t1.substring(t1.indexOf(",")+1,t1.indexOf(",")+3);
            switch (ss){
                case ("ba"):
                    if (st.equals("ba"))
                        return 0;
                    else
                        return -1;
                case ("sa"):
                    switch (st){
                        case ("ba"):
                            return 1;
                        case ("sa"):
                            return 0;
                        default:
                            return -1;
                    }
                case ("in"):
                    switch (st) {
                        case ("sm"):
                            return -1;
                        case ("tn"):
                            return 0;
                        default:
                            return 1;
                    }
                default:
                    if (st.equals("sm"))
                        return 0;
                    else
                        return 1;
            }
        };
        vector.sort(comparatorClass);
        for (int i = 0; i < vector.size(); i++)
            vector.set(i, (i+1) + vector.get(i).substring(vector.get(i).indexOf(",")));
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}