import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteFile
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        final String workingDirectory = System.getProperty("user.dir");
        final String filepath = "files/MyData.txt";

        System.out.print("Enter your Name: ");
        String name = consoleReader.readLine();

        System.out.print("Enter your Address: ");
        String address = consoleReader.readLine();

        System.out.print("Enter your Salary: ");
        double salary = Double.parseDouble(consoleReader.readLine());

        try (var outputFile = new PrintWriter(filepath, StandardCharsets.UTF_8))
        {
            outputFile.write("Name: ");
            outputFile.println(name);
            outputFile.write("Address: ");
            outputFile.println(address);
            outputFile.write("Salary: ");
            outputFile.println(salary);

            System.out.println("Writing to file: " + workingDirectory + " " + filepath + " was success.");
        }
    }
}
