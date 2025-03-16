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

public class Department extends JFrame {

    public Department(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(255,102,102));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(50,40,600,300);
        table.setBackground(new Color(255,102,102));
        table.setFont(new Font("serif",Font.PLAIN,15));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection c= Con.getConnection();
            String departmentInfo="select * from department";
            PreparedStatement ps= c.prepareStatement(departmentInfo);
            ResultSet rs=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs)); //setting values in table from resultSet

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back=new JButton("Back");
        back.setBounds(200,350,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //on clicking back button frame should close
            }
        });

        JLabel label1=new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Budget");
        label2.setBounds(431,11,105,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);

    }



}
