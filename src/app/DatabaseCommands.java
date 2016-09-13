
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseCommands {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<HistoryInformation> rows = new ArrayList<>();
    private ArrayList<CreditCards> cards = new ArrayList<>();
    
    public DatabaseCommands(){
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "");
            st = con.createStatement();
        }catch(Exception ex){
            System.out.println("Error: " + ex);
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
    
    //Checks for valid user login information
    public boolean checkValidUser(String username, String password) throws SQLException{
        
        try {
            PreparedStatement names = 
            con.prepareStatement("SELECT social_security_number FROM customer_login WHERE username=? AND password=?");
            names.setString(1, username);
            names.setString(2, password);
            rs = names.executeQuery();
            if(!rs.next()){
                return false;
            }
            display(rs);
            System.out.println("Success");
            return true;
        } catch(Exception ex){
            System.out.println(ex);
        }finally{
            if(rs != null){
                rs.close();
            }
        }
        System.out.println("bad");
        return false;
    }
    
    //Queries and returns users account number
    public int extractUserAccountNumber(String username) throws SQLException{
        PreparedStatement pst = null;
        rs = null;
        int accountNumber = 0;
        try {
            String sql = "SELECT * FROM customer_login WHERE username=?; ";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();  
            while (rs.next()) {
                accountNumber = rs.getInt("account_number");
                System.out.println("Success account Number");
            }
            return accountNumber;
        }catch(Exception e){
            System.out.println(e + "\tDang");
        }
        return accountNumber;
    }
     
    //Returns users personal information
     public PersonalInformation extractPersonalInformation(int acc){
        PreparedStatement pst = null;
        rs = null;
        PersonalInformation person;
        try {
            String sql = "SELECT * FROM personal_information WHERE account_number=?; ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, acc);
            rs = pst.executeQuery();
            //int accountNumber = 0;
            while (rs.next()) {
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                int zipcode = rs.getInt("zipcode");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                person = new PersonalInformation(address, city, state, zipcode, phoneNumber, email);
                System.out.println("Success Address");
                return person;
            }     
        }catch(Exception e){
            System.out.println(e + "\tDang");
        }
        return null;
     }
     
    //Returns users account information
    public Customer extractAccountInformation(int acc){
        PreparedStatement pst = null;
        rs = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customers WHERE account_number=?; ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, acc);
            rs = pst.executeQuery();
            //int accountNumber = 0;
            while (rs.next() && customer == null) {
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String ssn = rs.getString("social_security_number");
                double balance = rs.getDouble("account_balance");
                String type = rs.getString("account_type");
                //String type = rs.getString("account_type");
                Account account = new Account(balance, acc);
                customer = new Customer(fName, lName, ssn, account, type);
                System.out.println("Success Customer Information");
            }  
                return customer;
            }catch(Exception e){
                System.out.println(e + "\tDang");            
            }
        return null;
    }
     
    //Queries the activity_history database table
    public void populateActivityRows(Customer customer, String action, double amount){
        PreparedStatement statement = null;
        String query = "INSERT INTO activity_history(action, amount, account_number) VALUES(?, ?, ?) ;"; 
        try{
            con.setAutoCommit(false);
            statement = con.prepareStatement(query);
            statement.setString(1, action);
            statement.setDouble(2, amount);
            statement.setInt(3, customer.getAccount().getAccountNumber());
            statement.executeUpdate();
            con.commit();
            System.out.println("Populate Successful");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList activityHistoryInformation(int acc){
        PreparedStatement pst = null;
        rs = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM activity_history WHERE account_number=?; ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, acc);
            rs = pst.executeQuery();
            //int accountNumber = 0;
            while (rs.next() && customer == null) {
                String action = rs.getString("action");
                double amount = rs.getDouble("amount");
                String timeStamp = rs.getString("time_stamp");
                HistoryInformation info = new HistoryInformation(action, amount, timeStamp);
                rows.add(info);
                System.out.println("Success Customer Information");
            }  
                return rows;
            }catch(Exception e){
                System.out.println(e + "\tDang");            
            }
        return null;
    }
    
    public void queryCreditCardsTable(CreditCards card, int accountNumber){
        PreparedStatement pst = null;
        String query =
                "INSERT INTO credit_cards(card_number, expiration_date, csv_code, card_type, account_number) VALUES(?, ?, ?, ?, ?);";
        try{
            con.setAutoCommit(false);
            pst = con.prepareStatement(query);
            pst.setLong(1, card.getCardNumber());
            pst.setString(2, card.getExpirationDate());
            pst.setInt(3, card.getCsvCode());
            pst.setString(4, card.getCardType());
            pst.setInt(5, accountNumber);
            pst.executeUpdate();
            con.commit();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList creditCardTableQuery(int acc){
        PreparedStatement pst = null;
        rs = null;
   
        try {
            String sql = "SELECT * FROM credit_cards WHERE account_number=?; ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, acc);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                long cardNumber = rs.getLong("card_number");
                String cardType = rs.getString("card_type");
                String expirationDate = rs.getString("expiration_date");
                CreditCards card = new CreditCards(cardNumber, cardType, expirationDate);
                cards.add(card);
                System.out.println("Success Customer Information");
            }  
                return cards;
            }catch(Exception e){
                System.out.println(e + "\tDang");            
            }
        return null;
    } 
    
    private static void display(ResultSet rs) throws SQLException {
        while (rs.next()) {
            String lastName = rs.getString("username");
            String firstName = rs.getString("password");
         

            System.out.printf("%s, %s", lastName, firstName);
        }
    }
}
