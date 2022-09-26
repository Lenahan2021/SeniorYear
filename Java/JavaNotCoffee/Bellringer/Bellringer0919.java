import java.util.Scanner;

public class Bellringer0919 {
    public static void main(String[] args) {
           Scanner ui = new Scanner(System.in);
           System.out.println("Username: ");
           String user = ui.nextLine();
           System.out.println("Password: ");
           String pass = ui.nextLine();
           if (user.equals("admin") && pass.equals("admin")) {
                System.out.println("Welcome "+user);
           }
        }
    }