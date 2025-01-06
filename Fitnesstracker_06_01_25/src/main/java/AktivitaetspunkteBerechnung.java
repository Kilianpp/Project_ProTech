public class AktivitaetspunkteBerechnung {
    /**
     * Die Klasse AktivitaetspunkteBerechnung enthält Methoden zur Berechnung von Geschwindigkeit,
     * Kalorienverbrauch und Aktivitätspunkten basierend auf sportlichen Aktivitäten.
     */

    private static final int AKTIVITAETSPUNKT_PRO_KALORIEN_FACTOR = 50; // 1 Aktivitätspunkt = 50 verbrannte Kalorien

    public double berechneKalorienverbrauch(String sportart, int dauer, int strecke) {
        if (sportart == null || sportart.isEmpty()) {
            throw new IllegalArgumentException("Die Sportart darf nicht null oder leer sein.");
        }
        if (dauer <= 0) {
            throw new IllegalArgumentException("Die Zeit in Minuten muss größer als 0 sein.");
        }
        if (strecke <= 0) {
            throw new IllegalArgumentException("Die Strecke muss größer als 0 sein.");
        }

        double kalorienProKilometer = getKalorienProKilometer(sportart.toLowerCase());
        double kilometer = strecke / 1000.0; // Strecke in Meter umwandeln

        // Kalorienverbrauch basierend auf Strecke und Kalorien pro Kilometer
        double kalorienVerbrauchStrecke = kalorienProKilometer * kilometer;

        // Gewichtung: Strecke und Dauer (hier: 70% Strecke, 30% Dauer)
        return Math.round((0.7 * kalorienVerbrauchStrecke + 0.3 * dauer) * 100) / 100.0;
    }


    public double berechneAktivitaetspunkte(double kalorien) {
        return Math.floor(kalorien / AKTIVITAETSPUNKT_PRO_KALORIEN_FACTOR);
        // Pro 50 Kalorien wird 1 Aktivitätspunkt vergeben
    }

    private double getKalorienProKilometer(String sportart) {
        return switch (sportart) {
            case "laufen" -> 70.0;       // Kalorien pro Kilometer
            case "radfahren" -> 35.0;
            case "schwimmen" -> 90.0;
            case "rudern" -> 40.0;
            default ->
                    throw new IllegalArgumentException("Unbekannte Sportart: " + sportart + ". Unterstützt werden: 'laufen', 'radfahren', 'schwimmen', 'rudern'.");
        };
    }

}