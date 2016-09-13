package app;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bank implements Serializable{
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Customer customer;
    
    public Bank(){
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "");
            st = con.createStatement();
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    
   
    //
    public void getArraylistDataFromDatabase(){
        try {
            String query = "SELECT * FROM customers";
            rs = st.executeQuery(query);
            System.out.println("Success");
            while(rs.next()){
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String ssn = rs.getString("social_security_number");
                int account_number = rs.getInt("account_number");
                double account_balance = rs.getDouble("account_balance");
                String account_type = rs.getString("account_type");
                Account account = new Account(account_balance, account_number );
                Customer customer = new Customer(first_name, last_name, ssn, account_number, account_balance, account_type);
                customers.add(customer);      
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public int checkNumberOfAccountss(){
        int totalNumber = 0;
        try {
            String query = "SELECT MAX(account_number) FROM customers";
            rs = st.executeQuery(query);
            System.out.println("Success");
            while(rs.next()){
                totalNumber = rs.getInt("MAX(account_number)");                     
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
        return totalNumber;
    }
    
     public void insertDatas(Customer customer, PersonalInformation info){
        PreparedStatement accountInfo = null;
        String accountInfoQuery = 
                "INSERT INTO customers(first_name, last_name, social_security_number, account_number, account_balance, account_type) VALUES(?, ?, ?, ?, ?, ?); ";   
        try{
            con.setAutoCommit(false);
            accountInfo = con.prepareStatement(accountInfoQuery);
            accountInfo.setString(1, customer.getFirstName());
            accountInfo.setString(2, customer.getLastName());
            accountInfo.setString(3, customer.getSsn());
            accountInfo.setInt(4, customer.getAcc());
            accountInfo.setDouble(5, customer.getBalance());
            accountInfo.setString(6, customer.getAccountType());
            accountInfo.executeUpdate();
            con.commit();
            System.out.println("Success");
        } catch(SQLException e){
            System.out.println(e);
        }
        
        PreparedStatement personalInfo = null;
        String personalInfoQuery = 
                "INSERT INTO personal_information(address, city, state, zipcode, phone_number, email, account_number)  VALUES(?, ?, ?, ?, ?, ?, ?);";   
        try{
            con.setAutoCommit(false);
            personalInfo = con.prepareStatement(personalInfoQuery);
            personalInfo.setString(1, info.getAddress());
            personalInfo.setString(2, info.getCity());
            personalInfo.setString(3, info.getState());
            personalInfo.setInt(4, info.getZipcode());
            personalInfo.setString(5, info.getPhoneNumber());
            personalInfo.setString(6, info.getEmail());
            personalInfo.setInt(7, customer.getAcc());
            personalInfo.executeUpdate();
            con.commit();
            System.out.println("Success");
        } catch(SQLException e){
            System.out.println(e);
        }
        
        PreparedStatement securityInfo = null;
        String securityQuery =
                "INSERT INTO customer_login(username, password, social_security_number, account_number) VALUES(?, ?, ?, ?);";
        try{
            con.setAutoCommit(false);
            securityInfo = con.prepareStatement(securityQuery);
            securityInfo.setString(1, info.getUsername());
            securityInfo.setString(2, info.getPassword());
            securityInfo.setString(3, customer.getSsn());
            securityInfo.setInt(4, customer.getAcc());
            securityInfo.executeUpdate();
            con.commit();
            System.out.println("Success");
            
        }catch(SQLException e){
            System.out.println("FAIL");
            System.out.println(e);
        }
    }
     
    public void accountMoneyQuery(Customer customer, double amount){
         PreparedStatement deposit = null;
         String depositMoney = 
                 "UPDATE customers SET account_balance=? WHERE account_number=?";
         try{
             con.setAutoCommit(false);
             deposit = con.prepareStatement(depositMoney);
             deposit.setDouble(1, amount);
             deposit.setInt(2, customer.getAccount().getAccountNumber());
             deposit.executeUpdate();
             con.commit();
             System.out.println("Success");
         }catch(Exception e){
             System.out.println(e);
         }
    }
     
     public void removeCustomerFromDatabase(int n){
          PreparedStatement names = null;
        String insertNames = 
                "DELETE FROM customers WHERE account_number = ?";   
        try{
            con.setAutoCommit(false);
            names = con.prepareStatement(insertNames);
            names.setInt(1, n);      
            names.executeUpdate();
            con.commit();
            System.out.println("Success");
        } catch(SQLException e){
            System.out.println(e);
        }
     }

    public void addCustomer(Customer customer) {
            customers.add(customer);
    }

    public Customer getCustomer(int account) {
            return customers.get(account);
    }


    ArrayList<Customer> getCustomers(){
            return customers;
    }

    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for(Customer c : customers){
            if(c.getAcc() == accountNumber){
                customer = c;
                break;
            }
        }
        return customer;
    }

    void removeCustomer(Customer customer) {
            customers.remove(customer);
    }
}
