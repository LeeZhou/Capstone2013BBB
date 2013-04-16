package de.lessvoid.nifty.examples.controls.dropdown;

import java.util.Properties;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.controls.CheckBoxStateChangedEvent;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.controls.Label;
import de.lessvoid.nifty.controls.RadioButtonGroup;
import de.lessvoid.nifty.controls.RadioButtonGroupStateChangedEvent;
import de.lessvoid.nifty.controls.RadioButtonStateChangedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;


public class DropDownDialogController implements Controller {
  private Screen screen;
  private RadioButtonGroup radioButtonGroup1;
  private RadioButtonGroup radioButtonGroup2;
  private RadioButtonGroup radioButtonGroup3;
  private RadioButtonGroup radioButtonGroup4;
  private RadioButtonGroup radioButtonGroup5;
  private Nifty nifty2;
  public static int numberPlayer;
  public static int p1 = 0;
  public static int p2 = 0;
  public static int p3 = 0;
  public static int p4 = 0;
  private boolean isReady = false;
  private static int [] ability;
  
  @SuppressWarnings("unchecked")
  @Override
  public void bind(
      final Nifty nifty,
      final Screen screen,
      final Element element,
      final Properties parameter,
      final Attributes controlDefinitionAttributes) {
        nifty2 = nifty;
        this.screen = screen;
        this.radioButtonGroup1 = screen.findNiftyControl("RadioGroup-1", RadioButtonGroup.class);
        this.radioButtonGroup2 = screen.findNiftyControl("RadioGroup-2", RadioButtonGroup.class);
        this.radioButtonGroup3 = screen.findNiftyControl("RadioGroup-3", RadioButtonGroup.class);
        this.radioButtonGroup4 = screen.findNiftyControl("RadioGroup-4", RadioButtonGroup.class);
        this.radioButtonGroup5 = screen.findNiftyControl("RadioGroup-5", RadioButtonGroup.class);
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

  // P1 option
  
  @NiftyEventSubscriber(id="option-a1")
  public void onOptionA1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-a1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p1 = 1;
  }  
  
  @NiftyEventSubscriber(id="option-b1")
  public void onOptionB1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-b1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p1 = 2;
  }  
  
  @NiftyEventSubscriber(id="option-c1")
  public void onOptionC1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-c1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p1 = 3;
  }  
  
  @NiftyEventSubscriber(id="option-d1")
  public void onOptionD1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-d1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p1 = 4;
  }  
  
  @NiftyEventSubscriber(id="option-e1")
  public void onOptionE1Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-e1-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p1 = 5;
  }  
  
    // P2 option
  
  @NiftyEventSubscriber(id="option-a2")
  public void onOptionA2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-a2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p2 = 1;
  }  
  
  @NiftyEventSubscriber(id="option-b2")
  public void onOptionB2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-b2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p2 = 2;
  }  
  
  @NiftyEventSubscriber(id="option-c2")
  public void onOptionC2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-c2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p2 = 3;
  }  
  
  @NiftyEventSubscriber(id="option-d2")
  public void onOptionD2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-d2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p2 = 4;
  }  
  
  @NiftyEventSubscriber(id="option-e2")
  public void onOptionE2Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-e2-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p2 = 5;
  }  
    
  // P3 option
  @NiftyEventSubscriber(id="option-a3")
  public void onOptionA3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-a3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p3 = 1;
  }  
  
  @NiftyEventSubscriber(id="option-b3")
  public void onOptionB3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-b3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p3 = 2;
  }  
  
  @NiftyEventSubscriber(id="option-c3")
  public void onOptionC3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-c3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p3 = 3;
  }  
  
  @NiftyEventSubscriber(id="option-d3")
  public void onOptionD3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-d3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p3 = 4;
  }  
  
  @NiftyEventSubscriber(id="option-e3")
  public void onOptionE3Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-e3-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p3 = 5;
  }  
  
  // P4 options
  @NiftyEventSubscriber(id="option-a4")
  public void onOptionA4Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-a4-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p4 = 1;
  }  
  
  @NiftyEventSubscriber(id="option-b4")
  public void onOptionB4Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-b4-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p4 = 2;
  }  
  
  @NiftyEventSubscriber(id="option-c4")
  public void onOptionC4Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-c4-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p4 = 3;
  }  
  
  @NiftyEventSubscriber(id="option-d4")
  public void onOptionD4Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-d4-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p4 = 4;
  }  
  
  @NiftyEventSubscriber(id="option-e4")
  public void onOptionE4Changed(final String id, final RadioButtonStateChangedEvent event) {
    screen.findNiftyControl("option-e4-changed", Label.class).setText(String.valueOf(event.isSelected()));
    p4 = 5;
  }  
  
  @NiftyEventSubscriber(id="radioGroupAllowDeselection")
  public void onRadioGroupAllowDeselectionChanged(final String id, final CheckBoxStateChangedEvent event) {
    radioButtonGroup1.allowDeselection(event.isChecked());
    radioButtonGroup2.allowDeselection(event.isChecked());
    radioButtonGroup3.allowDeselection(event.isChecked());
    radioButtonGroup4.allowDeselection(event.isChecked());
    radioButtonGroup5.allowDeselection(event.isChecked());

  }

  // Number of Player Button Group
  
  @NiftyEventSubscriber(id="RadioGroup-1")
  public void onRadioGroup1Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-1-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }
  
  // Abilities Groups
  
  @NiftyEventSubscriber(id="RadioGroup-2")
  public void onRadioGroup2Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-2-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }

  @NiftyEventSubscriber(id="RadioGroup-3")
  public void onRadioGroup3Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-3-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }
  
  @NiftyEventSubscriber(id="RadioGroup-4")
  public void onRadioGroup4Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-4-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }
  
  @NiftyEventSubscriber(id="RadioGroup-5")
  public void onRadioGroup5Changed(final String id, final RadioButtonGroupStateChangedEvent event) {
    screen.findNiftyControl("RadioGroup-5-changed", Label.class).setText(event.getSelectedId() + " (" + event.getPreviousSelectedId() + ")");
  }
  
  // End Ability Groups
  
  @NiftyEventSubscriber(id="radioGroupDisable")
  public void onRadioGroupDisableCheckBox(final String id, final CheckBoxStateChangedEvent event) {
    radioButtonGroup1.setEnabled(!event.isChecked());    
    radioButtonGroup2.setEnabled(!event.isChecked());
    radioButtonGroup3.setEnabled(!event.isChecked());
    radioButtonGroup4.setEnabled(!event.isChecked());
    radioButtonGroup5.setEnabled(!event.isChecked());
    
    isReady = !isReady;
  }
  
    @NiftyEventSubscriber(id="startButton")
  public void onStartButtonClicked(final String id, final ButtonClickedEvent event) {
    if(isReady){
        nifty2.exit();
    }
  }
    
    public static int getNumberPlayer(){
        return numberPlayer;
    }
    
    public static int [] getPlayerAbility(){        
        ability = new int [4];
        ability[0] = p1;
        ability[1] = p2;
        if(numberPlayer >= 3){
            ability[2] = p3;
            if(numberPlayer == 4){
                ability[3] = p4;
            }
            else
            {
                ability[3] = 0;
            }
        }
        else{
            ability[2] = 0;
            ability[3] = 0;            
        }
        
        return ability;        
    }
}
