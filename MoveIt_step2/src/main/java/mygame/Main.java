package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.SpotLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    private ChaseCamera chaseCam;
    private SpotLight spot;
    private Node player;
    private PlayerFactory playerFactory;

    @Override
    public void simpleInitApp() {
        viewPort.setBackgroundColor(ColorRGBA.LightGray);

        spot = new SpotLight();
        spot.setDirection(cam.getDirection().normalizeLocal());
        spot.setColor(ColorRGBA.White);
        spot.setPosition(cam.getLocation());
        spot.setSpotRange(50f);
        spot.setSpotInnerAngle(FastMath.DEG_TO_RAD * 45);
        spot.setSpotOuterAngle(FastMath.DEG_TO_RAD * 50);
        rootNode.addLight(spot);

        this.renderer.setBackgroundColor(ColorRGBA.White);

        playerFactory = new PlayerFactory(assetManager);

        player = playerFactory.create();
        rootNode.attachChild(player);

        // NOTE: This is how we can place boxes
        /*
         cur = boxFactory.create(cur.getWorldTranslation().add(new Vector3f(1, 0, 0)));
         rootNode.attachChild(cur);
         cur = boxFactory.create(cur.getWorldTranslation().add(new Vector3f(0, 0, 1)));
         rootNode.attachChild(cur);
         cur = boxFactory.create(cur.getWorldTranslation().add(new Vector3f(0, 0, 1)));
         rootNode.attachChild(cur);
         cur = boxFactory.create(cur.getWorldTranslation().add(new Vector3f(-1, 0, 0)));
         rootNode.attachChild(cur);
         */

        // NOTE: this way we can remove
        /*
         rootNode.detachChild(cur);
         */

        setupCam(rootNode);
        initKeys();
    }

    private void setupCam(Spatial target) {
        flyCam.setEnabled(false);
        chaseCam = new ChaseCamera(cam, target, inputManager);
        chaseCam.setDragToRotate(true);
        chaseCam.setSmoothMotion(true);
        chaseCam.setChasingSensitivity(5);
        chaseCam.setRotationSpeed(10);
        chaseCam.setMinVerticalRotation(-FastMath.PI / 2);
        chaseCam.setMinDistance(5);
        chaseCam.setDefaultHorizontalRotation(-FastMath.PI / 4);
    }
    
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private static final String FORWARD = "forward";
    private static final String BACKWARD = "backward";
    private static final String UNDO = "undo";
    private static final String REDO = "redo";

    private void initKeys() {
        inputManager.addMapping(RIGHT, new KeyTrigger(KeyInput.KEY_D));
        inputManager.addListener(actionListener, RIGHT);
        inputManager.addMapping(LEFT, new KeyTrigger(KeyInput.KEY_A));
        inputManager.addListener(actionListener, LEFT);
        inputManager.addMapping(FORWARD, new KeyTrigger(KeyInput.KEY_W));
        inputManager.addListener(actionListener, FORWARD);
        inputManager.addMapping(BACKWARD, new KeyTrigger(KeyInput.KEY_S));
        inputManager.addListener(actionListener, BACKWARD);
        inputManager.addMapping(UNDO, new KeyTrigger(KeyInput.KEY_U));
        inputManager.addListener(actionListener, UNDO);
        inputManager.addMapping(REDO, new KeyTrigger(KeyInput.KEY_R));
        inputManager.addListener(actionListener, REDO);

    }
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals(RIGHT) && !keyPressed) {
                System.out.println("PLACE HOLDER: RIGHT");
                player.setLocalTranslation(player.getLocalTranslation().add(new Vector3f(-1, 0, 0)));
            } else if (name.equals(LEFT) && !keyPressed) {
                System.out.println("PLACE HOLDER: LEFT");
                player.setLocalTranslation(player.getLocalTranslation().add(new Vector3f(1, 0, 0)));
            } else if (name.equals(FORWARD) && !keyPressed) {
                System.out.println("PLACE HOLDER: FORWARD");
                player.setLocalTranslation(player.getLocalTranslation().add(new Vector3f(0, 0, 1)));
            } else if (name.equals(BACKWARD) && !keyPressed) {
                System.out.println("PLACE HOLDER: BACKWARD");
                player.setLocalTranslation(player.getLocalTranslation().add(new Vector3f(0, 0, -1)));
            } else if (name.equals(UNDO) && !keyPressed) {
                System.out.println("PLACE HOLDER: UNDO");
            } else if (name.equals(REDO) && !keyPressed) {
                System.out.println("PLACE HOLDER: REDO");
            }
        }
    };

    @Override
    public void simpleUpdate(float tpf) {
        spot.setDirection(cam.getDirection().normalize());
        spot.setPosition(cam.getLocation());
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
