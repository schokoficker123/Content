package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class QuestAbgebenCommand implements CommandFunction{
	private Spieler spieler;

	//Konstruktor der Command Klasse
	public QuestAbgebenCommand(Spieler spieler) {
		this.spieler = spieler;
	}
	/**
	 * 
	 * @param befehl
	 */
	@Override
	public void execute(Befehl befehl) {
		questAbgeben(befehl);
	}

	private void questAbgeben(Befehl befehl) {
		//     boolean geklappt=this.spieler.questAbgeben(befehl.gibZweitesWort());
		//     if(geklappt) {
		//         System.out.println("Quest erfüllt");
		//     } else {
		//         System.out.println("Quest konnte nicht erfüllt werden");
		//	        }
	}
}
