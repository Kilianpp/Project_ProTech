
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Verwaltung{
   private final ArrayList<Aktivitaet> ListeAktivitaet;

    public Verwaltung()
    {
        ListeAktivitaet = new ArrayList<Aktivitaet>();
    }

    public List<Aktivitaet> getListe(){
        return ListeAktivitaet;

    }

    public void aktivitaetHinzufügen(Aktivitaet aktivitaet){
        ListeAktivitaet.add(aktivitaet);
        ausgeben();
    }
    public void ausgeben(){
        for (Aktivitaet aktivitaet : ListeAktivitaet) {
            System.out.println(aktivitaet);
        }
    }                                                                               //Quelle: https://www.w3schools.com/java/java_date.as

    public List<Aktivitaet> filtern(Filter f1){
        List<Aktivitaet> gefilterteListe = new ArrayList<>();
        for (Aktivitaet aktivitaet : ListeAktivitaet) {
            if(f1.gehörtDazu(aktivitaet)){
                gefilterteListe.add(aktivitaet);
            }
        }
        return gefilterteListe;
    }

    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();                                        // Setzen der Verwaltung im Anwendungsfenster
        Anwendungsfenster anwendungsfenster = new Anwendungsfenster(verwaltung);
        anwendungsfenster.setDatum();
        anwendungsfenster.setVisible(true);
    }

}
