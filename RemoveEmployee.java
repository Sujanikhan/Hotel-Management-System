package admins;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveEmployee extends JFrame {

    JTextField jobText,nameText, ageText, salaryText, phoneText,aadharText,emailText;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox comboBox,comboBox1;
    JButton remove,back,check;
    public RemoveEmployee() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 102));
        add(panel);

        JLabel RE = new JLabel("REMOVE EMPLOYEE");
        RE.setBounds(450, 24, 445, 35);
        RE.setFont(new Font("Tahoma", Font.BOLD, 31));
        RE.setForeground(Color.WHITE);//by default black color
        panel.add(RE);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon); //scaled image
        label.setBounds(500, 100, 200, 200);
        panel.add(label);

        JLabel id = new JLabel("EMP ID");
        id.setBounds(60, 30, 150, 27);
        id.setFont(new Font("serif", Font.BOLD, 17));
        id.setForeground(Color.WHITE);
        panel.add(id);

        comboBox1 = new JComboBox();
        comboBox1.setBounds(200, 30, 150, 27);
        comboBox1.setBackground(new Color(16, 108, 115));
        comboBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox1.setForeground(Color.WHITE);
        panel.add(comboBox1);

        Connection connection = Con.getConnection();

        try {
            String q = "select * from employee";
            PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comboBox1.addItem(rs.getString("empid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JLabel name = new JLabel("NAME");
        name.setBounds(60, 80, 150, 27);
        name.setFont(new Font("serif", Font.BOLD, 17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(200, 80, 150, 27);
        nameText.setBackground(new Color(16, 108, 115));
        nameText.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameText.setForeground(Color.WHITE);
        nameText.setEditable(false);
        panel.add(nameText);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 130, 150, 27);
        age.setFont(new Font("serif", Font.BOLD, 17));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText = new JTextField();
        ageText.setBounds(200, 130, 150, 27);
        ageText.setBackground(new Color(16, 108, 115));
        ageText.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageText.setForeground(Color.WHITE);
        ageText.setEditable(false);
        panel.add(ageText);

        JLabel Gender = new JLabel("GENDER");
        Gender.setBounds(60, 180, 150, 27);
        Gender.setFont(new Font("serif", Font.BOLD, 17));
        Gender.setForeground(Color.WHITE);
        panel.add(Gender);

        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(200, 180, 70, 27);
        radioButtonM.setBackground(new Color(255, 102, 102));
        radioButtonM.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);

        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(280, 180, 100, 27);
        radioButtonF.setBackground(new Color(255, 102, 102));
        radioButtonF.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonM);
        buttonGroup.add(radioButtonF);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 230, 150, 27);
        job.setFont(new Font("serif", Font.BOLD, 17));
        job.setForeground(Color.WHITE);
        panel.add(job);

        jobText = new JTextField();
        jobText.setBackground(new Color(16, 108, 115));
        jobText.setBounds(200, 230, 150, 30);
        jobText.setFont(new Font("Tahoma", Font.BOLD, 14));
        jobText.setForeground(Color.WHITE);
        jobText.setEditable(false);
        panel.add(jobText);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 280, 150, 27);
        salary.setFont(new Font("serif", Font.BOLD, 17));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salaryText = new JTextField();
        salaryText.setBounds(200, 280, 150, 27);
        salaryText.setBackground(new Color(16, 108, 115));
        salaryText.setFont(new Font("Tahoma", Font.BOLD, 14));
        salaryText.setForeground(Color.WHITE);
        salaryText.setEditable(false);
        panel.add(salaryText);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60, 330, 150, 27);
        phone.setFont(new Font("serif", Font.BOLD, 17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneText = new JTextField();
        phoneText.setBounds(200, 330, 150, 27);
        phoneText.setBackground(new Color(16, 108, 115));
        phoneText.setFont(new Font("Tahoma", Font.BOLD, 14));
        phoneText.setForeground(Color.WHITE);
        phoneText.setEditable(false);
        panel.add(phoneText);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 380, 150, 27);
        aadhar.setFont(new Font("serif", Font.BOLD, 17));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        aadharText = new JTextField();
        aadharText.setBounds(200, 380, 150, 27);
        aadharText.setBackground(new Color(16, 108, 115));
        aadharText.setFont(new Font("Tahoma", Font.BOLD, 14));
        aadharText.setForeground(Color.WHITE);
        aadharText.setEditable(false);
        panel.add(aadharText);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60, 430, 150, 27);
        email.setFont(new Font("serif", Font.BOLD, 17));
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailText = new JTextField();
        emailText.setBounds(200, 430, 150, 27);
        emailText.setBackground(new Color(16, 108, 115));
        emailText.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailText.setForeground(Color.WHITE);
        emailText.setEditable(false);
        panel.add(emailText);

        check = new JButton("Check");
        check.setBounds(30, 500, 120, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emp = (String) comboBox1.getSelectedItem();

                try {
                    String q = "select * from employee where empid=?";
                    PreparedStatement ps = connection.prepareStatement(q);
                    ps.setString(1, emp);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        nameText.setText(rs.getString("name"));
                        ageText.setText(rs.getString("age"));
                        String gender = rs.getString("gender");

                        if (gender.equalsIgnoreCase("Male")) {
                            radioButtonM.setSelected(true);

                        } else if (gender.equalsIgnoreCase("Female")) {
                            radioButtonF.setSelected(true);
                        }
                        radioButtonM.setEnabled(false);
                        radioButtonF.setEnabled(false);

                        jobText.setText(rs.getString("job"));
                        salaryText.setText(rs.getString("salary"));
                        phoneText.setText(rs.getString("phone"));
                        emailText.setText(rs.getString("email"));
                        aadharText.setText(rs.getString("aadhar"));

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        remove = new JButton("Remove");
        remove.setBounds(300, 500, 120, 30);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLACK);
        panel.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String emply = (String) comboBox1.getSelectedItem();
                    String q = "delete from employee where empid=?";
                    PreparedStatement ps = connection.prepareStatement(q);
                    ps.setString(1, emply);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Employee removed successfully");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(170, 500, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLocation(300, 100);
        setLayout(null);
        setSize(900, 600);
        setVisible(true);
    }

}
