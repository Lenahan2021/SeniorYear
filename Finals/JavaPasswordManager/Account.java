public class Account {
    public String first;
    public String last;
    public String user;
    public String pass;

    //Spencer
    //creating the constructor and assigning properties based on the account information
    public Account(String firstName, String lastName, String username, String password) {
        this.first = firstName;
        this.last = lastName;
        this.user = username;
        this.pass = password;
    }
}