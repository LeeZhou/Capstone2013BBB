package mygame;


import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Dome;
import com.jme3.texture.Texture;
import com.jme3.util.TangentBinormalGenerator;



public class Main extends SimpleApplication {
  //implements AnimEventListener, ActionListener, AnalogListener {
  
  Boolean isRunning=true;
  private Spatial sceneModel;
  private BulletAppState bulletAppState;
  private RigidBodyControl landscape;
  private CharacterControl player1;
  private Vector3f walkDirection = new Vector3f();
  private boolean left = false, right = false, up = false, down = false;
  private AnimChannel channel;
  private AnimControl control;
  protected Geometry ball;
  protected Geometry ball2;
  //Node player;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    /*floor stuff*/
    private RigidBodyControl floor_phy;
    private RigidBodyControl ball_phy;
    private RigidBodyControl ball2_phy;
    private static final Box floor;
    Material floor_mat;
    Material stone_mat;
    
    static
    {
        floor = new Box(Vector3f.ZERO, 10f, 0.1f, 5f);
        floor.scaleTextureCoordinates(new Vector2f(3, 6));
    }
    
    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(false);
        cam.setLocation(new Vector3f(0f,15f,20f));
        //cam.setRotation(new Quaternion(2f,2f,-1f,-1f));
        cam.setAxes(new Vector3f(0f,0f,0f),new Vector3f(0f,0f,0f),new Vector3f(-100f,0f,0f));
        cam.lookAt(new Vector3f(0f,0f,0f), cam.getUp());
        
        /** Set up Physics Game */
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
       
        Sphere c = new Sphere(20, 20, 0.5f, true, false);
        
        
        ball = new Geometry("Sphere", c);
        ball2 = new Geometry("Sphere", c);
        c.setTextureMode(Sphere.TextureMode.Projected);
        
        TangentBinormalGenerator.generate(c);
        
        Material mat_lit = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat_lit.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond.jpg"));
        mat_lit.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
        mat_lit.setBoolean("UseMaterialColors",true);   
        mat_lit.setColor("Specular",ColorRGBA.White);
        mat_lit.setColor("Diffuse",ColorRGBA.White);
        mat_lit.setFloat("Shininess", 5f); // [1,128]
        
        stone_mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        stone_mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/Rock/Rock.PNG"));
        stone_mat.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Rock/Rock_normal.png"));
        stone_mat.setBoolean("UseMaterialColors",true);    
        stone_mat.setColor("Specular",ColorRGBA.White);
        stone_mat.setColor("Diffuse",ColorRGBA.White);
        stone_mat.setFloat("Shininess", 5f); // [1,128]
        
      
       
        stone_mat.setBoolean("UseMaterialColors",true);    
        stone_mat.setColor("Specular",ColorRGBA.White);
        stone_mat.setColor("Diffuse",ColorRGBA.White);
        stone_mat.setFloat("Shininess", 5f); // [1,128]
        
        float gax=(float) 0.5;
        
        
        ball.setMaterial(mat_lit);
        ball2.setMaterial(stone_mat);
        ball.setLocalTranslation(2,gax,3); // Move it a bit
        ball2.setLocalTranslation(5,gax,-3); // Move it a bit
        
        rootNode.attachChild(ball);
        rootNode.attachChild(ball2);
        ball_phy = new RigidBodyControl(1f);
        ball2_phy = new RigidBodyControl(1f);
        
        
        ball.addControl(ball_phy);
        ball2.addControl(ball2_phy);
        bulletAppState.getPhysicsSpace().add(ball_phy);
        bulletAppState.getPhysicsSpace().add(ball2_phy);
        ball_phy.setMass(.9f);
        ball2_phy.setMass(.9f);
        ball_phy.setRestitution(1f);
        ball2_phy.setRestitution(1f);
       
        
        
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        setUpLight();
        setUpKeys();
    
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);
        
        

        
        initMaterials();
        initFloor();
    }
    public void initMaterials(){
        floor_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key3 = new TextureKey("Textures/Terrain/Pond/Pond.jpg");
        key3.setGenerateMips(true);
        Texture tex3 = assetManager.loadTexture(key3);
        tex3.setWrap(Texture.WrapMode.Repeat);
        floor_mat.setTexture("ColorMap", tex3);
        
        stone_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
        key2.setGenerateMips(true);
        Texture tex2 = assetManager.loadTexture(key2);
        stone_mat.setTexture("ColorMap", tex2);
    }
    
    public void initFloor(){
        Geometry floor_geo = new Geometry("Floor", floor);
        floor_geo.setMaterial(floor_mat);
        floor_geo.setLocalTranslation(0, -0.1f, 0);
        this.rootNode.attachChild(floor_geo);
        /* Make the floor physical with mass 0.0f! */
        floor_phy = new RigidBodyControl(0.0f);
        floor_geo.addControl(floor_phy);
        bulletAppState.getPhysicsSpace().add(floor_phy);
    }
    

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }


    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        //Bleah
    }

    
    private void setUpLight() {
        // We add light so we see the scene
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);
    }
    
    /** We over-write some navigational key mappings here, so we can
    * add physics-controlled walking and jumping: */
    private void setUpKeys() {
        //inputManager.addMapping("Pause",  new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Ability", new KeyTrigger(KeyInput.KEY_X));
        
        inputManager.addMapping("Left2", new KeyTrigger(KeyInput.KEY_F));
        inputManager.addMapping("Right2", new KeyTrigger(KeyInput.KEY_H));
        inputManager.addMapping("Up2", new KeyTrigger(KeyInput.KEY_T));
        inputManager.addMapping("Down2", new KeyTrigger(KeyInput.KEY_G));
        inputManager.addMapping("Ability2", new KeyTrigger(KeyInput.KEY_B));
        
        inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        //inputManager.addListener(this, "Pause");
        inputManager.addListener(analogListener,new String[]{ "Left", "Right", "Up", "Down", "Left2", "Right2", "Up2", "Down2", "Jump"});
        inputManager.addListener(actionListener, new String[]{"Ability","Ability2"});
    }
    
    /** These are our custom actions triggered by key presses.
    * We do not walk yet, we just keep track of the direction the user pressed. */
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String binding, float value, float tpf) {
            if (binding.equals("Left")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                ball.rotate(-value*speed*3, 0, 0);
                ball_phy.applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
            } else if (binding.equals("Right")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                ball.rotate(value*speed*3, 0, 0);
                ball_phy.applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
            } else if (binding.equals("Up")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                ball.rotate(0, 0, -value*speed*3);
                ball_phy.applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
            } else if (binding.equals("Down")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                ball.rotate(0, 0, value*speed*3);
                ball_phy.applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
            } else if (binding.equals("Ability")) {
                //Add ability
            }    
              
            
            
            if (binding.equals("Left2")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                ball.rotate(-value*speed*3, 0, 0);
                ball2_phy.applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
            } else if (binding.equals("Right2")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                ball.rotate(value*speed*3, 0, 0);
                ball2_phy.applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
            } else if (binding.equals("Up2")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                ball.rotate(0, 0, -value*speed*3);
                ball2_phy.applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
            } else if (binding.equals("Down2")) {
                Vector3f v = ball.getLocalTranslation();
                ball.setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                ball.rotate(0, 0, value*speed*3);
                ball2_phy.applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
            } else if (binding.equals("Ability2")) {
            //ball.jump();
            }
        }
    };
    

    
    private ActionListener actionListener = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {
      if (name.equals("Ability") && !keyPressed) {
        //MINE
                Sphere c = new Sphere(5, 5, 0.2f, true, false);
                c.setTextureMode(Sphere.TextureMode.Projected);
                TangentBinormalGenerator.generate(c);
                Geometry mine=new Geometry("Mine",c);
                Material min_mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
                key2.setGenerateMips(true);
                min_mat.setBoolean("UseMaterialColors",true);   
                min_mat.setColor("Specular",ColorRGBA.Blue);
                min_mat.setColor("Diffuse",ColorRGBA.Blue);
                mine.setMaterial(min_mat);
                rootNode.attachChild(mine);
                mine.setLocalTranslation(ball_phy.getPhysicsLocation());
                RigidBodyControl mine_phy=new RigidBodyControl(1f);
                mine.addControl(mine_phy);
                bulletAppState.getPhysicsSpace().add(mine);
                mine_phy.setMass(1000f);
                mine_phy.setRestitution(3f);
      }
      
      if (name.equals("Ability2") && !keyPressed) {
        //MINE
                Sphere c = new Sphere(5, 5, 0.2f, true, false);
                c.setTextureMode(Sphere.TextureMode.Projected);
                TangentBinormalGenerator.generate(c);
                Geometry mine=new Geometry("Mine",c);
                Material min_mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
                key2.setGenerateMips(true);
                min_mat.setBoolean("UseMaterialColors",true);  
                min_mat.setColor("Specular",ColorRGBA.Gray);
                min_mat.setColor("Diffuse",ColorRGBA.Gray);
                mine.setMaterial(min_mat);
                rootNode.attachChild(mine);
                mine.setLocalTranslation(ball2_phy.getPhysicsLocation());
                RigidBodyControl mine_phy=new RigidBodyControl(1f);
                mine.addControl(mine_phy);
                bulletAppState.getPhysicsSpace().add(mine);
                mine_phy.setMass(1000f);
                mine_phy.setRestitution(3f);
      }
      
    }
  };
}
