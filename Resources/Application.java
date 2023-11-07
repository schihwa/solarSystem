import java.util.ArrayList;

public class Application {
    private static double scale = 350.0 / 4500.0; // Scaling Neptune's distance to 350

    // Scaled diameter function
    private static double scaleSize(double actualSize) {
        // Define the maximum size on canvas for the largest planet and scale
        // accordingly
        double maxDiameterOnCanvas = 50.0; // Example size for Jupiter
        double scaleFactor = maxDiameterOnCanvas / 139820; // Actual diameter of Jupiter
        return actualSize * scaleFactor;
    }

    // Scaled distance function
    private static double scaleDistance(double actualDistance) {
        // Use the scale defined for the simulation
        return actualDistance * scale;
    }

    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem(800, 800);

        // Initialize the sun with an arbitrary size that looks good on the canvas
        Orbitable sun = new Orbitable(scaleSize(93926), "YELLOW", 0, 0, null, 0);

        // The scaleDistance call had two arguments, corrected it to use one
        Orbitable mercury = new Orbitable(scaleSize(4879), "DARK_GRAY", scaleDistance(58), 0, sun, 4.15);
        Orbitable venus = new Orbitable(scaleSize(12104), "YELLOW", scaleDistance(108), 0, sun, 1.62);
        Orbitable earth = new Orbitable(scaleSize(12742), "BLUE", scaleDistance(149), 0, sun, 1);
        Orbitable mars = new Orbitable(scaleSize(6779), "RED", scaleDistance(228), 0, sun, 4.53);
        Orbitable jupiter = new Orbitable(scaleSize(139820), "ORANGE", scaleDistance(778), 0, sun, 3.08);
        Orbitable saturn = new Orbitable(scaleSize(116460), "ORANGE", scaleDistance(1430), 0, sun, 2.034);
        Orbitable uranus = new Orbitable(scaleSize(50724), "LIGHT_BLUE", scaleDistance(2870), 0, sun, 2.012);
        Orbitable neptune = new Orbitable(scaleSize(49244), "BLUE", scaleDistance(4500), 0, sun, 2.006);

        // Corrected the scaling of moon distances by calling scaleDistance instead of
        // multiplying by scale directly
        Orbitable moon = new Orbitable(scaleSize(3475), "LIGHT_GRAY", scaleDistance(0.384), 0, earth, 13.1);
        Orbitable io = new Orbitable(scaleSize(3642), "YELLOW", scaleDistance(0.421), 0, jupiter, 1.77);
        Orbitable europa = new Orbitable(scaleSize(3122), "WHITE", scaleDistance(0.671), 0, jupiter, 3.55);
        Orbitable ganymede = new Orbitable(scaleSize(5268), "LIGHT_GRAY", scaleDistance(1.070), 0, jupiter, 7.15);
        Orbitable callisto = new Orbitable(scaleSize(4821), "DARK_GRAY", scaleDistance(1.882), 0, jupiter, 16.69);

        // Characteristics of the comet
        double diameterOfComet = 50000; // Comets are small in comparison, but this can be made larger for visibility in
                                     // the simulation
        String colorOfComet = "WHITE"; // Comets are often depicted as white due to their icy composition
        double orbitDistanceOfComet = 300; // This will be a relatively close orbit to the Sun for demonstration
                                           // purposes
        double orbitAngleOfComet = 0; // Initial angle in the orbit
        double orbitSpeedOfComet = 5.0; // Comets move faster as they get closer to the Sun, but this is a simplified
                                        // version

        // Create the Orbitable object for the comet with scaled values
        Orbitable comet = new Orbitable(
                scaleSize(diameterOfComet), // Scale the size of the comet for the simulation
                colorOfComet, // Color of the comet
                scaleDistance(orbitDistanceOfComet), // Scale the distance of the comet for the simulation
                orbitAngleOfComet, // Initial orbit angle for the comet
                sun, // The Sun as the parent orbitable
                orbitSpeedOfComet // Orbit speed of the comet
        );

        // Add planets and moons to the list
        ArrayList<Orbitable> CelestialBodies = new ArrayList<>();
        // Added sun to the list instead of drawing separately to streamline the loop
        CelestialBodies.add(comet);
        CelestialBodies.add(sun);
        CelestialBodies.add(mercury);
        CelestialBodies.add(venus);
        CelestialBodies.add(earth);
        CelestialBodies.add(mars);
        CelestialBodies.add(jupiter);
        CelestialBodies.add(saturn);
        CelestialBodies.add(uranus);
        CelestialBodies.add(neptune);
        CelestialBodies.add(moon); // Earth's Moon
        CelestialBodies.add(io);
        CelestialBodies.add(europa);
        CelestialBodies.add(ganymede);
        CelestialBodies.add(callisto);

        // Main simulation loop
        while (true) {
            // Update and draw each planet and moon
            for (Orbitable orbitable : CelestialBodies) {
                orbitable.updatePosition(solarSystem);
                orbitable.draw(solarSystem);
            }

            // Finish drawing and update the display
            solarSystem.finishedDrawing();

            // Control simulation speed
            try {
                Thread.sleep(50); // Adjust as necessary for your simulation speed
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
}
