package admins;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddRoom extends JFrame implements ActionListener {
    JTextField t2, t4;
    JComboBox t3 , t5 ,t6;
    JButton b1,b2;
    private final int minRoomNumber = 1;
    private final int maxRoomNumber = 500;
    private final double minPrice = 3000.00;
    private final double maxPrice = 6000.00;
    public AddRoom(){
        JPanel panel= new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(255,102,102));
        panel.setLayout(null); //panel has border layout
        add(panel);

        JLabel l1= new JLabel("ADD ROOMS");
        l1.setBounds(580,10,200,27);
        l1.setFont(new Font("Tahoma", Font.BOLD,27));
        l1.setForeground(Color.WHITE);
        panel.add(l1);//label is on panel

        JLabel l2=new JLabel("Room Number");
        l2.setBounds(64,70,152,27);
        l2.setFont(new Font("serif",Font.BOLD,17));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        t2=new JTextField();
        t2.setBounds(200,70,156,20);
        t2.setFont(new Font("Tahoma",Font.PLAIN,14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel l3=new JLabel("Availability");
        l3.setBounds(64,110,152,22);
        l3.setFont(new Font("serif",Font.BOLD,17));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        t3=new JComboBox(new String [] {"Available", "Occupied"});
        t3.setBounds(200,110,156,20);
        t3.setFont(new Font("Tahoma",Font.PLAIN,14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(64,150,152,22);
        l4.setFont(new Font("serif",Font.BOLD,17));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        t4=new JTextField();
        t4.setBounds(200,150,156,20);
        t4.setFont(new Font("Tahoma",Font.PLAIN,14));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(64,190,152,22);
        l5.setFont(new Font("serif",Font.BOLD,17));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        t5=new JComboBox(new String[]{"Cleaned","Dirty"});
        t5.setBounds(200,190,156,20);
        t5.setFont(new Font("Tahoma",Font.PLAIN,14));
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        JLabel l6=new JLabel("Room Type");
        l6.setBounds(64,230,152,22);
        l6.setFont(new Font("serif",Font.BOLD,17));
        l6.setForeground(Color.WHITE);
        panel.add(l6);

        t6=new JComboBox(new String[]{"Single","Double"});
        t6.setBounds(200,230,156,20);
        t6.setFont(new Font("Tahoma",Font.PLAIN,14));
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);

        b1=new JButton("Add");
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("Back");
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);


        setUndecorated(true);
        setLocation(200,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try{
                Connection conn= Con.getConnection();
                String room =t2.getText();
                String ava=(String)t3.getSelectedItem();
                String price=t4.getText();
                String status=(String)t5.getSelectedItem();
                String type=(String) t6.getSelectedItem();

                if (!room.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Room Number must be numeric and should not contain any special characters or alphabets.");
                    return;
                }

                int roomNumber = Integer.parseInt(room); //convert string to integer value
                if (roomNumber < minRoomNumber || roomNumber > maxRoomNumber) {
                    JOptionPane.showMessageDialog(null, "Room Number must be between " + minRoomNumber + " and " + maxRoomNumber + ".");
                    return;
                }

                // Prevent adding duplicate room numbers
                String checkRoomQuery = "SELECT * FROM room WHERE roomNumber = ?";
                PreparedStatement ps= conn.prepareStatement(checkRoomQuery);
                ps.setString(1,room);
                ResultSet rs=ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Room Number " + roomNumber + " already exists.");
                    return;
                }


                // Validation for Price (it should be a positive number)
                if (!price.matches("^[0-9]+(\\.[0-9]{2})?$")) {
                    JOptionPane.showMessageDialog(null, "Price must be a valid number (positive number with optional decimal).");
                    return;
                }

                double roomPrice = Double.parseDouble(price); //convert string into double
               if (roomPrice < minPrice || roomPrice > maxPrice) {
                   JOptionPane.showMessageDialog(null, "Price must be  " + minPrice +" for single room" +"  and " + maxPrice + "for double room");
                    return;
                }

                String q="insert into room values(?,?,?,?,?)";
                PreparedStatement ps1= conn.prepareStatement(q);
                ps1.setString(1,room);
                ps1.setString(2,ava);
                ps1.setString(3,price);
                ps1.setString(4,status);
                ps1.setString(5,type);
                ps1.executeUpdate();

                JOptionPane.showMessageDialog(null,"Room Successfully Added");
                setVisible(false);

            }catch (Exception E){
                System.out.println("give proper input ");
                E.printStackTrace();
            }
        }else{
            setVisible(false);//when back button is pressed it hides current window AddRoom
        }
    }


}
