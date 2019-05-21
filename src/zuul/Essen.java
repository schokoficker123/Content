package zuul;

public class Essen extends Gegenstand{

    private int bonus;

    /*Dies ist die Methode die es dem Charakter erlaubt einen Gegenstand zu essen.
     * Ein Essbarer Gegenstand hat einen namen eine Beschreibung und ein Gewicht
     * Der Bpnus macht das man beispielsweise mehr gewicht tragen kann sobald man einen bestimmten Gegenstand gegessen hat.
     * der Bonus Wert wird returnt
     */
     
    public Essen(String name, String beschreibung, double gewicht, int bonus) {

        super(name, beschreibung, gewicht);
        this.bonus=bonus;
    }

    public int getBonus() {
        return this.bonus;
    }
}
