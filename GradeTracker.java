import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n============================");
            System.out.println(" STUDENT GRADE TRACKER ");
            System.out.println("============================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(name, marks));

                    System.out.println("Student Added Successfully!");

                    break;

                case 2:

                    if(students.size()==0) {

                        System.out.println("No Records Found");
                        break;
                    }

                    int total=0;
                    int highest=students.get(0).getMarks();
                    int lowest=students.get(0).getMarks();

                    System.out.println("\n===== REPORT =====");

                    for(Student s : students) {

                        System.out.println(
                        "Name : "+s.getName()
                        +" Marks : "+s.getMarks());

                        total += s.getMarks();

                        if(s.getMarks()>highest)
                            highest=s.getMarks();

                        if(s.getMarks()<lowest)
                            lowest=s.getMarks();
                    }

                    double average=
                    (double)total/students.size();

                    System.out.println("\nAverage = "+average);
                    System.out.println("Highest = "+highest);
                    System.out.println("Lowest = "+lowest);

                    break;

                case 3:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice!=3);

        sc.close();
    }
}
