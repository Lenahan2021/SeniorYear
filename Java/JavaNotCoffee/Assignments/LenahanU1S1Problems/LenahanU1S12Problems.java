import java.util.Scanner;

public class LenahanU1S12Problems {
    public static void main(String[] args) {
        triangleArea();
        midPointTable();
        minuteYearConverter();
        triangleVolume();
    }

    private static void triangleArea() {
        Scanner ui = new Scanner(System.in);

        System.out.println("Enter the data");
        String set = ui.nextLine();
        String[] setList = set.split(" ");

        System.out.println(setList.length);

        double[] setDoubles = new double[setList.length];

        for (int i = 0; i < setDoubles.length; i++) {
            setDoubles[i] = Double.parseDouble(setList[i]);
        }

        double side1 = getDistance(setDoubles[0], setDoubles[1], setDoubles[2], setDoubles[3]);

        double side2 = getDistance( setDoubles[2], setDoubles[3],  setDoubles[4], setDoubles[5]);

        double side3 = getDistance(setDoubles[4], setDoubles[5], setDoubles[0], setDoubles[1]);

        double s = (side1 + side2 + side3)/2;

        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));

        //Rounding
        //https://www.baeldung.com/java-round-decimal-number
        double scale = Math.pow(10, 2);
        System.out.println("The area of the triangle is" + (Math.round(area*scale)/scale));
    }

    private static double getDistance(double x1,double y1, double x2,double y2) {
        double side = Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2);
        return Math.sqrt(side);
    }

    private static void midPointTable() {
        double[] aX = {0,1,2,3,4};

        double[] aY = {0,4,7,9,11};

        double[] bX = {2,4,6,10,12};

        double[] bY = {1,2,3,5,7};


        System.out.println("\t a \t \t \t b \t \t    Middle Point");
        for (int i = 0; i < aX.length; i++) {
            //System.out.println(String.format("(%f, %f) \t (%f, %f) \t (%f, %f)", aX[i], aY[i], bX[i], bY[i], (bX[i]+aX[i])/2, (bY[i]+aY[i])/2));
            System.out.printf("(%f, %f) \t (%f, %f) \t (%f, %f)\n", aX[i], aY[i], bX[i], bY[i], (bX[i]+aX[i])/2, (bY[i]+aY[i])/2);

        }

    }

    private static void minuteYearConverter() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter number of minutes");
        int minutes = ui.nextInt();

        int yearMinutes = 525600;
        int dayMinutes = 1440;

        int years = minutes/yearMinutes;

        int days = (minutes-(years*yearMinutes))/dayMinutes;

        System.out.println(minutes+" minutes is approximately " + years +" years and " + days + " days");

    }

    private static void triangleVolume() {
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter length of the side of the equilateral triangle");
        double length = ui.nextDouble();

        double area = ((Math.sqrt(3))/4) * Math.pow(length, 2);
        double volume = area * length;

        System.out.println("The area is " + area);
        System.out.println("The volume of the Triangle prism is " + volume);
    }
}