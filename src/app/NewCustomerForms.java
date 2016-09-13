package app;

import app.Account;
import app.Bank;
import app.Checkings;
import app.Customer;
import app.Savings;
import javax.swing.JOptionPane;

/**
 *
 * @author Osiris Robledo
 */
public class NewCustomerForms extends javax.swing.JDialog {

    private Bank bank;
    private Customer customer;
    private PersonalInformation info;
    private PersonalInformation secure;

    /**
     * Creates new form AddAccountMenu
     */
    public NewCustomerForms(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
    }

    public StringBuilder areFieldsEmpty(StringBuilder warnings, String fName, String lName, String ssn, 
                                        double deposit, String username, String password, String address,
                                        String city, String state, int zipcode, String email, String phoneNumber) {
        
        if (firstNameField.getText().isEmpty()) {
            warnings.append("First name must not be empty\n");
        } else {
            fName = firstNameField.getText();
        }

        //Verify last name field is not empty
        if (lastNameField.getText().isEmpty()) {
            warnings.append("Last name must not be empty\n");
        } else {
            lName = lastNameField.getText();
        }

        //Verify social security
        if (!ssnField.getText().matches("(\\d{3}-?)(\\d{2}-?)\\d{4}")) {
            warnings.append("SSN must be a valid 9 digit social security number e.g(xxx-xx-xxxx)\n");
        } else {   
            ssn = ssnField.getText().replace("-", "");
        }

        //Verify deposit field is not empty
        if (depositField.getText().isEmpty()) {
            warnings.append("Initial deposit must be entered\n");
        } else {
            try {
                deposit = Double.parseDouble(depositField.getText());
            } catch (NumberFormatException ex) {
                warnings.append("Initial deposits must be number.\n");
            }
        }

        //Verify username
        if (userNameField.getText().isEmpty()) {
            warnings.append("Please provide a username.\n");
        } else {
            username = userNameField.getText();
        }
        
        //Verify password
        if (password.isEmpty()) {
            warnings.append("Please provide a password.\n");
        }
        
        //Verify address
        if (addressField.getText().isEmpty()) {
            warnings.append("Please provide an address.\n");
        } else {
            address = addressField.getText();
        }
        
        //Verify city
        if (cityField.getText().isEmpty()) {
            warnings.append("Please provide a city.\n");
        } else {
            city = cityField.getText();
        }
        
        //Verify state
        if (stateField.getText().isEmpty()) {
            warnings.append("Please provide a state.\n");
        } else {
            state = stateField.getText();
        }
        
        //Verify zipcode
        if (zipcodeField.getText().isEmpty()) {
            warnings.append("Please a valid 6 digit zipcode.\n");
        } else {
            zipcode = Integer.parseInt(zipcodeField.getText());
        }
        
        //Verify phone number
        if (phoneNumberField.getText().isEmpty()) {
            warnings.append("Please a valid 10 digit phone number.\n");
        } else {
            phoneNumber = phoneNumberField.getText();
        }
        
        //Verify email
        if (emailField.getText().isEmpty()) {
            warnings.append("Please provide a valid email address.\n");
        } else {
            email = emailField.getText();
        }  
        return warnings;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel1 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        ssnLabel1 = new javax.swing.JLabel();
        ssnField = new javax.swing.JTextField();
        depositLabel1 = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        typeLabel1 = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox();
        usernameLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stateField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        zipcodeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        okButton1 = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.GridLayout(14, 2, 5, 0));

        firstNameLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstNameLabel1.setText("First Name:");
        getContentPane().add(firstNameLabel1);

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameField);

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameField);

        ssnLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ssnLabel1.setText("Social Security Number:");
        getContentPane().add(ssnLabel1);

        ssnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssnFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ssnField);

        depositLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        depositLabel1.setText("Initial Deposit:");
        getContentPane().add(depositLabel1);
        getContentPane().add(depositField);

        typeLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        typeLabel1.setText("Account Type:");
        getContentPane().add(typeLabel1);

        typeField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Checking", "Savings" }));
        getContentPane().add(typeField);

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");
        getContentPane().add(usernameLabel);

        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(userNameField);

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");
        getContentPane().add(passwordLabel);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField);

        addressLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressLabel.setText("Address:");
        getContentPane().add(addressLabel);
        getContentPane().add(addressField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("City:");
        getContentPane().add(jLabel2);
        getContentPane().add(cityField);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("State:");
        getContentPane().add(jLabel3);
        getContentPane().add(stateField);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Zip Code:");
        getContentPane().add(jLabel4);

        zipcodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipcodeFieldActionPerformed(evt);
            }
        });
        getContentPane().add(zipcodeField);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Phone Number:");
        getContentPane().add(jLabel5);
        getContentPane().add(phoneNumberField);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("E-Mail");
        getContentPane().add(jLabel6);
        getContentPane().add(emailField);

        okButton1.setText("OK");
        okButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(okButton1);

        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void ssnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssnFieldActionPerformed

    private void okButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton1ActionPerformed
        StringBuilder warnings = new StringBuilder();
        String firstName = "", lastName = "", ssn = "", depositString = "", accountType = "", username = "",
                password = new String(passwordField.getPassword()), city = "", address = "", state = "", phoneNumber = "", email = "";
        int zipcode=0, accountNumber;
        char[] passtemp;
        double amount = 200;

        //Checks if user input for all fields are valid. If not, they're added to the 'warnings' string builder.
        warnings = areFieldsEmpty(warnings, firstName, lastName,
                                  ssn, amount, username, password,
                                  address, city, state, zipcode, phoneNumber, email);

        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        } else {
            firstName = firstNameField.getText();
            lastName = lastNameField.getText();
            ssn = ssnField.getText().replace("-", "");
            amount = Double.parseDouble(depositField.getText());
            username = userNameField.getText();
            address = addressField.getText();
            city = cityField.getText();
            state = stateField.getText();
            zipcode = Integer.parseInt(zipcodeField.getText());
            phoneNumber = phoneNumberField.getText();
            email = emailField.getText();
            Account account = null;
            if (typeField.getSelectedItem().toString() == "Checking") {
                if (amount >= 100) {
                    account = new Checkings(amount);
                    accountType = "Checking";
                } else {
                    warnings.append("Initial deposit must be greater than $100 for checking account.");
                }
            } else if (typeField.getSelectedItem().toString() == "Savings") {
                if (amount >= 50) {
                    account = new Savings(amount);
                    accountType = "Savings";
                } else {
                    warnings.append("Initial deposit must be greater than $50 for savings account.");
                }
            }

            //Checks if account was created correctly above. Also checks if it is a duplicate by checking the SSN and account type.
            if (account != null) {
                for (Customer dup : bank.getCustomers()) {
                    if (ssn.equals(dup.getSsn()) && accountType.equals(dup.getAccountType())) {
                        JOptionPane.showMessageDialog(this, "Customer with social security number already exists!");
                        return;
                    }
                }
                int highestNumberofAccounts = bank.checkNumberOfAccountss();
                int accNum = highestNumberofAccounts + 1;

                /////////////////////////////////Bug: Count goes up even if duplicate is encountered. Needs fixing//////////////////////    
                //customer = new Customer(firstName, lastName, ssn, account, accountType);
                customer = new Customer(firstName, lastName, ssn, accNum, amount, accountType);
                info = new PersonalInformation(address, city, state, zipcode, phoneNumber, email, username, password);
                bank.insertDatas(customer, info);
                bank.addCustomer(customer);

                //Displays new window message with created account info//////////////////////////////////////////////////////////
                JOptionPane.showMessageDialog(this, "New Account Information\n" + "Name: " + firstName + " " + lastName + "\n"
                        + "SSN: " + ssn + "\n" + "Balance: $" + amount + "\nAccount Type: "
                        + typeField.getSelectedItem().toString());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, warnings.toString());
            }
        }
    }//GEN-LAST:event_okButton1ActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed

    }//GEN-LAST:event_userNameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void zipcodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipcodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zipcodeFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JTextField ssnField;
    private javax.swing.JLabel ssnLabel1;
    private javax.swing.JTextField stateField;
    private javax.swing.JComboBox typeField;
    private javax.swing.JLabel typeLabel1;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField zipcodeField;
    // End of variables declaration//GEN-END:variables
}
