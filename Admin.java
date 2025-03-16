package admins;

import hotelmanagementsystem.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_Employee, add_Room, add_Drivers,remove_Employee, logout, back;
    public Admin(){
        add_Employee=new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(250,70,200,30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        add_Room=new JButton("ADD ROOM");
        add_Room.setBounds(250,220,200,30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Drivers=new JButton("ADD DRIVERS");
        add_Drivers.setBounds(250,370,200,30);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        remove_Employee=new JButton("REMOVE EMPLOYEE");
        remove_Employee.setBounds(250,520,200,30);
        remove_Employee.setBackground(Color.WHITE);
        remove_Employee.setForeground(Color.BLACK);
        remove_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        remove_Employee.addActionListener(this);
        add(remove_Employee);


        logout=new JButton("Logout");
        logout.setBounds(10,700,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);


        back=new JButton("Back");
        back.setBounds(110,700,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon l1= new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11=l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(l11);
        JLabel label=new JLabel(imageIcon);
        label.setBounds(70,50,120,120);
        add(label);

        ImageIcon imageIcon1= new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image=imageIcon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon11=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon11);
        label1.setBounds(70,200,120,120);
        add(label1);

        ImageIcon imageIcon2= new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image image1=imageIcon2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon12=new ImageIcon(image1);
        JLabel label2=new JLabel(imageIcon12);
        label2.setBounds(70,350,120,120);
        add(label2);

        ImageIcon l2= new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l111=l2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcona=new ImageIcon(l111);
        JLabel label5=new JLabel(imageIcona);
        label5.setBounds(70,500,120,120);
        add(label5);



        getContentPane().setBackground(new Color(255,102,102));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_Employee){
            new AddEmployee();
        }else if(e.getSource()==add_Room){
            new AddRoom();

        }else if(e.getSource()==add_Drivers){
            new AddDriver();

        }else if(e.getSource()==remove_Employee){
            new RemoveEmployee();
        }
        else if(e.getSource()==logout){
            System.exit(102);
        }else if (e.getSource()==back){
            new Dashboard();
            setVisible(false);//admin frame close dashboard opens
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
