package app;

import java.io.Serializable;


public class Account implements Serializable {
	private double balance = 0;	
	private int accountNumber;
	private static int numberOfAccounts = 10000000;
        private String username;
        private String password;
	
        //
	public Account(){
		this.accountNumber = numberOfAccounts++;
	}
        
        public Account(double balance, int acc){
		this.accountNumber = acc;
                this.balance = balance;
	}
        
        public Account(double balance, int acc, String username, String password){
		this.accountNumber = acc;
                this.balance = balance;
                this.username = username;
                this.password = password;
	}
        
        public String getUsername(){
            return this.username;
        }
        
        public String getPassword(){
            return this.password;
        }

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void withdraw(double amount){
		if(amount > this.balance){
			System.out.println("You have insufficient funds.");
			return;
		}
		this.balance -= amount + 5;
		
		System.out.println("You have withdrawn $" + amount + " and incurred a fee of $5.");
		System.out.println("You now have a balance of: " + this.balance);
	}
	
	public void deposit(double amount){
		if(amount <= 0){
			System.out.println("Please enter a positive amount");
			return;
		}
		
		this.balance += amount;
		
		System.out.println("You have deposited $" + amount + " with an interest rate of ");
		System.out.println("You now have a balance of: " + this.balance);
	}
	
	
	
	
	

}
