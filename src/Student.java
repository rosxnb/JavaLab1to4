import java.util.Scanner;

public class Student
{
    private final int id;
    private final String name;
    private final String address;

    public Student(int id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "\n--------------- Student Information --------------\n" +
               "Student ID:      " + id + "\n" +
               "Student Name:    " + name + "\n" +
               "Student Address: " + address + "\n";
    }

    public static void main(String[] args)
    {
        var consoleReader = new Scanner(System.in);

        int id;
        String name;
        String address;

        System.out.print("Enter Student Id: ");
        id = consoleReader.nextInt();
        consoleReader.nextLine();

        System.out.print("Enter Student Name: ");
        name = consoleReader.nextLine();

        System.out.print("Enter Student Address: ");
        address = consoleReader.nextLine();

        var student = new Student(id, name, address);
        System.out.println(student);
    }
}
