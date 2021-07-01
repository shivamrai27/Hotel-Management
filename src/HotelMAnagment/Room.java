package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable employeeInfoTable;
    JButton load, back;

    Room() {

        employeeInfoTable = new JTable();
        employeeInfoTable.setBounds(0, 40, 570, 400);
        add(employeeInfoTable);

        JLabel l1 = new JLabel("Room No.");
        l1.setBounds(20,10,70,20);
        add(l1);

        JLabel l2 = new JLabel("Available");
        l2.setBounds(140,10,70,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(255,10,70,20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(370,10,70,20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(474,10,70,20);
        add(l5);

        load = new JButton("Load Data");
        load.setBounds(160, 448, 100, 30);
        load.addActionListener(this);
        add(load);

        back = new JButton("Back");
        back.setBounds(300, 448, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon roomImage = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image roomImageCrop = roomImage.getImage().getScaledInstance(525,400,Image.SCALE_DEFAULT);
        ImageIcon finalReceptionImage = new ImageIcon(roomImageCrop);
        JLabel roomImageLable= new JLabel(finalReceptionImage);
        roomImageLable.setBounds(520,5,525,470);
        add(roomImageLable);

        setLayout(null);
        setBounds(270, 155, 1000, 525);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == load) {
            try {
                conn c = new conn();
                String str = "Select * from room";  // yha se Sql dmms se data uth ke ajyega object k form me
                ResultSet rs = c.s.executeQuery(str);   // aur ResultSet class ke variavle me c se s(statement) ki help se executeQuery method call kr ke usme me pass kr denge jo data uth ke aaya hai
                employeeInfoTable.setModel(DbUtils.resultSetToTableModel(rs)); //DbUtils package vhi se aya hai jha se net.proteanit import karaya hai
            } catch (Exception e) {

            }
        } else if (ae.getSource() == back) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Room();
    }
}