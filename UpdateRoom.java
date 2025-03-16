package reception;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoom extends JFrame {
JComboBox comboBox;
    public UpdateRoom(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,440);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,60,200,200);
        panel.add(label);

        JLabel label1=new JLabel("Update Room Status");
        label1.setBounds(550,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2=new JLabel("ID");
        label2.setBounds(50,88,46,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,17));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c=new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try{
            Connection conn = Con.getConnection();
            String q="select * from guest";
            PreparedStatement ps=conn.prepareStatement(q);
            ResultSet resultSet= ps.executeQuery();
            while(resultSet.next()){
                c.add(resultSet.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number");
        label3.setBounds(50,129,150,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,17));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3=new JTextField();
        textField3.setBounds(248,129,140,20);
        textField3.setEditable(false);
        panel.add(textField3);

        JLabel label4=new JLabel("Availability");
        label4.setBounds(50,174,97,16);
        label4.setFont(new Font("Tahoma",Font.BOLD,17));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4=new JTextField();
        textField4.setBounds(248,174,140,20);
        textField4.setEditable(false);
        panel.add(textField4);

        JLabel label5=new JLabel("Clean Status");
        label5.setBounds(50,216,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,17));
        label5.setForeground(Color.WHITE);
        panel.add(label5);



        comboBox=new JComboBox<>(new String[]{"Cleaned","Dirty"});
        comboBox.setBounds(248,216,140,20);
        panel.add(comboBox);


        JButton update=new JButton("Update");
        update.setBounds(300,355,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection con1= Con.getConnection() ;
                    String status=(String) comboBox.getSelectedItem();
                    String q1="update room set cleanStatus =? where roomnumber=?";
                    PreparedStatement ps1= con1.prepareStatement(q1);
                    ps1.setString(1,status);
                    ps1.setString(2,textField3.getText());
                    ps1.executeUpdate();

                    JOptionPane.showMessageDialog(null,"updated successfully");
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(180,355,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(60,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con2 = Con.getConnection();
                String id = c.getSelectedItem();
                try {
                    String q = "select * from guest where number=?";
                    PreparedStatement ps = con2.prepareStatement(q);
                    ps.setString(1, id);
                    ResultSet resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        textField3.setText(resultSet.getString("room"));
                    }

                    String q1 = "select * from room where roomnumber=?";
                    PreparedStatement ps1 = con2.prepareStatement(q1);
                    ps1.setString(1, textField3.getText());
                    ResultSet resultSet1 = ps1.executeQuery();
                    while (resultSet1.next()) {
                        textField4.setText(resultSet1.getString("availability"));
                        resultSet1.getString("cleanStatus");
                    }

                } catch (SQLException A) {
                    throw new RuntimeException(A);
                }
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);

    }

}
