package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CommandMoveTest {

    private Node player;
    
    @Before
    public void setUp() {
        player = new Node("player");
    }
    
    @Test
    public void shouldMoveLeft() {
        Command command = new MoveCommand(player, 1, 0);
        command.execute();
        assertEquals(new Vector3f(1, 0, 0), player.getLocalTranslation());
    }
    
    @Test
    public void shouldMoveRight() {
        Command command = new MoveCommand(player, -1, 0);
        command.execute();
        assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());
    }
    
    @Test
    public void shouldMoveUp() {
        Command command = new MoveCommand(player, 0, -1);
        command.execute();
        assertEquals(new Vector3f(0, 0, -1), player.getLocalTranslation());
    }
}
