import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SortiererBuilder {
    public static final Sortierer DAUERSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            int zwischenergebnis = o1.getDauer() - o2.getDauer();
            return prüfeAbsteigend(zwischenergebnis);

        }
    };

    public static final Sortierer STRECKENSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            int zwischenergebnis = o1.getStrecke() - o2.getStrecke();
            return prüfeAbsteigend(zwischenergebnis);
        }
    };
    public static final Sortierer KALORIENSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            int zwischenergebnis = (int)(o1.getKalorienverbrauch() - o2.getKalorienverbrauch());
            return prüfeAbsteigend(zwischenergebnis);
        }
    };
    public static final Sortierer PUNKTESORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            int zwischenergebnis = (int)(o1.getAktivitaetspunkte() - o2.getAktivitaetspunkte());
            return prüfeAbsteigend(zwischenergebnis);
        }
    };
    public static final Sortierer DATUMSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            DateTimeFormatter sortierformatierer = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate datum1 = LocalDate.parse(o1.getDateStr(), sortierformatierer);
            LocalDate datum2 = LocalDate.parse(o2.getDateStr(), sortierformatierer);
            int zwischenergebnis = datum1.compareTo(datum2);

            return prüfeAbsteigend(zwischenergebnis);
        }
    };
    public static final Sortierer DEFAULTSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {

            int zwischenergebnis = -187;

            return prüfeAbsteigend(zwischenergebnis);
        }
    };
}
