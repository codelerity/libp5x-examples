/**
 * Noise Sphere 
 * by David Pena.  
 * 
 * Uniform random distribution on the surface of a sphere.
 *
 * Translated from the Processing example to Java with libp5x by Neil C Smith.
 */
package com.codelerity.libp5x.esfera;

import processing.core.PApplet;

public class Esfera extends PApplet {

    int cuantos = 16000;
    Pelo[] lista;
    float radio = 200;
    float rx = 0;
    float ry = 0;

    @Override
    public void settings() {
        size(1024, 768, P3D);
    }

    @Override
    public void setup() {
        radio = height / 3.5f;

        lista = new Pelo[cuantos];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new Pelo();
        }
        noiseDetail(3);
    }

    @Override
    public void draw() {
        background(0);
        fill(255);
        text(frameRate, 20, 20);

        float rxp = (mouseX - (width / 2)) * 0.005f;
        float ryp = (mouseY - (height / 2)) * 0.005f;
        rx = rx * 0.9f + rxp * 0.1f;
        ry = ry * 0.9f + ryp * 0.1f;

        translate(width / 2, height / 2);
        rotateY(rx);
        rotateX(ry);
        fill(0);
        noStroke();
        sphere(radio);

        for (int i = 0; i < lista.length; i++) {
            lista[i].dibujar();
        }

    }

    class Pelo {

        float z = random(-radio, radio);
        float phi = random(TWO_PI);
        float largo = random(1.15f, 1.2f);
        float theta = asin(z / radio);

        Pelo() { // what's wrong with a constructor here
            z = random(-radio, radio);
            phi = random(TWO_PI);
            largo = random(1.15f, 1.2f);
            theta = asin(z / radio);
        }

        void dibujar() {

            float off = (noise(millis() * 0.0005f, sin(phi)) - 0.5f) * 0.3f;
            float offb = (noise(millis() * 0.0007f, sin(z) * 0.01f) - 0.5f) * 0.3f;

            float thetaff = theta + off;
            float phff = phi + offb;
            float x = radio * cos(theta) * cos(phi);
            float y = radio * cos(theta) * sin(phi);
            float z = radio * sin(theta);

            float xo = radio * cos(thetaff) * cos(phff);
            float yo = radio * cos(thetaff) * sin(phff);
            float zo = radio * sin(thetaff);

            float xb = xo * largo;
            float yb = yo * largo;
            float zb = zo * largo;

            strokeWeight(1);
            beginShape(LINES);
            stroke(0);
            vertex(x, y, z);
            stroke(200, 150);
            vertex(xb, yb, zb);
            endShape();
        }
    }

    public static void main(final String[] args) {
        PApplet.main(new Esfera());
    }

}
