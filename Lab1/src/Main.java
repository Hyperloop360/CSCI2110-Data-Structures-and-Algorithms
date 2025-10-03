import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Read in Circle:
        System.out.println("Enter circle center (x,y) and radius:");
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();
        double cr = sc.nextDouble();
        Circle c = new Circle(cx, cy, cr);


        // Read in Point:
        System.out.println("Enter a Point (x y)");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        Point p = new Point(x1, y1);


        //Read Rectangle:
        System.out.println("Enter rectangle (xpos ypos width height)");
        double xpos = sc.nextDouble();
        double ypos = sc.nextDouble();
        double width = sc.nextDouble();
        double height = sc.nextDouble();
        Rectangle r = new Rectangle(xpos,ypos,width,height);
        System.out.println();


        //Output:
        System.out.println("Circle[center=(" + c.getXpos() + ", " + c.getYpos() + "), radius=" + c.getRadius() + "]");
        System.out.println("Point " + p + " contained in circle? " + c.contains(p));
        System.out.println("Rectangle[xpos=" + r.getXpos() + ", ypos=" + r.getYpos() +
                ", width=" + r.getWidth() + ", height=" + r.getHeight() + "]");
        System.out.println("Rectangle contained in circle? " + c.contains(r));
        
    }
}