public class EllipticalOrbitable extends Orbitable {
    private double eccentricity; // Eccentricity of the elliptical orbit
    private double semiMajorAxis; // Semi-major axis of the ellipse

    public EllipticalOrbitable(double diameter, String color, double semiMajorAxis, double orbitAngle,
                                Orbitable parentOrbitable, double orbitSpeed, double eccentricity) {
        super(diameter, color, semiMajorAxis, orbitAngle, parentOrbitable, orbitSpeed);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
    }

    // Override the draw method to account for the elliptical shape of the orbit
    @Override
    public void draw(SolarSystem solarSystem) {
        double currentDistance = calculateDistanceForEllipse(semiMajorAxis, eccentricity, orbitAngle);

        if (getParentOrbitable() != null) {
            // Draw the object in an elliptical orbit around its parent
            solarSystem.drawSolarObjectAbout(
                    currentDistance, orbitAngle, getDiameter(), getColor(),
                    getParentOrbitable().getOrbitDistance(), getParentOrbitable().getOrbitAngle());
        } else {
            // Draw the object in an elliptical orbit with the sun at one focus
            solarSystem.drawSolarObject(
                    currentDistance, orbitAngle, getDiameter(), getColor());
        }
    }

    // Helper method to calculate the distance from the focus of the ellipse based on the current angle
    private double calculateDistanceForEllipse(double semiMajorAxis, double eccentricity, double orbitAngle) {
        double radianAngle = Math.toRadians(orbitAngle);
        return (semiMajorAxis * (1 - eccentricity * eccentricity)) /
                (1 + eccentricity * Math.cos(radianAngle));
    }

    // Getters for semiMajorAxis and eccentricity
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }
}
