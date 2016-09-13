
package app;

public class HistoryInformation {
    private String action;
    private double amount;
    private String timeStamp;
    
    public HistoryInformation(String action, double amount, String timeStamp){
        this.action = action;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    //
    public String getAction() {
        return action;
    }


    public void setAction(String action) {
        this.action = action;
    }

   
    public double getAmount() {
        return amount;
    }

   
    public void setAmount(double amount) {
        this.amount = amount;
    }

   
    public String getTimeStamp() {
        return timeStamp;
    }

    
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
