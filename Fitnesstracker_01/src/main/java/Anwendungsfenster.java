import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Anwendungsfenster extends JFrame {
    private JPanel Anwendungsfenster;
    private JComboBox comboBoxAktivität;
    private JLabel LabelAktivität;
    public JTextField textFieldDatum;
    private JTextField textFieldStrecke;
    public JTextField textFieldDauer;
    private JLabel labelDatum;
    private JLabel labelStrecke;
    private JLabel labelDauer;
    private JButton buttonSpeichern;
    private JComboBox comboBoxFilter;
    private JButton anwendenButton;
    private JTable table1;
    private Verwaltung verwaltung;
    private final DefaultTableModel datenmodell;



    public Anwendungsfenster(Verwaltung verwaltung) {//Konstruktor
        this.verwaltung = verwaltung;
        setTitle("Fitnesstracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(775, 300);
        setContentPane(Anwendungsfenster);
        setVisible(true);
        datenmodell=new DefaultTableModel();
        initialize();
    }

    private void initialize() {
        buttonSpeichern.addActionListener(e -> {                //"e ->" fasst das überschreiben einer einzelnen Methode zusammen (springt direkt zu action performed)
            if (prüfeWerte()) {
                String aktivitätsname = comboBoxAktivität.getSelectedItem().toString();
                String datum = textFieldDatum.getText();
                int strecke = Integer.parseInt(textFieldStrecke.getText());
                int dauer = Integer.parseInt(textFieldDauer.getText());
                Aktivitaet aktivitaet = new Aktivitaet(aktivitätsname, datum, dauer, strecke);
                verwaltung.aktivitaetHinzufügen(aktivitaet);
                displayTable(verwaltung.getListe());
            }
        });
        addColumn("Aktivität");
        addColumn("Datum");
        addColumn("Dauer in min");
        addColumn("Strecke in m");
        addColumn("Kalorienverbrauch");
        addColumn("Punkte");
        table1.setModel(datenmodell);

        anwendenButton.addActionListener(e -> {
            List<Aktivitaet> gefilterteListe = verwaltung.filtern(new FilterAktivitaet("Laufen"));
            displayTable(gefilterteListe);
        });
    }

    public void setDatum() {                                                           //Aktuelles Datum für neue Aktivität festlegen
        LocalDate date = LocalDate.now();                                               //LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");        //Umwandeln in deutschen Standard
        String dateStr = date.format(formatter);                                        //Umwandeln in String, dass es im Textfeld ausgegeben werden kann
        textFieldDatum.setText(dateStr);                                                //Ausgabe im Textfeld
    }

    private void addColumn(String spaltenName){
        datenmodell.addColumn(spaltenName);
    }

    public void displayTable(List<Aktivitaet> liste) {
       datenmodell.setRowCount(0);
        System.out.println(datenmodell.getRowCount());
        for (Aktivitaet aktivitaet : liste) {
            datenmodell.addRow(aktivitaet.alsArray());
        }

    }

    private boolean prüfeWerte() {
        //TODO Hanne
        return true;
    }
}




