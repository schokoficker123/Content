package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class QuestAcceptCommand implements CommandFunction {
    private Spieler spieler;

    public QuestAcceptCommand(Spieler spieler) {
        this.spieler = spieler;
    }
/**
 * @param befehl
 */
    
    public void execute(Befehl befehl) {
        questaccept(befehl);
    }
/**
 * Gibt aus ob die Quest angenommen wurde oder nicht.
 * @param befehl
 */
    private void questaccept(Befehl befehl) {

        boolean geklappt=this.spieler.questAnnehmen(befehl.gibZweitesWort());
        if(geklappt) {
            System.out.println("Quest angenommen");
        } else {
            System.out.println("Fehler");
        }
    }
}

