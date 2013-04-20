package screens;

import java.util.Properties;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.controls.CheckBoxStateChangedEvent;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.controls.DropDown;
import de.lessvoid.nifty.controls.DropDownSelectionChangedEvent;
import de.lessvoid.nifty.controls.Label;
import de.lessvoid.nifty.controls.RadioButtonGroup;
import de.lessvoid.nifty.controls.RadioButtonGroupStateChangedEvent;
import de.lessvoid.nifty.controls.RadioButtonStateChangedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import niftyclass.JustAnExampleModelClass;


public class GameSettingController implements Controller {
  private Screen screen;
  private RadioButtonGroup radioButtonGroup1;
  private DropDown [] dropDown;
  private Nifty nifty2;
  public static int numberPlayer;
  private static Boolean exit = false;
  private static int [] selection;
  private static int [] ability;
  
  @SuppressWarnings("unchecked")
  @Override
  public void bind(
      final Nifty nifty,
      final Screen screen,
      final Element element,
      final Properties parameter,
      final Attributes controlDefinitionAttributes) {
        dropDown = new DropDown[4];
        nifty2 = nifty;
        this.screen = screen;
        this.radioButtonGroup1 = screen.findNiftyControl("RadioGroup-1", RadioButtonGroup.class);
        for(int j = 0; j < 4; j++){
             this.dropDown[j] = screen.findNiftyControl("dropDown"+j, DropDown.class);            
        }
      }

  @Override
  public void init(final Properties parameter, final Attributes controlDefinitionAttributes) {
        selection = new int[4];
        ability = new int [4];
        for(int k = 0; k < 4; k++){
            selection[k] = 1;        
            ability[k] = 1;
            dropDown[k].addItem("Dash");
            dropDown[k].addItem("Jump");        
            dropDown[k].addItem("Glue");
            dropDown[k].addItem("Force Push");
            dropDown[k].addItem("Ghost");
            dropDown[k].addItem("Blink");
            dropDown[k].addItem("Mine");
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
  
  // Number of Players
  
  @NiftyEventSubscriber(id="option-1")
  public void onOption1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    numberPlayer = 2;
  }

  @NiftyEventSubscriber(id="option-2")
  public void onOption2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    numberPlayer = 3;
  }

  @NiftyEventSubscriber(id="option-3")
  public void onOption3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    numberPlayer = 4;
  }

  @NiftyEventSubscriber(id="RadioGroup-1")
  public void onRadioGroup1Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-1-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }

    @NiftyEventSubscriber(id="startButton")
    public void onStartButtonClicked(final String id, final ButtonClickedEvent event) {
          nifty2.exit();
    }   
    @NiftyEventSubscriber(id="quitButton")
    public void onQuitButtonClicked(final String id, final ButtonClickedEvent event) {
          exit = true;
          nifty2.exit();
    }  

    // Ability dropdown selection
    
    @NiftyEventSubscriber(id="dropDown0")
    public void onDropDownSelection1Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
        if(dropDown[0].getSelection() == "Dash"){
            selection[0] = 1;
        } 
        else if(dropDown[0].getSelection() == "Jump"){
            selection[0] = 2;
        }
        else if(dropDown[0].getSelection() == "Glue"){
            selection[0] = 3;
        }
        else if(dropDown[0].getSelection() == "Force Push"){
            selection[0] = 4;
        }
        else if(dropDown[0].getSelection() == "Ghost"){
            selection[0] = 5;
        }
        else if(dropDown[0].getSelection() == "Blink"){
            selection[0] = 6;
        }
        else if(dropDown[0].getSelection() == "Mine"){
            selection[0] = 7;
        }
    }

    @NiftyEventSubscriber(id="dropDown1")
    public void onDropDownSelection2Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
        if(dropDown[1].getSelection() == "Dash"){
            selection[1] = 1;
        } 
        else if(dropDown[1].getSelection() == "Jump"){
            selection[1] = 2;
        }
        else if(dropDown[1].getSelection() == "Glue"){
            selection[1] = 3;
        }
        else if(dropDown[1].getSelection() == "Force Push"){
            selection[1] = 4;
        }
        else if(dropDown[1].getSelection() == "Ghost"){
            selection[1] = 5;
        }
        else if(dropDown[1].getSelection() == "Blink"){
            selection[1] = 6;
        }
        else if(dropDown[1].getSelection() == "Mine"){
            selection[1] = 7;
        }        
    }

    @NiftyEventSubscriber(id="dropDown2")
    public void onDropDownSelection3Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
            if(dropDown[2].getSelection() == "Dash"){
                selection[2] = 1;
            } 
            else if(dropDown[2].getSelection() == "Jump"){
                selection[2] = 2;
            }
            else if(dropDown[2].getSelection() == "Glue"){
                selection[2] = 3;
            }
            else if(dropDown[2].getSelection() == "Force Push"){
                selection[2] = 4;
            }
            else if(dropDown[2].getSelection() == "Ghost"){
                selection[2] = 5;
            }
            else if(dropDown[2].getSelection() == "Blink"){
                selection[2] = 6;
            }
            else if(dropDown[2].getSelection() == "Mine"){
                selection[2] = 7;
            }
        
    }

    @NiftyEventSubscriber(id="dropDown3")
    public void onDropDownSelection4Changed(final String id, final DropDownSelectionChangedEvent<JustAnExampleModelClass> event) {
        if(dropDown[3].getSelection() == "Dash"){
            selection[3] = 1;
        } 
        else if(dropDown[3].getSelection() == "Jump"){
            selection[3] = 2;
        }
        else if(dropDown[3].getSelection() == "Glue"){
            selection[3] = 3;
        }
        else if(dropDown[3].getSelection() == "Force Push"){
            selection[3] = 4;
        }
        else if(dropDown[3].getSelection() == "Ghost"){
            selection[3] = 5;
        }
        else if(dropDown[3].getSelection() == "Blink"){
            selection[3] = 6;
        }
        else if(dropDown[3].getSelection() == "Mine"){
            selection[3] = 7;
        }
        
    }    

    public static int getNumberPlayer(){
        return numberPlayer;
    }

    public static int [] getPlayerAbility(){     
        
        System.arraycopy(selection, 0, ability, 0, 4);     
        return ability;        
    }
    
    public static Boolean getExitStatus(){
        return exit;        
    }

}
