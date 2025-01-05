public abstract class Filter<t> {
    protected final t wert;

    public Filter(t wert){
        this.wert = wert;
    }

    public abstract boolean gehörtDazu(Aktivitaet aktivitaet);
}

