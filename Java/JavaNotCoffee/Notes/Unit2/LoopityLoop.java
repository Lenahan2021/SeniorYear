import java.util.Scanner;

public class LoopityLoop {
    public static void main(String[] args) {
        //While conditional statement
        //while boolean expression
        // while(true) {
        //     System.out.println("Hi");
        // }
        //print out the numkbers 1 through 10

        // //while loops are recursive conditional statements
        // //keeps happening until a condition is met
        // if (i==9) {
        //     System.out.println(i);
        // }

        int i = 0;
        while(i<=9) {
            if (i!=9) {
                System.out.print(i+",");
            } else {
                System.out.print(i);
            }
            i++;
        }
        System.out.println();
        

        //print 0-9
        //for (some var; boolean expression; step)
        for (int j=0; j<=9; j++) {
            if (j!=9) {
                System.out.print(j+",");
            } else {
                System.out.print(j);
            }
            
        }
        //for i in range(s):
        //for item in list:

        minMaxChecker();
    }

    private static void minMaxChecker() {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        Scanner ui = new Scanner(System.in);
        int number = ui.nextInt();
        while (number != -1) {
            if (number > max) {
                max = number;
            }
            else if (number < min ) {
                min = number;
            }
            number = ui.nextInt();
        }
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);
    }
}