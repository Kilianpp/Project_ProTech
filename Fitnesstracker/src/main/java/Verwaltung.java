import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Verwaltung{
    private Anwendungsfenster anwendungsfenster;
    private Aktivitaet aktivitaet;

    public Verwaltung(Anwendungsfenster anwendungsfenster, Aktivitaet aktivitaet)
    {
        this.anwendungsfenster = anwendungsfenster;
        this.aktivitaet = aktivitaet;
    }


    public void setDatum () {                                                           //Aktuelles Datum für neue Aktivität festlegen
        LocalDate date = LocalDate.now();                                               //LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");        //Umwandeln in deutschen Standard
        String dateStr = date.format(formatter);                                        //Umwandeln in String, dass es im Textfeld ausgegeben werden kann
        anwendungsfenster.textFieldDatum.setText(dateStr);                                                //Ausgabe im Textfeld
    }                                                                                   //Quelle: https://www.w3schools.com/java/java_date.as
    public static void main(String[] args) {
        Aktivitaet aktivitaet = new Aktivitaet();
        Anwendungsfenster anwendungsfenster = new Anwendungsfenster(null, aktivitaet);
        Verwaltung verwaltung = new Verwaltung(anwendungsfenster, aktivitaet);          // Setzen der Verwaltung im Anwendungsfenster
        anwendungsfenster.setVerwaltung(verwaltung);                                    // Setzen des aktuellen Datums im Textfeld
        verwaltung.setDatum();                                                          // Zeigen des Anwendungsfensters
        anwendungsfenster.setVisible(true); }
}

