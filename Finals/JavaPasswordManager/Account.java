public class Account {
    String first;
    String last;
    String user;
    String pass;

    public void createAccount(String firstName, String lastName, String username, String password) {
        this.first = firstName;
        this.last = lastName;
        this.user = username;
        this.pass = password;
    }
}