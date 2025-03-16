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

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton add,back;

    public SearchRoom(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(255,102,102));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom=new JLabel("Search For Room");
        searchForRoom.setBounds(250,11,186,31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(searchForRoom);

        JLabel rbt=new JLabel("Room Type");
        rbt.setBounds(50,73,120,20);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(rbt);

        JLabel rn=new JLabel("Room Number");
        rn.setBounds(23,162,150,20);
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(rn);

        JLabel available=new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price=new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel BT=new JLabel("Room Type");
        BT.setBounds(580,162,150,20);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(BT);

        JLabel SS=new JLabel("Clean Status");
        SS.setBounds(306,162,150,20);
        SS.setForeground(Color.WHITE);
        SS.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(SS);

        checkBox=new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(255,102,102));
        panel.add(checkBox);

        choice=new Choice();
        choice.add("Single");
        choice.add("Double");
        choice.setBounds(170,70,120,20);
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(new Color(255,102,102));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection conn = Con.getConnection();
            String q="select * from room";
            PreparedStatement ps= conn.prepareStatement(q);
            ResultSet resultSet=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        add=new JButton("Search");
        add.setBounds(200,400,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(380,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,200);
        setSize(700,500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add) {
            Connection conn1=Con.getConnection();

            try {
                String Q = "select * from room where roomType=?";

                PreparedStatement ps= conn1.prepareStatement(Q);
                ps.setString(1,choice.getSelectedItem());
                ResultSet resultSet = ps.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                String Q1="select * from room where availability='Available' and roomType=?";
                PreparedStatement ps1=conn1.prepareStatement(Q1);
                ps1.setString(1,choice.getSelectedItem());

                if (checkBox.isSelected()) {
                    ResultSet resultSet1 = ps1.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));

                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false); //back button clicked
        }
    }

}
