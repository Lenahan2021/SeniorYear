import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordManager {

    private static boolean loggedIn = false;
    private static Account loggedInAccount;
    private static int loginTries = 4;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static ArrayList<Category> categories = new ArrayList<Category>();


    public static void main(String[] args) {
        readAndCreateAccounts();
        while (!loggedIn) {
            if (loginTries > 0) {
                loggedIn = login();
                
            } else {
                System.out.println("Shutting down");
                quitApp();
            }
        }
        Utils.clearConsole();
        System.out.println("You are now logged in!");
        readAndCreateDatabase();
        categories.get(0).entries.add(new Entry("Keepass", "user", "Pass", "cat"));
        while(loggedIn) {
            mainMenu();
        }
        quitApp();
    }

    public static boolean login() {
        Utils.clearConsole();

        System.out.println(String.format("%s", accounts.size()));

        System.out.println("Welcome to Password Manager, please sign in to get started");
        System.out.println(String.format("You have %s login tries remaining.", loginTries));
        System.out.println("You can either (1) register, or if you have an existing account, (2) login or (3) quit");

        Scanner ui = new Scanner(System.in);

        String choice = ui.next();
        switch(choice) {
            case "1":
            Utils.clearConsole();
            System.out.println("Follow the instructions to create account\n");
            System.out.println("Please enter a first name");
            String first = ui.next();
            System.out.println("Please enter a last name");
            String last = ui.next();
            String username = "";
            System.out.println("Please enter a username");
            username = ui.next();
            while (!checkUsername(username)) {
                System.out.println("Please enter a username");
                username = ui.next();
            }
            System.out.println("Please enter a password");
            String password = ui.next();
    
            Account acc = new Account(first, last, username, password);
            accounts.add(acc);
            return false;
            case "2":
                Utils.clearConsole();
                System.out.println("Please enter account username");
                username = ui.next();
                System.out.println("Please enter account password");
                password = ui.next();

                for (int i =0; i < accounts.size(); i++) {
                    if (accounts.get(i).user.equals(username)) {
                        if (accounts.get(i).pass.equals(password)) {
                            loggedInAccount = accounts.get(i);
                            return true;
                        } else {
                            System.out.println("Incorrect Password");
                            loginTries--;
                            return false;
                        }
                    }
                }
                System.out.println("Username not in system.");
                loginTries--;
                return false;
            case "3":
                System.out.println("You have logged out.");
                quitApp();
            default:
                return false;
        } 

    }

    public static void mainMenu() {
        int selectedCat = 0;
        System.out.println(String.format("Welcome %s %s.", loggedInAccount.first, loggedInAccount.last));
        System.out.println("Please select one of your categories to view the entries.");
        for (int i =0; i < categories.size(); i++) {
            System.out.println(String.format("%s. %s",  i+1, categories.get(i).name));
        }
        System.out.println(String.format("%s. Log out", categories.size()+1));
        Scanner ui = new Scanner(System.in);
        System.out.print("Please select a category number: ");
        selectedCat = ui.nextInt();
        if (selectedCat < categories.size()+1) {
            displayCategory(selectedCat);
        } else if (selectedCat == categories.size()+1) {
            Utils.clearConsole();
            System.out.println("logging out!");
            loggedIn=false;
        }
            else {
                System.out.println("Invalid choice");
        }
    }

    public static void displayCategory(int selected) {
        Utils.clearConsole();
        System.out.println("Here are the following entries for the category: " + categories.get(selected-1).name);
        for (int i =0; i < categories.get(selected-1).entries.size(); i++) {
            System.out.println(String.format("%s. name: %s", i+1, categories.get(selected-1).entries.get(i).name));
            System.out.println(String.format("user: %s", categories.get(selected-1).entries.get(i).username));
            System.out.println(String.format("pass %s \n", categories.get(selected-1).entries.get(i).password));
        }

        Scanner ui = new Scanner(System.in);
        System.out.println("You can (1)add entry (2)delete entry or (3)go back");
        int choice = ui.nextInt();
        switch (choice) {
            case 1:
            Utils.clearConsole();
            System.out.println("Name of entry:");
            String entryName = ui.next();
            System.out.println("Username of entry:");
            String entryUser = ui.next();
            System.out.println("password of entry:");
            String entryPass = ui.next();
            categories.get(selected-1).entries.add(new Entry(entryName, entryUser, entryPass, categories.get(selected-1).name));
            System.out.println("Entry successfully added");
            break;
            case 2:
            Utils.clearConsole();
            System.out.println("name of entry to delete:");
            String delEntryName = ui.next();
            int indexOfEntryToRemove = findEntryIndexInCat(categories.get(selected-1), delEntryName);
            if (indexOfEntryToRemove > 0) {
                categories.get(selected-1).entries.remove(indexOfEntryToRemove);
            }
            break;
            case 3:
            break;
            default:
            System.out.println("Try again");
            break;
        }
    }

    private static int findEntryIndexInCat(Category cat,String name) {
        for (int i = 0; i< cat.entries.size(); i++) {
            if (name.equals(cat.entries.get(i).name)) {
                return cat.entries.indexOf(cat.entries.get(i));
            }
        }

        return -1;
    }

    public static void readAndCreateAccounts() {
        String accountsStr = Utils.readStringFromFile("accounts.txt");
        Utils.saveAndClose();

        if (!accountsStr.equals("")) {
            String[] accountStrSplit = accountsStr.split("\n");

            for (int i = 0; i < accountStrSplit.length; i++) {
                String[] accountInfo = accountStrSplit[i].split(",");
                //gets rid of the whitepsace associated
                Account newAcc = new Account(accountInfo[0].trim(), accountInfo[1].trim(), accountInfo[2].trim(),accountInfo[3].trim());
                accounts.add(newAcc);
            }
        }
        
    }

    private static void createCategories(String s) {
        String[] categoriesStr = s.split(",");
        for (int i =0; i<categoriesStr.length; i++) {
            Category cat = new Category(categoriesStr[i]);
            categories.add(cat);
        }
    }

    public static void readAndCreateDatabase() {
        String s;
        s = Utils.readStringFromFile(String.format("Database/%sCategory.txt", loggedInAccount.user));
        Utils.saveAndClose();
        s = s.trim().replace("\n", "");
        if (s.equals( "")) {
            s = Utils.readStringFromFile("Database/DefaultCategories.txt");
            Utils.saveAndClose();
            s = s.replace("\n", "");
            createCategories(s);
        } else {
            createCategories(s);
        }
    }

   public static void writeAccounts() {
        String s = "";
        System.out.println(String.format("Account size is: %s", accounts.size()));

        for (int i = 0; i < accounts.size(); i++) {
            s = s + String.format("%s,%s,%s,%s\n", accounts.get(i).first, accounts.get(i).last, accounts.get(i).user, accounts.get(i).pass);
        }

        Utils.writeString(s, "accounts.txt");
        Utils.saveAndClose();
   }

   public static void writeCategories() {
    String s = "";
    System.out.println(String.format("Category size is: %s", categories.size()));

    for (int i = 0; i < categories.size(); i++) {
        if (i < categories.size()-1) {
            s = s + String.format("%s,", categories.get(i).name);
        } else {
            s = s + String.format("%s", categories.get(i).name);
        }
        
    }
    System.out.println(s);

    Utils.writeString(s, String.format("Database/%sCategory.txt",loggedInAccount.user));
    Utils.saveAndClose();
}

   public static boolean checkUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (username.equals(accounts.get(i).user)) {
                System.out.println("Username already taken");
                return false;
            }
        }
        return true;
   }

   public static void quitApp() {
        writeAccounts();
        writeCategories();
        System.exit(0);
   }
}
