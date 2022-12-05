import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

//Spencer
public class BufferWriter {

    //global variables
    private static final String DATA_FILE = "mymedia.txt";
    private static Scanner in;
    private static BufferedWriter out;

    //Spencer
    //writing string to a text file
    public static void writeString(String s) {

        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(DATA_FILE));
    
            } catch (Exception e) {
                System.err.println("Cannot open file for output!");
                e.printStackTrace();    //Very useful -> prints out the error
            }   
        }
            try {
                out.write(s);
                out.newLine();
            } catch(Exception e ) {
                System.err.println("Cannot write file!");
                e.printStackTrace();
            }
        
    } 

    //Spencer
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

    //Spencer
    public static String readString(String file) {
        //check to see if in  is already there, if not create it
        if (in==null) {
            try {
                in = new Scanner(new File(DATA_FILE));
            }
            catch (Exception e) {
                System.err.println("Cannot open file for input!");
                e.printStackTrace();
            }
        }

        //read in the values from the text file
        try {
            //if there is a new line, read it in
            if (in.hasNext()) {
                String s = in.nextLine();
                return s;                       //grabs everything
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
}
