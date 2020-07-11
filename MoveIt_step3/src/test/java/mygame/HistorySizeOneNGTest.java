/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cli
 */
public class HistorySizeOneNGTest {
    private History history;
    private CommandMock command;
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
        history = new History(1);
        command = new CommandMock();
        history.execute(command);
    }

        
    @Test
    public void testExecute() {
        Assert.assertEquals(command.executeCalls, 1);
    }
    
    @Test
    public void testExecuteUndo() {
        history.undo();
        Assert.assertEquals(command.undoCalls, 1);
    }

    @Test
    public void testExecuteUndoRedo() {
        history.undo();
        history.redo();
        Assert.assertEquals(command.executeCalls, 2);
    }

    @Test
    public void testExecuteUndoTwice() {
        history.undo();
        history.undo();
        Assert.assertEquals(command.undoCalls, 1);
    }
    
    @Test
    public void testExecuteUndoRedoTwice() {
        history.undo();
        history.redo();
        history.redo();
        Assert.assertEquals(command.executeCalls, 2);
    }
}