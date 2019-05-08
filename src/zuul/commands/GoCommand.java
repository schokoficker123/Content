package zuul.commands;

import zuul.Befehl;
import zuul.Raum;
import zuul.Spieler;

public class GoCommand implements CommandFunction {
    private Spieler spieler;

    public GoCommand(Spieler spieler) {
        this.spieler = spieler;
    }

    @Override
    public void execute(Befehl befehl) {
        wechsleRaum(befehl);
    }

    private void wechsleRaum(Befehl befehl)
    {
        if(!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Wohin möchten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen den Raum zu verlassen.
        Raum naechsterRaum = this.spieler.getAktuellerRaum().getAusgang(richtung);

        if (naechsterRaum == null) {
            System.out.println("Dort ist keine Tür!");
        }
        else {
            this.spieler.geheZu(naechsterRaum);
            raumInfoAusgeben();
        }
    }

    private void raumInfoAusgeben() {
        System.out.println(this.spieler.getAktuellerRaum().getLangeBeschreibung());
    }

}
