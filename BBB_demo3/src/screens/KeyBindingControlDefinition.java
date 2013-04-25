package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.EffectBuilder;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.checkbox.builder.CheckboxBuilder;
import de.lessvoid.nifty.controls.dropdown.builder.DropDownBuilder;
import de.lessvoid.nifty.controls.label.builder.LabelBuilder;
import de.lessvoid.nifty.controls.listbox.builder.ListBoxBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioButtonBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioGroupBuilder;
import niftyclass.CommonBuilders;
import niftyclass.DialogPanelControlDefinition;



public class KeyBindingControlDefinition {
  public static final String NAME = "DropDownDialogControl";
  private static CommonBuilders builders = new CommonBuilders();

  public static void register(final Nifty nifty) {
    new ControlDefinitionBuilder(NAME) {{
      controller(new KeyBindingController());
      control(new ControlBuilder(DialogPanelControlDefinition.NAME) {{    
       
        
        // Key bindings
        
        panel(new PanelBuilder() {{
          childLayoutVertical();
          image(new ImageBuilder("title3") {{
            filename("Interface/title3.png");
         }});
        }});        
        panel(builders.vspacer());
        panel(new PanelBuilder() {{
          width("100%");
          height("1px");
          backgroundColor("#0008");
        }});
        panel(builders.vspacer());          
      
         
        panel(new PanelBuilder() {{
          childLayoutHorizontal();
          control(builders.createLabel("Player 1"));
          control(new DropDownBuilder("key0") {{
               width("*");                    
          }});            
        }});
        panel(builders.vspacer());
        
        panel(new PanelBuilder() {{
          childLayoutHorizontal();
          control(builders.createLabel("Player 2"));
          control(new DropDownBuilder("key1") {{
               width("*");                    
          }});            
        }});
        panel(builders.vspacer());
        
        panel(new PanelBuilder() {{
          childLayoutHorizontal();
          control(builders.createLabel("Player 3"));
          control(new DropDownBuilder("key2") {{
               width("*");                    
          }});            
        }});
        panel(builders.vspacer());
        
        panel(new PanelBuilder() {{
          childLayoutHorizontal();
          control(builders.createLabel("Player 4"));
          control(new DropDownBuilder("key3") {{
               width("*");                    
          }});            
        }});          
        
      }});
    }}.registerControlDefintion(nifty);
  }

}
