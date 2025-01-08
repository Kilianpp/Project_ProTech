import java.util.Comparator;

public abstract class Sortierer implements Comparator<Aktivitaet> {
protected boolean absteigend = false;

    public Sortierer(){

    }

    protected int prüfeAbsteigend(int ind) {
        if (absteigend) {
        ind *= -1;
        }
        return ind;
    }

    public Sortierer setAbsteigend(boolean absteigend) {
        this.absteigend = absteigend;
        return this;
    }
}
