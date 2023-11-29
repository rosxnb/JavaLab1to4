import java.util.Scanner;

class UnAuthorizedException extends Exception
{
    public UnAuthorizedException(String message)
    {
        super(message);
    }
}

public class UserRoleChecker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user role: ");
        String userRole = scanner.nextLine();

        try
        {
            checkUserRole(userRole);
            System.out.println("User role is authorized.");
        }
        catch (UnAuthorizedException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void checkUserRole(String userRole) throws UnAuthorizedException
    {
        if (!userRole.equalsIgnoreCase("EMPLOYEE"))
        {
            throw new UnAuthorizedException(userRole + " is not authorized to have access");
        }
    }
}
