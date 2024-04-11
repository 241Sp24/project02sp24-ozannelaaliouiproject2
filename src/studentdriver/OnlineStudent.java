package studentdriver;

public class OnlineStudent extends StudentFees {
    
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
    
    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super (studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
        this.MONTHLY_FEE = MONTHLY_FEE;
    }
    
    @Override
    public double getPayableAmount() {
        return MONTHLY_FEE * getNoOfMonths();
    }
    
    /**
     * @return the noOfMonths
     */
    public int getNoOfMonths() {
        return noOfMonths;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nNo of months" + noOfMonths + "\nPayable amount: " + getPayableAmount();
        
}

   
}