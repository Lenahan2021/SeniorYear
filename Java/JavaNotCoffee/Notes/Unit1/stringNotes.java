public class stringNotes {
    public static void main(String[] args) {
        String name = 'bobs'; // literal assignment
        String name2 = new String("Bobs"); // class assignment or constructor

        int age = 0; //I is not capitalized
        String ages = "0";

        System.out.println(name+ages);
        System.out.printf("%s %s", name,ages);

        /*
         main metthods
         substring -return a section of String
         indexOf - return the index of a char in a string
         equals() - strings can't use ==
         length() - returns the length of the string
         */

         String email = "nate.adam@bobaboom.gov";
         String email2 = "nate.spencer@bobaboom.gov";



         //print out the username
        System.out.println(email);

        //length
        System.out.println(email.length());
         //where is the out sign
        System.out.println(email.substring(0,9));
        System.out.println(email.substring(0,email2.indexOf("@")));

        email2.indexOf("@");


    }
}
