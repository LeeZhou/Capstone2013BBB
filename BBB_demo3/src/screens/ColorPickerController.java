/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.controls.Slider;
import de.lessvoid.nifty.controls.SliderChangedEvent;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.PanelRenderer;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.tools.Color;
import de.lessvoid.xml.xpp3.Attributes;
import java.util.Properties;

/**
 *
 * @author calvin
 */
public class ColorPickerController implements Controller{
        private Screen screen;
        private Element [] color;
        private static float []red;
        private static float []green;
        private static float []blue;
        private static float []alpha;
        private static float[][] colorMap = new float[4][4];

    @Override
    public void bind(
        final Nifty nifty,
        final Screen screen,
        final Element element,
        final Properties parameter,
        final Attributes controlDefinitionAttributes) {
        red = new float [4];
        green = new float [4];
        blue = new float [4];
        alpha = new float [4];
        color = new Element [4];
        
      this.screen = screen;
      for(int i = 0; i < 4; i++){
          this.color[i] = screen.findElementByName("color" + i);                
            this.red[i] = 0.f;
            this.green[i] = 0.f;
            this.blue[i] = 0.f;
      }      

    }

    @Override
    public void init(final Properties parameter, final Attributes controlDefinitionAttributes) {
    }

    @Override
    public void onStartScreen() {
      getSlider("sliderR0").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderG0").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderB0").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderA0").setup(0.f, 255.f, 255.f, 1.f, 10.f);
        
      getSlider("sliderR1").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderG1").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderB1").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderA1").setup(0.f, 255.f, 255.f, 1.f, 10.f);
      
      getSlider("sliderR2").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderG2").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderB2").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderA2").setup(0.f, 255.f, 255.f, 1.f, 10.f);

      getSlider("sliderR3").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderG3").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderB3").setup(0.f, 255.f,   0.f, 1.f, 10.f);
      getSlider("sliderA3").setup(0.f, 255.f, 255.f, 1.f, 10.f);

    }

    @Override
    public void onFocus(final boolean getFocus) {
    }

    @Override
    public boolean inputEvent(final NiftyInputEvent inputEvent) {
      return false;
    }

    // Color 1
    
    @NiftyEventSubscriber(id="sliderR0")
    public void onRedSlider0Change(final String id, final SliderChangedEvent event) {
      red[0] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderG0")
    public void onGreenSlider0Change(final String id, final SliderChangedEvent event) {
      green[0] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderB0")
    public void onBlueSlider0Change(final String id, final SliderChangedEvent event) {
      blue[0] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderA0")
    public void onAlphaSlider0Change(final String id, final SliderChangedEvent event) {
      alpha[0] = event.getValue();
      changeColor();    
    }
    
    // Color 2
    
    @NiftyEventSubscriber(id="sliderR1")
    public void onRedSlider1Change(final String id, final SliderChangedEvent event) {
      red[1] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderG1")
    public void onGreenSlider1Change(final String id, final SliderChangedEvent event) {
      green[1] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderB1")
    public void onBlueSlider1Change(final String id, final SliderChangedEvent event) {
      blue[1] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderA1")
    public void onAlphaSlider1Change(final String id, final SliderChangedEvent event) {
      alpha[1] = event.getValue();
      changeColor();    
    }
    
    // Color 3
    
    @NiftyEventSubscriber(id="sliderR2")
    public void onRedSlider2Change(final String id, final SliderChangedEvent event) {
      red[2] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderG2")
    public void onGreenSlider2Change(final String id, final SliderChangedEvent event) {
      green[2] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderB2")
    public void onBlueSlider2Change(final String id, final SliderChangedEvent event) {
      blue[2] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderA2")
    public void onAlphaSlider2Change(final String id, final SliderChangedEvent event) {
      alpha[2] = event.getValue();
      changeColor();    
    }
    
    @NiftyEventSubscriber(id="sliderR3")
    public void onRedSlider3Change(final String id, final SliderChangedEvent event) {
      red[3] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderG3")
    public void onGreenSlider3Change(final String id, final SliderChangedEvent event) {
      green[3] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderB3")
    public void onBlueSlider3Change(final String id, final SliderChangedEvent event) {
      blue[3] = event.getValue();
      changeColor();
    }

    @NiftyEventSubscriber(id="sliderA3")
    public void onAlphaSlider3Change(final String id, final SliderChangedEvent event) {
      alpha[3] = event.getValue();
      changeColor();    
    }
   

    private void changeColor() {
      color[0].getRenderer(PanelRenderer.class).setBackgroundColor(new Color(red[0] / 255.f, green[0] / 255.f, blue[0] / 255.f, alpha[0] / 255.f));
      color[1].getRenderer(PanelRenderer.class).setBackgroundColor(new Color(red[1] / 255.f, green[1] / 255.f, blue[1] / 255.f, alpha[1] / 255.f));
      color[2].getRenderer(PanelRenderer.class).setBackgroundColor(new Color(red[2] / 255.f, green[2] / 255.f, blue[2] / 255.f, alpha[2] / 255.f));
      color[3].getRenderer(PanelRenderer.class).setBackgroundColor(new Color(red[3] / 255.f, green[3] / 255.f, blue[3] / 255.f, alpha[3] / 255.f));

    }

    private Slider getSlider(final String id) {
      return (Slider) screen.findNiftyControl(id, Slider.class);
    }
    
    private static void makeColorMapping() {
        for (int i = 0; i < 4; i++) {
            colorMap[i][0] = red[i];
            colorMap[i][1] = green[i];
            colorMap[i][2] = blue[i];
            colorMap[i][3] = alpha[i];
        }
    }
    
    public static float [][] getColorMapping(){
        makeColorMapping();
        return colorMap;
    }

}
