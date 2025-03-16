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

public class Room extends JFrame {
    JTable table;
    JButton back;
    public Room(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("ROOM DETAILS");
        l1.setBounds(600,20,250,27);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(l1);

        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(600,100,200,200);
        panel.add(label);

        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(255,102,102));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection conn= Con.getConnection() ;
            String RoomInfo="select * from room";
            PreparedStatement ps= conn.prepareStatement(RoomInfo);
            ResultSet rs= ps.executeQuery();
            //now data need to set in jtable
            while(rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                }
            }
        });

        JLabel room=new JLabel("Room No.");
        room.setBounds(12,15,80,19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);


        JLabel availability=new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(availability);

        JLabel Clean=new JLabel("Clean Status");
        Clean.setBounds(216,15,150,19);
        Clean.setForeground(Color.WHITE);
        Clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Clean);

        JLabel Price=new JLabel("Price");
        Price.setBounds(330,15,80,19);
        Price.setForeground(Color.WHITE);
        Price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Price);

        JLabel Bed=new JLabel("Bed Type");
        Bed.setBounds(417,15,80,19);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);


        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);


    }
}
