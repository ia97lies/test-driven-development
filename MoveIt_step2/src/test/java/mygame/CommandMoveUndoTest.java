package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CommandMoveUndoTest {

    private Node player;
    private Command command;
    
    @Before
    public void setUp() {
        player = new Node("player");
        command = new MoveCommand(player, -1, 0);
        command.execute();
    }
    
    @Test
    public void shouldUndoRightMove() {
        command.undo();
        assertEquals(new Vector3f(0, 0, 0), player.getLocalTranslation());
    }
    
    @Test
    public void shouldUndoDoubleRightMove() {
        Command command2 = new MoveCommand(player, -1, 0);
        command2.execute();
        command2.undo();
        assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());
    }
    
    @Test
    public void shouldUndoLeftMove() {
        Command command2 = new MoveCommand(player, 0, 1);
        command2.execute();
        command2.undo();
        assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());
    }
}
