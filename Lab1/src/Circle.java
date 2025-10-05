/**
 * Antony Punnassery
 * B01012905
 */
public class Circle {
    private double xpos, ypos, radius;
    private static final double EPSILON = 1e-8;

    public Circle(double xpos, double ypos, double radius) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public double getXpos() {return xpos;}
    public double getYpos() {return ypos;}
    public double getRadius() {return radius;}

    public void setCenter(double xpos, double ypos) { this.xpos = xpos; this.ypos = ypos; }
    public void setRadius(double radius) {this.radius = radius;}

    public boolean contains(Point p) {
        double dx = p.getX() - xpos;
        double dy = p.getY() - ypos;
        double distanceSquared = Math.sqrt(dx * dx + dy * dy);
        return distanceSquared <= radius * EPSILON;
    }

    public boolean contains(Rectangle r) {
        Point topLeft = new Point (r.getXpos (), r.getYpos ());
        Point topRight = new Point (r.getXpos () + r.getWidth (), r.getYpos ());
        Point bottomLeft = new Point (r.getXpos (), r.getYpos () + r.getHeight ());
        Point bottomRight = new Point (r.getXpos () + r.getWidth(), r.getYpos () + r.getHeight ());

        return contains(topLeft) && contains(topRight) && contains(bottomLeft) && contains(bottomRight);

    }

    // to string method
    public String toString() {
        return "Circle at (" + xpos + ", " + ypos + ") with radius " + radius;
    }

}
