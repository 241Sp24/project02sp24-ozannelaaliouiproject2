package studentdriver;

public class GraduateStudent extends StudentFees {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    //Must add assitanceship calculation
    //public double getPayableAmount(){
    //    return (((coursesEnrolled * CREDITS_PER_COURSE) * PER_CREDIT_FEE) + ADDITIONAL_FEES);
    //}
    //@Override
    //public String toString(){
    //    return ;}
}
