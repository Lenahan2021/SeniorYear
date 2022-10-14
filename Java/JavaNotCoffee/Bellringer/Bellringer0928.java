import java.util.Scanner;

public class Bellringer0928 {
    public static void main(String[] args) {
        gpaCalculator();
    }

    public static void gpaCalculator() {
        double[] grades = {0,0,0,0,0};
        int gradeAmount = 5;
        Scanner ui = new Scanner(System.in);
        for (int i = 0; i < gradeAmount; i++) {
            System.out.printf("Please enter your percentage for class %d: ", i+1);
            grades[i] = ui.nextDouble();
        }

        double total = addArray(grades);

        System.out.print((total/grades.length)/25);
    }

    public static void printArray(double[] grades) {
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i]+",");
        }
    }

    public static double addArray(double[] grades) {
        double total = 0;
        for (int i = 0; i < grades.length; i++) {
            total += grades[i];
        }
        return total;
    }
}