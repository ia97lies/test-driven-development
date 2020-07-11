/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author cli
 */
class CommandMock implements Command {

    public int executeCalls = 0;
    public int undoCalls = 0;
    public CommandMock() {
    }

    public void execute() {
        executeCalls++;
    }

    public void undo() {
        undoCalls++;
    }
    
}
