import java.lang.Math;
import java.util.Random;
import java.util.random;

public class JavaMath {
    public static void main(String[] args) {
        // System.out.println(16/5);
        // System.out.println(160000000/5);
        // System.out.println(18.0/5);
        // System.out.println(18.0/5.0);
        // System.out.println(Long.MAX_VALUE);
        // System.out.println(Double.MAX_VALUE);
        // System.out.println(Integer.MAX_VALUE);

        // System.out.println(Math.pow(18, 5));

        // System.out.println(6*(2/1)/1);

        // System.out.println(Math.pow(18, 5)/(7/7/8));

        // System.out.print(9/2);
        // System.out.print(10/3);
        // System.out.print(9/10);

        // System.out.println(1367/2);
        // System.out.println(1367*0.5);

        // //GOOD RULE: Any calculations, include a double

        // System.out.println(1367*2);

        //Cant name variables same
        int age = 18;
        double ages = 17; 

        double year = 17; // data type object primitivae
        Double years = 17; //class type objet - non primitiave

        Integer agey = 17;
        //python increase by 1 use +=1
        //python increase by any nuber use += anynumber

        age++;
        age+=5;

        double randomness = Math.random();
        System.out.println(randomness);
        System.out.println(randomness*10);
        

        System.out.println((int)(randomness*10));

        Random rand = new Random();

        int randomInt = rand.nextInt(10);
        double randomDouble = rand.nextDouble();
        System.out.println(randomDouble);

    }
}
