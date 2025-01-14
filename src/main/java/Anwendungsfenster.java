import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private JLabel LabelFilter;
    private JComboBox comboBoxSortieren;
    private JButton buttonSortieren;
    private JButton clearButton;
    private JCheckBox speichernCheck;
    private Verwaltung verwaltung;
    private final DefaultTableModel datenmodell;
    private boolean absteigend = false;
    private final Fehlermeldung fehlermeldung;


    public Anwendungsfenster(Verwaltung verwaltung) {
        this.verwaltung = verwaltung;
        fehlermeldung = new Fehlermeldung();
        setTitle("Fitnesstracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(775, 300);
        setContentPane(Anwendungsfenster);
        setVisible(true);
        setPlaceHolder(textFieldDatum, "Bsp.: 25-01-25");
        setPlaceHolder(textFieldDauer, "Bsp.: 30");
        setPlaceHolder(textFieldStrecke, "Bsp.: 2500");
        textFieldDatum.setForeground(Color.BLACK);
        datenmodell = new DefaultTableModel();
        initialize();
        displayTable(verwaltung.getListe());
    }

    private void setPlaceHolder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void initialize() {
        buttonSpeichern.addActionListener(e -> {                //"e ->" fasst das überschreiben einer einzelnen Methode zusammen (springt direkt zu action performed)
            if (prüfeWerte()) {
                String aktivitätsname = comboBoxAktivität.getSelectedItem().toString();
                String datum = textFieldDatum.getText();
                int strecke = Integer.parseInt(textFieldStrecke.getText());
                int dauer = Integer.parseInt(textFieldDauer.getText());
                Aktivitaet aktivitaet = new Aktivitaet(aktivitätsname, datum, dauer, strecke);
                verwaltung.aktivitaetHinzufügen(aktivitaet, speichernCheck.isSelected());
                displayTable(verwaltung.getListe());
            }
        });
        addColumn("Aktivität");
        addColumn("Datum");
        addColumn("Dauer");
        addColumn("Strecke");
        addColumn("Kalorienverbrauch");
        addColumn("Punkte");
        table1.setModel(datenmodell);


        anwendenButton.addActionListener(e -> {
            String filterCombobox = comboBoxFilter.getSelectedItem().toString();
            if (filterCombobox.equals("Kein Filter")) {
                displayTable(verwaltung.filterEntfernen());
                return;
            }
            List<Aktivitaet> gefilterteListe = verwaltung.filtern(new FilterAktivitaet(filterCombobox));
            displayTable(gefilterteListe);

        });
        comboBoxSortieren.addActionListener(e -> {
            sortieren();
        });

        buttonSortieren.addActionListener(e -> {
            if (absteigend) {
                buttonSortieren.setText("Aufsteigend");
                absteigend = false;
            } else {
                buttonSortieren.setText("Absteigend");
                absteigend = true;
            }
            sortieren();
        });

        clearButton.addActionListener(e ->
        {verwaltung.löschen();
            displayTable(verwaltung.getListe());
        });
    }

    private void sortieren() {
        Sortierer sortierer = null;
        String wertSortierer = comboBoxSortieren.getSelectedItem().toString();
        switch (wertSortierer) {
            case "Datum" -> sortierer = SortiererBuilder.DATUMSORTIERER;
            case "Dauer" -> sortierer = SortiererBuilder.DAUERSORTIERER;
            case "Strecke" -> sortierer = SortiererBuilder.STRECKENSORTIERER;
            case "Kalorien" -> sortierer = SortiererBuilder.KALORIENSORTIERER;
            case "Punkte" -> sortierer = SortiererBuilder.PUNKTESORTIERER;
            case "Keine" -> sortierer = SortiererBuilder.DEFAULTSORTIERER;
        }
        if (sortierer == null) {
            System.out.println("Fehler beim sortieren (wertSortierer)" + wertSortierer);
            return;
        }
        sortierer.setAbsteigend(absteigend);
        displayTable(verwaltung.sortieren(sortierer));
    }


    public void setDatum() {                                                           //Aktuelles Datum für neue Aktivität festlegen
        LocalDate date = LocalDate.now();                                               //LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");        //Umwandeln in deutschen Standard
        String dateStr = date.format(formatter);                                        //Umwandeln in String, dass es im Textfeld ausgegeben werden kann
        textFieldDatum.setText(dateStr);                                                //Ausgabe im Textfeld
    }

    private void addColumn(String spaltenName) {
        datenmodell.addColumn(spaltenName);
    }


    public void displayTable(List<Aktivitaet> liste) {
        datenmodell.setRowCount(0);
        for (Aktivitaet aktivitaet : liste) {
            datenmodell.addRow(aktivitaet.alsArray());
        }

    }

    private boolean prüfeWerte() {
        int index = comboBoxAktivität.getSelectedIndex();
        if (index == 0) {
            fehler("Aktivität wählen");//Fehler ausgeben
            return false;
        }
        String datum = textFieldDatum.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate Daturm = LocalDate.parse(datum, formatter);

        } catch (Exception e) {
            fehler("Datum falsch");
            return false;
        }//Fehler ausgeben


        try {
            int strecke = Integer.parseInt(textFieldStrecke.getText());

        } catch (Exception e) {
            fehler("Strecke falsch");
            return false;
        }//Fehler ausgeben


        try {
            int dauer = Integer.parseInt(textFieldDauer.getText());

        } catch (Exception e) {
            fehler("Dauer falsch");
            return false;
        }//Fehler ausgeben

        return true;
    }

    private void fehler(String nachricht) {
        fehlermeldung.fehlerfenster(nachricht);
    }

}




