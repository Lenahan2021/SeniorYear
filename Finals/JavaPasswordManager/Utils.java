public class Utils {

    //https://stackoverflow.com/questions/2979383/how-to-clear-the-console
    public final static void clearConsole()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
