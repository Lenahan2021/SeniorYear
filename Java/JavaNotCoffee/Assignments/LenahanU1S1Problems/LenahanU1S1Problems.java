import java.util.Scanner;
import java.util.function.DoubleSupplier;
import java.lang.Math;

public class LenahanU1S1Problems {
    public static void main(String[] args) {
        // convertMiletoKM();
        // calculateEnergy();
        futureInvestments();
        //drivingCost();
    }

    public static void convertMiletoKM() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter miles");

        double miles = ui.nextDouble();
        System.out.println(miles+"miles is "+ miles*1.6+"kilometers");
    }

    public static void calculateEnergy() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Ente the amount of water in kilograms: ");
        float weight = ui.nextFloat();
        System.out.println("Enter the initial temperature: ");
        float init = ui.nextFloat();
        System.out.println("Enter the final termperature: ");
        float finalTemp = ui.nextFloat();
        System.out.println("The energy needed is "+ (weight * (finalTemp-init) * 4184));
    }

    //Broke
    public static void futureInvestments() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double amount = ui.nextDouble();
        System.out.println("Enter annual interest rate in percentage: ");
        double interest = ui.nextDouble()/100;
        System.out.println("Enter number of years: ");
        double years = ui.nextDouble();
        double futureInvestmentValue = (amount * Math.pow((1+(interest/12)), years*12));
        System.out.println("Future Value is" + futureInvestmentValue);
    }

    //Good
    public static void drivingCost() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter the driving distance: ");
        double distance = ui.nextDouble();
        System.out.println("Enter miles per gallon: ");
        double miles = ui.nextDouble();
        System.out.println("Enter price per gallon: ");
        double price = ui.nextDouble();
        System.out.println("The cost of driving is: $"+ ((distance/miles)*price));
    }
}