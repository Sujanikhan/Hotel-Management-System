package reception;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
public CheckOut(){
    JPanel panel=new JPanel();
    panel.setBounds(5,5,790,390);
    panel.setBackground(new Color(255,102,102));
    panel.setLayout(null);
    add(panel);

    JLabel label=new JLabel("Check-Out");
    label.setBounds(100,20,100,30);
    label.setFont(new Font("Tahoma",Font.PLAIN,20));
    label.setForeground(Color.WHITE);
    panel.add(label);

    JLabel userId=new JLabel("Guest Id");
    userId.setBounds(30,80,150,30);
    userId.setFont(new Font("Tahoma",Font.BOLD,14));
    userId.setForeground(Color.WHITE);
    panel.add(userId);

    Choice customer=new Choice();
    customer.setBounds(200,80,150,25);
    panel.add(customer);

    JLabel roomNum=new JLabel("Room Number");
    roomNum.setBounds(30,130,150,30);
    roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
    roomNum.setForeground(Color.WHITE);
    panel.add(roomNum);

    JLabel labelRoomNumber =new JLabel();
    labelRoomNumber.setBounds(200,130,150,30);
    labelRoomNumber.setFont(new Font("Tahoma",Font.BOLD,14));
    labelRoomNumber.setForeground(Color.WHITE);
    panel.add(labelRoomNumber);

    JLabel checkintime =new JLabel("Check-In Time");
    checkintime.setBounds(30,180,150,30);
    checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
    checkintime.setForeground(Color.WHITE);
    panel.add(checkintime);

    JLabel labelcheckintime =new JLabel();
    labelcheckintime.setBounds(200,180,400,30);
    labelcheckintime.setFont(new Font("Tahoma",Font.BOLD,14));
    labelcheckintime.setForeground(Color.WHITE);
    panel.add(labelcheckintime);

    JLabel checkouttime =new JLabel("Check-Out Time");
    checkouttime.setBounds(30,230,150,30);
    checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
    checkouttime.setForeground(Color.WHITE);
    panel.add(checkouttime);

    Date date=new Date();

    JLabel labelcheckouttime =new JLabel(""+date);
    labelcheckouttime.setBounds(200,230,250,30);
    labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
    labelcheckouttime.setForeground(Color.WHITE);
    panel.add(labelcheckouttime);

    try{
        Connection con= Con.getConnection();
        String q="select * from guest";
        PreparedStatement ps= con.prepareStatement(q);
        ResultSet resultSet=ps.executeQuery();
        while(resultSet.next()){
            customer.add(resultSet.getString("number"));
        }
    }catch(Exception E){
        E.printStackTrace();
    }

    JButton checkout=new JButton("Check-Out");
    checkout.setBounds(30,300,120,30);
    checkout.setForeground(Color.WHITE);
    checkout.setBackground(Color.BLACK);
    panel.add(checkout);
    checkout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Connection con=Con.getConnection();
                con.setAutoCommit(false);
                String q1="delete from guest where number=?";
                PreparedStatement ps=con.prepareStatement(q1);
                ps.setString(1,customer.getSelectedItem());
                ps.executeUpdate();

               String q2= "update room set availability='Available' where roomnumber=?";
               PreparedStatement ps1= con.prepareStatement(q2);
               ps1.setString(1,labelRoomNumber.getText());
               ps1.executeUpdate();
               con.commit();
                JOptionPane.showMessageDialog(null,"Done");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }
    });

    JButton check=new JButton("Check");
    check.setBounds(300,300,120,30);
    check.setForeground(Color.WHITE);
    check.setBackground(Color.BLACK);
    panel.add(check);
    check.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection con1=Con.getConnection();
            try{
                String q="select * from guest where number=?";
                PreparedStatement ps=con1.prepareStatement(q);
                ps.setString(1,customer.getSelectedItem());
                ResultSet resultSet=ps.executeQuery();
                while(resultSet.next()){
                    labelRoomNumber.setText(resultSet.getString("room"));
                    labelcheckintime.setText(resultSet.getString("checkintime"));
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
    });

    JButton back=new JButton("Back");
    back.setBounds(170,300,120,30);
    back.setForeground(Color.WHITE);
    back.setBackground(Color.BLACK);
    panel.add(back);
    back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            setVisible(false);
        }
    });

    setUndecorated(true);
    setLayout(null);
    setSize(800,400);
    setLocation(500,210);
    setVisible(true);
}


}
