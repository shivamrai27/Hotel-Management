package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    TextField roomNumberTextFiled, nameTextField, checkInTextField, amountPaidTextField, pendingAmountTextField;
    JButton loadButton, updateButton, backButton;
    Choice c1;

    UpdateCheck(){

        JLabel updateCheckLAbel = new JLabel("Check-in Details");
        updateCheckLAbel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        updateCheckLAbel.setBounds(60,20,150,30);
        add(updateCheckLAbel);

        JLabel customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        customerIdLabel.setBounds(30,80,130,20);
        add(customerIdLabel);

        c1 = new Choice();
        try{

            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);  // altrnatively you can pass "whole sql command instead of str variable to save one line"
            while(rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel roomNumberLable = new JLabel("Room No.");
        roomNumberLable.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        roomNumberLable.setBounds(30,120,130,20);
        add(roomNumberLable);
        roomNumberTextFiled = new TextField();
        roomNumberTextFiled.setBounds(200,120,150,25);
        add(roomNumberTextFiled);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        nameLabel.setBounds(30,160,130,20);
        add(nameLabel);
        nameTextField = new TextField();
        nameTextField.setBounds(200,160,150,25);
        add(nameTextField);

        JLabel checkinLabel = new JLabel("Check-in");
        checkinLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        checkinLabel.setBounds(30,200,130,20);
        add(checkinLabel);
        checkInTextField = new TextField();
        checkInTextField.setBounds(200,200,150,25);
        add(checkInTextField);

        JLabel amountPaidLabel = new JLabel("Amount Paid");
        amountPaidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        amountPaidLabel.setBounds(30,240,130,20);
        add(amountPaidLabel);
        amountPaidTextField = new TextField();
        amountPaidTextField.setBounds(200,240,150,25);
        add(amountPaidTextField);

        JLabel pendingAmountLabel = new JLabel("Pending Amount");
        pendingAmountLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        pendingAmountLabel.setBounds(30,280,130,24);
        add(pendingAmountLabel);
        pendingAmountTextField = new TextField();
        pendingAmountTextField.setBounds(200,280,150,25);
        add(pendingAmountTextField);

        loadButton = new JButton("LOAD");
        loadButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        loadButton.setBounds(20,328,110,30);
        loadButton.addActionListener(this);
        add(loadButton);

        updateButton = new JButton("UPDATE");
        updateButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        updateButton.setBounds(135,328,110,30);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        backButton.setBounds(250,328,110,30);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon updateCheckImage = new ImageIcon(ClassLoader.getSystemResource("icons/hotelcheckin.jpg"));
        Image updateCheckImageImageCrop = updateCheckImage.getImage().getScaledInstance(468,300,Image.SCALE_DEFAULT);
        ImageIcon finalupdateCheckImage = new ImageIcon(updateCheckImageImageCrop);
        JLabel updateCheckImageLable= new JLabel(finalupdateCheckImage);
        updateCheckImageLable.setBounds(390,10,468,400);
        add(updateCheckImageLable);

        setLayout(null);
        setBounds(280,160,900,420);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == loadButton ){

            try{
                String room =null;
                String deposit =  null;
                int amountPaid ;
                String price =null;

                conn c = new conn();
                String id = c1.getSelectedItem();
                String str = "select * from customer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    roomNumberTextFiled.setText(rs.getString("room"));
                    nameTextField.setText((rs.getString("name")));
                    checkInTextField.setText((rs.getString("status")));
                    amountPaidTextField.setText((rs.getString("deposit")));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number ='"+room+"'");
                while(rs2.next()){
                    price=rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    pendingAmountTextField.setText(Integer.toString(amountPaid));
                }

            }catch(Exception e){
                System.out.print(e);
            }

        }else if(ae.getSource() == updateButton){

            try{

            }catch(Exception e){
                System.out.print(e);
            }

        }else if(ae.getSource() == backButton){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

}

    public static void main(String [] args){

        new UpdateCheck();
    }
}
