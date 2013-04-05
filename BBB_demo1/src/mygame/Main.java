package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.Control;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;
import com.jme3.util.TangentBinormalGenerator;
import java.math.BigInteger;



public class Main extends SimpleApplication {
  
    private Boolean isRunning = true;
    private Boolean isBall1Alive = true;
    private Boolean isBall2Alive = true;   
    private Boolean isBall3Alive = true;
    private Boolean isBall4Alive = true;
    private Boolean gameEnd = false;    
    
    private BulletAppState bulletAppState;
    private Spatial bear_geo;
    private RigidBodyControl floor_phy;
    private RigidBodyControl bear_phy;
    private static final Box floor;
    private Material floor_mat;
    private Material mat_lit;
    private Material mat_rock;
    private Material mat_dirt;
    private Material mat_road;
    private Material mat_red;
    private final float gax = (float) 0.5;       
    private Sphere c;   
    private ParticleEmitter fire;    
    private BitmapText ch;
    private DirectionalLight sun;    
    private Spatial ramp_geo;
    private Control ramp_phy;   
    private int abilitySize = 2;
    BigInteger[] p1Abilities = new BigInteger[abilitySize];
    BigInteger[] p2Abilities = new BigInteger[abilitySize]; 

    
    // array of ball instances
    private RigidBodyControl [] ball_phy;
    private SphereCollisionShape [] ballShape;
    private Geometry [] ball;
    
    // Hardcoded number of players for testing
    private int numberPlayer = 4;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();

    }
    /*floor stuff*/   
    
    static
    {
        floor = new Box(Vector3f.ZERO, 10f, 0.1f, 5f);
        floor.scaleTextureCoordinates(new Vector2f(3, 6));
    }        
 
    
    @Override
    public void simpleInitApp() {        
          
        /** Set up Physics Game */
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().addCollisionListener(physicsCollisionListener);               
 
        // Initialize map and keys
        variableInit();
        setCam();
        setUpLight();
        setUpKeys();        
        initMaterials();        
        initFloor();
        InitObj();
        initAbilities(p1Abilities);
        initAbilities(p2Abilities);
        
    }
    
    // initialize balls, obstacle and pwrups
    private void InitObj(){
        variableInit();
        createPowerUp();
        createRamp();
        createBallArray(numberPlayer);
    }
    
    private void variableInit(){
        isRunning = true;
        isBall1Alive = true;
        isBall2Alive = true;  
        isBall3Alive = true;
        isBall4Alive = true;
        gameEnd = false;
       
        
    }
    
    // set camera position and light
    private void setCam(){
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        flyCam.setEnabled(false);        
        cam.setLocation(new Vector3f(0f,15f,20f));        
        cam.setAxes(new Vector3f(0f,0f,0f),new Vector3f(0f,0f,0f),new Vector3f(-100f,0f,0f));
        cam.lookAt(new Vector3f(0f,0f,0f), cam.getUp());
        sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1,0,-2).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);     
        
    }
    
    //Initialize power-up objects
    private void createPowerUp(){        
        //create and edit properties
        fire = 
           new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30);
        mat_red = new Material(assetManager, 
           "Common/MatDefs/Misc/Particle.j3md");
        mat_red.setTexture("Texture", assetManager.loadTexture(
           "Effects/Explosion/flame.png"));
        fire.setMaterial(mat_red);
        fire.setImagesX(2); 
        fire.setImagesY(2); // 2x2 texture animation
        fire.setEndColor(new ColorRGBA(1f, 0f, 1f, 1f));   // red
        fire.setStartColor(new ColorRGBA(1f, 0f, 2f, 0.5f)); // yellow
        fire.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        fire.setStartSize(3f);
        fire.setEndSize(0.1f);
        fire.setGravity(0, 0, 0);
        fire.setLowLife(1f);
        fire.setHighLife(3f);
        fire.getParticleInfluencer().setVelocityVariation(0.1f);
        
        //place on the map
        rootNode.attachChild(fire);         
    }
    
    
    private void createBallArray(int number){
        
        c = new Sphere(20, 20, 0.5f, true, false);
        c.setTextureMode(Sphere.TextureMode.Projected);
        TangentBinormalGenerator.generate(c);  
        ball = new Geometry [number];
        ballShape = new SphereCollisionShape[number];
        ball_phy = new RigidBodyControl[number];
        for(int i = 0; i < number; i++){
            ball[i] = new Geometry("Ball "+i, c);
            ballShape[i] = new SphereCollisionShape(0.5f);
            if(i==0)
            {
                ball[i].setMaterial(mat_lit);
                ball[i].setLocalTranslation(-8,gax,4);
            }
            else if(i==1)
            {
                ball[1].setMaterial(mat_rock);
                ball[i].setLocalTranslation(-8,gax,-3);
            }
            else if(i==2)
            {
                ball[i].setMaterial(mat_dirt);
                ball[i].setLocalTranslation(8,gax,-3);
            }
            else if(i==3)
            {
                ball[i].setMaterial(mat_road);
                ball[i].setLocalTranslation(8,gax,4);
            }
            
            rootNode.attachChild(ball[i]);
            ball_phy[i] = new RigidBodyControl(ballShape[i],0.9f);
            ball[i].addControl(ball_phy[i]); 
            bulletAppState.getPhysicsSpace().add(ball_phy[i]);
            ball_phy[i].setCollisionGroup(PhysicsCollisionObject.COLLISION_GROUP_01);
            ball_phy[i].addCollideWithGroup(PhysicsCollisionObject.COLLISION_GROUP_01);
            ball_phy[i].setRestitution(1f);
            
        }
        
    }   
  
        private void createObstacle(){
        bear_geo = assetManager.loadModel("Models/bear.j3o");
        bear_geo.setLocalTranslation(0f,0f,0f);        
        rootNode.attachChild(bear_geo);
        bear_phy = new RigidBodyControl(2f);
        bear_geo.addControl(bear_phy);
        bear_phy.setPhysicsLocation(new Vector3f(0f,10f,0f));
        bulletAppState.getPhysicsSpace().add(bear_phy);
    }
    
     private void createRamp(){
        ramp_geo = assetManager.loadModel("Models/ramp.j3o");
        ramp_geo.setLocalTranslation(4f,0f,-1f);        
        rootNode.attachChild(ramp_geo);
        ramp_phy = new RigidBodyControl(0f);
        ramp_geo.addControl(ramp_phy);
        bulletAppState.getPhysicsSpace().add(ramp_phy);
    }
    
    //Initialize material and texture
    public void initMaterials(){
        
        //Floor material
        floor_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key3 = new TextureKey("Textures/Terrain/Pond/Pond.jpg");
        key3.setGenerateMips(true);
        Texture tex3 = assetManager.loadTexture(key3);
        tex3.setWrap(Texture.WrapMode.Repeat);
        floor_mat.setTexture("ColorMap", tex3);
    
        //Defining Ball 1 material
        mat_lit = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat_lit.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond.jpg"));
        mat_lit.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Pond/Pond_normal.png"));
        mat_lit.setBoolean("UseMaterialColors",true);    
        mat_lit.setColor("Specular",ColorRGBA.White);
        mat_lit.setColor("Diffuse",ColorRGBA.White);
        mat_lit.setFloat("Shininess", 5f); // [1,128]   
        
        //Defining Ball 2 material
        mat_rock = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat_rock.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/Rock/Rock.PNG"));
        mat_rock.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/Rock/Rock_normal.png"));
        mat_rock.setBoolean("UseMaterialColors",true);    
        mat_rock.setColor("Specular",ColorRGBA.White);
        mat_rock.setColor("Diffuse",ColorRGBA.White);
        mat_rock.setFloat("Shininess", 5f); // [1,128]
        
        //Defining Ball 3 material
        mat_dirt = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat_dirt.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/splat/dirt.jpg"));
        mat_dirt.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/splat/dirt.jpg"));
        mat_dirt.setBoolean("UseMaterialColors",true);    
        mat_dirt.setColor("Specular",ColorRGBA.White);
        mat_dirt.setColor("Diffuse",ColorRGBA.White);
        mat_dirt.setFloat("Shininess", 5f); // [1,128]
        
        //Defining Ball 4 material
        mat_road = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat_road.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Terrain/splat/road.jpg"));
        mat_road.setTexture("NormalMap", assetManager.loadTexture("Textures/Terrain/splat/road.jpg"));
        mat_road.setBoolean("UseMaterialColors",true);    
        mat_road.setColor("Specular",ColorRGBA.White);
        mat_road.setColor("Diffuse",ColorRGBA.White);
        mat_road.setFloat("Shininess", 5f); // [1,128]
        
    }
    
    //Initalizing floor
    public void initFloor(){
        //create floor and attach to map
        Geometry floor_geo = new Geometry("Floor", floor);
        floor_geo.setMaterial(floor_mat);
        floor_geo.setLocalTranslation(0, -0.1f, 0);
        this.rootNode.attachChild(floor_geo);
        
        //Add physics to floor
        floor_phy = new RigidBodyControl(0.0f);
        floor_geo.addControl(floor_phy);
        floor_phy.setKinematic(false);
        bulletAppState.getPhysicsSpace().add(floor_phy);
    }   

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    //Initialize lighting
    private void setUpLight() {
        // We add light so we see the scene and attach to map
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);
    }    

    private void setUpKeys() {
        
        //System Keys
        
        inputManager.addMapping("Reset",  new KeyTrigger(KeyInput.KEY_P));
        inputManager.addListener(actionListener, "Reset");
        
        
        // Ability keybindings and listener
        inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Dash", new KeyTrigger(KeyInput.KEY_M));
        inputManager.addListener(actionListener, "Jump");
        inputManager.addListener(actionListener, "Dash");
        
        // Player 1 keybindings and listener
        
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));        
        
        inputManager.addListener(analogListener,new String[]{ "Left","Right", "Up", "Down"});
        
        // Player 2 keybindings and listener
        
        inputManager.addMapping("Left2", new KeyTrigger(KeyInput.KEY_F));
        inputManager.addMapping("Right2", new KeyTrigger(KeyInput.KEY_H));
        inputManager.addMapping("Up2", new KeyTrigger(KeyInput.KEY_T));
        inputManager.addMapping("Down2", new KeyTrigger(KeyInput.KEY_G));        
        
        inputManager.addListener(analogListener,new String[]{ "Left2","Right2", "Up2", "Down2"});
      
        // Player 3 keybindings and listener
        inputManager.addMapping("Left3", new KeyTrigger(KeyInput.KEY_J));
        inputManager.addMapping("Right3", new KeyTrigger(KeyInput.KEY_L));
        inputManager.addMapping("Up3", new KeyTrigger(KeyInput.KEY_I));
        inputManager.addMapping("Down3", new KeyTrigger(KeyInput.KEY_K));
        
        inputManager.addListener(analogListener,new String[]{ "Left3","Right3", "Up3", "Down3"});
        
        // Player 4 keybindings and listener
        inputManager.addMapping("Left4", new KeyTrigger(KeyInput.KEY_NUMPAD4));
        inputManager.addMapping("Right4", new KeyTrigger(KeyInput.KEY_NUMPAD6));
        inputManager.addMapping("Up4", new KeyTrigger(KeyInput.KEY_NUMPAD8));
        inputManager.addMapping("Down4", new KeyTrigger(KeyInput.KEY_NUMPAD5));
        
        inputManager.addListener(analogListener,new String[]{ "Left4","Right4", "Up4", "Down4"});
        
    }
    
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String binding, float value, float tpf) {
           
            // New code: maps ball array (HARDCODED)
            // player 1 action listener
            if (binding.equals("Left")) {                
                    Vector3f v = ball[0].getLocalTranslation();
                    ball[0].setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                    ball[0].rotate(-value*speed*3, 0, 0);
                    ball_phy[0].applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
                } else if (binding.equals("Right")) {
                    Vector3f v = ball[0].getLocalTranslation();
                    ball[0].setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                    ball[0].rotate(value*speed*3, 0, 0);
                    ball_phy[0].applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
                } else if (binding.equals("Up")) {
                    Vector3f v = ball[0].getLocalTranslation();
                    ball[0].setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                    ball[0].rotate(0, 0, -value*speed*3);
                    ball_phy[0].applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
                } else if (binding.equals("Down")) {
                    Vector3f v = ball[0].getLocalTranslation();
                    ball[0].setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                    ball[0].rotate(0, 0, value*speed*3);
                    ball_phy[0].applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
                }           
            
            //player 2 action listener
           
              if (binding.equals("Left2")) {                
                    Vector3f v = ball[1].getLocalTranslation();
                    ball[1].setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                    ball[1].rotate(-value*speed*3, 0, 0);
                    ball_phy[1].applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
                } else if (binding.equals("Right2")) {
                    Vector3f v = ball[1].getLocalTranslation();
                    ball[1].setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                    ball[1].rotate(value*speed*3, 0, 0);
                    ball_phy[1].applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
                } else if (binding.equals("Up2")) {
                    Vector3f v = ball[1].getLocalTranslation();
                    ball[1].setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                    ball[1].rotate(0, 0, -value*speed*3);
                    ball_phy[1].applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
                } else if (binding.equals("Down2")) {
                    Vector3f v = ball[1].getLocalTranslation();
                    ball[1].setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                    ball[1].rotate(0, 0, value*speed*3);
                    ball_phy[1].applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
                }      
              
              //player 3 action listener
              if (binding.equals("Left3")) {                
                    Vector3f v = ball[2].getLocalTranslation();
                    ball[2].setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                    ball[2].rotate(-value*speed*3, 0, 0);
                    ball_phy[2].applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
                } else if (binding.equals("Right3")) {
                    Vector3f v = ball[2].getLocalTranslation();
                    ball[2].setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                    ball[2].rotate(value*speed*3, 0, 0);
                    ball_phy[2].applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
                } else if (binding.equals("Up3")) {
                    Vector3f v = ball[2].getLocalTranslation();
                    ball[2].setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                    ball[2].rotate(0, 0, -value*speed*3);
                    ball_phy[2].applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
                } else if (binding.equals("Down3")) {
                    Vector3f v = ball[2].getLocalTranslation();
                    ball[2].setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                    ball[2].rotate(0, 0, value*speed*3);
                    ball_phy[2].applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
                }
              
              
              //player 4 action listener
              if (binding.equals("Left4")) {                
                    Vector3f v = ball[3].getLocalTranslation();
                    ball[3].setLocalTranslation(v.x + value*speed*3, v.y, v.z);
                    ball[3].rotate(-value*speed*3, 0, 0);
                    ball_phy[3].applyForce(new Vector3f(-3f, 0, 0),new Vector3f(-3f, 0, 0)); // push the ball foward
                } else if (binding.equals("Right4")) {
                    Vector3f v = ball[3].getLocalTranslation();
                    ball[3].setLocalTranslation(v.x - value*speed*3, v.y, v.z);
                    ball[3].rotate(value*speed*3, 0, 0);
                    ball_phy[3].applyForce(new Vector3f(3f, 0, 0),new Vector3f(3f, 0, 0));
                } else if (binding.equals("Up4")) {
                    Vector3f v = ball[3].getLocalTranslation();
                    ball[3].setLocalTranslation(v.x , v.y , v.z + value*speed*3);
                    ball[3].rotate(0, 0, -value*speed*3);
                    ball_phy[3].applyForce(new Vector3f(0, 0, -3f),new Vector3f(0, 0, -3f));
                } else if (binding.equals("Down4")) {
                    Vector3f v = ball[3].getLocalTranslation();
                    ball[3].setLocalTranslation(v.x , v.y, v.z - value*speed*3);
                    ball[3].rotate(0, 0, value*speed*3);
                    ball_phy[3].applyForce(new Vector3f(0, 0, 3f),new Vector3f(0, 0, 3f));
                }
        }
    };     
    
    private ActionListener actionListener = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {
      if (name.equals("Pause") && !keyPressed) {
            isRunning = !isRunning;
      } else if (name.equals("Reset") && !keyPressed){
            System.out.println("RESET");
          
      } else if (name.equals("Jump") && !keyPressed && !onCooldown(p1Abilities,1)) {
          Vector3f v = ball[0].getLocalTranslation(); 
          if( v.y < 0.6 && v.y > 0){
            ball_phy[0].applyImpulse(new Vector3f(0, 7f, 0), Vector3f.ZERO );               
          }             
      } else if(name.equals("Dash") && !keyPressed && !onCooldown(p2Abilities,1)){                       
            Vector3f v = ball_phy[1].getLinearVelocity();
            if(v.x != 0 && v.z!=0){
                ball_phy[1].applyImpulse(new Vector3f(v.x*20,0,v.z*20), Vector3f.ZERO);
            }
      }
    }
  };    

    
    // Listens to collision between objects
    private PhysicsCollisionListener physicsCollisionListener = new PhysicsCollisionListener(){        
        public void collision(PhysicsCollisionEvent event) {
            if (event.getNodeA().getName().equals("Ball1") || event.getNodeB().getName().equals("Ball1l")) {                
            if (event.getNodeA().getName().equals("Ball2") || event.getNodeB().getName().equals("Ball2")) {
                System.out.println("Ouch my balls!!!!!!!!"); 
            }    
            }
        }
    };  

    
    @Override
    public void simpleUpdate(float tpf) {
      
      //Check if ball is within the map; if not, destroy the ball
      //System.out.println(tpf);
      Vector3f loc1 = ball_phy[0].getPhysicsLocation();
      Vector3f loc2 = ball_phy[1].getPhysicsLocation();
      Vector3f loc3 = ball_phy[2].getPhysicsLocation();
      Vector3f loc4 = ball_phy[3].getPhysicsLocation();
      if(loc1.y < 0 && isBall1Alive){
          System.out.println("Ball 1 DEAD");   
          isBall1Alive = false;           
          if(!isBall2Alive || !isBall3Alive || !isBall4Alive){
              ch.detachAllChildren();
          }
          ch = new BitmapText(guiFont, false);  
          ch.setSize(guiFont.getCharSet().getRenderedSize() * 5);
          ch.setText("Ball 1 DEAD");       
          ch.setColor(ColorRGBA.Red);
          ch.setLocalTranslation(
          settings.getWidth() / 3f,
          settings.getHeight() / 4f, 0);
          guiNode.attachChild(ch);
          bulletAppState.getPhysicsSpace().remove(ball_phy[0]);
          rootNode.detachChild(ball[0]);
      } else if(loc2.y < 0 && isBall2Alive){
          System.out.println("Ball 2 DEAD");
          isBall2Alive = false;            
          if(!isBall1Alive || !isBall3Alive || !isBall4Alive){
              ch.detachAllChildren();
          }
          ch = new BitmapText(guiFont, false); 
          ch.setSize(guiFont.getCharSet().getRenderedSize() * 5);
          ch.setText("Ball 2 DEAD");        
          ch.setColor(ColorRGBA.Red);
          ch.setLocalTranslation(
          settings.getWidth() / 3f,
          settings.getHeight() / 4f, 0);
          guiNode.attachChild(ch);
          bulletAppState.getPhysicsSpace().remove(ball_phy[1]);
          rootNode.detachChild(ball[1]);
      } else if(loc3.y < 0 && isBall3Alive){
          System.out.println("Ball 3 Dead");
          isBall3Alive = false;            
          if(!isBall2Alive || !isBall1Alive || !isBall4Alive){
              ch.detachAllChildren();
          }
          ch = new BitmapText(guiFont, false); 
          ch.setSize(guiFont.getCharSet().getRenderedSize() * 5);
          ch.setText("Ball 3 DEAD");        
          ch.setColor(ColorRGBA.Red);
          ch.setLocalTranslation(
          settings.getWidth() / 3f,
          settings.getHeight() / 4f, 0);
          guiNode.attachChild(ch);
          bulletAppState.getPhysicsSpace().remove(ball_phy[2]);
          rootNode.detachChild(ball[2]);
      
        } else if(loc4.y < 0 && isBall4Alive){
          System.out.println("Ball 4 Dead");
          isBall4Alive = false;            
          if(!isBall2Alive || !isBall1Alive || !isBall3Alive){
              ch.detachAllChildren();
          }
          ch = new BitmapText(guiFont, false); 
          ch.setSize(guiFont.getCharSet().getRenderedSize() * 5);
          ch.setText("Ball 4 DEAD");        
          ch.setColor(ColorRGBA.Red);
          ch.setLocalTranslation(
          settings.getWidth() / 3f,
          settings.getHeight() / 4f, 0);
          guiNode.attachChild(ch);
          bulletAppState.getPhysicsSpace().remove(ball_phy[3]);
          rootNode.detachChild(ball[3]);
      
        }
      
      
      
      
      if(!isBall1Alive && !isBall2Alive && !isBall3Alive && !isBall4Alive && !gameEnd){
          gameEnd = true;
          destroyObj();
          InitObj();
      }
  }
    
    // destroy objects
    private void destroyObj(){
        ch.detachAllChildren();
        bulletAppState.getPhysicsSpace().remove(ramp_phy);
        rootNode.detachChild(ramp_geo);
        rootNode.detachChild(fire); 
        
    }    
    
     public void initAbilities(BigInteger[] temp) {
        for (int i = 0; i < abilitySize; i++) {
            temp[i] = new BigInteger(String.valueOf(System.nanoTime()));
        }
    }
    
    public boolean onCooldown(BigInteger[] temp, int i) {
        if (temp[i].compareTo(new BigInteger(String.valueOf(System.nanoTime()))) < 0) {
            temp[i] = new BigInteger(String.valueOf(System.nanoTime())).add(
                    new BigInteger("5000000000"));
            return false;
        }
        else {
            return true;
        }
    }
 

}