package screens;

import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import de.lessvoid.nifty.EndNotify;
import java.util.Properties;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.Button;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.controls.CheckBox;
import de.lessvoid.nifty.controls.CheckBoxStateChangedEvent;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.controls.DropDown;
import de.lessvoid.nifty.controls.DropDownSelectionChangedEvent;
import de.lessvoid.nifty.controls.Label;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.controls.ListBoxSelectionChangedEvent;
import de.lessvoid.nifty.controls.RadioButtonGroup;
import de.lessvoid.nifty.controls.RadioButtonGroupStateChangedEvent;
import de.lessvoid.nifty.controls.RadioButtonStateChangedEvent;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.controls.TextFieldChangedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import java.util.List;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.InputManager;
import com.jme3.input.controls.KeyTrigger;
import niftyclass.JustAnExampleModelClass;

/**
 *
 * @author calvin
 */
public class MapSelectionController implements Controller{

  private Screen screen;
  public static int currentMap;


  @Override
  public void bind(
      final Nifty nifty,
      final Screen screen,
      final Element element,
      final Properties parameter,
      final Attributes controlDefinitionAttributes) {
        this.screen = screen;        
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
  
  @NiftyEventSubscriber(id="map-0")
  public void onOption0Changed(final String id, final RadioButtonStateChangedEvent event) {
    currentMap = 0;
  }

  @NiftyEventSubscriber(id="map-1")
  public void onOption1Changed(final String id, final RadioButtonStateChangedEvent event) {
    currentMap = 1;
  }
  
  @NiftyEventSubscriber(id="map-2")
  public void onOption2Changed(final String id, final RadioButtonStateChangedEvent event) {
    currentMap = 2;
  }
  
  @NiftyEventSubscriber(id="map-3")
  public void onOption3Changed(final String id, final RadioButtonStateChangedEvent event) {
    currentMap = 3;
  }
  
  @NiftyEventSubscriber(id="map-4")
  public void onOption4Changed(final String id, final RadioButtonStateChangedEvent event) {
    currentMap = 4;
  }
  
  
  public static int getCurrentMap(){
      return currentMap;
  }    
  
}
