package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioButtonBuilder;
import de.lessvoid.nifty.controls.radiobutton.builder.RadioGroupBuilder;
import niftyclass.CommonBuilders;
import niftyclass.DialogPanelControlDefinition;

/**
 *
 * @author calvin
 */
public class MapSelectionControlDefinition {
  public static final String NAME = "listBoxDialogControl";
  private static CommonBuilders builders = new CommonBuilders();

  public static void register(final Nifty nifty) {
    new ControlDefinitionBuilder(NAME) {{
      controller(new MapSelectionController());
      control(new ControlBuilder(DialogPanelControlDefinition.NAME) {{

        // the actual list box panel at the top          
        panel(new PanelBuilder() {{
          childLayoutHorizontal();
         image(new ImageBuilder("title2") {{
            filename("Interface/title2.png");
         }});
        }});
        
        panel(builders.vspacer());
        panel(new PanelBuilder() {{
          width("100%");
          height("1px");
          backgroundColor("#0008");
        }});
        panel(builders.vspacer());
        panel(builders.vspacer());
        panel(builders.vspacer());
        
        image(new ImageBuilder("map0") {{
                  filename("Interface/map0.png");
                  alignCenter();
        }});
        
        panel(builders.vspacer());
        panel(builders.vspacer());
        panel(builders.vspacer());        

        panel(new PanelBuilder(){{ 
            childLayoutHorizontal();
            control(new ButtonBuilder("mapbutton1", "Map 1"));
            panel(builders.hspacer("5px"));
            control(new ButtonBuilder("mapbutton2", "Map 2"));
            panel(builders.hspacer("5px"));
            control(new ButtonBuilder("mapbutton3", "Map 3"));
            panel(builders.hspacer("5px"));
            control(new ButtonBuilder("mapbutton4", "Map 4"));
            panel(builders.hspacer("5px"));
            control(new ButtonBuilder("mapbutton5", "Map 5"));
            alignCenter();
        }});


        
      }});
    }}.registerControlDefintion(nifty);
  }
}