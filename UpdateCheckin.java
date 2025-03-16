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

public class UpdateCheckin extends JFrame {
    public UpdateCheckin(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(255, 102, 102));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("UPDATE CHECKIN DETAILS");
        label1.setBounds(124, 11, 300, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("ID");
        label2.setBounds(25, 88, 46, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248, 85, 140, 20);
        panel.add(c);

        try {
            Connection conn = Con.getConnection();
            String q = "SELECT * FROM guest";
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                c.add(resultSet.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(25, 129, 107, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 129, 140, 20);
        panel.add(textField3);

        JLabel label4 = new JLabel("Name");
        label4.setBounds(25, 174, 97, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248, 174, 140, 20);
        textField4.setEditable(false);
        panel.add(textField4);

        JLabel label5 = new JLabel("Checked-in");
        label5.setBounds(25, 216, 97, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248, 216, 140, 20);
        textField5.setEditable(false);
        panel.add(textField5);

        JButton update = new JButton("Update");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn=Con.getConnection();

                try {
                    conn.setAutoCommit(false);
                    String q="select room from guest where number=?";
                    PreparedStatement ps= conn.prepareStatement(q);
                    ps.setString(1,c.getSelectedItem());
                    ResultSet rs=ps.executeQuery();
                    String curr=null;
                    while(rs.next()){
                         curr=rs.getString("room");
                    }
                    String q1="select availability from room where roomnumber=?";
                    PreparedStatement ps1= conn.prepareStatement(q1);
                    ps1.setString(1,textField3.getText());
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        String ava=rs1.getString("availability");
                        if("Occupied".equals(ava)){
                            JOptionPane.showMessageDialog(null, "Room " + textField3.getText() + " is already occupied. Please choose another room.");
                            conn.rollback();  // Rollback transaction if room is occupied
                            return;
                        }
                    }
                    String q2="update guest set room=? where number=?";
                    PreparedStatement ps2= conn.prepareStatement(q2);
                    ps2.setString(1,textField3.getText());
                    ps2.setString(2,c.getSelectedItem());
                    ps2.executeUpdate();

                    String q3="update room set availability='Available' where roomnumber=?";
                    PreparedStatement ps3= conn.prepareStatement(q3);
                    ps3.setString(1,curr);
                    ps3.executeUpdate();

                    String q4="update room set availability='Occupied' where roomnumber=?";
                    PreparedStatement ps4= conn.prepareStatement(q4);
                    ps4.setString(1,textField3.getText());
                    ps4.executeUpdate();
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Updated successfully");
                    setVisible(false);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"improper input for room number");
                    throw new RuntimeException(ex);
                }

            }
        });




                JButton back = new JButton("Back");
                back.setBounds(168, 378, 89, 23);
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                panel.add(back);
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });

                JButton check = new JButton("Check");
                check.setBounds(281, 378, 89, 23);
                check.setBackground(Color.BLACK);
                check.setForeground(Color.WHITE);
                panel.add(check);
                check.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Connection conn = Con.getConnection();

                        try {
                            String q = "select * from guest where number=?";
                            PreparedStatement ps = conn.prepareStatement(q);
                            ps.setString(1, c.getSelectedItem());
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                textField3.setText(rs.getString("room"));
                                textField4.setText(rs.getString("name"));
                                textField5.setText(rs.getString("checkintime"));
                            }

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                });



                setUndecorated(true);
                setLayout(null);
                setSize(950, 500);
                setLocation(400, 200);
                setVisible(true);
            }


}
