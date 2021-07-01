package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable employeeInfoTable;
    JButton load, back;

    CustomerInfo() {

        employeeInfoTable = new JTable();
        employeeInfoTable.setBounds(0, 40, 1000, 400);
        add(employeeInfoTable);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(28,10,70,20);
        add(l1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(170,10,70,20);
        add(l2);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(280,10,70,20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(413,10,70,20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(540,10,70,20);
        add(l5);

        JLabel l6 = new JLabel("Room No.");
        l6.setBounds(660,10,70,20);
        add(l6);

        JLabel l7 = new JLabel("Status");
        l7.setBounds(787,10,70,20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900,10,70,20);
        add(l8);

        load = new JButton("Load Data");
        load.setBounds(340, 448, 100, 30);
        load.addActionListener(this);
        add(load);

        back = new JButton("Back");
        back.setBounds(550, 448, 100, 30);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setBounds(270, 155, 1000, 525);
        getContentPane().setBackground(new Color(176,224,230));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == load) {
            try {
                conn c = new conn();
                String str = "Select * from customer";  // yha se Sql dmms se data uth ke ajyega object k form me
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

        new CustomerInfo();
    }

}