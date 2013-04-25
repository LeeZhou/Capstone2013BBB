package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.ImageRenderer;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.render.NiftyImage;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import java.util.Properties;

/**
 *
 * @author calvin
 */
public class MapSelectionController implements Controller{

  private Screen screen;
  public static int currentMap;
  private Nifty nifty;

  @Override
  public void bind(
      final Nifty nifty,
      final Screen screen,
      final Element element,
      final Properties parameter,
      final Attributes controlDefinitionAttributes) {
        this.screen = screen;   
        this.nifty = nifty;
  }

  @Override
  public void init(final Properties parameter, final Attributes controlDefinitionAttributes) {   

            
  }

  @Override
  public void onStartScreen() {
  }

  @Override
  public void onFocus(final boolean getFocus) {
  }

  @Override
  public boolean inputEvent(final NiftyInputEvent inputEvent) {
    return false;
  }
  
  @NiftyEventSubscriber(id="mapbutton1")
  public void onMapButton1Clicked(final String id, final ButtonClickedEvent event) {
      Element niftyElement = nifty.getCurrentScreen().findElementByName("map0");
      NiftyImage img = nifty.getRenderEngine().createImage("Interface/map0.png", false);
      niftyElement.getRenderer(ImageRenderer.class).setImage(img);
      currentMap = 0;
  }
  
  @NiftyEventSubscriber(id="mapbutton2")
  public void onMapButton2Clicked(final String id, final ButtonClickedEvent event) {
      Element niftyElement = nifty.getCurrentScreen().findElementByName("map0");
      NiftyImage img = nifty.getRenderEngine().createImage("Interface/map1.png", false);
      niftyElement.getRenderer(ImageRenderer.class).setImage(img);
      currentMap = 1;
  }
  
  @NiftyEventSubscriber(id="mapbutton3")
  public void onMapButton3Clicked(final String id, final ButtonClickedEvent event) {
      Element niftyElement = nifty.getCurrentScreen().findElementByName("map0");
      NiftyImage img = nifty.getRenderEngine().createImage("Interface/map2.png", false);
      niftyElement.getRenderer(ImageRenderer.class).setImage(img);
      currentMap = 2;
  }
  
  @NiftyEventSubscriber(id="mapbutton4")
  public void onMapButton4Clicked(final String id, final ButtonClickedEvent event) {
      Element niftyElement = nifty.getCurrentScreen().findElementByName("map0");
      NiftyImage img = nifty.getRenderEngine().createImage("Interface/map3.png", false);
      niftyElement.getRenderer(ImageRenderer.class).setImage(img);
      currentMap = 3;
  }
  
  @NiftyEventSubscriber(id="mapbutton5")
  public void onMapButton5Clicked(final String id, final ButtonClickedEvent event) {
      Element niftyElement = nifty.getCurrentScreen().findElementByName("map0");
      NiftyImage img = nifty.getRenderEngine().createImage("Interface/map4.png", false);
      niftyElement.getRenderer(ImageRenderer.class).setImage(img);
      currentMap = 4;
  }  
  
  
  public static int getCurrentMap(){
      return currentMap;
  }    
  
}
