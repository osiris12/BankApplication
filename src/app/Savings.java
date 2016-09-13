package app;


public class Savings extends Account {
    private static String accountType = "Savings";


    public Savings(double initialDeposit){
            super();
            this.setBalance(initialDeposit);
         
    }

    public String toString(){
            return "Account Type: " + accountType + " Account\n" +
                            "Account Number: " + this.getAccountNumber() + "\n" +
                            "Balance: " + this.getBalance() + "\n" ;
                           // "Interest Rate: " + this.getInterests() + "%\n";
    }
}
