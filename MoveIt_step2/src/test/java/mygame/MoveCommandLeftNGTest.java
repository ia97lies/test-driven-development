/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cli
 */
public class MoveCommandLeftNGTest {

    private Node player;
    private MoveCommand command;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        player = new Node("Player");
        command = new MoveCommand(player, 1, 0);
        command.execute();
    }

    @Test
    public void testMoveLeft() {
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(1, 0, 0));
    }

    @Test
    public void testMoveLeftTwice() {
        command = new MoveCommand(player, 1, 0);
        command.execute();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(2, 0, 0));
    }

    @Test
    public void TestMoveLeftUndo() {
        command.undo();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(0, 0, 0));
    }
        
    @Test
    public void testMoveLeftTwiceUndo() {
        command = new MoveCommand(player, 1, 0);
        command.execute();
        command.undo();
        Assert.assertEquals(player.getLocalTranslation(), new Vector3f(1, 0, 0));
    }

}