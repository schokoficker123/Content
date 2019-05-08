package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class DropCommand implements CommandFunction{
    private Spieler spieler;

    public DropCommand(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public void execute(Befehl befehl) {
        gegenstandAblegen(befehl);
    }

    private void gegenstandAblegen(Befehl befehl) {
        boolean geklappt=this.spieler.gegenstandAblegen(befehl.gibZweitesWort());
        if(geklappt) {
            System.out.println("Gegenstand abgelegt");
        } else {
            System.out.println("Gegenstand konnte nicht abgelegt werden");
        }
    }
}
