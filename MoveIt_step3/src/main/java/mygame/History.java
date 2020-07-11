/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author cli
 */
class History {

    Command commands[];
    int size;
    int top;

    History(int size) {
        this.size = size;
        this.top = 0;
        this.commands = new Command[size];
    }

    History() {
        this(1);
    }

    void execute(Command command) {
        this.commands[top++] = command;
        command.execute();
    }

    void undo() {
        if (top > 0) {
            if (commands[--top] != null) {
                commands[top].undo();
            }
        }
    }

    void redo() {
        if (top < size) {
            if (commands[top] != null) {
                commands[top++].execute();
            }
        }
    }
}
