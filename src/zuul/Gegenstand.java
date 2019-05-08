package zuul;

public class Gegenstand {

    private String name;
    private String beschreibung;
    private int gewicht;
    private boolean essbar;

    public Gegenstand(String name, String beschreibung, int gewicht) {
        this.beschreibung=beschreibung;
        this.name=name;
        this.gewicht=gewicht;
    }

    @Override
    public String toString() {
        return name + ", " + this.beschreibung +", " + this.gewicht+"kg";
    }

    public int getGewicht() {
        return this.gewicht;
    }

    public String getName() {
        return this.name;
    }
}
