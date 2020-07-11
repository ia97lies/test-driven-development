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
public class HistoryNGTest {
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
        
    @Test
    public void testUndo() {
        History history = new History();
        history.undo();
    }

    @Test
    public void testRedo() {
        History history = new History();
        history.redo();
    }

}