import java.util.*;
public class GradeCal 
{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String studentName = obj.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = obj.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            double subjectMarks = obj.nextDouble();
            totalMarks += subjectMarks;
        }

        double averageMarks = totalMarks / numSubjects;

        System.out.println("Student Name: " + studentName);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);

        char grade = calculateGrade(averageMarks);
        System.out.println("Grade: " + grade);
    }

    private static char calculateGrade(double averageMarks) {
        if (averageMarks >= 90) {
            return 'A';
        } else if (averageMarks >= 80) {
            return 'B';
        } else if (averageMarks >= 70) {
            return 'C';
        } else if (averageMarks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
