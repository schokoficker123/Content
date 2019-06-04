/*
 * Diese Klasse enthaelt eine Aufaehlung aller Befehlswoerter, die dem
 * Spiel bekannt sind. Mit ihrer Hilfe werden eingetippte Befehle
 * erkannt.
 *
 * @author  Michael Koelling und David J. Barnes
 * @version 2008.03.30
 */
package zuul;

public class Befehlswoerter
{
	// ein konstantes Array mit den gueltigen Befehlswoertern
	private static final String gueltigeBefehle[] = {
			"go", "look", "speak", "questaccept", "take", "drop", "eat", "status", "quests", "quit", "help"
	};

	/**
	 * Konstruktor - initialisiere die Befehlswoerter.
	 */
	public Befehlswoerter()
	{
		// nichts zu tun momentan...
	}

	public String getGueltigeBefehle() {
		String erg="";
		for(String s: gueltigeBefehle) {
			erg+=s+" / ";
		}
		return erg;
	}

	/**
	 * Pruefe, ob eine gegebene Zeichenkette ein gueltiger
	 * Befehl ist.
	 * @return 'true', wenn die gegebene Zeichenkette ein gueltiger
	 * Befehl ist, 'false' sonst.
	 */
	public boolean istBefehl(String eingabe)
	{
		for(int i = 0; i < gueltigeBefehle.length; i++) {
			if(gueltigeBefehle[i].equals(eingabe))
				return true;
		}
		// Wenn wir hierher gelangen, wurde die Eingabe nicht
		// in den Befehlswoerter gefunden.
		return false;
	}
}
