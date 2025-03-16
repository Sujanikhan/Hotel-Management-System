package admins;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameText, ageText,carText,locText,locText1;
    JRadioButton radioButtonM,radioButtonF;
    JComboBox comboBox1;
    JButton add,back;
    public AddDriver(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("ADD DRIVERS");
        label.setBounds(550,50,200,27);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,27));
        panel.add(label);

        JLabel name=new JLabel("NAME");
        name.setBounds(64,70,102,22);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText=new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setForeground(Color.WHITE);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setBackground(new Color(16,108,115));
        panel.add(nameText);

        JLabel age=new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("serif",Font.BOLD,17));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText=new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setForeground(Color.WHITE);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setBackground(new Color(16,108,115));
        panel.add(ageText);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(64,150,102,22);
        gender.setFont(new Font("serif",Font.BOLD,17));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        radioButtonM=new JRadioButton("MALE");
        radioButtonM.setBounds(174,150,70,27);
        radioButtonM.setBackground(new Color(255,102,102));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);

        radioButtonF=new JRadioButton("FEMALE");
        radioButtonF.setBounds(250,150,100,27);
        radioButtonF.setBackground(new Color(255,102,102));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButtonM);
        buttonGroup.add(radioButtonF);

        JLabel carC=new JLabel("CAR");
        carC.setBounds(64,190,110,22);
        carC.setFont(new Font("serif",Font.BOLD,17));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        carText=new JTextField();
        carText.setBounds(174,190,156,20);
        carText.setForeground(Color.WHITE);
        carText.setFont(new Font("Tahoma",Font.BOLD,14));
        carText.setBackground(new Color(16,108,115));
        panel.add(carText);

        JLabel available=new JLabel("AVAILABLE");
        available.setBounds(64,230,102,22);
        available.setFont(new Font("serif",Font.BOLD,17));
        available.setForeground(Color.WHITE);
        panel.add(available);
        comboBox1=new JComboBox(new String[]{"Yes","No"});
        comboBox1.setBounds(176,230,154,20);
        comboBox1.setForeground(Color.WHITE);
        comboBox1.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox1.setBackground(new Color(16,108,115));
        panel.add(comboBox1);

        JLabel loc=new JLabel("Pickup Loc");
        loc.setBounds(64,270,102,22);
        loc.setFont(new Font("serif",Font.BOLD,20));
        loc.setForeground(Color.WHITE);
        panel.add(loc);
        locText=new JTextField();
        locText.setBounds(174,270,156,20);
        locText.setForeground(Color.WHITE);
        locText.setFont(new Font("Tahoma",Font.BOLD,14));
        locText.setBackground(new Color(16,108,115));
        panel.add(locText);

        JLabel loc1=new JLabel("Drop Loc");
        loc1.setBounds(64,310,102,22);
        loc1.setFont(new Font("serif",Font.BOLD,20));
        loc1.setForeground(Color.WHITE);
        panel.add(loc1);
        locText1=new JTextField();
        locText1.setBounds(174,310,156,20);
        locText1.setForeground(Color.WHITE);
        locText1.setFont(new Font("Tahoma",Font.BOLD,14));
        locText1.setBackground(new Color(16,108,115));
        panel.add(locText1);


        add=new JButton("ADD");
        add.setBounds(64,400,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(198,400,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon1);
        label1.setBounds(450,100,300,300);
        panel.add(label1);

        setUndecorated(true);
        setLocation(300,100);
        setLayout(null);
        setSize(900,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add) {
            String name=nameText.getText();
            String age= ageText.getText();
            String gender=null;
            if(radioButtonM.isSelected()){
                gender="Male";
            }else if(radioButtonF.isSelected()){
                gender="Female";
            }
            String car=carText.getText();
            String available=(String)comboBox1.getSelectedItem();
            String pickup=locText.getText();
            String drop=locText1.getText();

            if (!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Name should only contain alphabets and spaces.");
                return;
            }

            if (name.length() > 20) {
                JOptionPane.showMessageDialog(this, "Name cannot be longer than 20 alphabets.");
                return;
            }

            try {
                int parsedAge = Integer.parseInt(age);
                if (parsedAge < 18 || parsedAge > 65) {
                    JOptionPane.showMessageDialog(this, "Age should be between 18 and 100.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age should be a valid number.");
                return;
            }

            if (!car.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Car name should only contain alphabets and spaces.");
                return;
            }

            if (car.length() > 20) {
                JOptionPane.showMessageDialog(this, "Company name cannot be longer than 20 alphabets.");
                return;
            }


            if (!pickup.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Pickup location should only contain alphabets and spaces.");
                return;
            }

            if (pickup.length() > 20) {
                JOptionPane.showMessageDialog(this, "Pickup location cannot be longer than 20 alphabets.");
                return;
            }


            if (!drop.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Drop location should only contain alphabets and spaces.");
                return;
            }

            if (drop.length() > 20) {
                JOptionPane.showMessageDialog(this, "Drop location cannot be longer than 20 alphabets.");
                return;
            }

            try{
                Connection conn= Con.getConnection();
                String q="insert into driver values(?,?,?,?,?,?,?)";
                PreparedStatement ps= conn.prepareStatement(q);
                ps.setString(1,name);
                ps.setString(2,age);
                ps.setString(3,gender);
                ps.setString(4,car);
                ps.setString(5,available);
                ps.setString(6,pickup);
                ps.setString(7,drop);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Driver Added");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

}
