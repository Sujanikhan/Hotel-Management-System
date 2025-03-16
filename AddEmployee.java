package admins;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField idText,nameText, ageText, salaryText, phoneText,aadharText,emailText;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox comboBox;
    JButton add,back;
    public AddEmployee(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(255,102,102));
        add(panel);

        JLabel AED=new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Tahoma",Font.BOLD,31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        JLabel id=new JLabel("EMP ID");
        id.setBounds(60,30,150,27);
        id.setFont(new Font("serif",Font.BOLD,17));
        id.setForeground(Color.WHITE);
        panel.add(id);
        idText=new JTextField();
        idText.setBounds(200,30,150,27);
        idText.setBackground(new Color(16,108,115));
        idText.setFont(new Font("Tahoma",Font.BOLD,14));
        idText.setForeground(Color.WHITE);
        panel.add(idText);

        JLabel name=new JLabel("NAME");
        name.setBounds(60,80,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText=new JTextField();
        nameText.setBounds(200,80,150,27);
        nameText.setBackground(new Color(16,108,115));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setForeground(Color.WHITE);
        panel.add(nameText);

        JLabel age=new JLabel("AGE");
        age.setBounds(60,130,150,27);
        age.setFont(new Font("serif",Font.BOLD,17));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText=new JTextField();
        ageText.setBounds(200,130,150,27);
        ageText.setBackground(new Color(16,108,115));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);

        JLabel Gender=new JLabel("GENDER");
        Gender.setBounds(60,180,150,27);
        Gender.setFont(new Font("serif",Font.BOLD,17));
        Gender.setForeground(Color.WHITE);
        panel.add(Gender);

        radioButtonM=new JRadioButton("MALE");
        radioButtonM.setBounds(200,180,70,27);
        radioButtonM.setBackground(new Color(255,102,102));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);

        radioButtonF=new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,180,100,27);
        radioButtonF.setBackground(new Color(255,102,102));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButtonM);
        buttonGroup.add(radioButtonF);

        JLabel job=new JLabel("JOB");
        job.setBounds(60,230,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);

        comboBox=new JComboBox(new String[]{"Front Desk", "HouseKeeping", "Kitchen Staff","Manager","Accountant","Chef"});
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setBounds(200,230,150,30);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel salary=new JLabel("SALARY");
        salary.setBounds(60,280,150,27);
        salary.setFont(new Font("serif",Font.BOLD,17));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salaryText=new JTextField();
        salaryText.setBounds(200,280,150,27);
        salaryText.setBackground(new Color(16,108,115));
        salaryText.setFont(new Font("Tahoma",Font.BOLD,14));
        salaryText.setForeground(Color.WHITE);
        panel.add(salaryText);

        JLabel phone=new JLabel("PHONE");
        phone.setBounds(60,330,150,27);
        phone.setFont(new Font("serif",Font.BOLD,17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneText=new JTextField();
        phoneText.setBounds(200,330,150,27);
        phoneText.setBackground(new Color(16,108,115));
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneText.setForeground(Color.WHITE);
        panel.add(phoneText);

        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60,380,150,27);
        aadhar.setFont(new Font("serif",Font.BOLD,17));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        aadharText=new JTextField();
        aadharText.setBounds(200,380,150,27);
        aadharText.setBackground(new Color(16,108,115));
        aadharText.setFont(new Font("Tahoma",Font.BOLD,14));
        aadharText.setForeground(Color.WHITE);
        panel.add(aadharText);

        JLabel email=new JLabel("EMAIL");
        email.setBounds(60,430,150,27);
        email.setFont(new Font("serif",Font.BOLD,17));
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailText=new JTextField();
        emailText.setBounds(200,430,150,27);
        emailText.setBackground(new Color(16,108,115));
        emailText.setFont(new Font("Tahoma",Font.BOLD,14));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);


        add=new JButton("ADD");
        add.setBounds(80,500,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(250,500,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);


        setUndecorated(true);
        setLocation(300,100);
        setLayout(null);
        setSize(900,600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String id=idText.getText();
            String name=nameText.getText();
            String age= ageText.getText();
            String gender=null;
            if(radioButtonM.isSelected()){
                gender="Male";
            }else if(radioButtonF.isSelected()){
                gender="Female";
            }
            String job=(String)comboBox.getSelectedItem();
            String salary= salaryText.getText();
            String phone= phoneText.getText();
            String email= emailText.getText();
            String aadhar=aadharText.getText();

            try {
                int parsedId = Integer.parseInt(id);
                if (parsedId < 1 || parsedId > 999) {
                    JOptionPane.showMessageDialog(this, "Employee id should be between 1 and 999.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Employee id should be a valid number.");
                return;
            }

            if (!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Name should only contain alphabets and spaces.");
                return;
            }

            if (name.length() > 20) {
                JOptionPane.showMessageDialog(this, "Name cannot be longer than 20 alphabets.");
                return;
            }

            try {
                int parsedAge = Integer.parseInt(age);
                if (parsedAge < 18 || parsedAge > 65) {
                    JOptionPane.showMessageDialog(this, "Age should be between 18 and 65.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age should be a valid number.");
                return;
            }


            try {
                double parsedSalary = Double.parseDouble(salary);
                if (parsedSalary < 10000 || parsedSalary > 50000) {
                    JOptionPane.showMessageDialog(this, "Salary should be between 10000 and 50000.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Salary should be a valid number.");
                return;
            }


            if (!phone.matches("[1-9]\\d{9}")) {
                JOptionPane.showMessageDialog(this, "Phone number should be 10 digits and not start with 0.");
                return;
            }

            // Aadhar number validation: must follow the format XXXX XXXX XXXX
            if (!aadhar.matches("\\d{4} \\d{4} \\d{4}")) {
                JOptionPane.showMessageDialog(this, "Aadhar number should follow the format: XXXX XXXX XXXX and cannot have leading zeros.");
                return;
            }

            // Check for repetitive patterns like 1111 1111 1111
            String[] blocks = aadhar.split(" ");
            for (String block : blocks) {
                if (block.matches("(\\d)\\1{3}")) {
                    JOptionPane.showMessageDialog(this, "Aadhar number cannot have repetitive digits.");
                    return;
                }
            }
            // Email validation
            if (!email.matches("^[A-Za-z0-9_!&%$#*\\-\\.]+[@][a-zA-Z]+[\\.][A-Za-z]{2,3}$")) {
                JOptionPane.showMessageDialog(this, "Email is not valid.");
                return;
            }

            try{
                Connection conn= Con.getConnection();
                String q="insert into employee values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps= conn.prepareStatement(q);
                ps.setString(1,id);
                ps.setString(2,name);
                ps.setString(3,age);
                ps.setString(4,gender);
                ps.setString(5,job);
                ps.setString(6,salary);
                ps.setString(7,phone);
                ps.setString(8,email);
                ps.setString(9,aadhar);
                ps.executeUpdate();//insert data in table
                JOptionPane.showMessageDialog(null,"employee added");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);//back button
        }
    }


}
