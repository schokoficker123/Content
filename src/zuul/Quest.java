package zuul;

public class Quest {
	private Gegenstand gegenstand;

	public Quest(Gegenstand gegenstand) {
		this.gegenstand = gegenstand;

	}

	public void QuestAbschliessen() {
		//boolean Questfertig = this.spieler.getAktuellerRaum();
		boolean Questfertig = this.gegenstand.getRelevanz() == 1;

		if(Questfertig) {
			System.out.println("Tippe: questabgeben");
		} else {
			System.out.println();
		}
	} 

}
