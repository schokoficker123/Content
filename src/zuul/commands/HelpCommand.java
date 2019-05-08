package zuul.commands;

import zuul.Befehl;
import zuul.Parser;

public class HelpCommand implements CommandFunction {
    private Parser parser;

    public HelpCommand(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void execute(Befehl befehl) {
        hilfstextAusgeben();
    }

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlsw�rter.
     */
    private void hilfstextAusgeben()
    {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren in der Welt von Zuul herum");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        System.out.println("   " + this.parser.getAlleBefehle());
    }
}
