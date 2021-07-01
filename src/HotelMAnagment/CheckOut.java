package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JTextField roomNumbertextField;
    JButton checkOutButton, backButton,tickButton;
    CheckOut(){


        JLabel checkOutLabel = new JLabel("CHECK OUT");
        checkOutLabel.setBounds(80,20,200,30);
        checkOutLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        add(checkOutLabel);

        JLabel customerID = new JLabel("Customer ID");
        customerID.setBounds(20,90,115,30);
        customerID.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        add(customerID);

        c1 = new Choice();
        try{
            conn c = new conn ();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        c1.setBounds(200,90,150,25);
        add(c1);

        JLabel roomNumber = new JLabel("Room No.");
        roomNumber.setBounds(20,140,115,30);
        roomNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        add(roomNumber);
        roomNumbertextField = new JTextField();
        roomNumbertextField.setBounds(200,140,150,25);
        add(roomNumbertextField);

        checkOutButton = new JButton("CHECK-OUT");
        checkOutButton.setBounds(20,200,150,30);
        checkOutButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        checkOutButton.addActionListener(this);
        add(checkOutButton);

        backButton = new JButton("BACK");
        backButton.setBounds(200,200,150,30);
        backButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon ticktImage = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image tickImageImageCrop = ticktImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon finaltickImage = new ImageIcon(tickImageImageCrop);
        tickButton = new JButton(finaltickImage);
        tickButton.setBounds(355,90,20,22);
        tickButton.addActionListener(this);
        add(tickButton);

        ImageIcon checkOutImage = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image chechkOutImageImageCrop = checkOutImage.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon finalcheckOutkImage = new ImageIcon(chechkOutImageImageCrop);
        JLabel checkOutImageLable= new JLabel(finalcheckOutkImage);
        checkOutImageLable.setBounds(390,5,400,250);
        add(checkOutImageLable);

        setLayout(null);
        setBounds(337,160,800,300);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);

    }

public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkOutButton){
            String id = c1.getSelectedItem();
            String room = roomNumbertextField.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str2 = "update room set available = 'Available' where room_number ='"+room+"'";
            conn c = new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout Successful");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }


        }else if(ae.getSource() == backButton){
            this.setVisible(false);
            new Reception().setVisible(true);
        }else if(ae.getSource() == tickButton){
         conn c= new conn();
         String id = c1.getSelectedItem();
         try{
             ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
             while(rs.next()){
                 roomNumbertextField.setText(rs.getString("room"));
             }
         }catch(Exception e){
             System.out.println(e);
         }

        }

}

    public static void main(String[] args){

        new CheckOut();
    }

}
