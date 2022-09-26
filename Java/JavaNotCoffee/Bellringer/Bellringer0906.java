import java.util.Scanner;

public class Bellringer0906 {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        System.out.println("What is your username: ");
        String un = ui.nextLine();

        System.out.println("What is your password?");
        String pw = ui.nextLine();

        System.out.println("Username: "+un);
        System.out.println("Password: "+pw);

        System.out.printf("Username: %s\nPassword: %s", un,pw);

    }
}