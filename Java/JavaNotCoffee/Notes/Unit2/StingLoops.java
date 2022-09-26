import java.lang.Math;
public class StingLoops {
    public static void main(String[] args) {
        //Examples of Loops utilize wth strings
        //Sequence Data -> Strings, Array, List, ArrayList

        //count the number of char in a String
        howMany("GIGGLING","G");

        //find and place all /s/s with a /s
        spaceReplacer("This sentence.  has.  double spaces.  !");

        //input banana and print out bnn
        removeVowels("banana");

        //brute force a password 
        passwordCrack("123456");
    }

    private static void howMany(String s, String v) {
        //Find and count v in s
        int count = 0;
        for (int i = 0; i<s.length(); i++) {
            //substring returns a portion of the string
            if (s.toUpperCase().substring(i, i+1).equals(v.toUpperCase())) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void spaceReplacer(String s) {
        String strin = s.replace("  ", " ");
        System.out.println(strin);
    }

    private static void removeVowels (String s) {
        //aeiou and sometimes y
        //make sure that 50% of the time, it removes y

        String vowels = "";
        if (Math.random() < 0.5) {
            vowels = "aeiou";
        } else {
            vowels = "aeiouy";
        }
        for (int i = 0; i < vowels.length(); i++) {
            s = s.replace(vowels.substring(i, i+1), "");
        }

        System.out.println(s);
    }

    //think about tweaking this so that you can incorporate letters...
    private static void passwordCrack(String p) {
        String guess="";
        int count = 0;

        while (!guess.equals(p)) {
            count++;
            guess = String.valueOf(count);
        }
        System.out.println("Found it!");
    }

}
