package reception;

import hotelmanagementsystem.Con;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class NewGuest extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textFieldName, textAmount;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton add, back;

    public NewGuest(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 102, 102));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550, 100, 200, 200);
        panel.add(imglabel);

        JLabel labelName = new JLabel("NEW GUEST FORM");
        labelName.setBounds(550, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID No:");
        labelID.setBounds(50, 76, 200, 14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving License"});
        comboBox.setBounds(250, 73, 150, 20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(50, 111, 200, 14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(250, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(50, 151, 200, 14);
        labelName1.setForeground(Color.WHITE);
        labelName1.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelName1);

        textFieldName = new JTextField();
        textFieldName.setBounds(250, 151, 150, 20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(50, 191, 200, 14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(255, 102, 102));
        r1.setBounds(250, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(255, 102, 102));
        r2.setBounds(330, 191, 80, 15);
        panel.add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);


        JLabel labelRoom = new JLabel("Allocated Room No:");
        labelRoom.setBounds(50, 231, 200, 14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelRoom);


        c1 = new Choice();
        try {
            Connection conn = Con.getConnection();
            String q="select * from room";
            PreparedStatement ps=conn.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                c1.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(250, 231, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(50, 280, 200, 14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelCIS);

        Date date1 = new Date();


        date = new JLabel("" + date1);//get current date
        date.setBounds(250, 280, 200, 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);

        JLabel labelAmount = new JLabel("Amount Paid :");
        labelAmount.setBounds(50, 320, 200, 14);
        labelAmount.setForeground(Color.WHITE);
        labelAmount.setFont(new Font("serif", Font.BOLD, 17));
        panel.add(labelAmount);

        textAmount = new JTextField();
        textAmount.setBounds(250, 320, 150, 20);
        panel.add(textAmount);

        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String radioBTn = null;
            if (r1.isSelected()) {
                radioBTn = "Male";
            } else if (r2.isSelected()) {
                radioBTn = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textFieldName.getText();
            String s4 = radioBTn;
            String s5 = c1.getSelectedItem();
            String s6 = date.getText();
            String s7 = textAmount.getText();



            // Validate ID number based on the selected type
            if (s1.equals("Aadhar Card")) {
                // Validate Aadhar number: 12 digits with spaces after every 4 digits
                if (!s2.matches("\\d{4} \\d{4} \\d{4}")) {
                    JOptionPane.showMessageDialog(this, "Aadhar number should follow the format: XXXX XXXX XXXX.");
                    return;
                }
            }

            // Check for repetitive patterns like 1111 1111 1111 or 1234 5678 9876
            String[] blocks = s1.split(" ");
            for (String block : blocks) {
                if (block.matches("(\\d)\\1{3}")) { // Check if all digits are the same (e.g., 1111)
                    JOptionPane.showMessageDialog(this, "Aadhar number cannot have repetitive digits like 1111, 2222, etc.");
                    return;
                }
            }

            if (s1.equals("Driving License") || s1.equals("Passport") || s1.equals("Voter ID")) {
                // Check for repetitive patterns like A0000000, ABC1111111, DHL00000, etc.
                if (s2.matches("[A-Za-z]{1,3}\\d{7}") && s2.matches(".*(\\d)\\1{3}.*")) {
                    JOptionPane.showMessageDialog(this, s1 + " cannot have repetitive patterns ");
                    return;
                }
            }


            try{
                if (s2.length() <= 3) {
                    String firstThreeLetters = s2.substring(0, 3).toLowerCase(); // Convert to lowercase to handle case-insensitivity

                    // Check if the first three characters contain repeating alphabets
                    if (firstThreeLetters.charAt(0) == firstThreeLetters.charAt(1) ||
                            firstThreeLetters.charAt(0) == firstThreeLetters.charAt(2) ||
                            firstThreeLetters.charAt(1) == firstThreeLetters.charAt(2)) {
                        JOptionPane.showMessageDialog(this, s1 + " should not have repeating alphabets in the first three characters.");
                        return;
                    }
                } else {
                    // If the string is too short to check the first 3 characters, handle it
                    JOptionPane.showMessageDialog(this, "ID number should not contain special character.");
                    return;
                }

            }catch(Exception E){
                JOptionPane.showMessageDialog(this, "Error in ID validation: ");
            }


                if (s1.equals("Passport")) {
                if (!s2.matches("[A-Za-z]{1}\\d{7}")) {
                    JOptionPane.showMessageDialog(this, "Passport number should start with letter and should not contain special characters.");
                    return;
                }

            }

            if (s1.equals("Driving License")) {
                if (!s2.matches("[A-Za-z]{1,3}-\\d{10}")) {
                    JOptionPane.showMessageDialog(this, "Driving license number should start with letter and should not contain special characters.");
                    return;
                }
            }

            if (s1.equals("Voter ID")) {
                if (!s2.matches("[A-Za-z]{3}\\d{7}")) {
                    JOptionPane.showMessageDialog(this, "Voter ID number should start with letter and should not contain special characters.");
                    return;
                }
            }

            // Validation for name (only alphabetic characters)
            if (!s3.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Name should only contain alphabets and spaces.");
                return;
            }
            // Check if the name is too long
            if (s3.length() > 20) {
                JOptionPane.showMessageDialog(this, "Name cannot be longer than 20 alphabets.");
                return;
            }

            // Validation for amount (numeric and within a valid range)
            try {
                int parsedA = Integer.parseInt(s7);
                if (parsedA < 3000 || parsedA >6000) {
                    JOptionPane.showMessageDialog(this, "Pay RS.3000 for single room and Rs.6000 for double room");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Amount should be a valid number.");
                return;
            }



            try {
                // Check if the selected room is already occupied
                Connection connection=Con.getConnection();
                connection.setAutoCommit(false);
                String checkRoomQuery = "SELECT availability FROM room WHERE roomnumber = ?";
                PreparedStatement ps= connection.prepareStatement(checkRoomQuery);
                ps.setString(1,s5);
                ResultSet rs=ps.executeQuery();
                if (rs.next()) {
                    String availability = rs.getString("availability");
                    //This checks if the room's availability is "occupied".
                    if ("occupied".equals(availability)) {
                        JOptionPane.showMessageDialog(this, "Room " + s5 + " is already occupied. Please choose another room.");
                        return;
                    }
                }

                // Insert new customer record into the database
                String insertCustomerQuery = "INSERT INTO guest VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps1=connection.prepareStatement(insertCustomerQuery);
                ps1.setString(1,s1);
                ps1.setString(2,s2);
                ps1.setString(3,s3);
                ps1.setString(4,s4);
                ps1.setString(5,s5);
                ps1.setString(6,s6);
                ps1.setString(7,s7);
                ps1.executeUpdate();

                // Update the room's availability to 'occupied'
                String updateRoomQuery = "UPDATE room SET availability = 'occupied' WHERE roomnumber = ?";
                PreparedStatement ps2= connection.prepareStatement(updateRoomQuery);
                ps2.setString(1,s5);
                ps2.executeUpdate();
                connection.commit();
                JOptionPane.showMessageDialog(null, "Guest added successfully!");
                setVisible(false);  // Close the form or navigate as needed

            } catch (Exception E) {
                E.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while adding the guest.");

            }




        } else {
            setVisible(false);
        }
    }


}
