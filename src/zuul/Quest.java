package zuul;

public class Quest {
	private Gegenstand gegenstand;
	private Spieler spieler;
	private int i = 0;

	public Quest(Gegenstand gegenstand) {
		this.gegenstand = gegenstand;

	}

	public Quest(Spieler spieler) {
		this.spieler = spieler;
	}

	public void QuestAbschliessen() {
		//boolean Questfertig = this.spieler.getAktuellerRaum();

		while(i == 0);{
			if(this.spieler.ermittleRelevanzGewicht() == 1.0) {
				System.out.println("Tippe: questabgeben");
				i = 1;

			} else {
				System.out.println(".....");
			}
		}  
	}
}