package edu.cwru.ebme380.sms;

import processing.core.PApplet;

/**
 * The main stage of the front-end program for interfacing with the electronic system.
 *
 * @since September 27, 2016
 * <br>
 * <br> <b><u>SICU Stress Measurement System</u></b>
 * <br> Project P04 | C380 Team A
 * <br> <i>
 * <br> Case Western Reserve University
 * <br> EBME 380: BME Design Experience
 * <br> Fall 2016 Semester
 * @author Theodore Frohlich <ttf10@case.edu>
 * @author Abigail Walker <amw138@case.edu>
 */
public class MainApp extends PApplet {
    
    public static void main(String[] args) {
        PApplet.main(new String[] {"--present", "edu.cwru.ebme380.sms.MainApp"});
    }
    
    @Override
    public void settings() {
        fullScreen();
        focused = true;  // unlike size(int, int), fullscreen() loses the focus
    }
    
    @Override
    public void setup() {
        background(0);
    }
    
    @Override
    public void draw() {
        stroke(0, 210, 0);
        fill(0, 159, 0);
        ellipse(width/2, height/2, 64,64);
    }
    
}
