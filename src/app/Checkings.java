package app;


public class Checkings extends Account {
	private static String accountType = "Checking";
	
	public Checkings(double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		
	}
	
	public String toString(){
		return "Account Type: " + accountType + " Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n";
				
	}


}