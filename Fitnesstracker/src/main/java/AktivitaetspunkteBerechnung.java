public class AktivitaetspunkteBerechnung {
    /**
     * Die Klasse AktivitaetspunkteBerechnung enthält Methoden zur Berechnung von Geschwindigkeit,
     * Kalorienverbrauch und Aktivitätspunkten basierend auf sportlichen Aktivitäten.
     */

        private static final int AKTIVITAETSPUNKT_PRO_KALORIEN_FACTOR = 50; // 1 Aktivitätspunkt = 50 verbrannte Kalorien
        private static final int SEKUNDEN_PRO_MINUTE = 60;

        public double berechneGeschwindigkeit(double strecke, double zeitInMinuten) {
            if (strecke < 0) {
                throw new IllegalArgumentException("Die Strecke darf nicht negativ sein.");
            }
            if (zeitInMinuten <= 0) {
                throw new IllegalArgumentException("Die Zeit in Minuten muss größer als 0 sein.");
            }
            return strecke / (zeitInMinuten * SEKUNDEN_PRO_MINUTE); // Strecke / Zeit in Sekunden
        }

        public double berechneKalorienverbrauch(String sportart, double zeitInMinuten) {
            if (sportart == null || sportart.isEmpty()) {
                throw new IllegalArgumentException("Die Sportart darf nicht null oder leer sein.");
            }
            if (zeitInMinuten <= 0) {
                throw new IllegalArgumentException("Die Zeit in Minuten muss größer als 0 sein.");
            }
            double kalorienProMinute = getKalorienProMinute(sportart.toLowerCase());
            return Math.round(kalorienProMinute * zeitInMinuten * 100) / 100.0; // Zwei Dezimalstellen
        }

        public double berechneAktivitaetspunkte(double kalorien) {
            return kalorien / AKTIVITAETSPUNKT_PRO_KALORIEN_FACTOR;
        }

        private double getKalorienProMinute(String sportart) {
            return switch (sportart) {
                case "laufen" -> 12.0;
                case "radfahren" -> 7.0;
                case "schwimmen" -> 10.0;
                case "rudern" -> 6.0;
                default -> throw new IllegalArgumentException("Unbekannte Sportart: " + sportart + ". Unterstützt werden: 'laufen', 'radfahren', 'schwimmen' ,'rudern'.");
            };
        }
    }

