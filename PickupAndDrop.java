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
import java.sql.SQLException;

public class PickupAndDrop extends JFrame {
JCheckBox checkBox;
    public PickupAndDrop(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(255,102,102));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        JLabel pus=new JLabel("Pickup and Drop Service");
        pus.setBounds(90,11,250,28);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(pus);

        JLabel toc=new JLabel("Car name");
        toc.setBounds(32,97,89,14);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(toc);

        Choice c=new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try {
            Connection conn= Con.getConnection();
            String q="select * from driver";
            PreparedStatement ps= conn.prepareStatement(q);
            ResultSet resultSet=ps.executeQuery();
            while(resultSet.next()){
                c.add(resultSet.getString("car"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table=new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(255,102,102));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection conn1=Con.getConnection();
            String q="select * from driver";
            PreparedStatement ps= conn1.prepareStatement(q);
            ResultSet resultSet=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(24,200,46,40);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age=new JLabel("Age");
        age.setBounds(165,200,46,40);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(264,200,46,40);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel carname=new JLabel("Car");
        carname.setBounds(366,200,100,40);
        carname.setForeground(Color.WHITE);
        panel.add(carname);

        JLabel avail=new JLabel("Available");
        avail.setBounds(486,200,100,40);
        avail.setForeground(Color.WHITE);
        panel.add(avail);

        JLabel available=new JLabel("Pickuploc");
        available.setBounds(600,200,100,40);
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location=new JLabel("Droploc");
        location.setBounds(700,200,100,40);
        location.setForeground(Color.WHITE);
        panel.add(location);

        checkBox=new JCheckBox("Only Display Available");
        checkBox.setBounds(500,80,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(255,102,102));
        panel.add(checkBox);

        JButton display=new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==display){
                    Connection connection=Con.getConnection();

                    try {
                        String q="select * from driver where car=?";
                        PreparedStatement ps= connection.prepareStatement(q);
                        ps.setString(1,c.getSelectedItem());
                        ResultSet resultSet=ps.executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));

                        String q1="select * from driver where available='yes' and car=?";
                        PreparedStatement ps1= connection.prepareStatement(q1);
                        ps1.setString(1,c.getSelectedItem());
                        if (checkBox.isSelected()) {
                            ResultSet resultSet1 = ps1.executeQuery();
                            table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(420,500,120,30);
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
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);

    }

}
