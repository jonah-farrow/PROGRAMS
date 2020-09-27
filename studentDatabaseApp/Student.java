import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;
    
    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();
    
        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - First Year\n2 - Second Year\n3 - Third Year\n4 - Fourth Year\nEnter student class level: ");
        this.gradeYear = in.nextLine();
        setStudentID();
    }

    // Generate an ID
    private void setStudentID(){
        // Grade Level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        // Get inside of a loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            
            if(!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse; 
            }
            else { break; }
        } while (1 != 0);
    }
    // View balance
    public void viewBalance(){
        System.out.println("Your balance is: £" + tuitionBalance);
    }
    // Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: £");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of £" + payment);
        viewBalance();
    }
    // Student Status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID + 
                "\nCourses Enrolled: " + courses + 
                "\nBalance: £" + tuitionBalance;
    }
}