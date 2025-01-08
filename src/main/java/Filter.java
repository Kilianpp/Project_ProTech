public abstract class Filter{
    protected final String wert;

    public Filter(String wert){
        this.wert = wert;
    }

    public abstract boolean gehörtDazu(Aktivitaet aktivitaet);
}

