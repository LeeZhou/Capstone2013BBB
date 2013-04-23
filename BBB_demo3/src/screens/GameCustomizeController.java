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
public class GameCustomizeController implements Controller{

  private Screen screen;
  public static int currentMap;
    private static DropDown[] keybinding;
    private static int key0 = 0;
    private static int key1 = 1;
    private static int key2 = 2;
    private static int key3 = 3;


  @Override
  public void bind(
      final Nifty nifty,
      final Screen screen,
      final Element element,
      final Properties parameter,
      final Attributes controlDefinitionAttributes) {
        this.screen = screen;
        keybinding = new DropDown[4];
        for(int j = 0; j < 4; j++){
             this.keybinding[j] = screen.findNiftyControl("key"+j, DropDown.class);            
        }
  }

  @Override
  public void init(final Properties parameter, final Attributes controlDefinitionAttributes) {
      for(int i = 0; i < 4; i++){
            keybinding[i].addItem("Default");
            keybinding[i].addItem("WASD + Q");
            keybinding[i].addItem("IJKL + SPACE");
            keybinding[i].addItem("ARROW + ENTER");        
            keybinding[i].addItem("8456 + 0");
      }

            
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
  
  @NiftyEventSubscriber(id="key0")
  public void onkey0Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[0].getSelection() == "WASD + Q"){ 
          key0 = 0;
      }
      else if(keybinding[0].getSelection() == "IJKL + SPACE"){
          key0 = 1;
      }
      else if(keybinding[0].getSelection() == "ARROW + ENTER"){
          key0 = 2;
      }
      else if(keybinding[0].getSelection() == "8456 + 0"){
          key0 = 3;
      }
      else if(keybinding[0].getSelection() == "Default"){
          key0 = 0;
      }
  }
  
  @NiftyEventSubscriber(id="key1")
  public void onkey1Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[1].getSelection() == "WASD + Q"){          
          key1 = 0;
      }
      else if(keybinding[1].getSelection() == "IJKL + SPACE"){
          key1 = 1;
      }
      else if(keybinding[1].getSelection() == "ARROW + ENTER"){
          key1 = 2;
      }
      else if(keybinding[1].getSelection() == "8456 + 0"){
          key1 = 3;
      }
      else if(keybinding[1].getSelection() == "Default"){
          key1 = 1;
      }
  }
  
  @NiftyEventSubscriber(id="key2")
  public void onkey2Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[2].getSelection() == "WASD + Q"){          
          key2 = 0;
      }
      else if(keybinding[2].getSelection() == "IJKL + SPACE"){
          key2 = 1;
      }
      else if(keybinding[2].getSelection() == "ARROW + ENTER"){
          key2 = 2;
      }
      else if(keybinding[2].getSelection() == "8456 + 0"){
          key2 = 3;
      }
      else if(keybinding[2].getSelection() == "Default"){
          key2 = 2;
      }
  }
  
  @NiftyEventSubscriber(id="key3")
  public void onkey3Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[3].getSelection() == "WASD + Q"){          
          key3 = 0;
      }
      else if(keybinding[3].getSelection() == "IJKL + SPACE"){
          key3 = 1;
      }
      else if(keybinding[3].getSelection() == "ARROW + ENTER"){
          key3 = 2;
      }
      else if(keybinding[3].getSelection() == "8456 + 0"){
          key3 = 3;
      }
      else if(keybinding[3].getSelection() == "Default"){
          key3 = 3;
      }
  }
  
  public static int getCurrentMap(){
      return currentMap;
  }  
  
  public static int [] getKeyBinding(){
      return keybinding;
  }

  public static Boolean isKeyBindingValid(){
      int numberPlayer = GameSettingController.getNumberPlayer();
      if(numberPlayer ==2){
          if(key0 == key1){
              return false;
          }
          else{
              return true;
          }
      }      
      else if(numberPlayer >=3){
          if(key1==key2 || key0 == key2){
              return false;
          }
          else if(numberPlayer == 4){
              if(key1 == key3 || key2 == key3 || key0 == key3){
                  return false;
              }
              else{
                  return true;
              }              
          }
          else{
              return true;
          }
      }
      else{
          return true;
      }
  
    }
}
