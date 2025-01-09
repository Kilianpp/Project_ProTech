
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Verwaltung{
   private final ArrayList<Aktivitaet> ListeAktivitaet;
   private final RessourcenLader materialLader;                         //bei abspeichern in Textdokument notwendig (zeile drüber einkommentieren)
    private List<Aktivitaet> gefilterteListe = new ArrayList<>(); //erzeugen einer neuen gefilterten Liste
    private Sortierer sortspeicher = null;
    private Filter filterSpeicher = null;

    public Verwaltung()                                                 // konstruktor
    {
        //ListeAktivitaet = new ArrayList<Aktivitaet>();                  //erzeugen der ArrayList

        materialLader = new RessourcenLader();                            //Notwendig bei abspeichern in Textdokument
        ListeAktivitaet = new ArrayList<>(materialLader.listeLesen());      //Notwendig bei abspeichern in Textdokument
        gefilterteListe = new ArrayList<>(ListeAktivitaet);

    }

    public List<Aktivitaet> getListe(){     //ausgeben der Liste
        return gefilterteListe;

    }

    public void aktivitaetHinzufügen(Aktivitaet aktivitaet){            //hinzufügen einer Aktivität in die Liste
        ListeAktivitaet.add(aktivitaet);
        gefilterteListe.add(aktivitaet);
        materialLader.listeSpeichern(ListeAktivitaet);                  //Notwendig bei abspeichern in Textdokument
        if(filterSpeicher != null){
            filtern(filterSpeicher);
        }
        if (sortspeicher != null) {
            sortieren(sortspeicher);
        }
    }                                                                    //Quelle: https://www.w3schools.com/java/java_date.as


    public List<Aktivitaet> filtern(Filter f1){                         //filtern der Liste
        gefilterteListe.clear();
        for (Aktivitaet aktivitaet : ListeAktivitaet) {                 //filtern nach Aktivität
            if(f1.gehörtDazu(aktivitaet)){
                gefilterteListe.add(aktivitaet);                        //hinzufügen zur gefilterten Liste
            }
        }
        filterSpeicher = f1;
        if(sortspeicher != null){
            sortieren(sortspeicher);
        }
        return gefilterteListe;
    }

    public List<Aktivitaet> filterEntfernen(){
        gefilterteListe = new ArrayList<>(ListeAktivitaet);
        filterSpeicher = null;
        if(sortspeicher != null){
            sortieren(sortspeicher);
        }
        return gefilterteListe;
    }

    public List<Aktivitaet> sortieren(Sortierer s1){                //sortieren der Liste
        gefilterteListe.sort(s1);
        sortspeicher = s1;
        return gefilterteListe;
    }

    public void löschen(){//TODO Ben
    ListeAktivitaet.clear();
    gefilterteListe.clear();
    if(materialLader != null){
        materialLader.listeSpeichern(ListeAktivitaet);                    //nur bei speichern in Textdatei
        }
    }



    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();                                        // Setzen der Verwaltung im Anwendungsfenster
        Anwendungsfenster anwendungsfenster = new Anwendungsfenster(verwaltung);
        anwendungsfenster.setDatum();
        anwendungsfenster.setVisible(true);
    }

}
