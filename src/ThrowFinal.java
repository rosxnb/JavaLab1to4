import java.util.Scanner;

import static java.lang.System.exit;

public class ThrowFinal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int momAge, childAge;

        System.out.print("Enter age of mom: ");
        momAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter age of son: ");
        childAge = scanner.nextInt();
        scanner.nextLine();

        try
        {
            ThrowFinal.validateAge(momAge, childAge);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            exit(0);
        }
        finally
        {
            System.out.println("Inside the 'finally' clause.");
        }
    }

    public static void validateAge(int parentAge, int childAge)
            throws Exception
    {
        if (parentAge <= childAge) throw new Exception("Mom cannot be younger then her child, duh!");
    }
}
