package HotelMAnagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

JLabel addDriverLabel,nameLabel, ageLabel, genderLabel, carCompanyLable, carmodelLabel, availableLabel, locatioLabel, driverImageLabel;
JTextField  nameTextField, ageTextField, carCompanyTextField, carModelTextField, locationTextField ;
JComboBox genderComboBox, availableComboBox;
JButton addDriverButton, cancelButton;

    AddDriver(){

        addDriverLabel = new JLabel("ADD DRIVER");
        addDriverLabel.setFont(new Font("Engravers MT", Font.PLAIN,17 ));
        addDriverLabel.setBounds(90,20,150,50);
        add(addDriverLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font ("Comic Sans Ms", Font.PLAIN,17));
        nameLabel.setBounds(60,90,110,30);
        add(nameLabel);
        nameTextField = new JTextField();
        nameTextField.setBounds(200,90,150,30);
        add(nameTextField);

        ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("comic Sans MS",Font.PLAIN,17));
        ageLabel.setBounds(60,140,110,30);
        add(ageLabel);
        ageTextField = new JTextField();
        ageTextField.setBounds(200,140,150,30);
        add(ageTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,17));
        genderLabel.setBounds(60,200,110,30);
        add(genderLabel);
        String genderString[] = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox(genderString);
        genderComboBox.setBounds(200,200,150,30);
        add(genderComboBox);

        carCompanyLable = new JLabel("Car Company");
        carCompanyLable.setFont(new Font("Comic sans MS",Font.PLAIN,17));
        carCompanyLable.setBounds(60,260,110,30);
        add(carCompanyLable);
        carCompanyTextField = new JTextField();
        carCompanyTextField.setBounds(200,260,150,30);
        add(carCompanyTextField);

        carmodelLabel = new JLabel("Car Model");
        carmodelLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,17));
        carmodelLabel.setBounds(60,320,110,30);
        add(carmodelLabel);
        carModelTextField = new JTextField();
        carModelTextField.setBounds(200,320,150,30);
        add(carModelTextField);

        availableLabel =new JLabel("Availability");
        availableLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,17));
        availableLabel.setBounds(60,380,110,30);
        add(availableLabel);
        String availableString [] = {"Available", "Not Available"};
        availableComboBox = new JComboBox(availableString);
        availableComboBox.setBounds(200,380,150,30);
        add(availableComboBox);

        locatioLabel = new JLabel("Location");
        locatioLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,17));
        locatioLabel.setBounds(60,440,110,30);
        add(locatioLabel);
        locationTextField = new JTextField();
        locationTextField.setBounds(200,440,150,30);
        add(locationTextField);

        addDriverButton = new JButton("ADD");
        addDriverButton.setFont(new Font("Rockwell",Font.PLAIN,17));
        addDriverButton.setBounds(75,500,100,30);
        addDriverButton.addActionListener(this);
        add(addDriverButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Rockwell", Font.PLAIN,17));
        cancelButton.setBounds(230,500,100,30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon driverImage = new ImageIcon(ClassLoader.getSystemResource("icons/cardriver.png"));
        Image driverImageCrop = driverImage.getImage().getScaledInstance(540,580,Image.SCALE_DEFAULT);
        ImageIcon finalDiverImage = new ImageIcon(driverImageCrop);
        driverImageLabel =new JLabel(finalDiverImage);
        driverImageLabel.setBounds(380,0,540,580);
        add(driverImageLabel);

        setLayout(null);
        setBounds(300,150,900,580);
        getContentPane().setBackground(new Color(155,234,221));
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addDriverButton) {
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String company = carCompanyTextField.getText();
            String model = carModelTextField.getText();
            String availability = (String) availableComboBox.getSelectedItem();
            String location = locationTextField.getText();

            conn c = new conn();
            try {
                String driver = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + availability + "','" + location + "')";
                c.s.executeUpdate(driver);
                JOptionPane.showMessageDialog(null, "New Driver Added");
                new AddDriver().setVisible(true);
                this.setVisible(false);
            } catch (Exception e) {

            }
        } else if (ae.getSource() == cancelButton) {
            this.setVisible(false);
        }
    }

     public static void main (String[] args){

         new AddDriver();
    }
}
