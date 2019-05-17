package zuul;

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
		hexenhaus = new Raum("im Hexenhaus");
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
		rathaus=new Raum("im Rathaus, hier herscht Norrington über das Land");
		schmied=new Raum("bei der Schmiedin Tia Dalma");

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
 * Diese Methode fügt Gegenstaende in bestimmten Rauemen ein.
 */
	private void addGegenstaende() {
		taverne.gegenstandAblegen(new Gegenstand("Bierkrug", "ein leckeres dunkles Pils in einem edlen Krug", 2));
		taverne.gegenstandAblegen(new Gegenstand("Teller", "ein Teller mit deftigem Wildschweinfleisch mit Sosse", 5 ));
		piratenhoehle.gegenstandAblegen(new Gegenstand("Schatztruhe", "eine mit Gold gefuellte Holzkiste", 40));
		piratenschiff.gegenstandAblegen(new Gegenstand("Piratensäbel", "ein gekrümmtes Säbel eines lang verstorbenen Matrosen", 8));
		piratenhoehle.gegenstandAblegen(new Gegenstand("Schwert", "das Schwert des alten Piratenkapitaens", 10));
		sumpf.gegenstandAblegen(new Essen("Regenwurm", "ein kleiner Wurm den man bei Hungersnot essen kann", 1, 2)); 
		sumpf.gegenstandAblegen(new Essen("Pilz", "ein seltsam aussehender Pilz", 1, 20));
		lichtung.gegenstandAblegen(new Gegenstand("Korb", "ein Weidenkorb gefuellt mit Brot", 4));
		lichtung.gegenstandAblegen(new Essen("Muffin", "lecker lecker", 1, 5)); 
	}

	private void addNPC() {
		taverne.setNPC(new NPC("Barceeper", "Guten Tag"));
	}
/**
 * Der Startraum soll der Marktplatz sein.
 * @return Marktplatz
 */
	public Raum getStartRaum() {
		return this.marktplatz;
	}


}
