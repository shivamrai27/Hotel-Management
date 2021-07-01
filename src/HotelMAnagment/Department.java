package HotelMAnagment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {

    JTable t1;
    JButton loadDepartmentButton, backButton;
    Choice c1;

    Department() {

        JLabel department = new JLabel("DEPARTMENTS");
        department.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        department.setBounds(167,10,180,30);
        add(department);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(60, 65, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(330, 65, 100, 20);
        add(l2);

        t1 = new JTable();
        t1.setBounds(0, 100, 500, 270);
        add(t1);

        loadDepartmentButton = new JButton("LOAD");
        loadDepartmentButton.setBounds(120, 390, 100, 30);
        loadDepartmentButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        loadDepartmentButton.addActionListener(this);
        add(loadDepartmentButton);

        backButton = new JButton("BACK");
        backButton.setBounds(270, 390, 100, 30);
        backButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        setBounds(485, 170, 500, 480);
        getContentPane().setBackground(new Color(176, 224, 230));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == loadDepartmentButton) {
            try {
                String str = "select * from department";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == backButton) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {

        new Department();

    }

}