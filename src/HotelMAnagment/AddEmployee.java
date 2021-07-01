package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton rb1, rb2;
    JComboBox cb1;
    JButton b1, b2;

    AddEmployee() {
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        name.setBounds(60, 30, 120, 30);
        add(name);
        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        age.setBounds(60, 80, 120, 30);
        add(age);
        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        gender.setBounds(60, 130, 120, 30);
        add(gender);
        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        rb1.setBounds(200, 130, 70, 30);
        rb1.setBackground(Color.WHITE);
        add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        rb2.setBounds(270, 130, 80, 30);
        
        rb2.setBackground(Color.WHITE);
        add(rb2);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        job.setBounds(60, 180, 120, 30);
        add(job);
        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cb1 = new JComboBox(str);
        cb1.setBounds(200, 180, 150, 30);
        
        add(cb1);

        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        salary.setBounds(60, 230, 120, 30);
        add(salary);
        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        phone.setBounds(60, 280, 120, 30);
        add(phone);
        t4 = new JTextField();
        t4.setBounds(200, 280, 150, 30);
        add(t4);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        aadhar.setBounds(60, 330, 120, 30);
        add(aadhar);
        t5 = new JTextField();
        t5.setBounds(200, 330, 150, 30);
        add(t5);

        JLabel email = new JLabel("E-MAIL");
        email.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        email.setBounds(60, 380, 120, 30);
        add(email);
        t6 = new JTextField();
        t6.setBounds(200, 380, 150, 30);
        add(t6);

        b1 = new JButton("ADD");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(70, 445, 90, 30);
        b1.setFont(new Font("Rockwell", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);




        b2 = new JButton("CANCEL");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(220, 445, 110, 30);
        b2.setFont(new Font("Rockwell", Font.PLAIN, 17));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430, 600, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(360, 0, 430, 600);
        getContentPane().setBackground(new Color(155, 234, 221));
        add(l1);

//
//        JLabel l2 = new JLabel("ABOUT EMPLOYEE");
//        l2.setBounds(415,60,600,30);
//        l2.setFont(new Font("  Comic Sans MS", Font.PLAIN,30));
//        l2.setForeground(new Color(0x67d1e8));
//        add(l2);

        setLayout(null);
        setBounds(345, 165, 800, 550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();

        String gender = null;

        if (rb1.isSelected()) {
            gender = "Male";
        } else if (rb2.isSelected()) {
            gender = "Female";
        } else if(ae.getSource() == b2){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
        String job = (String) cb1.getSelectedItem();
         conn c = new conn();
         String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";

         try {
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null, "Employee Added" );
               this.setVisible(false);
         }catch (Exception e){
             System.out.println(e);

         }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }


}
