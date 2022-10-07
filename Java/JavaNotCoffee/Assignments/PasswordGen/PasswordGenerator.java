import java.util.Scanner;
import java.util.Random;
public class PasswordGenerator {
    public static void main(String[] args) {
        int chars=0;
        int nums=0;
        int specialChars=0;
        Scanner ui = new Scanner(System.in);
        boolean requirements = false;
        while(!requirements) {
            System.out.println("How many characters do you want?: ");
            chars = ui.nextInt();
            System.out.println("How many numbers do you want?: ");
            nums = ui.nextInt();
            System.out.println("How many special characters do you want?: ");
            specialChars = ui.nextInt();

            if ((chars+nums+specialChars) > 8) {
                requirements = true;
            } 
            else {
                System.out.println("Password needs to be a atleast 8 characters long");
            }
        }

        boolean satisfied = false;
        while (!satisfied) {
            String password = genPassword(chars, nums, specialChars);
            System.out.println("Your new password is: " + password);
            System.out.println("Would you like to generate a new one? (y/n)");
            String choice = ui.next();
            if (choice.equals("n")) {
                satisfied = true;
            }
        }
    }

    public static String genPassword(int chars, int nums, int specialChars) {
        boolean goodPass = false;
        String out= "";
        while (!goodPass) {
            //https://stackoverflow.com/questions/3559063/how-to-enter-quotes-in-a-java-string
            String specialCharacters='';
            //https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java
            out= "";
            Random r = new Random();
            for(int i = 0; i < chars; i++) {
                if (r.nextInt(2) == 1) {
                    out += (char)(r.nextInt(26) + 'a');
                } else {
                    out += (char)(r.nextInt(26) + 'A');
                }
            }
            for(int i = 0; i < nums; i++) {
                out += (char)(r.nextInt(10) + 48);
            }

            for(int i = 0; i < specialChars; i++) {
                out += (specialCharacters.charAt(r.nextInt(specialCharacters.length() - 1)));
            }

            if(hasUppercase(out)) {
                goodPass = true;
            }
        }
        return out;
    }

    public static boolean hasUppercase(String pass) {
        for (int i =0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                //Passes requirement
                return true;
            }
        }
        return false;
    }
}

