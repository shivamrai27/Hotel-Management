package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRoom extends JFrame implements ActionListener {

    JTextField roomNumberTextField, pricceTextField;
    JComboBox aviailabiltyComboBox, statusComboBox, bedTypeComboBox;
    JButton addButton, cancelButton;

    AddRoom() {

        JLabel addRoom = new JLabel("ADD ROOM");
        addRoom.setBounds(90, 30, 130, 30);
        addRoom.setFont(new Font("Engravers MT", Font.PLAIN, 17));
        add(addRoom);


        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        roomNumber.setBounds(20, 90, 120, 30);
        add(roomNumber);

        roomNumberTextField = new JTextField();
        roomNumberTextField.setBounds(160, 90, 180, 30);
        add(roomNumberTextField);

        JLabel aviailabilty = new JLabel("Aviailabilty");
        aviailabilty.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        aviailabilty.setBounds(20, 150, 120, 30);
        add(aviailabilty);

        String str[] = {"Avialable", "Not avialable"};
        aviailabiltyComboBox = new JComboBox(str);
        aviailabiltyComboBox.setBounds(160, 150, 180, 30);
        add(aviailabiltyComboBox);

        JLabel status = new JLabel("Clean Status");
        status.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        status.setBounds(20, 210, 120, 30);
        add(status);

        String str1[] = {"Cleaned", "Dirty"};
        statusComboBox = new JComboBox(str1);
        statusComboBox.setBounds(160, 210, 180, 30);
        add(statusComboBox);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        price.setBounds(20, 270, 120, 30);
        add(price);

        pricceTextField = new JTextField();
        pricceTextField.setBounds(160, 270, 180, 30);
        add(pricceTextField);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        bedType.setBounds(20, 330, 120, 30);
        add(bedType);

        String str2[] = {"Single Bed", "Double Bed"};
        bedTypeComboBox = new JComboBox(str2);
        bedTypeComboBox.setBounds(160, 330, 180, 30);
        add(bedTypeComboBox);

        addButton = new JButton("Add");
        addButton.setBounds(35, 400, 100, 30);
        addButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        addButton.addActionListener(this);
        add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(240, 400, 100, 30);
        cancelButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addRoom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(385, 0, 500, 500);

        getContentPane().setBackground(new Color(155, 234, 221));
        add(l1);

        setLayout(null);
        setBounds(310, 160, 900, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {

            String room = roomNumberTextField.getText();
            String available = (String) aviailabiltyComboBox.getSelectedItem();
            String status = (String) statusComboBox.getSelectedItem();
            String price = pricceTextField.getText();
            String bed = (String) bedTypeComboBox.getSelectedItem();

            conn c = new conn();
            try {
                String str = "insert into room values('" + room + "','" + available + "','" + status + "','" + price + "','" + bed + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added");
                new AddRoom().setVisible(true);
            } catch (Exception e) {

            }

        } else if (ae.getSource() == cancelButton) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }
}

