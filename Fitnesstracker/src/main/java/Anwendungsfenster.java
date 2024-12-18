import javax.swing.*;

public class Anwendungsfenster extends JFrame {
    private Aktivitaet aktivitaet;
    private JPanel Anwendungsfenster;
    private JComboBox comboBoxAktivität;
    private JLabel LabelAktivität;
    public JTextField textFieldDatum;
    private JTextField textFieldStrecke;
    public JTextField textFieldDauer;
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
    private Verwaltung verwaltung;
    private Aktivitaet aktivität;


    public Anwendungsfenster(Verwaltung verwaltung, Aktivitaet aktivitaet) {//Konstruktor
        this.verwaltung = verwaltung; 
        this.aktivitaet = aktivitaet;
        setTitle("Fitnesstracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(775,300);
        setContentPane(Anwendungsfenster);
        setVisible(true);

    }
    public void setVerwaltung(Verwaltung verwaltung) {
        this.verwaltung = verwaltung;
    }

    public void setAktivitaet(Aktivitaet aktivitaet) {
        this.aktivitaet = aktivitaet;

    }}



