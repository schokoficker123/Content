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
				
		/**
		 * wenn der Spieler einen Gegenstand bei sich trägt, der für eine Quest relevant ist, 
		 * soll der Text "Tippe: questabgeben" ausgegeben werden. Funktioniert aber nicht ...
		 */
		boolean Questfertig = this.spieler.ermittleRelevanzGewicht() == 1.0;
		
		while(i == 0) {
			if(Questfertig) {
				System.out.println("Tippe: questabgeben");
				i = 1;

			} else {
				System.out.println(".....");
			}
		}  
	}
}