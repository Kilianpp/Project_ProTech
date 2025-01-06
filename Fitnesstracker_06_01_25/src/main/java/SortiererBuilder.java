public class SortiererBuilder {
    public static final Sortierer DATUMSORTIERER = new Sortierer() {
        @Override
        public int compare(Aktivitaet o1, Aktivitaet o2) {
            int zwischenergebnis = o1.getDateStr().compareTo(o2.getDateStr());
            return prüfeAbsteigend(zwischenergebnis);
        }
    };
}
