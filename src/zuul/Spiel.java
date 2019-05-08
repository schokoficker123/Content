/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz erzeugt und initialisiert alle anderen Objekte
 *  der Anwendung: Sie legt alle R�ume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt f�r ihre Ausf�hrung.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */
package zuul;


import zuul.commands.*;
import java.util.HashMap;

public class Spiel
{
    private Parser parser;
    private Spieler spieler;
    private HashMap<String, CommandFunction> commands;
    private boolean beendet;

    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel()
    {
        this.beendet=false;
        this.spieler=new Spieler();
        raeumeAnlegen();
        parser = new Parser();
        this.commands=new HashMap<>();

        this.commands.put("go", new GoCommand(this.spieler));
        this.commands.put("help", new HelpCommand(this.parser));
        this.commands.put("look", new LookCommand(this.spieler));
        this.commands.put("status", new StatusCommand(this.spieler));
        this.commands.put("take", new TakeCommand(this.spieler));
        this.commands.put("drop", new DropCommand(this.spieler));
        this.commands.put("eat", new EatCommand(this.spieler));
        this.commands.put("quit", new QuitCommand(this));
        this.commands.put("sleep", new SleepCommand(this.spieler));
    }

    private void raeumeAnlegen()
    {
        this.spieler.geheZu(new WorldGenerator().getStartRaum());  // das Spiel startet auf der Lichtung
    }

    public void quit() {
        this.beendet=true;
    }

    /**
     * Die Hauptmethode zum Spielen. Läuft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen()
    {
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und führen sie aus, bis das Spiel beendet wird.

        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            verarbeiteBefehl(befehl);
        }
        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begrüßungstext für den Spieler ausgeben.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Entdecke die Welt von Zuul. Doch Vorsicht, überall lauern Gefahren!");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        raumInfoAusgeben();
    }

    private void verarbeiteBefehl(Befehl befehl)
    {
        if(befehl.istUnbekannt()) {
            System.out.println("Ich weiß nicht, was Sie meinen...");

        } else {
            String befehlswort = befehl.gibBefehlswort();
            this.commands.get(befehlswort).execute(befehl);
        }
    }

    private void raumInfoAusgeben() {
        System.out.println(this.spieler.getAktuellerRaum().getLangeBeschreibung());
    }

}
