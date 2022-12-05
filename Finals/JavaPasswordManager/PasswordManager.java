import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {

    private static boolean loggedIn = false;
    private static Account loggedInAccount;
    private static int loginTries = 4;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static ArrayList<Category> categories = new ArrayList<Category>();

    public static void main(String[] args) {
        readAndCreateAccounts();
        //while were not logged in, keep trying
        while (!loggedIn) {
            if (loginTries > 0) {
                loggedIn = login();
            } else {
                //if we run out of tries, close down
                System.out.println("Shutting down");
                quitApp();
            }
        }
        Utils.clearConsole();
        System.out.println("You are now logged in!");
        //create the database with the entries and categories read in based on what account is logged in to
        readAndCreateDatabase();
        categories.get(0).entries.add(new Entry("Keepass", "user", "Pass", "cat"));
        //once we log out, quit the app
        while(loggedIn) {
            mainMenu();
        }
        quitApp();
    }

    //Spencer
    public static boolean login() {
        Utils.clearConsole();

        System.out.println(String.format("%s", accounts.size()));

        System.out.println("Welcome to Password Manager, please sign in to get started");
        System.out.println(String.format("You have %s login tries remaining.", loginTries));
        System.out.println("You can either (1) register, or if you have an existing account, (2) login or (3) quit");

        Scanner ui = new Scanner(System.in);

        String choice = ui.next();
        switch(choice) {
            //register account
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
                //if the username is taken take another
                while (!checkUsername(username)) {
                    System.out.println("Please enter a username");
                    username = ui.next();
                }
                System.out.println("Please enter a password");
                String password = ui.next();
                
                //Finally add the account to the list of available accounts
                Account acc = new Account(first, last, username, password);
                accounts.add(acc);
                return false;
            //log in
            case "2":
                
                Utils.clearConsole();
                System.out.println("Please enter account username");
                username = ui.next();
                System.out.println("Please enter account password");
                password = ui.next();

                //if our login info matches up with an existing account, login.
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
            //shutdown
                System.out.println("You have logged out.");
                quitApp();
            default:
                return false;
        } 

    }

    //Spencer
    public static void mainMenu() {
        int selectedCat = 0;
        System.out.println(String.format("Welcome %s %s.", loggedInAccount.first, loggedInAccount.last));
        System.out.println("Please select one of your categories to view the entries.");
        //print out the categories
        for (int i =0; i < categories.size(); i++) {
            System.out.println(String.format("%s. %s",  i+1, categories.get(i).name));
        }
        //other options to choose from
        System.out.println(String.format("%s. Add category", categories.size()+1));
        System.out.println(String.format("%s. Delete Category", categories.size()+2));
        System.out.println(String.format("%s. Log out", categories.size()+3));
        Scanner ui = new Scanner(System.in);
        System.out.print("Please select a category number: ");
        selectedCat = ui.nextInt();
        //if we select a category, display the entries inside of it
        if (selectedCat < categories.size()+1) {
            displayCategory(selectedCat);
            
        } else 
        //adding category to categories list
        if (selectedCat == categories.size()+1) {
            Utils.clearConsole();
            System.out.println("What is the name of the category you would like to add?");
            String catName = ui.next();
            categories.add(new Category(catName));
        } else 
        //remove category from categories list if found
        if (selectedCat == categories.size()+2) {
            System.out.println("What is the name of the category to delete?");
            String catToDelete = ui.next();
            if (findIndexOfCat(catToDelete) >= 0) {
                categories.remove(findIndexOfCat(catToDelete));
            } else {
                System.out.println("Category not found to delete!");
            }

            //log out
        } else if (selectedCat == categories.size()+3) {
            Utils.clearConsole();
            System.out.println("logging out!");
            loggedIn=false;
        } else {
            //invalid choice
            System.out.println("Invalid choice");
        }
    }

    //Spencer
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
            //add entry
            case 1:
            Utils.clearConsole();
            System.out.println("Name of entry:");
            String entryName = ui.next();
            System.out.println("Username of entry:");
            String entryUser = ui.next();
            System.out.println("password of entry:");
            String entryPass = ui.next();
            //create new entry and add it to the selected category entry
            categories.get(selected-1).entries.add(new Entry(entryName, entryUser, entryPass, categories.get(selected-1).name));
            System.out.println("Entry successfully added");
            break;
            //delete entry
            case 2:
            Utils.clearConsole();
            System.out.println("name of entry to delete:");
            String delEntryName = ui.next();
            //find the index of the entry we want to delete in the selected category
            int indexOfEntryToRemove = findEntryIndexInCat(categories.get(selected-1), delEntryName);
            //means we found an entry to remove
            if (indexOfEntryToRemove >= 0) {
                categories.get(selected-1).entries.remove(indexOfEntryToRemove);
            } else {
                //Print out error if we can't find the entry
                System.out.println("Entry not found to delete");
            }
            break;
            case 3:
            break;
            default:
            //any other option and we try again
            System.out.println("Try again");
            break;
        }
    }

    //Spencer
    private static int findIndexOfCat(String name) {
        //if the name of the category we want to find is in the categories list, then return the index, else return -1
        for (int i = 0; i< categories.size(); i++) {
            if (name.equals(categories.get(i).name)) {
                return i;
            }
        }

        return -1;
    }

    //Spencer
    private static int findEntryIndexInCat(Category cat,String name) {
        //if the name of the entry  we want to find is in the entries list that is associated with the selected account, return the index, else return -1
        for (int i = 0; i< cat.entries.size(); i++) {
            if (name.equals(cat.entries.get(i).name)) {
                return cat.entries.indexOf(cat.entries.get(i));
            }
        }

        return -1;
    }

    //Spencer
    public static void readAndCreateAccounts() {
        //Read in the whole accounts file to a string
        String accountsStr = Utils.readStringFromFile("accounts.txt");
        Utils.saveAndClose();

        //if its empty, dont worry about it
        if (!accountsStr.equals("")) {
            //split the accounts up by new lines
            String[] accountStrSplit = accountsStr.split("\n");

            //for each account, split it by a ',' and gather the associated information together to create a new account object
            for (int i = 0; i < accountStrSplit.length; i++) {
                String[] accountInfo = accountStrSplit[i].split(",");
                //gets rid of the whitepsace associated
                Account newAcc = new Account(accountInfo[0].trim(), accountInfo[1].trim(), accountInfo[2].trim(),accountInfo[3].trim());
                //finally, add the account to the accounts list
                accounts.add(newAcc);
            }
        }
        
    }

    //Spencer
    private static void createCategories(String s) {
        //create category object and add to categories list
        String[] categoriesStr = s.split(",");
        for (int i =0; i<categoriesStr.length; i++) {
            Category cat = new Category(categoriesStr[i]);
            categories.add(cat);
        }
    }

    //Spencer
    public static void readAndCreateDatabase() {
        //read in the correct category file based on user
        String s;
        s = Utils.readStringFromFile(String.format("Database/%sCategory.txt", loggedInAccount.user));
        Utils.saveAndClose();

        //format it
        s = s.trim().replace("\n", "");

        //if the string is empty, then we can just load in the default cateogies
        if (s.equals( "")) {
            s = Utils.readStringFromFile("Database/DefaultCategories.txt");
            Utils.saveAndClose();
            s = s.replace("\n", "");
            createCategories(s);
        } else {
            //else, use the categories in the list
            createCategories(s);
        }
    }

    //Spencer
   public static void writeAccounts() {
        String s = "";

        //for each account, add the information to a string, seperating each account by a new line, and account info by a ','
        for (int i = 0; i < accounts.size(); i++) {
            s = s + String.format("%s,%s,%s,%s\n", accounts.get(i).first, accounts.get(i).last, accounts.get(i).user, accounts.get(i).pass);
        }

        //write to the file
        Utils.writeString(s, "accounts.txt");
        Utils.saveAndClose();
   }

   //Spencer
   public static void writeCategories() {
    String s = "";
    //System.out.println(String.format("Category size is: %s", categories.size()));

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

    //Spencer
   public static boolean checkUsername(String username) {
    //when creating a new account, if the username is already taken in the system, return false
        for (int i = 0; i < accounts.size(); i++) {
            if (username.equals(accounts.get(i).user)) {
                System.out.println("Username already taken");
                return false;
            }
        }
        return true;
   }

   //Spencer
   
   public static void quitApp() {
    //on shut down, write the accounts and categories, and entries, then exit the app
        writeAccounts();
        writeCategories();
        System.exit(0);
   }
}