package zuul.commands;

import zuul.Befehl;
import zuul.Spiel;

public class QuitCommand implements CommandFunction {


    private Spiel spiel;

    public QuitCommand(Spiel spiel) {
        this.spiel = spiel;
    }

    @Override
    public void execute(Befehl befehl) {
        beenden(befehl);

    }

    private void beenden(Befehl befehl)
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
        }
        else {
            this.spiel.quit();
        }
    }
}
