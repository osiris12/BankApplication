
package app;

//Testing
public class PersonalInformation {
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private String phoneNumber;
    private String email;
    private String password;
    private String username;
    
    public PersonalInformation(String address, String city, String state, int zipcode, String phoneNumber, String email, String username, String password){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public PersonalInformation(String address, String city, String state, int zipcode, String phoneNumber, String email){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public PersonalInformation(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }
  
    public void setAddress(String address) {
        this.address = address;
    }
   
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

 
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
}
