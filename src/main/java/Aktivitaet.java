public class Aktivitaet{
    private final String name;
    private final String dateStr;
    private final int dauer;
    private final int strecke;
    private final double kalorienverbrauch;
    private final double aktivitaetspunkte;
    private final static AktivitaetspunkteBerechnung PBerechne = new AktivitaetspunkteBerechnung();



    public Aktivitaet(String name, String dateStr, int dauer, int strecke){         //erzeuzeugen des Objekt Aktivität
    this.name = name;
    this.dateStr = dateStr;
    this.dauer = dauer;
    this.strecke = strecke;
    this.kalorienverbrauch = PBerechne.berechneKalorienverbrauch(name, dauer, strecke);
    this.aktivitaetspunkte = PBerechne.berechneAktivitaetspunkte(kalorienverbrauch);

    }

    public Object[] alsArray(){                                                     //Hinzufügen der werte der Aktivität zu einem Array
        return new Object[]{name, dateStr, dauer, strecke, kalorienverbrauch, aktivitaetspunkte};
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %.2f %.2f", name, dateStr, dauer, strecke, kalorienverbrauch, aktivitaetspunkte);
    }


    public String getName() {
        return name;
    }

    public String getDateStr() {
        return dateStr;
    }

    public int getDauer() {

        return dauer;
    }

    public int getStrecke() {
        return strecke;
    }

    public double getAktivitaetspunkte() {
        return aktivitaetspunkte;
    }

    public double getKalorienverbrauch() {
        return kalorienverbrauch;
    }
}
