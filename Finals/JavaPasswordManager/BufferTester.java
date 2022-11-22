

public class BufferTester {
    //Read in the file and print to the console
    public static void main(String[] args) {
        //write a file
        BufferWriter.writeString("Hello World!\n");
        BufferWriter.saveAndClose();
        //read in the file and print to the console
        System.out.println(BufferWriter.readString());   
    }
}