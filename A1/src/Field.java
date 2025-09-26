public class Field {
    private double tlxpos, tlypos, width, height;

    public Field (double tlxpos, double tlypos, double width, double height){
        this.tlxpos = tlxpos;
        this.tlypos = tlypos;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString(){
        return "[" + tlxpos + ", " + tlypos + ", " + width + ", " + height + "]";
    }
}
