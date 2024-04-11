package studentdriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner Myscanner = new Scanner(System.in);
        System.out.println("Enter no of UG students : ");
        int UGStudents = Myscanner.nextInt();
        System.out.println("Enter the no of Graduate students: ");
        int GSStudents = Myscanner.nextInt();
        System.out.println("Enter the no of online students: ");
        int OSStudents = Myscanner.nextInt();

        StudentFees[] students = new StudentFees[12];

        File inputfile = new File("input.csv");
        Scanner input = new Scanner(inputfile);
        int x = 0;

        while (input.hasNextLine()) {
            String[] strings = input.nextLine().split(",");

            if (x < 5) {
                int id = Integer.parseInt(strings[0]);
                String name = strings[1];
                boolean enrolled = Boolean.parseBoolean(strings[2]);
                int courseenrolled = Integer.parseInt(strings[3]);
                boolean HasScolarship = Boolean.parseBoolean(strings[4]);
                double Amount = Double.parseDouble(strings[5]);

                students[x] = new UGStudent(name, id, enrolled, HasScolarship, Amount, courseenrolled);
                x++;
            } else if (x < 9) {
                if (Boolean.parseBoolean(strings[4]) == true) {
                    int studentid = Integer.parseInt(strings[0]);
                    String studentname = strings[1];
                    boolean isstudentenrolled = Boolean.parseBoolean(strings[2]);
                    boolean isstudentGraduateAssistant = Boolean.parseBoolean(strings[4]);
                    String graduateType = strings[5];
                    int coursesenrolled = Integer.parseInt(strings[3]);

                    students[x] = new GraduateStudent(studentname, studentid, isstudentenrolled,
                            isstudentGraduateAssistant, graduateType, coursesenrolled);
                    x++;

                } else if (Boolean.parseBoolean(strings[4]) == false) {
                    int studentid = Integer.parseInt(strings[0]);
                    String studentname = strings[1];
                    boolean isstudentenrolled = Boolean.parseBoolean(strings[2]);
                    boolean isstudentGraduateAssistant = Boolean.parseBoolean(strings[4]);
                    int coursesenrolled = Integer.parseInt(strings[3]);

                    students[x] = new GraduateStudent(studentname, studentid, isstudentenrolled,
                            isstudentGraduateAssistant, coursesenrolled);
                    x++;
                }
            } else {
                int idofstudent = Integer.parseInt(strings[0]);
                String studentname = strings[1];
                boolean isthestudentenrolled = Boolean.parseBoolean(strings[2]);
                int numberofmonths = Integer.parseInt(strings[3]);

                students[x] = new OnlineStudent(studentname, idofstudent, isthestudentenrolled, numberofmonths);
                x++;
            }
        }
        input.close();

        // Calculate and display details
        double totalUGFee = 0;
        int scholarshipCount = 0;
        int totalUGCourses = 0;
        double totalGradFee = 0;
        int gradAssistantCount = 0;
        int totalGraduateCourses = 0;
        double totalOnlineFee = 0;

        for (StudentFees student : students) {
            if (student instanceof UGStudent && student.isEnrolled()) {
                UGStudent ugStudent = (UGStudent) student;
                totalUGFee += ugStudent.getPayableAmount();
                if (ugStudent.isHasScholarship()) {
                    scholarshipCount++;
                }
                totalUGCourses += ugStudent.getCoursesEnrolled();
            } else if (student instanceof GraduateStudent && student.isEnrolled()) {
                GraduateStudent gradStudent = (GraduateStudent) student;
                totalGradFee += gradStudent.getPayableAmount();
                if (gradStudent.isIsGraduateAssistant()) {
                    gradAssistantCount++;
                }
                totalGraduateCourses += gradStudent.getCoursesEnrolled();
            } else if (student instanceof OnlineStudent && student.isEnrolled()) {
                OnlineStudent onlineStudent = (OnlineStudent) student;
                totalOnlineFee += onlineStudent.getPayableAmount();
            }
        }

        // Calculate averages
        double avgUGFee = totalUGFee / UGStudents;
        double avgGradFee = totalGradFee / GSStudents;
        double avgOnlineFee = totalOnlineFee / OSStudents;

        // Output the details
        System.out.println("**********Undergraduate students list**********");
        int ugStudentCount = 0;
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent ugStudent = (UGStudent) student;
                if (ugStudent.isEnrolled()) {
                    ugStudentCount++;
                    System.out.println("Student name: " + ugStudent.getStudentName());
                    System.out.println("Student id: " + ugStudent.getStudentID());
                    System.out.println("Enrolled: " + ugStudent.isEnrolled());
                    System.out.println("Scholarship: " + ugStudent.isHasScholarship());
                    if (ugStudent.isHasScholarship()) {
                        System.out.println("Scholarship amount: " + ugStudent.getScholarshipAmount());
                    }
                    System.out.println("Courses enrolled: " + ugStudent.getCoursesEnrolled());
                    System.out.println("Payable amount: " + ugStudent.getPayableAmount());
                    System.out.println();
                }
            }
        }

        System.out.println("**********Graduate students list**********");
        int gradStudentCount = 0;
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent gradStudent = (GraduateStudent) student;
                if (gradStudent.isEnrolled()) {
                    gradStudentCount++;
                    System.out.println("Student name: " + gradStudent.getStudentName());
                    System.out.println("Student id: " + gradStudent.getStudentID());
                    System.out.println("Enrolled: " + gradStudent.isEnrolled());
                    System.out.println("Graduate assistant: " + gradStudent.isIsGraduateAssistant());
                    if (gradStudent.isIsGraduateAssistant()) {
                        System.out.println("Graduate assistant type: " + gradStudent.getGraduateAssistantType());
                    }
                    System.out.println("Courses enrolled: " + gradStudent.getCoursesEnrolled());
                    System.out.println("Payable amount: " + gradStudent.getPayableAmount());
                    System.out.println();
                }
            }
        }

        System.out.println("**********Online students list**********");
        int onlineStudentCount = 0;
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                OnlineStudent onlineStudent = (OnlineStudent) student;
                if (onlineStudent.isEnrolled()) {
                    onlineStudentCount++;
                    System.out.println("Student name: " + onlineStudent.getStudentName());
                    System.out.println("Student id: " + onlineStudent.getStudentID());
                    System.out.println("Enrolled: " + onlineStudent.isEnrolled());
                    System.out.println("No of months: " + onlineStudent.getNoOfMonths());
                    System.out.println("Payable amount: " + onlineStudent.getPayableAmount());
                    System.out.println();
                }
            }
        }

        // Output the details
        System.out.println("**********Undergraduate Students details**********");
        System.out.println("Average Students fee: " + avgUGFee);
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + totalUGCourses);

        System.out.println("**********Graduate Students details**********");
        System.out.println("Average Students fee: " + avgGradFee);
        System.out.println("Graduate Assistantship count: " + gradAssistantCount);
        System.out.println("Total number of courses: " + totalGraduateCourses);

        System.out.println("**********Online Students details**********");
        System.out.println("Average Students fee: " + avgOnlineFee);
    }
}
