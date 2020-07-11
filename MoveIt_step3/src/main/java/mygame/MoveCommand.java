/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author cli
 */
class MoveCommand implements Command {
    private final Node player;
    private final int x;
    private final int z;
    private final Vector3f oldPos;

    MoveCommand(Node player, int x, int z) {
        this.player = player;
        this.x = x;
        this.z = z;
        this.oldPos = player.getLocalTranslation().clone();
    }

    public void execute() {
        player.setLocalTranslation(player.getLocalTranslation().add(new Vector3f(x, 0, z)));
    }

    public void undo() {
        player.setLocalTranslation(oldPos);
    }
    
}
