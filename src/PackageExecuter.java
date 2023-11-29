import MyPackage.Jokes;
import java.util.Scanner;

public class PackageExecuter
{
    public static void main(String[] args)
    {
        Jokes jokeFactory = new Jokes();
        Scanner scanner = new Scanner(System.in);

        int input;
        do
        {
            String joke = jokeFactory.getJoke();
            System.out.println("\t ***************************************** \n" + joke + "\n\t *****************************************" );

            System.out.println("\n ----------------------------------------------------------------------------");
            System.out.println("Enter 1 to get joke and 0 to exit.");
            input = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while (input == 1);
    }
}
