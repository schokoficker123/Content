package zuul;

public class Quest {
	private Spieler spieler;
	
	public Quest(Spieler spieler) {
		this.spieler = spieler;
		
	}

	public void QuestAbschliessen() {
		//boolean Questfertig = this.spieler.getAktuellerRaum();
		boolean Questfertig = this.spieler.getGegenstaende();
		if(Questfertig) {
			//System.out.println("Tippe: questabgeben");
		} else {
			System.out.println();
		}
	} 

}
