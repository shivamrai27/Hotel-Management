package HotelMAnagment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {


    JComboBox bedTypeComboBox;
    JCheckBox availableCheckBox;
    JTable t1;
    JButton searchRoomButton, backButton;

    SearchRoom() {


        JLabel roomBedType = new JLabel("Bed Type");
        roomBedType.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        roomBedType.setBounds(30, 10, 130, 30);
        add(roomBedType);
        t1 = new JTable();
        bedTypeComboBox = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedTypeComboBox.setBounds(180, 10, 150, 25);
        bedTypeComboBox.setBackground(Color.WHITE);
        add(bedTypeComboBox);

        availableCheckBox = new JCheckBox("Only display available");
        availableCheckBox.setBounds(780, 10, 150, 25);
        availableCheckBox.setBackground(Color.WHITE);
        add(availableCheckBox);

        JLabel l1 = new JLabel("Room No.");
        l1.setBounds(50, 60, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 60, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(450, 60, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 60, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 60, 100, 20);
        add(l5);

        t1 = new JTable();
        t1.setBounds(0, 90, 1000, 310);
        add(t1);

        searchRoomButton = new JButton("SEARCH");
        searchRoomButton.setBounds(335, 410, 120, 30);
        searchRoomButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        searchRoomButton.addActionListener(this);
        add(searchRoomButton);

        backButton = new JButton("BACK");
        backButton.setBounds(525, 410, 120, 30);
        backButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        setBounds(260, 170, 1000, 490);
        getContentPane().setBackground(new Color(176, 224, 230));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == searchRoomButton) {
            try {

                String str = "select * from room where bed_type = '" + bedTypeComboBox.getSelectedItem() + "'";
                String str2 = "select * from room where available = 'Available' AND bed_type = '" + bedTypeComboBox.getSelectedItem() + "' ";
                conn c = new conn();
                ResultSet rs;
                if (availableCheckBox.isSelected()) {
                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == backButton) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {

        new SearchRoom();

    }

}
