import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordManager {

    private static boolean loggedIn = false;
    private static int loginTries = 4;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static ArrayList<Category> categories = new ArrayList<Category>();


    public static void main(String[] args) {
        readAndCreateAccounts();
        while (!loggedIn) {
            if (loginTries >0) {
                loggedIn = login();
            } else {
                System.out.println("Shutting down");
                Utils.quitApp();
            }
        }
        Utils.clearConsole();
        System.out.println("You are now logged in!");
    }

    public static boolean login() {
        Utils.clearConsole();

        System.out.println(String.format("%s", accounts.size()));

        System.out.println("Welcome to Pass, please sign in to get started");
        System.out.println(String.format("You have %s login tries remaining.", loginTries));
        System.out.println("You can either (1) register, or if you have an existing account, (2) login or (3) quit");

        Scanner ui = new Scanner(System.in);

        String choice = ui.next();
        switch(choice) {
            case "1":
                Utils.clearConsole();
                System.out.println("Follow the instructions to create account");
                System.out.println("Please enter a first name");
                String first = ui.next();
                System.out.println("Please enter a last name");
                String last = ui.next();
                System.out.println("Please enter a username");
                String username = ui.next();
                System.out.println("Please enter a password");
                String password = ui.next();

                Account acc = new Account(first, last, username, password);
                accounts.add(acc);
                ui.close();
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
                            ui.close();
                            return true;
                        } else {
                            System.out.println("Incorrect Password");
                            loginTries--;
                            ui.close();
                            return false;
                        }
                    }
                }
                System.out.println("Username not in system.");
                loginTries--;
            case "3":
                System.out.println("You have logged out.");
                writeAccounts();
                ui.close();
                Utils.quitApp();
                return false;
            default:
                ui.close();
                return false;
        } 

    }

    public static void readAndCreateAccounts() {
        String accountsStr = Utils.readStringFromFile("accounts.txt");
        Utils.saveAndClose();

        String[] accountStrSplit = accountsStr.split("\n");

        for (int i = 0; i < accountStrSplit.length; i++) {
            String[] accountInfo = accountStrSplit[i].split(",");
            //gets rid of the whitepsace associated
            Account newAcc = new Account(accountInfo[0].trim(), accountInfo[1].trim(), accountInfo[2].trim(),accountInfo[3].trim());
            accounts.add(newAcc);
        }
    }

   public static void writeAccounts() {
        String s = "";

        for (int i = 0; i < accounts.size(); i++) {
            s = s + String.format("%s,%s,%s,%s\n", accounts.get(i).first, accounts.get(i).last, accounts.get(i).user, accounts.get(i).pass);
        }

        Utils.writeString(s, "accounts.txt");
        Utils.saveAndClose();
   }
}
