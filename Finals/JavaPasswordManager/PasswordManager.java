import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {

    private static boolean loggedIn = false;
    private static int loginTries = 4;
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {
        while (!loggedIn) {
            loggedIn = login();
        }

        
        System.out.println("You are now logged in!");
    }

    public static boolean login() {

        System.out.println("Welcome to Pass, please sign in to get started");
        System.out.println(String.format("You have %s login tries remaining.", loginTries));
        System.out.println("You can either (1) register, or if you have an existing account, (2) login");

        Scanner ui = new Scanner(System.in);

        String choice = ui.next();
        switch(choice) {
            case "1":
                Utils.clearConsole();
                System.out.println("Please enter a first name");
                String first = ui.next();
                System.out.println("Please enter a last name");
                String last = ui.next();
                System.out.println("Please enter a username");
                String username = ui.next();
                System.out.println("Please enter a password");
                String password = ui.next();

                Account acc = new Account();
                acc.createAccount(first, last, username, password);
                accounts.add(acc);
                return false;
            case "2":
                Utils.clearConsole();
                System.out.println("Please enter account username");
                username = ui.next();
                System.out.println("Please enter account password");
                password = ui.next().trim();

                for (int i =0; i < accounts.size(); i++) {
                    if (accounts.get(i).user.equals(username)) {
                        if (accounts.get(i).pass.equals(password)) {
                            return true;
                        } else {
                            System.out.println("Incorrect Password");
                            loginTries--;
                            return false;
                        }
                    }
                }
            default:
                return false;
        }
        
    }
        
}
