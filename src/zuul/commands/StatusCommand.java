package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class StatusCommand implements CommandFunction {
    private Spieler spieler;

    public StatusCommand(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public void execute(Befehl befehl) {
        status();
    }

    private void status() {
        System.out.println(this.spieler.zeigeStatus());
    }
}
