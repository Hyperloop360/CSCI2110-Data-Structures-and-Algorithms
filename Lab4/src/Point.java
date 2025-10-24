public class Point<T>{

    private T xpos;
    private T ypos;

    public Point(T xpos, T ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public T getXpos(){
        return xpos;
    }
    public T getYpos(){
        return ypos;
    }
    public void setXpos(T xpos){
        this.xpos = xpos;
    }
    public void setYpos(T ypos){
        this.ypos = ypos;
    }

    @Override
    public String toString(){
        return "XPOS: " + xpos + " YPOS: " + ypos;
    }



}