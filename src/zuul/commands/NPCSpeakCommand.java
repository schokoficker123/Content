package zuul.commands;

import zuul.Befehl;
import zuul.NPC;
import zuul.Spieler;

public class NPCSpeakCommand implements CommandFunction {
	private Spieler spieler;

	public NPCSpeakCommand(Spieler spieler) {
		this.spieler = spieler;
	}

	public void execute(Befehl befehl) {
		npcspeak();
	}

	private void npcspeak() {

		NPC npc=this.spieler.getAktuellerRaum().getNPC("Barceeper");
		
		System.out.println(npc.toString());

	}
}
 