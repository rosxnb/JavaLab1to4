import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadFile
{
    public static void main(String[] args) throws IOException
    {
        final String filepath = "files/MyData.txt";

        try (Scanner fileInput = new Scanner(Path.of(filepath), StandardCharsets.UTF_8))
        {
            // Because we formatted data while storing it in file, we can simply print now
            System.out.println(fileInput.nextLine()); // print name
            System.out.println(fileInput.nextLine()); // print address
            System.out.println(fileInput.nextLine()); // print salary
        }
    }
}
