package studentdriver;

public class UGStudent extends StudentFees {

    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    double ADDITIONAL_FEE = 820.70;

    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled) {
        super (studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        return ADDITIONAL_FEE + coursesEnrolled * 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\nScolarship: " + hasScholarship + "\nScolarship amount: " + scholarshipAmount + "\nCourses Registered: " + "\nPayable amount: " + getPayableAmount();
    }

    

    

   
}
