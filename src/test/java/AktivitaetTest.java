import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AktivitaetTest {
private Aktivitaet aktivitaetTest;
private final String aktivitaet = "Laufen";
private final String datum = "08-01-2025";
private final int dauer = 57;
private final int strecke = 4678;
private final AktivitaetspunkteBerechnung berechnung = new AktivitaetspunkteBerechnung();
private final double kalorien = berechnung.berechneKalorienverbrauch(aktivitaet, dauer, strecke);
private final double aktivitaetspunkte = berechnung.berechneAktivitaetspunkte(kalorien);

    @BeforeEach
    void setUp() {
        aktivitaetTest = new Aktivitaet(aktivitaet, datum, dauer, strecke);
    }

    @Test
    void getName() {
        assertEquals(aktivitaet, aktivitaetTest.getName());
    }

    @Test
    void getDateStr() {
        assertEquals(datum, aktivitaetTest.getDateStr());
    }

    @Test
    void getDauer() {
        assertEquals(dauer, aktivitaetTest.getDauer());
    }

    @Test
    void getStrecke() {
        assertEquals(strecke, aktivitaetTest.getStrecke());
    }

    @Test
    void getAktivitaetspunkte() {
        assertEquals(aktivitaetspunkte, aktivitaetTest.getAktivitaetspunkte());

    }

    @Test
    void getKalorienverbrauch() {
        assertEquals(kalorien, aktivitaetTest.getKalorienverbrauch());
    }
}