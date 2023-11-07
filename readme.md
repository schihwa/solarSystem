
# Solar System Simulation

This Java application provides a dynamic simulation of the Solar System. It employs scaling techniques to visually represent the size of planets and their respective distances from the Sun, adhering to a simplified model of orbital mechanics. The application also features the inclusion of a comet to demonstrate its orbit within the system.

## Features

- Proportionally scaled planetary distances and diameters.
- Orbital simulation of the Solar System's planets and major moons.
- Comet with illustrative orbital path included in the simulation.
- Real-time animations depicting the motion of celestial bodies.
- Customizable simulation speeds for varied viewing experiences.

## Prerequisites

Ensure you have the following installed:

- Java Development Kit (JDK) (Version 8 or higher recommended)

## Installation

To set up the simulation environment on your local machine, clone the repository 
## Running the Application

Compile the Java source files and execute the `Application` class by running the following commands:

```bash
javac Application.java
java Application```
```

## Simulation Details

Within the `Application` class, a simulation window is established which subsequently spawns instances of the `Orbitable` class. These instances are intended to represent the Sun, the eight planets, several moons, and a comet. The sizes and distances of these celestial objects are scaled to suit the simulation environment. 

Each `Orbitable` object is instantiated with properties that define its size, color, distance from its orbital focus (e.g., the Sun or a planet), initial position in its orbit, and orbital velocity.

## Usage

Upon execution of the `Application` class, the simulation commences. Celestial bodies will orbit at predefined velocities, which can be modulated by altering the delay in the main simulation loop (controlled by `Thread.sleep`).

## Adding a New Planet

To add a new planet to the simulation, follow these steps:

1. Define the planet's properties, such as actual size, color, actual distance from the Sun, initial orbit angle, and orbit speed.
2. Use the `scaleSize` and `scaleDistance` methods to scale the planet's size and distance for the simulation.
3. Instantiate a new `Orbitable` object with the scaled values.
4. Add the new `Orbitable` instance to the `CelestialBodies` ArrayList.
5. Re-compile and run the application to see the new planet in action.

Example of adding a fictional planet:

```java
// Assuming this is added inside the main method in Application.java

double fictionalPlanetSize = 10000; // Replace with actual size
String fictionalPlanetColor = "GREEN"; // Replace with desired color
double fictionalPlanetDistance = 5000; // Replace with actual distance
double fictionalPlanetOrbitSpeed = 1.5; // Replace with desired orbit speed

Orbitable fictionalPlanet = new Orbitable(
    scaleSize(fictionalPlanetSize),
    fictionalPlanetColor,
    scaleDistance(fictionalPlanetDistance),
    0, // Initial orbit angle
    sun, // Orbiting around the sun
    fictionalPlanetOrbitSpeed
);

CelestialBodies.add(fictionalPlanet);
```



Thank you for your interest in the Solar System Simulation!
