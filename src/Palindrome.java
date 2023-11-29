import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Palindrome implements AutoCloseable
{
    final String DirectoryPath;
    final PrintWriter PalindromeFile;
    final PrintWriter NonPalindromeFile;
    final Scanner ConsoleReader;

    public Palindrome() throws IOException
    {
        DirectoryPath = System.getProperty("user.dir");
        PalindromeFile = new PrintWriter(DirectoryPath + "/files/palindromes.txt", StandardCharsets.UTF_8);
        NonPalindromeFile = new PrintWriter(DirectoryPath + "/files/non-palindromes.txt", StandardCharsets.UTF_8);
        ConsoleReader = new Scanner(System.in);
        System.out.println(DirectoryPath);
    }

    private void write(PrintWriter printWriter, String number)
    {
        printWriter.println(number);
    }

    @Override
    public void close()
    {
        PalindromeFile.close();
        NonPalindromeFile.close();
        ConsoleReader.close();
    }

    public boolean isPalindrome(String s)
    {
        int len = s.length();
        for (int i = 0; i < len/2; ++i)
        {
            if (s.charAt(i) != s.charAt(len - i - 1))
            {
                return false;
            }
        }

        return true;
    }

    public void run()
    {
        String input;
        String str;
        boolean isPalin;

        System.out.print("\nEnter your text: ");
        str = ConsoleReader.nextLine();

        String[] tokens = str.split(" ");
        for (String token: tokens)
        {
            isPalin = isPalindrome(token);
            write(isPalin ? PalindromeFile : NonPalindromeFile, token);
        }
    }

    public static void main(String[] args) throws IOException
    {
        try (var palindrome = new Palindrome())
        {
            palindrome.run();
        }
    }
}
