import java.util.Scanner;

public class StudentGrade{
    public static void main(String [] args){
        Scanner sc =new Scanner(System.in);
   System.out.println("Enter the nmber of subjects\n ");
    int numSubjects = sc.nextInt();
    int totalMarks=0;
    for(int i =1;i<=numSubjects;i++){
        System.out.println("Enter the marks of " + i + " Subjects (out of 100):");
        int marks = sc.nextInt();
         
      totalMarks += marks;  
    }
    double avgPercentage = (double) totalMarks / (numSubjects * 100) * 100;

char grade;
if (avgPercentage >= 90) {
    grade = 'A';
} else if (avgPercentage >= 80) {
    grade = 'B';
} else if (avgPercentage >= 70) {
    grade = 'C';
} else if (avgPercentage >= 60) {
    grade = 'D';
} else {
    grade = 'F';
}

System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
