package zuul;

import java.util.ArrayList;

public class Spieler {

    private Raum aktuellerRaum;
    private int tragkraft;
    private ArrayList<Gegenstand> gegenstaende;

    public Spieler() {
        this.gegenstaende=new ArrayList<>();
        this.tragkraft = 30;
    }

    public int ermittleGewicht() {
        int gesamtgewicht=0;

        // this.gegenstaende wird durchlaufen
        // Jeder Gegenstand in der Liste wird einmal
        // in der Variablen g abgespeichert
        for(Gegenstand g: this.gegenstaende) {
            // a = a + b oder a+=b
            gesamtgewicht += g.getGewicht();
        }
        return gesamtgewicht;
    }

    /**

     *
     * Dieser Gegenstand sollte dann im aktuellen Raum
     * gesucht werden (Methode dafür erstellen!).
     * Sofern dieser Gegenstand mit diesem Namen
     * existiert und sofern die Tragkraft es zulässt,
     * wird dieser Gegenstand aufgenommen.
     *
     * Das bedeutet natürlich, dass der Raum diesen
     * Gegenstand dann nicht mehr haben kann
     * (Methode dafür erstellen!).
     *
     * Die Methode gegenstandAufnehmen() liefert dann
     * true oder false zurück, je nachdem ob es
     * geklappt hat oder nicht.
     */
    public boolean gegenstandAufnehmen(String name) {
        Gegenstand gesucht=this.aktuellerRaum.sucheGegenstand(name);
        if(gesucht==null) {
            return false;
        } else {
            if(ermittleGewicht()+gesucht.getGewicht()<=this.tragkraft) {
                this.gegenstaende.add(gesucht);
                this.aktuellerRaum.entferneGegenstand(gesucht);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean gegenstandAblegen(String name) {
        for(Gegenstand g: this.gegenstaende) {
            if(g.getName().equalsIgnoreCase(name)) {
                this.gegenstaende.remove(g);
                this.aktuellerRaum.gegenstandAblegen(g);
                return true;
                // Methode wird abgebrochen (damit auch die Schleife)
            }
        }
        // Falls das hier erreicht wird, wurde der Gegenstand
        // nicht gefunden
        return false;
    }

    public String zeigeStatus() {
        String erg="Ich kann insgesamt ";
        erg+=this.tragkraft + "kg tragen\n";
        for(Gegenstand g: this.gegenstaende) {
            erg+=" - " + g.getName() + " " + g.getGewicht()+"kg\n";
        }
        erg+=this.tragkraft-ermittleGewicht() + "kg kann ich noch tragen!";
        return erg;
    }

    public void geheZu(Raum raum) {
        this.aktuellerRaum=raum;
    }

    public Raum getAktuellerRaum() {
        return aktuellerRaum;
    }

    public void essen(String name) {
        for(Gegenstand g: this.gegenstaende) {
            if(g.getName().equalsIgnoreCase(name)) {
                // Ist g ein Objekt vom Typ Essen
                if(g instanceof Essen) {
                    Essen e=(Essen)g;
                    this.tragkraft+=e.getBonus();
                    this.gegenstaende.remove(g);
                    return;
                }
            }
        }
    }

    public void sleep() {

        System.out.println("Ich schlaf dann mal");
    }
}
