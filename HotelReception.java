package reception;

import hotelmanagementsystem.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReception extends JFrame{

    public HotelReception(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(255,102,102));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(255,102,102));
        add(panel1);

        JButton btnNGF=new JButton("New Guest Form");
        btnNGF.setBounds(30,50,200,40);
        btnNGF.setBackground(Color.BLACK);
        btnNGF.setFont(new Font("Tahoma",Font.BOLD,14));
        btnNGF.setForeground(Color.WHITE);
        panel1.add(btnNGF);
        btnNGF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new NewGuest();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnRoom=new JButton("Room");
        btnRoom.setBounds(30,100,200,40);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        btnRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnDepartment=new JButton("Department");
        btnDepartment.setBounds(30,150,200,40);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        btnDepartment.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnAEI=new JButton("All Employee Info");
        btnAEI.setBounds(30,200,200,40);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        btnAEI.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnGI=new JButton("Guest Info");
        btnGI.setBounds(30,250,200,40);
        btnGI.setBackground(Color.BLACK);
        btnGI.setForeground(Color.WHITE);
        btnGI.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnGI);
        btnGI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Guest();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCO=new JButton("Check Out");
        btnCO.setBounds(30,300,200,40);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        btnCO.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnUC=new JButton("Update Check-In");
        btnUC.setBounds(30,350,200,40);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        btnUC.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   new UpdateCheckin();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnURS=new JButton("Update Room Status");
        btnURS.setBounds(30,400,200,40);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        btnURS.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnPUS=new JButton("Pickup And Drop");
        btnPUS.setBounds(30,450,200,40);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        btnPUS.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new PickupAndDrop();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton btnSR=new JButton("Search Room");
        btnSR.setBounds(30,500,200,40);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        btnSR.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton logout=new JButton("Logout");
        logout.setBounds(30,600,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.exit(500);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(140,600,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible(false);
                    new Dashboard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }


}
