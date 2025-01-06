
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Verwaltung{
   private final ArrayList<Aktivitaet> ListeAktivitaet;
   //private final RessourcenLader materialLader;
    public Verwaltung()
    {
        ListeAktivitaet = new ArrayList<Aktivitaet>();

        /*materialLader = new RessourcenLader();
        ListeAktivitaet = new ArrayList<>(materialLader.listeLesen());*/

    }

    public List<Aktivitaet> getListe(){
        return ListeAktivitaet;

    }

    public void aktivitaetHinzufügen(Aktivitaet aktivitaet){
        ListeAktivitaet.add(aktivitaet);
        //materialLader.listeSpeichern(ListeAktivitaet);
    }
                                                                             //Quelle: https://www.w3schools.com/java/java_date.as

    public List<Aktivitaet> filtern(Filter f1){
        List<Aktivitaet> gefilterteListe = new ArrayList<>();
        for (Aktivitaet aktivitaet : ListeAktivitaet) {
            if(f1.gehörtDazu(aktivitaet)){
                gefilterteListe.add(aktivitaet);
            }
        }
        return gefilterteListe;
    }

    public List<Aktivitaet> sortieren(Sortierer s1){
        ListeAktivitaet.sort(s1);
        return ListeAktivitaet;
    }

    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();                                        // Setzen der Verwaltung im Anwendungsfenster
        Anwendungsfenster anwendungsfenster = new Anwendungsfenster(verwaltung);
        anwendungsfenster.setDatum();
        anwendungsfenster.setVisible(true);
    }

}
