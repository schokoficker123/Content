package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class QuestCommand implements CommandFunction {
	private Spieler spieler;
	
	public QuestCommand(Spieler spieler) {
		this.spieler = spieler;
	}

	public void execute(Befehl befehl) {
		quests(befehl);
	}
	
	private void quests(Befehl befehl) {
		String listeQuests =this.spieler.getKurzBeschreibung();

		System.out.println(listeQuests);

}
}