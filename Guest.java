package reception;

import hotelmanagementsystem.Con;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Guest extends JFrame {

    public Guest(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(255,102,102));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection c= Con.getConnection()  ;
            String q="select * from guest";
            PreparedStatement ps=c.prepareStatement(q);
            ResultSet resultSet=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel id=new JLabel("ID");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        JLabel number=new JLabel("Number");
        number.setBounds(160,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(number);

        JLabel name=new JLabel("Name");
        name.setBounds(290,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(410,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);


        JLabel room=new JLabel("Room");
        room.setBounds(540,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        JLabel time=new JLabel("Check-In Time");
        time.setBounds(660,11,150,14);
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(time);

        JLabel amount=new JLabel("Amount Paid");
        amount.setBounds(790,11,100,14);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(amount);

        JButton back=new JButton("Back");
        back.setBounds(300,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);

    }
}
