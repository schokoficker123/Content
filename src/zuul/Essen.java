package zuul;

public class Essen extends Gegenstand{

	private int bonus;
	private int gifteffekt;

	/*Dies ist die Methode die es dem Charakter erlaubt einen Gegenstand zu essen.
	 * Ein Essbarer Gegenstand hat einen namen eine Beschreibung und ein Gewicht
	 * Der Bpnus macht das man beispielsweise mehr Gewicht tragen kann sobald man einen bestimmten Gegenstand gegessen hat.
	 * der Bonus Wert wird returnt
	 */

	public Essen(String name, String beschreibung, double gewicht, int questrelevant, int bonus, int gifteffekt) {

		super(name, beschreibung, gewicht, questrelevant);
		this.bonus=bonus;
		this.gifteffekt=gifteffekt;
	}


	public int getBonus() {
		return this.bonus;
	}
	public int gifteffekt() {
		System.out.println("Du wurdest vergiftet, Game Over");
		return this.gifteffekt;
	}
}
