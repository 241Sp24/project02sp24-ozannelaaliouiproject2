package studentdriver;

public abstract class StudentFees {

    public String studentName;
    public int studentID;
    public boolean isEnrolled;
    int CREDITS_PER_COURSE = 3;
    double PER_CREDIT_FEE = 543.50;

    public StudentFees(String studentName, int studentID, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }

    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentID) {
        this.studentID = studentID;
    }

    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }
    public abstract double getPayableAmount();
    
    @Override
    public String toString(){
        return "Student name: " + this.studentName + "\nStudent id " + this.studentID + "\nEnrolled: " + this.isEnrolled;
        }

    
}
