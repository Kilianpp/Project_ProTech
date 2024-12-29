import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Verwaltung extends Anwendungsfenster{

    public void setDatum () {                                                           //Aktuelles Datum für neue Aktivität festlegen
        LocalDate date = LocalDate.now();                                               //LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");        //Umwandeln in deutschen Standard
        String dateStr = date.format(formatter);                                        //Umwandeln in String, dass es im Textfeld ausgegeben werden kann
        textFieldDatum.setText(dateStr);                                                //Ausgabe im Textfeld
    }                                                                                   //Quelle: https://www.w3schools.com/java/java_date.asp
}
