public class FilterAktivitaet extends Filter{


    public FilterAktivitaet(String wert) {
        super(wert);
    }

    @Override
    public boolean gehörtDazu(Aktivitaet aktivitaet) {
        return aktivitaet.getName().equals(wert);
    }
}
