import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
            //https://www.w3schools.com/java/java_files_create.asp
            catch (Exception e) {
                System.err.println("Cannot open file for input!");
                System.out.println("Creating new file!");
                File createFile = new File(file);
                try {
                    createFile.createNewFile();
                    System.out.println("File created!");
                    in = new Scanner(new File(file));
                } catch (IOException t) {
                    System.out.println("Cannot create new file!");
                    t.printStackTrace();
                }
            }
        }
        //read in the values from the text file
        try {
            String s = "";
            if (in.hasNext()) {
                while (in.hasNext()) {
                    s  = s + in.nextLine() + "\n";
                }
                System.out.println(String.format(String.format("Read from file %s and had info", file)));
                return s;
            } else {
                System.out.println(String.format(String.format("Read from file %s but was empty", file)));
                return "";
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
                System.out.println(String.format("Wrote to file %s", file));
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

}
