package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.EffectBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.dropdown.builder.DropDownBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioButtonBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioGroupBuilder;
import niftyclass.CommonBuilders;
import niftyclass.DialogPanelControlDefinition;

/**
 * The DropDownDialogControlDefinition registers a new control with Nifty
 * that represents the whole Dialog. This gives us later an appropriate
 * ControlBuilder to actual construct the Dialog (as a control).
 * @author void
 */
public class GameSettingControlDefinition {
  public static final String NAME = "dropDownDialogControl";
  private static CommonBuilders builders = new CommonBuilders();

  public static void register(final Nifty nifty) {
    new ControlDefinitionBuilder(NAME) {{
        controller(new GameSettingController());
        control(new ControlBuilder(DialogPanelControlDefinition.NAME) {{
        control(builders.createLabel("Game Settings"));
        panel(builders.vspacer());

        panel(new PanelBuilder() {{
          width("100%");
          height("1px");
          backgroundColor("#0008");
        }});
        panel(builders.vspacer());
        
        // Number of Player selection
        control(new RadioGroupBuilder("RadioGroup-1")); // the RadioGroup id is used to link radiobuttons logical together so that only one of them can be active at a certain time
        panel(new PanelBuilder() {{
          control(builders.createLabel("# of Players"));
          childLayoutHorizontal();
          control(new RadioGroupBuilder("RadioGroup-1"));
          panel(new PanelBuilder() {{
            childLayoutHorizontal();
            backgroundColor("#8001");
            paddingLeft("7px");
            paddingRight("7px");
            paddingTop("4px");
            paddingBottom("4px");
            width("200px");
            height("30px");
            onActiveEffect(new EffectBuilder("border") {{
              effectParameter("color", "#0008");
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("2P", "25px"));
              control(new RadioButtonBuilder("option-1"){{
                  group("RadioGroup-1");
              }});
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("3P", "25px"));
              control(new RadioButtonBuilder("option-2"){{
                  group("RadioGroup-1");
              }});
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("4P", "25px"));
              control(new RadioButtonBuilder("option-3"){{
                  group("RadioGroup-1");
              }});
            }});
          }});
          panel(builders.hspacer("10px"));        
        }});
        panel(builders.vspacer());
        panel(builders.vspacer());
        panel(new PanelBuilder() {{
          width("100%");
          height("1px");
          backgroundColor("#0008");
        }});
        panel(builders.vspacer());   
        // P1 ability selection        
        control(builders.createLabel("Select Ability"));
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
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                control(new DropDownBuilder("dropDown0") {{
                    width("*");                    
                }
                });
            }});               
        }});  
        
        panel(builders.vspacer());
        
        // P2 ability
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("Player 2"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                control(new DropDownBuilder("dropDown1") {{
                    width("*");                    
                }
                });
            }});            
            
        }});  
        
        panel(builders.vspacer());
        
        // P3 ability
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("Player 3"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                control(new DropDownBuilder("dropDown2") {{
                    width("*");                    
                }
                });
            }});            
            
        }});  
        
        panel(builders.vspacer());        
        
        // P4 ability 
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("Player 4"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                control(new DropDownBuilder("dropDown3") {{
                    width("*");                    
                }
                });
            }});           
            
        }});  
                

      }});
    }}.registerControlDefintion(nifty);
  }
}
