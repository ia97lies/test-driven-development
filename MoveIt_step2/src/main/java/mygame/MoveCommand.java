package mygame;

import com.jme3.scene.Node;

public class MoveCommand implements Command {

    private Node player;
    private int x;
    private int z;

    public MoveCommand() {
    }

    MoveCommand(Node player, int x, int z) {
        this.player = player;
        this.x = x;
        this.z = z;
    }

    @Override
    public void execute() {
        player.move(x, 0, z);
    }

    @Override
    public void undo() {
        player.move(-x, 0, -z);
    }
    
}
