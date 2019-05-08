package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class SleepCommand implements CommandFunction{

    private Spieler spieler;

    public SleepCommand(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public void execute(Befehl befehl) {
        System.out.println("Ist auch schon spät, geh schlafen!");
        this.spieler.sleep();
    }
}
