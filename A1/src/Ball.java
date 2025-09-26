public class Ball {
    private double bx, by;

    //Constructor
    public Ball() {}

    //Set Methods
    public void setBx(double bx) { this.bx = bx; }
    public void setBy(double by) { this.by = by; }

    //Get Methods
    public double getBx() { return bx; }
    public double getBy() { return by; }

    @Override
    public String toString(){
        return "[" + getBx() + ", " + getBy() + "]";
    }

}
