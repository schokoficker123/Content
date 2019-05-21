package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class NPCSpeakCommand implements CommandFunction {
	private Spieler spieler;
	
	public NPCSpeakCommand(Spieler spieler) {
		this.spieler = spieler;
	}

	public void execute(Befehl befehl) {
		speak(befehl);
	}

	private void speak(Befehl befehl) {
		String listeNPCs =this.spieler.getAktuellerRaum().getNPC();

		System.out.println(listeNPCs);

	}
}
