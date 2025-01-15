
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungTest {

    private static Verwaltung verwaltung;

    @BeforeEach
    public void setUp(){
        verwaltung = new Verwaltung();
    }
    @Test
    void aktivitaetHinzufuegenTest (){

        Aktivitaet laufen= new Aktivitaet("laufen","04-05-2000",60,10000);

        int elementeDavor=verwaltung.getListe().size();

        verwaltung.aktivitaetHinzufügen(laufen,false);

        assertEquals(elementeDavor+1,verwaltung.getListe().size());
    }

    @Test
    void filternTesten (){

        Aktivitaet laufen= new Aktivitaet("laufen","04-05-2000",60,10000);
        Aktivitaet rudern= new Aktivitaet("rudern","04-05-2000",60,10000);
        Aktivitaet schwimmen= new Aktivitaet("schwimmen","04-05-2000",60,10000);

        verwaltung.aktivitaetHinzufügen(laufen,false);
        verwaltung.aktivitaetHinzufügen(rudern,false);
        verwaltung.aktivitaetHinzufügen(schwimmen,false);

        FilterAktivitaet filterTest= new FilterAktivitaet("laufen");

        List<Aktivitaet> filterTestListe = verwaltung.filtern(filterTest);
        for (Aktivitaet aktivitaet : filterTestListe) {
            assertEquals ("laufen",aktivitaet.getName());
        }
    }
}