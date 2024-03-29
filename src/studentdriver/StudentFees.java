package studentdriver;

public abstract class StudentFees {

    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    int CREDITS_PER_COURSE = 3;
    double PER_CREDIT_FEE = 543.50;

    public StudentFees(String studentName, int studentID, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
    }

    public String GetStudentName() {
        return studentName;
    }

    public int GetStudentID() {
        return studentID;
    }

    public boolean isIsEnrolled() {
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

    // public double getPayableAmount(){
    //      return        ;}
    //@Override
    //public String toString(){
    //return 
}
