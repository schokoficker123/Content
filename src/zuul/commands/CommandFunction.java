package zuul.commands;

import zuul.Befehl;

public interface CommandFunction {
    void execute(Befehl befehl);
}
