public class Circle {
    private double xpos, ypos, radius;

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
        double distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= radius * radius;
    }

}
