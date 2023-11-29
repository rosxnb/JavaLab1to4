import java.util.Scanner;

public class UserInput
{
    private int num1;
    private int num2;

    public void takeInput()
    {
        Scanner consoleReader = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        num1 = consoleReader.nextInt();
        num2 = consoleReader.nextInt();
    }

    public void print_sum()
    {
        System.out.println("The sum " + num1 + " and " + num2 + " = " + (num1 + num2));
    }

    public static void main(String[] args)
    {
        var obj = new UserInput();
        obj.takeInput();
        obj.print_sum();
    }
}