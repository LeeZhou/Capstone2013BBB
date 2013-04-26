/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.label.builder.LabelBuilder;
import de.lessvoid.nifty.controls.slider.builder.SliderBuilder;
import niftyclass.CommonBuilders;
import niftyclass.DialogPanelControlDefinition;

/**
 *
 * @author calvin
 */
public class ColorPickerControlDefinition{

public static final String NAME = "sliderAndScrollbarDialogControl";
  private static CommonBuilders builders = new CommonBuilders();

  public static void register(final Nifty nifty) {
    new ControlDefinitionBuilder(NAME) {{
      controller(new ColorPickerController());
      control(new ControlBuilder(DialogPanelControlDefinition.NAME) {{

        panel(new PanelBuilder() {{
          childLayoutVertical();
          image(new ImageBuilder("title4") {{
            filename("Interface/title4.png");
         }});
        }});        
        panel(builders.vspacer());
                panel(new PanelBuilder() {{
          width("100%");
          height("1px");
          backgroundColor("#0008");
        }});
        panel(builders.vspacer());
        panel(new PanelBuilder(){{
            childLayoutHorizontal();
            
            // Player 1
            
            panel(new PanelBuilder(){{
                childLayoutVertical();
                control(builders.createLabel("Player 1"));
                panel(builders.vspacer());

                panel(new PanelBuilder() {{
                childLayoutHorizontal();
                height("35%");

                panel(builders.hspacer("20px"));
                panel(new PanelBuilder() {{
                childLayoutVertical();
                width("23px");
                control(new SliderBuilder("sliderR0", true));
                control(new LabelBuilder() {{
                  alignCenter();
                  text("R");
                  width("100%");
                }});
                }});
                panel(builders.hspacer("5px"));
                panel(new PanelBuilder() {{
                childLayoutVertical();
                control(new SliderBuilder("sliderG0", true));
                width("23px");
                control(new LabelBuilder() {{
                  alignCenter();
                  text("G");
                  width("100%");
                }});
                }});
                panel(builders.hspacer("5px"));
                panel(new PanelBuilder() {{
                childLayoutVertical();
                control(new SliderBuilder("sliderB0", true));
                width("23px");
                control(new LabelBuilder() {{
                  alignCenter();
                  text("B");
                  width("100%");
                }});
                }});
                }});
                panel(builders.hspacer("35px"));

                panel(new PanelBuilder() {{                
                alignCenter();
                panel(builders.vspacer());
                childLayoutVertical();
                width("20%");
                panel(new PanelBuilder("color0") {{
                  alignCenter();
                  valignCenter();
                  width("50px");
                  height("50px");
                  backgroundColor("#000f");
                }});
                }});
                panel(builders.hspacer("9px"));

            }});
            
            // Player 2
            
            panel(new PanelBuilder(){{
            childLayoutVertical();
            control(builders.createLabel("Player 2"));
            panel(builders.vspacer());

            panel(new PanelBuilder() {{
            childLayoutHorizontal();
            height("35%");

            panel(builders.hspacer("20px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            width("23px");
            control(new SliderBuilder("sliderR1", true));
            control(new LabelBuilder() {{
              alignCenter();             
              text("R");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderG1", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("G");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderB1", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("B");
              width("100%");
            }});
            }});
            }});
            panel(builders.hspacer("35px"));

            panel(new PanelBuilder() {{                
                alignCenter();
                panel(builders.vspacer());
                childLayoutVertical();
                width("20%");
                panel(new PanelBuilder("color1") {{
                  alignCenter();
                  valignCenter();
                  width("50px");
                  height("50px");
                  backgroundColor("#000f");
                }});
                }});
            panel(builders.hspacer("9px"));

            }});
                        
            // Player 3
                        
            panel(new PanelBuilder(){{
            childLayoutVertical();
            control(builders.createLabel("Player 3"));
            panel(builders.vspacer());

            panel(new PanelBuilder() {{
            childLayoutHorizontal();
            height("35%");

            panel(builders.hspacer("20px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            width("23px");
            control(new SliderBuilder("sliderR2", true));
            control(new LabelBuilder() {{
              alignCenter();
              text("R");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderG2", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("G");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderB2", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("B");
              width("100%");
            }});
            }});
            }});
            panel(builders.hspacer("35px"));

            panel(new PanelBuilder() {{                
                alignCenter();
                panel(builders.vspacer());
                childLayoutVertical();
                width("20%");
                panel(new PanelBuilder("color2") {{
                  alignCenter();
                  valignCenter();
                  width("50px");
                  height("50px");
                  backgroundColor("#000f");
                }});
                }});
            panel(builders.hspacer("9px"));

            }});
                      
            // Player 4
            
            panel(new PanelBuilder(){{
            childLayoutVertical();
            control(builders.createLabel("Player 4"));
            panel(builders.vspacer());

            panel(new PanelBuilder() {{
            childLayoutHorizontal();
            height("35%");

            panel(builders.hspacer("20px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            width("23px");
            control(new SliderBuilder("sliderR3", true));
            control(new LabelBuilder() {{
              alignCenter();
              text("R");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderG3", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("G");
              width("100%");
            }});
            }});
            panel(builders.hspacer("5px"));
            panel(new PanelBuilder() {{
            childLayoutVertical();
            control(new SliderBuilder("sliderB3", true));
            width("23px");
            control(new LabelBuilder() {{
              alignCenter();
              text("B");
              width("100%");
            }});
            }});
            }});
            panel(builders.hspacer("35px"));
            panel(new PanelBuilder() {{                
                alignCenter();
                panel(builders.vspacer());
                childLayoutVertical();
                width("20%");
                panel(new PanelBuilder("color3") {{
                  alignCenter();
                  valignCenter();
                  width("50px");
                  height("50px");
                  backgroundColor("#000f");
                }});
                }});
            panel(builders.hspacer("9px"));

            }});                          
            
        }});

        
      }});
    }}.registerControlDefintion(nifty);
  }
  }