package zuul;

import java.util.ArrayList;

public class Spieler {

	private Raum aktuellerRaum;
	private double tragkraft;
	private ArrayList<Gegenstand> gegenstaende;
	private ArrayList<NPC> quest;

	public Spieler() {
		this.quest=new ArrayList<>();
		this.gegenstaende=new ArrayList<>();
		this.tragkraft = 30;
	}

	public double ermittleGewicht() {
		double gesamtgewicht=0;

		// this.gegenstaende wird durchlaufen
		// Jeder Gegenstand in der Liste wird einmal
		// in der Variablen g abgespeichert
		for(Gegenstand g: this.gegenstaende) {
			// a = a + b oder a+=b
			gesamtgewicht += g.getGewicht();
		}
		return gesamtgewicht;
	}
                            
	/**

	 *
	 * Dieser Gegenstand sollte dann im aktuellen Raum
	 * gesucht werden (Methode dafuer erstellen!).
	 * Sofern dieser Gegenstand mit diesem Namen
	 * existiert und sofern die Tragkraft es zulaesst,
	 * wird dieser Gegenstand aufgenommen.
	 *
	 * Das bedeutet natuerlich, dass der Raum diesen
	 * Gegenstand dann nicht mehr haben kann
	 * (Methode dafuer erstellen!).
	 *
	 * Die Methode gegenstandAufnehmen() liefert dann
	 * true oder false zurueck, je nachdem ob es
	 * geklappt hat oder nicht.
	 */

	/**
	 * 
	 * @param name des gegenstandes den der Spieler aufnehmen soll.
	 * @return ob der Spieler gnug Tragkraft hat um den Gegenstand zu tragen oder nicht.
	 */
	public boolean gegenstandAufnehmen(String name) {
		Gegenstand gesucht=this.aktuellerRaum.sucheGegenstand(name);
		if(gesucht==null) {
			return false;
		} else {
			if(ermittleGewicht()+gesucht.getGewicht()<=this.tragkraft) {
				this.gegenstaende.add(gesucht);
				this.aktuellerRaum.entferneGegenstand(gesucht);
				return true;
			} else {
				return false;
			}
		}
	}
	/**
	 * Diese Methode sorgt dafuer das der Spieler seine Gegenstï¿½nde im Inventar ablegen kann "droppen".
	 * @param name des Gegenstandes
	 * @return Ob der Gegenstand gefunden wurde oder nicht, wurde er gefunden, wird er abgelegt
	 */
	public boolean gegenstandAblegen(String name) {
		for(Gegenstand g: this.gegenstaende) {
			if(g.getName().equalsIgnoreCase(name)) {
				this.gegenstaende.remove(g);
				this.aktuellerRaum.gegenstandAblegen(g);
				return true;
				// Methode wird abgebrochen (damit auch die Schleife)
			}
		}
		// Falls das hier erreicht wird, wurde der Gegenstand
		// nicht gefunden
		return false;
	}
	/**
	 * Diese Methode überprüft ob eine Quest mit passendem namen in dem bestimmten Raum vorhanden ist.
	 * @return erg
	 */
	public boolean questAnnehmen(String questname) {
		NPC gesucht=this.aktuellerRaum.sucheQuest(questname);
		if(gesucht==null) {
			return false;
		} 
			if(gesucht!=null) {
				this.quest.add(gesucht);
				this.aktuellerRaum.entferneQuest(gesucht);	
				return true;
			} else {
				return false;
			}
		}
	
	

	public String zeigeStatus() {
		String erg="Ich kann insgesamt ";
		erg+=this.tragkraft + "kg tragen\n";
		for(Gegenstand g: this.gegenstaende) {
			erg+=" - " + g.getName() + " " + g.getGewicht()+"kg\n";
		}
		erg+=this.tragkraft-ermittleGewicht() + "kg kann ich noch tragen!";
		return erg;
	}
	/**
	 * Diese Methode erlaubt es dme Spieler von Raum zu Raum zu gehen.
	 * @param raum
	 */
	public void geheZu(Raum raum) {
		this.aktuellerRaum=raum;
	}
	/**
	 * 
	 * @return Aktueller Raum, wo sich der Spieler befindet
	 */
	public Raum getAktuellerRaum() {
		return aktuellerRaum;
	}
	/**
	 * Diese Methode erlaubt es dem Spieler einen Gegenstand zu essen.
	 * Dabei muss geprueft werden ob der Gegenstand essbar ist oder nicht.
	 * @param name des Essbaren Gegenstandes
	 */
	public void essen(String name) {
		for(Gegenstand g: this.gegenstaende) {
			if(g.getName().equalsIgnoreCase(name)) {
				// Ist g ein Objekt vom Typ Essen
				if(g instanceof Essen) {
					Essen e=(Essen)g;
					this.tragkraft+=e.getBonus();
					this.gegenstaende.remove(g);

					return;

				}
			}
		}
	}
	public String getKurzBeschreibung() {
		String erg = "";
		if(this.quest.size()>0) {
			erg+="\nOffene Quests:\n";
			for(NPC qu: this.quest) {
				erg+=" - " + qu.getKurz();
			}
			return erg;
		} else {
			return null;
		}

	}

}
