package zuul;

public class Essen extends Gegenstand{

    private int bonus;

    public Essen(String name, String beschreibung, int gewicht, int bonus) {

        super(name, beschreibung, gewicht);
        this.bonus=bonus;
    }

    public int getBonus() {
        return this.bonus;
    }
}
