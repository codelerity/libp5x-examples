# Examples for libp5x

[libp5x](https://github.com/praxis-live/libp5x/) is a modularized fork of [Processing](https://processing.org/)
used inside [PraxisLIVE](https://www.praxislive.org). Based on Processing v3.5.3, it fully supports Java 11+ and
the Java module system, and uses [LWJGL](https://www.lwjgl.org) for OpenGL rendering.

This repository contains a number of examples ported from Processing to Java, using libp5x. They all use the
Gradle build system. The `gradle.build` files may be used as templates for other projects.

## Contents

 - **Esfera**, by David Pena - a 3D noise sphere using the LWJGL renderer, ported from
   https://github.com/processing/processing-docs/tree/master/content/examples/Demos/Performance/Esfera
 - **Flocking**, by Daniel Shiffman - an implementation of a Boids program, using the Java2D renderer. Ported from
   https://github.com/processing/processing-docs/tree/master/content/examples/Topics/Simulate/Flocking
 - **PeasyCamSphere**, by Neil C Smith - simple example using the PeasyCam library, demonstrating how to add
   Processing libraries inside the `libs` folder. Drag or scroll with the mouse to control the camera.
 - **TextureCylinder** - load an image and render it on a cylinder and quad, demonstrating use of the `data` folder
   in the build. Ported from
   https://github.com/processing/processing-docs/tree/master/content/examples/Topics/Textures/TextureCylinder

## Running the examples

All the example projects require Java 11+. Open the projects in your IDE, or use `./gradlew run`. Building any of
the projects will create a distributable application using the Gradle application plugin.

Neil C Smith, [Codelerity Ltd.](https://www.codelerity.com)

