package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice c1;
    TextField roomNumberTextFiel, availabilityTextField, cleanStatusTextField;
    JButton check,back,update;

    UpdateRoom(){

        JLabel updateRoomStatus = new JLabel("Update Room Status");
        updateRoomStatus.setBounds(70,20,200,30);
        updateRoomStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(updateRoomStatus);

        JLabel guestId = new JLabel("Guest ID");
        guestId.setBounds(30,80,115,30);
        guestId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(guestId);

        c1 = new Choice();
        try{
            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e ){}
        c1.setBounds(215,80,150,30);
        add(c1);


        JLabel roomNumber = new JLabel("Room No.");
        roomNumber.setBounds(30,140,115,30);
        roomNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(roomNumber);
        roomNumberTextFiel = new TextField();
        roomNumberTextFiel.setBounds(215,140,150,30);
        add(roomNumberTextFiel);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(30,200,115,30);
        availability.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(availability);
        availabilityTextField = new TextField();
        availabilityTextField.setBounds(215,200,150,30);
        add(availabilityTextField);

        JLabel cleanStatus = new JLabel("Clean Status");
        cleanStatus.setBounds(30,260,115,30);
        cleanStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(cleanStatus);
        cleanStatusTextField = new TextField();
        cleanStatusTextField.setBounds(215,260,150,30);
        add(cleanStatusTextField);

        check = new JButton("Check");
        check.setFont(new Font("Rockwell", Font.PLAIN,17));
        check.setBounds(30,320,100,30);
        check.addActionListener(this);
        add(check);

        back = new JButton("Back");
        back.setFont(new Font("Rockwell", Font.PLAIN,17));
        back.setBounds(260,320,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon updateRoomImage = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image updateRoomImageImageCrop = updateRoomImage.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon finalupdateRoomImage = new ImageIcon(updateRoomImageImageCrop);
        JLabel receptionImageLable= new JLabel(finalupdateRoomImage);
        receptionImageLable.setBounds(390,10,500,400);
        add(receptionImageLable);

        update = new JButton("Update");
        update.setFont(new Font("Rockwell", Font.PLAIN,17));
        update.setBounds(145,320,100,30);
        update.addActionListener(this);
        add(update);

        setLayout(null);
        setBounds(275,160,920,420);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String room = null;
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"'");
                while(rs.next()){
                    roomNumberTextFiel.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){
                    availabilityTextField.setText(rs2.getString("available"));
                    cleanStatusTextField.setText(rs2.getString("status"));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == update){
            try{
                conn c = new conn();
                String room = roomNumberTextFiel.getText();
                String available = availabilityTextField.getText();
                String status = cleanStatusTextField.getText();

                String str = "update room set available = '"+available+"',status='"+status+"' where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == back){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String [] args){

        new UpdateRoom();
    }
}
