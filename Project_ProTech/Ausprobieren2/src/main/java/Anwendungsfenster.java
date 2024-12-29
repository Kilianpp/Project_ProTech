import javax.swing.*;

public class Anwendungsfenster extends JFrame {
    private JPanel Anwendungsfenster;
    private JComboBox comboBoxAktivität;
    private JLabel LabelAktivität;
    public JTextField textFieldDatum;
    private JTextField textFieldStrecke;
    private JTextField textFieldDauer;
    private JTextField textFieldKalorienverbrauch;
    private JTable tableAusgabe;
    private JLabel labelDatum;
    private JLabel labelStrecke;
    private JLabel labelDauer;
    private JLabel labelKalorien;
    private JButton buttonSpeichern;
    private JComboBox comboBoxFilter;
    private JComboBox comboBoxFilter2;
    private JButton anwendenButton;
    private Verwaltung Verwaltung;


    public Anwendungsfenster() {        //Konstruktor
        setTitle("Fitnesstracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(775,300);
        setContentPane(Anwendungsfenster);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        Anwendungsfenster f1 = new Anwendungsfenster();
        //f1.Verwaltung.setDatum();
        Verwaltung verwaltung = new Verwaltung();
        verwaltung.setDatum();

}}


