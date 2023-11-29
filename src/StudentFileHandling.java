import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

record StudentInfo(int id, String name, String grade)
{

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

public class StudentFileHandling
{
    public static void main(String[] args)
    {
        // Input students from console
        List<StudentInfo> studentInfos = inputStudentsFromConsole();

        // Write students to file
        writeStudentsToFile(studentInfos);

        // Read students from file, sort, and display
        List<StudentInfo> sortedStudentInfos = readAndSortStudentsFromFile();
        displayStudents(sortedStudentInfos);
    }

    private static List<StudentInfo> inputStudentsFromConsole()
    {
        List<StudentInfo> studentInfos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++)
        {
            System.out.println("Enter details for Student " + i + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Grade: ");
            String grade = scanner.nextLine();

            StudentInfo studentInfo = new StudentInfo(id, name, grade);
            studentInfos.add(studentInfo);
        }

        return studentInfos;
    }

    private static void writeStudentsToFile(List<StudentInfo> studentInfos)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt")))
        {
            for (StudentInfo studentInfo : studentInfos)
                writer.println(studentInfo.id() + "," + studentInfo.name() + "," + studentInfo.grade());

            System.out.println("Students written to file successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static List<StudentInfo> readAndSortStudentsFromFile()
    {
        List<StudentInfo> studentInfos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String grade = parts[2];
                studentInfos.add(new StudentInfo(id, name, grade));
            }

            studentInfos.sort(Comparator.comparingInt(StudentInfo::id));
            System.out.println("Students read from file and sorted successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return studentInfos;
    }

    private static void displayStudents(List<StudentInfo> studentInfos)
    {
        System.out.println("Sorted Student Details:");
        for (StudentInfo studentInfo : studentInfos)
        {
            System.out.println(studentInfo);
        }
    }
}
