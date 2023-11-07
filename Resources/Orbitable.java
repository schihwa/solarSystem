public class Orbitable extends CelestialBody {
    protected double orbitDistance;
    protected double orbitAngle;
    protected final Orbitable parentOrbitable;
    protected double orbitSpeed;

    public Orbitable(double diameter, String color, double orbitDistance, double orbitAngle, Orbitable parentOrbitable,
            double orbitSpeed) {
        super(diameter, color);
        this.orbitDistance = orbitDistance;
        this.orbitAngle = orbitAngle;
        this.parentOrbitable = parentOrbitable;
        this.orbitSpeed = orbitSpeed;
    }


    public double getOrbitDistance() {
        return orbitDistance;
    }

    public double getOrbitAngle() {
        return orbitAngle;
    }

    public Orbitable getParentOrbitable() {
        return parentOrbitable;
    }

    @Override
    public void updatePosition(SolarSystem solarSystem) {
        this.orbitAngle += orbitSpeed; // Increase the orbit angle by the orbit speed
        this.orbitAngle %= 360; // Keep the angle within the range of 0-359 degrees
    }

    @Override
    public void draw(SolarSystem solarSystem) {
        // If the object orbits around another object, we calculate the relative
        // position based on the parent's position.
        if (parentOrbitable != null) {
            // Use drawSolarObjectAbout to draw this object around its parent orbitable.
            solarSystem.drawSolarObjectAbout(
                    orbitDistance + (parentOrbitable.getDiameter()/2), // distance from this object to the point about which it is orbiting
                    orbitAngle, // the angle (in degrees) that represents how far the object is around its orbit
                    getDiameter(), // the size of the object
                    getColor(), // the color of this object
                    parentOrbitable.getOrbitDistance(), // the distance of the parent object from its point of orbit (if
                                                        // it has one, otherwise this is the distance from the sun)
                    parentOrbitable.getOrbitAngle() // the angle of the parent object in its orbit (if it has one,
                                                    // otherwise this is the angle in its orbit around the sun)
            );
        } else {
            // If there's no parent, then this object is a central body (like the Sun) and
            // we just draw it at its own position.
            solarSystem.drawSolarObject(
                    orbitDistance, // this would be 0 for a central body like the Sun
                    orbitAngle, // this would be 0 for a central body like the Sun
                    getDiameter(),
                    getColor());
        }
    }

}
