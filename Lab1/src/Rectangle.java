/**
 * Antony Punnassery
 * B01012905
 */
public class Rectangle {
    private double xpos,ypos, width, height;

    public Rectangle(double xpos, double ypos, double width, double height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    public double getXpos() { return xpos; }
    public double getYpos() { return ypos; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public void setXpos(double xpos) { this.xpos = xpos; }
    public void setYpos(double ypos) { this.ypos = ypos; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public String toString() {
        return "(" + xpos + ", " + ypos + ", " + width + ", " + height + ")";
    }
}
