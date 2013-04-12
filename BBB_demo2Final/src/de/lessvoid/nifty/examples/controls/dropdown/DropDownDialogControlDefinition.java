package de.lessvoid.nifty.examples.controls.dropdown;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.EffectBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.checkbox.builder.CheckboxBuilder;
import de.lessvoid.nifty.controls.dropdown.builder.DropDownBuilder;
import de.lessvoid.nifty.controls.label.builder.LabelBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioButtonBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioGroupBuilder;
import de.lessvoid.nifty.examples.controls.common.CommonBuilders;
import de.lessvoid.nifty.examples.controls.common.DialogPanelControlDefinition;

/**
 * The DropDownDialogControlDefinition registers a new control with Nifty
 * that represents the whole Dialog. This gives us later an appropriate
 * ControlBuilder to actual construct the Dialog (as a control).
 * @author void
 */
public class DropDownDialogControlDefinition {
  public static final String NAME = "dropDownDialogControl";
  private static CommonBuilders builders = new CommonBuilders();

  public static void register(final Nifty nifty) {
    new ControlDefinitionBuilder(NAME) {{
        controller(new DropDownDialogController());
        control(new ControlBuilder(DialogPanelControlDefinition.NAME) {{
        control(builders.createLabel("Game Settings"));
        panel(builders.vspacer());
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
          panel(new PanelBuilder() {{
            childLayoutHorizontal();
            backgroundColor("#8001");
            paddingLeft("7px");
            paddingRight("7px");
            paddingTop("4px");
            paddingBottom("4px");
            width("200px");
            onActiveEffect(new EffectBuilder("border") {{
              effectParameter("color", "#0008");
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("2P", "25px"));
              control(new RadioButtonBuilder("option-1") {{
                group("RadioGroup-1");
              }});
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("3P", "25px"));
              control(new RadioButtonBuilder("option-2") {{
                group("RadioGroup-1");
              }});
            }});
            panel(new PanelBuilder() {{
              childLayoutHorizontal();
              control(builders.createLabel("4P", "25px"));
              control(new RadioButtonBuilder("option-3") {{
                group("RadioGroup-1");
              }});
            }});
          }});
          panel(builders.hspacer("10px"));        
        }});
        panel(builders.vspacer());
        panel(builders.vspacer());
                
        // P1 ability selection
        
        control(new RadioGroupBuilder("RadioGroup-2"));
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("P1 Ability"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                backgroundColor("#8001");
                paddingLeft("7px");
                paddingRight("7px");
                paddingTop("4px");
                paddingBottom("4px");
                width("500px");
                onActiveEffect(new EffectBuilder("border") {{
                    effectParameter("color", "#0008");
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Dash", "65px"));
                    control(new RadioButtonBuilder("option-a1") {{
                        group("RadioGroup-2");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Jump", "65px"));
                    control(new RadioButtonBuilder("option-b1") {{
                        group("RadioGroup-2");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Glue", "65px"));
                    control(new RadioButtonBuilder("option-c1") {{
                        group("RadioGroup-2");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Force Push", "65px"));
                    control(new RadioButtonBuilder("option-d1") {{
                        group("RadioGroup-2");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Ghost", "65px"));
                    control(new RadioButtonBuilder("option-e1") {{
                        group("RadioGroup-2");
                    }});
                }});
            }});            
            
        }});  
        
        panel(builders.vspacer());
        
        control(new RadioGroupBuilder("RadioGroup-3"));
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("P2 Ability"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                backgroundColor("#8001");
                paddingLeft("7px");
                paddingRight("7px");
                paddingTop("4px");
                paddingBottom("4px");
                width("500px");
                onActiveEffect(new EffectBuilder("border") {{
                    effectParameter("color", "#0008");
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Dash", "65px"));
                    control(new RadioButtonBuilder("option-a2") {{
                        group("RadioGroup-3");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Jump", "65px"));
                    control(new RadioButtonBuilder("option-b2") {{
                        group("RadioGroup-3");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Glue", "65px"));
                    control(new RadioButtonBuilder("option-c2") {{
                        group("RadioGroup-3");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Force Push", "65px"));
                    control(new RadioButtonBuilder("option-d2") {{
                        group("RadioGroup-3");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Ghost", "65px"));
                    control(new RadioButtonBuilder("option-e2") {{
                        group("RadioGroup-3");
                    }});
                }});
            }});            
            
        }});  
        
        panel(builders.vspacer());
        
        control(new RadioGroupBuilder("RadioGroup-4"));
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("P3 Ability"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                backgroundColor("#8001");
                paddingLeft("7px");
                paddingRight("7px");
                paddingTop("4px");
                paddingBottom("4px");
                width("500px");
                onActiveEffect(new EffectBuilder("border") {{
                    effectParameter("color", "#0008");
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Dash", "65px"));
                    control(new RadioButtonBuilder("option-a3") {{
                        group("RadioGroup-4");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Jump", "65px"));
                    control(new RadioButtonBuilder("option-b3") {{
                        group("RadioGroup-4");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Glue", "65px"));
                    control(new RadioButtonBuilder("option-c3") {{
                        group("RadioGroup-4");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Force Push", "65px"));
                    control(new RadioButtonBuilder("option-d3") {{
                        group("RadioGroup-4");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Ghost", "65px"));
                    control(new RadioButtonBuilder("option-e3") {{
                        group("RadioGroup-4");
                    }});
                }});
            }});            
            
        }});  
        
        panel(builders.vspacer());
        
        control(new RadioGroupBuilder("RadioGroup-5"));
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            control(builders.createLabel("P4 Ability"));                
            panel(builders.vspacer());
            panel(new PanelBuilder() {{
                childLayoutHorizontal();
                backgroundColor("#8001");
                paddingLeft("7px");
                paddingRight("7px");
                paddingTop("4px");
                paddingBottom("4px");
                width("500px");
                onActiveEffect(new EffectBuilder("border") {{
                    effectParameter("color", "#0008");
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Dash", "65px"));
                    control(new RadioButtonBuilder("option-a4") {{
                        group("RadioGroup-5");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Jump", "65px"));
                    control(new RadioButtonBuilder("option-b4") {{
                        group("RadioGroup-5");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Glue", "65px"));
                    control(new RadioButtonBuilder("option-c4") {{
                        group("RadioGroup-5");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Force Push", "65px"));
                    control(new RadioButtonBuilder("option-d4") {{
                        group("RadioGroup-5");
                    }});
                }});
                panel(new PanelBuilder() {{
                    childLayoutHorizontal();
                    control(builders.createLabel("Ghost", "65px"));
                    control(new RadioButtonBuilder("option-e4") {{
                        group("RadioGroup-5");
                    }});
                }});
            }});            
            
        }});  
        
        
        panel(builders.vspacer());  
        panel(builders.vspacer());     
        panel(builders.vspacer());  
        panel(builders.vspacer());  
        panel(builders.vspacer());  
        
        panel(new PanelBuilder() {{
            width("100%");
            height("1px");
            backgroundColor("#0008");
        }});
        panel(builders.vspacer());  
        panel(new PanelBuilder() {{
            childLayoutHorizontal();
            panel(builders.vspacer());  
            panel(builders.vspacer());  
            control(builders.createLabel("Ready"));
            control(new CheckboxBuilder("radioGroupDisable") {{
                checked(false);
            }});          
            panel(builders.hspacer("250px"));
            control(new ButtonBuilder("startButton", "Start"));
        }});        
        
        
        panel(builders.vspacer());       
        panel(builders.vspacer());       
        
        
      }});
    }}.registerControlDefintion(nifty);
  }
}
