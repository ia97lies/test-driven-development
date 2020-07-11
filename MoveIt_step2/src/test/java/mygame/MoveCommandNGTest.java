/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cli
 */
public class MoveCommandNGTest {
    private Node player;
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
        player = new Node("Player");
    }
        
    @Test
    public void testMoveRigth() {
        Command command = new MoveCommand(player, -1, 0);
        command.execute();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(-1, 0, 0));        
    }

    @Test
    public void testMoveUp() {
        Command command = new MoveCommand(player, 0, -1);
        command.execute();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(0, 0, -1));        
    }
    
    @Test
    public void testMoveUpUndo() {
        Command command = new MoveCommand(player, 0, -1);
        command.execute();
        command.undo();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(0, 0, 0));                
    }
}