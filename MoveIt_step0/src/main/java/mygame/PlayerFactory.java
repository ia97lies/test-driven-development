package mygame;


import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class PlayerFactory {
    private final AssetManager assetManager;
    
    public PlayerFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    public Node create() {
        Node node = new Node("Box");
               
        Box shape = new Box(0.5f, 0.5f, 0.5f);
        Geometry hub = new Geometry("BoxGeo", shape);
        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat.setBoolean("UseMaterialColors", true);
        mat.setColor("Diffuse", ColorRGBA.Blue);
        mat.setColor("Ambient", ColorRGBA.Gray);
        mat.setColor("Specular", ColorRGBA.White);
        mat.setFloat("Shininess", 4f);
        hub.setMaterial(mat);
        node.attachChild(hub);
        
        return node;
    }
}
