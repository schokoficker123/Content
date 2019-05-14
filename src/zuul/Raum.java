/**
 * Diese Klasse modelliert Raueme in der Welt von Zuul.
 *
 * Ein "Raum" repraesentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen Rauemen ueber Ausgaenge verbunden.
 * Moegliche Ausgaenge liegen im Norden, Osten, Sueden und Westen.
 * Fuer jede Richtung haelt ein Raum eine Referenz auf den 
 * benachbarten Raum.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
package zuul;

import java.util.ArrayList;
import java.util.HashMap;

public class Raum
{
	private String beschreibung;
	private HashMap<String, Raum> ausgaenge;
	private ArrayList<Gegenstand> gegenstaende;
	private ArrayList<NPC> npc;

	/**
	 * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
	 * hat anfangs keine Ausgaenge.
	 * @param beschreibung enthaelt eine Beschreibung in der Form
	 *        "in einer Kueche" oder "auf einem Sportplatz".
	 */
	public Raum(String beschreibung)
	{
		this.npc=new ArrayList<>();
		this.gegenstaende=new ArrayList<>();
		this.ausgaenge=new HashMap<>();
		this.beschreibung = beschreibung;
	}
	/**
	 * 
	 * @param neuerGegenstand
	 */

	public void gegenstandAblegen(Gegenstand neuerGegenstand) {
		this.gegenstaende.add(neuerGegenstand);
	}
	/**
	 * 
	 * @param neuerNPC
	 */

	public void setNPC(NPC neuerNPC) {
		this.npc.add(neuerNPC);
	}
	/**
	 * 
	 * @param richtung
	 * @param nachbar
	 */

	public void setAusgang(String richtung, Raum nachbar) {
		this.ausgaenge.put(richtung, nachbar);
	}
	/**
	 * 
	 * @param name
	 * @return Name des Ausganges
	 */

	public Raum getAusgang(String name) {
		return this.ausgaenge.get(name);
	
	}

	public String getLangeBeschreibung() {
		String erg=  "Sie sind " + this.beschreibung + "\nAusgaenge: " + this.ausgaengeToString();
		if(this.gegenstaende.size()>0) {
			erg+="\nGegenstaende in diesem Raum:\n";
			for(Gegenstand g: this.gegenstaende) {
				erg+=" - " + g.toString() + "\n";
			}
		}

		if(this.npc.size()>0) {
			erg+="\nNPCs:\n";
			for(NPC np: this.npc) {
				erg+=" - " + np.toString() + "\n";
			}
		}
		return erg;
	}
	/**
	 * 
	 * @return erg
	 */

	public String ausgaengeToString() {
		String erg="";
		for(String richtung: ausgaenge.keySet()) {
			erg+=richtung + " ";
		}
		return erg;
	}

	/**
	 * @return Die Beschreibung dieses Raums.
	 */
	public String gibBeschreibung()
	{
		return beschreibung;
	}
/**
 * 
 * @param gesucht
 */
	public void entferneGegenstand(Gegenstand gesucht) {
		this.gegenstaende.remove(gesucht);
	}

	public Gegenstand sucheGegenstand(String name) {
		for(Gegenstand g: this.gegenstaende) {
			// if(g.getName() == name) --> funktioniert nicht,
			// da hier nur die Referenz auf Gleichheit geprueft wird
			// d.h. ob die im gleichen Speicher stehen
			if(g.getName().equalsIgnoreCase(name)) {
				return g;
				// Dieses return beendet die Methode
			}
		}
		// Falls diese Stelle erreicht wird, wurde kein
		// Gegenstand gefunden
		return null;
	}

}
