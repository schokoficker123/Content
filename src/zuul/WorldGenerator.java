package zuul;

import java.util.ArrayList;

public class WorldGenerator {
	private Raum piratenschiff, piratenhoehle, piratenbucht, lichtung, sumpf, hexenhaus, dungeon, ebene1, ebene2, bossraum, wald, marktplatz, rathaus, schmied, taverne, gasthaus, keller, geheimgang; 
	

	public WorldGenerator() {
		this.raeumeAnlegen();
		this.setzeAusgaenge();
		this.addGegenstaende();
		this.addNPC();
		
		
	}

	private void raeumeAnlegen() {

		/**
		 * Diese Methode legt alle benoetigten Raueme an und gibt
		 * beim betreten der Area einen besstimmten Text aus, der dem Raum zugewiesen ist.
		 */

		lichtung = new Raum("auf einer Lichtung, umgeben von dunklen Tannen");
		piratenschiff = new Raum("auf der Black Pearl");
		taverne = new Raum("in der Taverne, mit zwielichten Gestalten an der Theke");
		hexenhaus=new Raum("im alten Hexenhaus von Tia Dalma");
		piratenbucht = new Raum("in der alten Piratenbucht");
		piratenhoehle = new Raum("in einer alten gruseligen Piratenhoehle");
		keller = new Raum("im Keller der Taverne");
		geheimgang = new Raum("in einem schmalen modrigen Geheimgang");
		gasthaus=new Raum("bei den den Gaestezimmern im ersten Stock der Taverne");
		sumpf=new Raum("im Sumpf umgeben von Schlamm und Schlick");
		dungeon=new Raum("im Dungeon. Betreten auf eigene Gefahr");
		ebene1=new Raum("in der ersten Ebene des Dungeons");
		ebene2=new Raum("in der zweiten Ebene des Dungeons");
		bossraum=new Raum("im Bossraum");
		wald=new Raum("im Wald, vorsicht.. Nicht verlaufen");
		marktplatz=new Raum("auf dem Marktplatz, viele verschiedene gestalten wuseln umher");
		rathaus=new Raum("im Rathaus, hier herscht Norrington ï¿½ber das Land");
		schmied=new Raum("in der Schmiede des alten Jankins");

	}

	private void setzeAusgaenge() {

		// die Ausgaenge initialisieren 
		marktplatz.setAusgang("north", rathaus);
		marktplatz.setAusgang("east", taverne);
		marktplatz.setAusgang("south", schmied);
		marktplatz.setAusgang("west", wald);
		schmied.setAusgang("north", marktplatz);
		rathaus.setAusgang("south", marktplatz);
		taverne.setAusgang("west", marktplatz);
		taverne.setAusgang("up", gasthaus);
		taverne.setAusgang("down", keller);
		gasthaus.setAusgang("down", taverne);
		keller.setAusgang("up", taverne);
		keller.setAusgang("down", geheimgang);
		geheimgang.setAusgang("up", keller);
		geheimgang.setAusgang("west", piratenhoehle);
		piratenhoehle.setAusgang("up", piratenbucht);
		piratenhoehle.setAusgang("east", geheimgang);
		piratenbucht.setAusgang("down", piratenhoehle);
		piratenbucht.setAusgang("north", piratenschiff);
		piratenbucht.setAusgang("south", lichtung);
		piratenschiff.setAusgang("south", piratenbucht);
		lichtung.setAusgang("north", piratenbucht);
		lichtung.setAusgang("south", sumpf);
		sumpf.setAusgang("north", lichtung);
		sumpf.setAusgang("east", wald);
		sumpf.setAusgang("west", hexenhaus);
		wald.setAusgang("west", sumpf);
		wald.setAusgang("east", marktplatz);
		hexenhaus.setAusgang("east", sumpf);
		hexenhaus.setAusgang("south", dungeon);
		dungeon.setAusgang("north", hexenhaus);
		dungeon.setAusgang("down", ebene1);
		ebene1.setAusgang("up", dungeon);
		ebene1.setAusgang("down", ebene2);
		ebene2.setAusgang("up", ebene1);
		ebene2.setAusgang("down", bossraum);
		bossraum.setAusgang("up", ebene2);
	}

/**
 * Diese Methode fuegt Gegenstaende in bestimmten Rauemen ein.
 */
	private void addGegenstaende() {
		taverne.gegenstandAblegen(new Gegenstand("Bierkrug", "ein leckeres dunkles Pils in einem edlen Krug", 1.6));
		taverne.gegenstandAblegen(new Gegenstand("Teller", "ein Teller mit deftigem Wildschweinfleisch mit Sosse", 3.4 ));
		piratenhoehle.gegenstandAblegen(new Gegenstand("Schatztruhe", "eine mit Gold gefuellte Holzkiste", 40.0));
		piratenschiff.gegenstandAblegen(new Gegenstand("Piratensï¿½bel", "ein gekrï¿½mmtes Sï¿½bel eines lang verstorbenen Matrosen", 8.0));
		piratenhoehle.gegenstandAblegen(new Gegenstand("Schwert", "das Schwert des alten Piratenkapitaens", 10.0));
		sumpf.gegenstandAblegen(new Essen("Regenwurm", "ein kleiner Wurm den man bei Hungersnot essen kann", 0.1, 2,0)); 
		sumpf.gegenstandAblegen(new Essen("Pilz", "ein seltsam aussehender Pilz", 0.2, 20,1));
		lichtung.gegenstandAblegen(new Gegenstand("Korb", "ein Weidenkorb gefuellt mit Brot", 4.0));
		lichtung.gegenstandAblegen(new Essen("Muffin", "lecker lecker", 0.3, 5,0)); 
	}

	/*
	 * Um eine Quest einzufügen muss man nur: 1. Name vom Questgeber, 2. Langbeschreibung der Quest, 3.name der Quest 
	 * (max 1 Wort), 4. Kurzbeschreibung der Quest eingeben.
	 */
	private void addNPC() {
		taverne.setNPC(new NPC("Der alte Gibbs",
				 "Arr ich bin der alte Gibbs, um mein Rätsel zu lösen brauchst du etwas Grips. \n"
				 +"Meinen Ring habe ich verloren, bring ihn mir! Dann werde ich dich belohnen. Auf hoher See ich früher war! \n"
				 +"Segelte von Bucht zu Bucht jedes Jahr. Gold und Ehre wirst du haben. Du darfst nur nicht versagen. \n",
				 "ring",
				 "Finde den Ring vom alten Gibbs"));
		
		rathaus.setNPC(new NPC("Norrington",
				 "Willkommen im Rathaus",
				 "schwert",
				 "Kaufe dir ein besseres Schwert um den dungeon zu bezwingen"));
	}
/**
 * Der Startraum soll der Marktplatz sein.
 * @return Marktplatz
 */
	public Raum getStartRaum() {
		return this.marktplatz;
	}

}
