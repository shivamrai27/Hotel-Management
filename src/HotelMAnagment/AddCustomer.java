package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel newCustomerFormLabel, nameLabel, idLabel, numberLabel,genderlabel, countryLabel,allocatedRoomNumberLabel, checkedInLabel, depositLabel ;
    JTextField numbertextField, nameTextField, countryTextField, checkedInTextField, depositTextField;
    JComboBox idComboBox, allocatedRoomNumberComboBox;
    JRadioButton maleRadioButton, femaleRadioButton;
    JButton addCustomerButton, backButton;
    Choice c1;

    AddCustomer(){

        newCustomerFormLabel = new JLabel("NEW CUSTOMER FORM");
        newCustomerFormLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        newCustomerFormLabel.setBounds(80,20,238,50);
        add(newCustomerFormLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        nameLabel.setBounds(30,90, 150,30);
        add(nameLabel);
        nameTextField=new JTextField();
        nameTextField.setBounds(220,90,150,30);
        add(nameTextField);


        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        idLabel.setBounds(30,140, 150,30);
        add(idLabel);
        idComboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        idComboBox.setBounds(220,140,150,30);
        add(idComboBox);

        numberLabel = new JLabel("Number");
        numberLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        numberLabel.setBounds(30,190, 150,30);
        add(numberLabel);
        numbertextField = new JTextField();
        numbertextField.setBounds(220,190,150,30);
        add(numbertextField);

        genderlabel = new JLabel("Gender");
        genderlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        genderlabel.setBounds(30,240, 150,30);
        add(genderlabel);
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Default", Font.PLAIN,13));
        maleRadioButton.setBounds(220,240,65,30);
        maleRadioButton.setBackground(Color.WHITE);
        add(maleRadioButton);
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Default", Font.PLAIN, 13));
        femaleRadioButton.setBounds(285,240,85,30);
        femaleRadioButton.setBackground(Color.WHITE);
        add(femaleRadioButton);

        countryLabel = new JLabel("Country");
        countryLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        countryLabel.setBounds(30,290, 150,30);
        add(countryLabel);
        countryTextField = new JTextField();
        countryTextField.setBounds(220,290,150,30);
        add(countryTextField);

        allocatedRoomNumberLabel = new JLabel("Allocate Room No.");
        allocatedRoomNumberLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        allocatedRoomNumberLabel.setBounds(30,340, 150,30);
        add(allocatedRoomNumberLabel);

        c1 = new Choice();

        try{
            conn c = new conn();
            String str = "select * from room";
             ResultSet rs = c.s.executeQuery(str);
             while (rs.next()){
                 c1.add(rs.getString("room_number"));
             }
        }catch (Exception ignored){ }
        c1.setBounds(220,340,150,30);
        add(c1);


        checkedInLabel = new JLabel("Checked In");
        checkedInLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        checkedInLabel.setBounds(30,390, 150,30);
        add(checkedInLabel);
        checkedInTextField = new JTextField();
        checkedInTextField.setBounds(220, 390,150,30);
        add(checkedInTextField);


        depositLabel = new JLabel("Deposit");
        depositLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        depositLabel.setBounds(30,440, 150,30);
        add(depositLabel);
        depositTextField = new JTextField();
        depositTextField.setBounds(220,440,150,30);
        add(depositTextField);

        addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBounds(30,500,148,30);
        addCustomerButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        addCustomerButton.addActionListener(this);
        add(addCustomerButton);

        backButton = new JButton("Back");
        backButton.setBounds(220,500,148,30);
        backButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addCustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(485, 441, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(393, 89, 485, 441);
        add(l1);

        setLayout(null);
        getContentPane().setBackground(new Color(155, 234, 221));
        setBounds(280,150,900,580);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addCustomerButton) {

            String name = nameTextField.getText();
            String id = (String) idComboBox.getSelectedItem();
            String number = numbertextField.getText();
            String gender = null;
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }
            String country = countryTextField.getText();
            String room = c1.getSelectedItem();
            String status = checkedInTextField.getText();
            String deposit = depositTextField.getText();

            String str = "insert into customer values('" + name + "','" + id + "','" + number + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";
            String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == backButton) {
            new Reception().setVisible(true);
            this.setVisible(false);

        }
    }

    public static void main (String[] args){

        new AddCustomer();

    }
}
