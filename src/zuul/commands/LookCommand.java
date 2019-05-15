package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class LookCommand implements CommandFunction {
    private Spieler spieler;

    public LookCommand(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public void execute(Befehl befehl) {
        umsehen();
    }
/**
 * Mit diesem Befehl kannst du dir anzeigne 
 * lassen in welchem Raum du bist, 
 * welche Gegenstaende es dort gibt und 
 * welche Ausgaenge in welcher Richtung.
 */
    private void umsehen() {

        System.out.println(this.spieler.getAktuellerRaum().getLangeBeschreibung());
    }
}
