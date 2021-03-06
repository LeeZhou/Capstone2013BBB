/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.controls.DropDown;
import de.lessvoid.nifty.controls.DropDownSelectionChangedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import java.util.Properties;
import mygame.Main;
import niftyclass.JustAnExampleModelClass;

/**
 *
 * @author calvin
 */
public class KeyBindingController implements Controller {
    
    private Screen screen;
    private DropDown[] keybinding;
    public static int [] key;

    
    public void bind(Nifty nifty, Screen screen, Element element, Properties parameter, Attributes controlDefinitionAttributes) {
        this.screen = screen;
        keybinding = new DropDown[4];

        for(int j = 0; j < 4; j++){
             this.keybinding[j] = screen.findNiftyControl("key"+j, DropDown.class);
        }
        
    }

    public void init(Properties parameter, Attributes controlDefinitionAttributes) {
         key = new int[4];
         for(int i = 0; i < 4; i++){
            keybinding[i].addItem("Default/Last Key");
            keybinding[i].addItem("WASD + Q");
            keybinding[i].addItem("IJKL + SPACE");
            keybinding[i].addItem("ARROW + RIGHTSHIFT");        
            keybinding[i].addItem("8456 + 0");
            if(Main.gamecounter == 0){
                key[i] = i;
            }
            else{
             key[i] = Main.key[i];
         }
      }        

    }

    public void onStartScreen() {

    }

    public void onFocus(boolean getFocus) {

    }

    public boolean inputEvent(NiftyInputEvent inputEvent) {
        return false;
    }
    
    @NiftyEventSubscriber(id="key0")
    public void onkey0Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[0].getSelection() == "WASD + Q"){ 
          key[0] = 0;
      }
      else if(keybinding[0].getSelection() == "IJKL + SPACE"){
          key[0] = 1;
      }
      else if(keybinding[0].getSelection() == "ARROW + RIGHTSHIFT"){
          key[0] = 2;
      }
      else if(keybinding[0].getSelection() == "8456 + 0"){
          key[0] = 3;
      }
      else if(keybinding[0].getSelection() == "Default/Last Key"){
          if(Main.gamecounter==0){
              key[0] = 0;
          }
          else{
              key[0] = Main.key[0];
          }
      }
  }
  
  @NiftyEventSubscriber(id="key1")
  public void onkey1Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[1].getSelection() == "WASD + Q"){          
          key[1] = 0;
      }
      else if(keybinding[1].getSelection() == "IJKL + SPACE"){
          key[1] = 1;
      }
      else if(keybinding[1].getSelection() == "ARROW + RIGHTSHIFT"){
          key[1] = 2;
      }
      else if(keybinding[1].getSelection() == "8456 + 0"){
          key[1] = 3;
      }
      else if(keybinding[1].getSelection() == "Default/Last Key"){
          if(Main.gamecounter==0){
              key[1] = 1;
          }
          else{
              key[1] = Main.key[1];
          }
      }
  }
  
  @NiftyEventSubscriber(id="key2")
  public void onkey2Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[2].getSelection() == "WASD + Q"){          
          key[2] = 0;
      }
      else if(keybinding[2].getSelection() == "IJKL + SPACE"){
          key[2] = 1;
      }
      else if(keybinding[2].getSelection() == "ARROW + RIGHTSHIFT"){
          key[2] = 2;
      }
      else if(keybinding[2].getSelection() == "8456 + 0"){
          key[2] = 3;
      }
      else if(keybinding[2].getSelection() == "Default/Last Key"){
          if(Main.gamecounter==0){
              key[2] = 2;
          }
          else{
              key[2] = Main.key[2];
          }
      }
  }
  
  @NiftyEventSubscriber(id="key3")
  public void onkey3Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
      if(keybinding[3].getSelection() == "WASD + Q"){          
          key[3] = 0;
      }
      else if(keybinding[3].getSelection() == "IJKL + SPACE"){
          key[3] = 1;
      }
      else if(keybinding[3].getSelection() == "ARROW + RIGHTSHIFT"){
          key[3] = 2;
      }
      else if(keybinding[3].getSelection() == "8456 + 0"){
          key[3] = 3;
      }
      else if(keybinding[3].getSelection() == "Default/Last Key"){
          if(Main.gamecounter==0){
              key[3] = 3;
          }
          else{
              key[3] = Main.key[3];
          }
      }
  }
  
  public static int []getKeyBinding(){
      return key;
  }

  public static Boolean isKeyBindingValid(){
      int numberPlayer = PlayerSettingController.getNumberPlayer();
      if(numberPlayer ==2){
          if(key[0] == key[1]){
              return false;
          }
          else{
              return true;
          }
      }      
      else if(numberPlayer >=3){
          if(key[1] == key[2] || key[0] == key[2]){
              return false;
          }
          else if(numberPlayer == 4){
              if(key[1] == key[3] || key[2] == key[3] || key[0] == key[3]){
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
  /*
  public static Boolean isKeyBindingSelected(){
      int numberPlayer = PlayerSettingController.getNumberPlayer();
      if(numberPlayer ==2){
          if(key[0] == 4 || key[1] == 4){
              return false;
          }
          else{
              return true;
          }
      }      
      else if(numberPlayer ==3){
          if(key[1] == 4 || key[2] == 4 || key[0] == 4){
              return false;
          }
          else{
              return true;
          }
      }
        else if(numberPlayer == 4){
            if(key[1] == 4 || key[2] == 4 || key[0] == 4 || key[3] == 4){
                return false;
            }
            else{
                return true;
            }              
        }
        else{
            return false;
        }
  }*/
  
    
}
