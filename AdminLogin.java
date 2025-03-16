package admins;

import hotelmanagementsystem.Con;
import hotelmanagementsystem.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;
    public AdminLogin(){
        JLabel label1=new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.white);
        add(label1);
        JLabel label2=new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);
        add(label2);
        textField1=new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.white);
        textField1.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        add(textField1);

        passwordField1=new JPasswordField();
        passwordField1.setBounds(150,70,150,30);
        passwordField1.setForeground(Color.white);
        passwordField1.setBackground(new Color(26,104,110));
        add(passwordField1);

//        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
//        Image i1=imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
//        JLabel label=new JLabel(imageIcon);
//        label.setBounds(318,-30,255,300);
//        add(label);
        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);//add in frame
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(255,102,102));
        setLayout(null);
        setSize(600,300);
        setVisible(true);
        setLocation(400,270);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try{
                Connection c= Con.getConnection() ;
                String user=textField1.getText();
                String pass=passwordField1.getText();
                String q="select * from adminlogin where username = ? and password=?";
                PreparedStatement ps=c.prepareStatement(q);
                ps.setString(1,user);
                ps.setString(2,pass);
                ResultSet resultSet= ps.executeQuery();
                if(resultSet.next()){
                    resultSet.getString("username");
                    resultSet.getString("password");
                    new Admin();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"invalid username and password");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            System.exit(102);
        }
    }


}
