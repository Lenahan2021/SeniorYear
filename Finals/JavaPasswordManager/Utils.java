import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Utils {

    private static Scanner in;
    private static BufferedWriter out;

    //https://stackoverflow.com/questions/2979383/how-to-clear-the-console
    public final static void clearConsole()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }


    //Modified the statement a little bit to read in multiple lines at once for a string
    public static String readStringFromFile(String file) {
        
        //check to see if in  is already there, if not create it
        if (in==null) {
            try {
                in = new Scanner(new File(file));
            }
            catch (Exception e) {
                System.err.println("Cannot open file for input!");
                e.printStackTrace();
            }
        }

        //read in the values from the text file
        try {
            String s = "";
            if (in.hasNext()) {
                while (in.hasNext()) {
                    s  = s + in.nextLine() + "\n";
                }
                return s;
            } else {
                return null;
            }
        }

        catch(Exception e ) {
            System.err.println("Cannot read the file!");
            e.printStackTrace();
        }

        return null;
    }

    public static void writeString(String s, String file) {

        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(file, false));
    
            } catch (Exception e) {
                System.err.println("Cannot open file for output!");
                e.printStackTrace();    //Very useful -> prints out the error
            }   
        }
            try {
                out.write(s);
            } catch(Exception e ) {
                System.err.println("Cannot write file!");
                e.printStackTrace();
            }
        
    }

    public static void saveAndClose() {
        //closes after the Scanner is done reading the file

        if (in!=null) {
            try {
                in.close();
                in=null;    //reset the object -> to be used again later
            }
            catch (Exception e) {
                System.out.println("Cannot close input file!");
                e.printStackTrace();
            }
        }
        //close
        if (out!=null) {
            try {
                out.close();
                out=null;    //reset the object -> to be used again later
            }
            catch (Exception e) {
                System.out.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
        //technically you need both for the file to be saved and closed
    }

    public static void quitApp() {
        System.exit(0);
    }
}
