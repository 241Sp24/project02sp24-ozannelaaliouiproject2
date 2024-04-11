package studentdriver;

public class GraduateStudent extends StudentFees {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super (studentName, studentID, isEnrolled);
        
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        super (studentName, studentID, isEnrolled);
        
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    
    public String getGraduateAssistantType() {
        return graduateAssistantType;
    }
    
    public double getPayableAmount() {
        if (isIsGraduateAssistant() == true) {
            if (graduateAssistantType.equals("full")) {
                return ADDITIONAL_FEES;
            } else if (graduateAssistantType.equals("half")){
                return (((coursesEnrolled * getCREDITS_PER_COURSE()) * getPER_CREDIT_FEE()) + ADDITIONAL_FEES) / 2;
            }
        }
        return ((coursesEnrolled * getCREDITS_PER_COURSE()) * getPER_CREDIT_FEE());
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nGraduate assistant: " + isIsGraduateAssistant() + "\nGraduate assistant type: " + graduateAssistantType + "\nCoursesEnrolled" + getCoursesEnrolled() + "\nPayable amount: " + getPayableAmount();
    }
        
               
                
            
}
