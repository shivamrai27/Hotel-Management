package HotelMAnagment;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUpService extends JFrame implements ActionListener {



    JTable t1;
    JButton searchDriverButton, backButton;
    Choice c1;


    PickUpService() {

        JLabel pickup = new JLabel("PICK UP SERVICES");
        pickup.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        pickup.setBounds(450,10,180,30);
        add(pickup);


        JLabel carModel = new JLabel("Car Model");
        carModel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        carModel.setBounds(30, 50, 130, 30);
        add(carModel);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("model"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        c1.setBounds(200,53,150,25);
        add(c1);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 100, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 100, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(335, 100, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 100, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(620, 100, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(743, 100, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(880, 100, 100, 20);
        add(l7);

        t1 = new JTable();
        t1.setBounds(0, 130, 1000, 270);
        add(t1);

        searchDriverButton = new JButton("SEARCH");
        searchDriverButton.setBounds(335, 420, 120, 30);
        searchDriverButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        searchDriverButton.addActionListener(this);
        add(searchDriverButton);

        backButton = new JButton("BACK");
        backButton.setBounds(525, 420, 120, 30);
        backButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        setBounds(260, 170, 1000, 500);
        getContentPane().setBackground(new Color(176, 224, 230));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == searchDriverButton) {
            try {

                String str = "select * from driver where model = '" + c1.getSelectedItem() + "'";
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

        new PickUpService();

    }

}