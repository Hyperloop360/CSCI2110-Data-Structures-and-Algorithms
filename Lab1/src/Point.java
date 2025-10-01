public class Point {
    private double px, py;

    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }

    public double getX() {return px;}
    public double getY() {return py;}

    public void setX(double px) {this.px = px;}
    public void setY(double py) {this.py = py;}

    @Override
    public String toString() {
        return "(" + px + ", " + py + ")";
    }
}
