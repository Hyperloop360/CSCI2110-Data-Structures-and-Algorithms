 public class Ball {
    private double bx, by;

    //Constructor
    public Ball(double bx, double by) {
        this.bx = bx;
        this.by = by;
    }

    //Set Methods
    public void setBx(double bx) { this.bx = bx; }
    public void setBy(double by) { this.by = by; }

    //Get Methods
    public double getBx() { return bx; }
    public double getBy() { return by; }

    @Override
    public String toString(){
        return "[" + (String.format("%.3f", getBx())) + ", " + String.format("%.1f", getBy()) + "]";
    }

}
