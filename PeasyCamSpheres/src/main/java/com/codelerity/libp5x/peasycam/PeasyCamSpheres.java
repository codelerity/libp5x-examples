/*
 * PeasyCam example by Neil C Smith.
 *
 * Click and drag to rotate, scroll to zoom.
 */
package com.codelerity.libp5x.peasycam;

import processing.core.PApplet;
import peasy.PeasyCam;

public class PeasyCamSpheres extends PApplet {

    PeasyCam cam;
    
    @Override
    public void settings() {
        size(1024, 768, P3D);
    }

    @Override
    public void setup() {
        cam = new PeasyCam(this, width/2);
    }

    @Override
    public void draw() {
        background(24);
        stroke(0);
        strokeWeight(0.5f);
        
        var radius = height / 6;
        var distance = height / 5;
        
        lights();
        
        sphereDetail((int)(abs(cos(millis() * 0.001f)) * 36));
        pushMatrix();
        translate(-distance, 0, 0);
        fill(0,96,0);
        sphere(radius);
        popMatrix();
        
        sphereDetail((int)(abs(sin(millis() * 0.001f)) * 24));
        pushMatrix();
        translate(distance, 0, 0);
        rotateX(PI/2);
        fill(255, 60, 120);
        sphere(radius);
        popMatrix();
    }

    public static void main(final String[] args) {
        PApplet.main(new PeasyCamSpheres());
    }

}
