/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choosse Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JOptionPane;

/**
 *
 * @author Osiris Robledo
 */
public class AddAccountMenu extends javax.swing.JDialog {
    private Bank bank;
    private Customer customer;
    
    /**
     * Creates new form AddAccountMenu
     */
    public AddAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        ssnLabel = new javax.swing.JLabel();
        ssnField = new javax.swing.JTextField();
        depositLabel = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account Menu");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 5, 0));

        firstNameLabel.setText("First Name");
        getContentPane().add(firstNameLabel);

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Last Name");
        getContentPane().add(lastNameLabel);

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameField);

        ssnLabel.setText("Social Security Number");
        getContentPane().add(ssnLabel);

        ssnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssnFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ssnField);

        depositLabel.setText("Initial Deposit");
        getContentPane().add(depositLabel);
        getContentPane().add(depositField);

        typeLabel.setText("Account Type");
        getContentPane().add(typeLabel);

        typeField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Checking", "Savings" }));
        getContentPane().add(typeField);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        StringBuilder warnings = new StringBuilder(); 
        String firstName = "", lastName = "", ssn = "", depositString = "", accountType = "";
        
        double amount = 0;
        //Verify first name field
        if(firstNameField.getText().isEmpty()){
            warnings.append("First name must not be empty\n");
        } else {
            firstName = firstNameField.getText();
        }
        //Verify last name field
        if(lastNameField.getText().isEmpty()){
            warnings.append("Last name must not be empty\n");
        } else {
            lastName = lastNameField.getText();
        }
        //Verify social security
        if(!ssnField.getText().matches("(\\d{3}-?)(\\d{2}-?)\\d{4}")){
            warnings.append("SSN must be a valid social security number e.g(xxx-xx-xxxx)\n");
        } else {
            ssn = ssnField.getText().replace("-", "");
        }
        
        //Verify initial deposit
        if(depositField.getText().isEmpty()){
            warnings.append("Initial deposit must be entered");
        } else {
            try {
                amount = Double.parseDouble(depositField.getText());
            }
            catch(NumberFormatException ex){
                warnings.append("Initial deposits must be number.");
            }
        }
        
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        } else {
            Account account = null;
            if(typeField.getSelectedItem().toString() == "Checking"){
                if(amount >= 100){
                    account = new Checkings(amount);
                    accountType = "Checking";
                }
                else{
                    warnings.append("Initial deposit must be greater than $100 for checking account.");
                }
            } else if(typeField.getSelectedItem().toString() == "Savings") {
                if(amount >= 50){
                    account = new Savings(amount);  
                    accountType = "Savings";
                }
                else{
                    warnings.append("Initial deposit must be greater than $50 for savings account.");
                } 
            } 
            
            //Checks if account was created correctly above. Also checks if it is a duplicate by checking the SSN and account type.
            if(account != null){
                for(Customer dup : bank.getCustomers()){  
                    if(ssn.equals(dup.getSsn()) && accountType.equals(dup.getAccountType())){
                        JOptionPane.showMessageDialog(this, "Customer with social security number already exists!");
                        return;
                        }
                    }
                int highestNumberofAccounts = bank.checkNumberOfAccountss();
                int accNum = highestNumberofAccounts+1;
            /////////////////////Bug: Count goes up even if duplicate is encountered. Needs fixing//////////////////////    
                //customer = new Customer(firstName, lastName, ssn, account, accountType);
                customer = new Customer(firstName, lastName, ssn, accNum, amount, accountType);
                bank.addCustomer(customer);
                
                //Displays new window message with created account info//////////////////////////////////////////////////////////
                JOptionPane.showMessageDialog(this, "New Account Information\n" + "Name: " + firstName + " " + lastName + "\n" + 
                                                    "SSN: " + ssn + "\n" + "Balance: $" + amount + "\nAccount Type: " + 
                                                    typeField.getSelectedItem().toString());
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, warnings.toString());
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    Customer getCustomer() {
        return customer;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField ssnField;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JComboBox typeField;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    
}