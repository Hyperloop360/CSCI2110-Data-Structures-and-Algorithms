import java.util.Scanner;

public class PointTester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Integers
        int intX = sc.nextInt();
        int intY = sc.nextInt();
        Point<Integer> point1 = new Point<>(intX, intY);

        //Doubles
        double doubleX = sc.nextDouble();
        double doubleY = sc.nextDouble();
        Point<Double> point2 = new Point<>(doubleX, doubleY);

        //String
        String stringX = sc.next();
        String stringY = sc.next();
        Point<String> point3 = new Point<>(stringX, stringY);


        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}
