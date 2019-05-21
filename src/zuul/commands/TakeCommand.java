package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class TakeCommand implements CommandFunction {
    private Spieler spieler;

    public TakeCommand(Spieler spieler) {
        this.spieler = spieler;
    }
/**
 * @param befehl
 */
    @Override
    public void execute(Befehl befehl) {
        gegenstandAufnehmen(befehl);
    }
/**
 * Gibt aus ob der Gegenstand aufgenommen wurde oder nicht.
 * @param befehl
 */
    private void gegenstandAufnehmen(Befehl befehl) {

        boolean geklappt=this.spieler.gegenstandAufnehmen(befehl.gibZweitesWort());
        if(geklappt) {
            System.out.println("Gegenstand aufgenommen");
        } else {
            System.out.println("Gegenstand konnte nicht aufgenommen werden");
        }
    }
}
