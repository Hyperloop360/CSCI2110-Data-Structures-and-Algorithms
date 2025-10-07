/**
 * Antony Punnassery
 * B01012905
 */
public class Main {
    public static void main(String[] args){

        Ball soccerBall;
        Field dalField;
        Player srini;

        System.out.println("SOCCER GAME SETUP!");
        srini = new Player("Srini");
        dalField = new Field(0.0, 0.0, 500.0, 400.0);
        soccerBall = new Ball(100.0, 200.0);

        System.out.println(srini + "\n" + dalField + "\n" + soccerBall);
        System.out.println("\n");
        srini.kick(dalField, soccerBall, 300.0, 45.0);
        System.out.println(srini + " kicks the ball for a distance of 300.0 pixels at 45.0 degrees");
        System.out.println(soccerBall);
        System.out.println("\n");
        srini.kick(dalField, soccerBall, 500.0, 0.0);
        System.out.println(srini + " kicks the ball for a distance of 500.0 pixels at 0.0 degrees");
        System.out.println(soccerBall);
        System.out.println("\n");
        srini.kick(dalField, soccerBall, 100.0, 270.0);
        System.out.println(srini + " kicks the ball for a distance of 100.0 pixels at 270.0 degrees");
        System.out.println(soccerBall);

        //Expected Result:
        /*
        SOCCER GAME SETUP!
        Player Srini
        Field: [x=0.0,y=0.0, w=500.0,h=400.0]
        Ball is at (100.0,200.0)

        Player Srini kicks the ball for a distance of 300.0 pixels at 45.0 degrees
        Ball is at (312.132,200.0)
        reflected = true

        Player Srini kicks the ball for a distance of 500.0 pixels at 0.0 degrees
        Ball is at (312.132,200.0)
        reflected = true

        Player Srini kicks the ball for a distance of 100.0 pixels at 270.0 degrees
        Ball is at (312.132,100.0)
        reflected = false
         */


    }
}

        /* Test for Field
        Field field1;
        field1 = new Field(20.0, 30.0, 50.0, 20.0);
        System.out.println(field1);*/


        /*  Test for Ball:
        Ball ball1;
        ball1 = new Ball();
        ball1.setBx(50.0);
        ball1.setBy(20.0);

        System.out.println(ball1);*/