package hotelmanagementsystem;

import admins.AdminLogin;
import reception.HotelReception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton add, rec;
    public Dashboard(){

        rec= new JButton("RECEPTION");
        rec.setBounds(425, 510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.white);
        rec.addActionListener(this);      //to make click events
        add(rec);

        add= new JButton("ADMIN");
        add.setBounds(880, 510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2=i11.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11=new ImageIcon(i2);
        JLabel label1=new JLabel(imageIcon11);
        label1.setBounds(850,300,200,195);
        add(label1);

        ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i22=i111.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111=new ImageIcon(i22);
        JLabel label11=new JLabel(imageIcon111);
        label11.setBounds(400,300,200,195);
        add(label11);


        getContentPane().setBackground(new Color(255,102,102));
        setLayout(null);
        setSize(1950,1090)  ;
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new HotelReception();
           setVisible(false);

        }else{
            new AdminLogin();
            setVisible(false);
        }
    }


}
