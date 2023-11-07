public abstract class CelestialBody {
    private final double diameter; // size
    private final String color; // colour of body

    public CelestialBody(double diameter, String color) {
        if (diameter <= 0) {
            throw new IllegalArgumentException("Diameter must be positive.");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }

        this.diameter = diameter;
        this.color = color;
    }

    public abstract void updatePosition(SolarSystem solarSystem);

    public abstract void draw(SolarSystem solarSystem);

    public double getDiameter() {
        return diameter;
    }

    public String getColor() {
        return color;
    }
}
