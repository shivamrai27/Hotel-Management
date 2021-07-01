package HotelMAnagment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagment extends JFrame implements ActionListener {
    int x;//isme 1 unimplemented method hota hai jisko override karana hota hai
    HotelManagment() {
        setBounds(0, 0, 1366, 768); // YOu can also do by setSize() and setLocation() function
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 768);
        add(l1);
        JLabel l2 = new JLabel("KING PALACE");
        l2.setBounds(180, 100, 470, 90);
        l2.setForeground(new Color(160,0,153));
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l1.add(l2);
        JButton b1 =new JButton("Next");
        b1.setBackground(new Color(0,153,220));
        b1.setForeground(Color.WHITE);

        b1.setBounds(650,650,150,30);
        b1.addActionListener(this);
        l1.add(b1);
        setLayout(null);
        setVisible(true);
        while (true) {
            l2.setVisible(false); // lid =  j label
            try {
                Thread.sleep(500); //1000 = 1 second
            } catch (Exception e) {
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    public void actionPerformed(ActionEvent loging){               //aur us method ka naam yhi hai plus uske ander hme ActionEvent class ka object banana hota hai
        new Login().setVisible(true); // yha pe jyu login class ka object bnye new likh ke tyu login class ka  constructer call hua jisse next pe click krte hi login frame open hoga
        this.setVisible(false);  // isse first frame close hojyega
    }

    public static void main(String[] args) {
        new HotelManagment();
    }
}
