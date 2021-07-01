package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
JButton newCustomerFormButton, customerInfoButton, roomButton, departmentButton, employeeInfoButton,managerInfoButton,
        checkOutButton, updateCheckStatusButton, updateRoomStatusButton, pickuUpServiceButton, searchRoombutton, logoutButton;

    Reception(){

//..EXTRAS(Font and its size)...........customerInfoButton.setFont(new Font("Comic Sans MS",Font.PLAIN,17));...................


        newCustomerFormButton = new JButton("New Customer");
        newCustomerFormButton.setBounds(10,30,200,30);
        newCustomerFormButton.addActionListener(this);
        add(newCustomerFormButton);

        customerInfoButton = new JButton("Customer Info");
        customerInfoButton.setBounds(10,70,200,30);
        customerInfoButton.addActionListener(this);
        add(customerInfoButton);

        roomButton = new JButton("Room");
        roomButton.setBounds(10,110,200,30);
        roomButton.addActionListener(this);
        add(roomButton);

        departmentButton = new JButton("Department");
        departmentButton.setBounds(10,150,200,30);
        departmentButton.addActionListener(this);
        add(departmentButton);

        employeeInfoButton = new JButton("Employee Info");
        employeeInfoButton.setBounds(10,190,200,30);
        employeeInfoButton.addActionListener(this);
        add(employeeInfoButton);

        managerInfoButton = new JButton("Manager Info");
        managerInfoButton.setBounds(10,230,200,30);
        managerInfoButton.addActionListener(this);
        add(managerInfoButton);

        checkOutButton = new JButton("Checkout");
        checkOutButton.setBounds(10,270,200,30);
        checkOutButton.addActionListener(this);
        add(checkOutButton);

        updateCheckStatusButton = new JButton("Upate Check Staus");
        updateCheckStatusButton.setBounds(10,310,200,30);
        updateCheckStatusButton.addActionListener(this);
        add(updateCheckStatusButton);

        updateRoomStatusButton = new JButton("Update Room Staus");
        updateRoomStatusButton.setBounds(10,350,200,30);
        updateRoomStatusButton.addActionListener(this);
        add(updateRoomStatusButton);

        pickuUpServiceButton = new JButton("Pick up Service");
        pickuUpServiceButton.setBounds(10,390,200,30);
        pickuUpServiceButton.addActionListener(this);
        add(pickuUpServiceButton    );

        searchRoombutton = new JButton("Search Room");
        searchRoombutton.setBounds(10,430,200,30);
        searchRoombutton.addActionListener(this);
        add(searchRoombutton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(10,470,200,30);
        logoutButton.addActionListener(this);
        add(logoutButton);


        ImageIcon receptionImage = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image receptionImageCrop = receptionImage.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
        ImageIcon finalReceptionImage = new ImageIcon(receptionImageCrop);
        JLabel receptionImageLable= new JLabel(finalReceptionImage);
        receptionImageLable.setBounds(250,30,500,470);
        add(receptionImageLable);

        setLayout(null);
        setBounds(333,157,820,550);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == newCustomerFormButton ){
            new AddCustomer().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == customerInfoButton){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == roomButton){
            new Room().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == departmentButton){
            new Department().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == employeeInfoButton){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == managerInfoButton){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == checkOutButton){
            new CheckOut().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == updateCheckStatusButton){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == updateRoomStatusButton){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == pickuUpServiceButton){
            new PickUpService().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == searchRoombutton){
            new SearchRoom().setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource() == logoutButton){
            setVisible(false);

        }

    }


    public static void main(String [] args){
        new Reception();

    }
}
