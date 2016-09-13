package app;

import java.io.Serializable;


public class Customer implements Serializable {
    private String firstName, lastName, ssn, accountType;
    private double balance;
    private int acc = 0;
    private Account account;

    public Customer(String firstName, String lastName, String ssn, Account account, String accountType) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.account = account;
            this.accountType = accountType;
    }
    
    public Customer(String firstName, String lastName, String ssn, int acc, double balance, String accountType) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.balance = balance;
            this.acc = acc;
            this.accountType = accountType;
    }

    public String basicInfo(){
            return "----------Customer Information----------\n" +
                            "First Name: " + this.getFirstName() + "\t" +
                            "Last Name: " + this.getLastName() + "\t" +
                            "SSN: " + this.getSsn() + "\t" ;
    }
	
	
    Account getAccount(){
            return account;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the acc
     */
    public int getAcc() {
        return acc;
    }
    
    public void setAcc() {
        this.acc++;
    }

}
