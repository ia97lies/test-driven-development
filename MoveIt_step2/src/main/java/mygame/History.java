package mygame;

import java.util.LinkedList;

class History {

    private final LinkedList<Command> commands;
    private final LinkedList<Command> redos;

    public History() {
        commands = new LinkedList<>();
        redos = new LinkedList<>();
    }
    
    void execute(Command command) {
        commands.add(command);
        command.execute();
    }

    void undo() {
        if (!commands.isEmpty()) {
            Command command = commands.removeLast();
            redos.add(command);
            command.undo();
        }
    }

    void redo() {
        if (!redos.isEmpty()) {
            redos.removeLast().execute();
        }
    }
}
