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

public class Employee extends JFrame {

    public Employee(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(255,102,102));
        panel.add(table);

        try{
            Connection c= Con.getConnection() ;
            String employeeSql="select * from employee";
            PreparedStatement ps=c.prepareStatement(employeeSql);
            ResultSet rs=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back= new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel id=new JLabel("Emp ID");
        id.setBounds(41,11,70,19);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        JLabel name=new JLabel("Name");
        name.setBounds(150,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel Age=new JLabel("Age");
        Age.setBounds(260,11,70,19);
        Age.setForeground(Color.WHITE);
        Age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(360,11,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel job=new JLabel("Job");
        job.setBounds(470,11,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(job);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(580,11,70,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(680,11,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phone);

        JLabel gmail=new JLabel("Gmail");
        gmail.setBounds(810,11,70,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gmail);

        JLabel aadhar=new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }

}
