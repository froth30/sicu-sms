/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

package edu.cwru.sicu_sms;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * The main stage of the front-end program for interfacing with the electronic system.
 *
 * @since September 27, 2016
 * @author Ted Frohlich <ttf10@case.edu>
 * @author Abby Walker <amw138@case.edu>
 */
public class Main extends PApplet {
    
    public static void main(String[] args) {
        PApplet.main(new String[] {"--present", "edu.cwru.sicu_sms.Main"});
    }
    
    @Override
    public void settings() {
        fullScreen();
        focused = true;  // unlike size(int, int), fullscreen() loses the focus
        smooth();
    }
    
    @Override
    public void setup() {
        background(0);
    }
    
    @Override
    public void draw() {
        // fade background
        fill(0, 20);
        rect(0, 0, width-1, height-1);
        
        // display project name
        PFont font = createFont("Colonna MT", 64, true);
        textFont(font);
        textAlign(CENTER);
        fill(0, 0, 180);
        text("SICU Stress Measurement System", width/2, height/2 - 200);
        
        // draw orbiter
        stroke(0, 0, 210);
        fill(0, 0, 159);
        int t = millis();
        float x = 50 * sin(t/200f);
        float y = 50 * cos(t/200f);
        ellipse(width/2 + x, height/2 - y, 20, 20);
    }
    
}
