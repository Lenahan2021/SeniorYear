import Java.util.Scanner;
import java.util.Random;
import java.lang.Math;


public BasicMathQuiz {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        Random rand = new Random();
        int points = 0;
        //cast to int then get a random decimal * 100
        int num1 = (int)(Math.random()*100);
        int num2 = rand.nextInt(100)+1; //0-100
        double answer = 0.0;
        double input = 0.0;

        //loop the program 10 times
        for (int j =0; j < 10; j++) {
    //generate a math expression
            int signNumber = rand.nextInt(4);
            if (signNumber==0) {
                System.out.printf("What is %d / %d", num1,num2);
                answer = (double)num1/num2;
                input = ui.nextDouble;
            }
            else if (signNumber==1) {
                System.out.printf("What is %d * %d", num1,num2);
                answer = (double)num1*num2;
                input = ui.nextDouble;
            }
            else if (signNumber==2) {
                System.out.printf("What is %d + %d", num1,num2);
                answer = (double)num1+num2;
                input = ui.nextDouble;
            }
            else {
                System.out.printf("What is %d - %d", num1,num2);
                answer = (double)num1-num2;
                input = ui.nextDouble;
            }
            //check to see if the user answered the expression correctly
            if (input==answer) {
                System.out.println("Great job! That's correct!");
                points++;
            } else {
                System.out.printf("OOO so close, the answer is %f", answer);
            }
            
            //output their points
        }
        System.out,println("You scored " + points + "points.")
    }
}
