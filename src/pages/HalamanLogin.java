package pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HalamanLogin extends JFrame implements ActionListener{
    private JLabel lblUsername, lblPassword, lblStatus;
    private JTextField username;
    private JPasswordField password;
    private JButton bLgn;
    
    public HalamanLogin(){
        setTitle("Halaman Login");
        lblUsername = new JLabel("Username: ");
        username = new JTextField(20);
        lblPassword = new JLabel("Password: ");
        password = new JPasswordField(20);
        bLgn = new JButton("Login");
        bLgn.addActionListener(this);
        lblStatus = new JLabel("");
        
        setLayout(null);
        add(lblUsername);
        add(username);
        add(lblPassword);
        add(password);
        add(bLgn);
        add(lblStatus);
        
        lblUsername.setBounds(10,10,120,20);
        username.setBounds(85,10,150,20);
        lblPassword.setBounds(10,35,120,20);
        password.setBounds(85,35,150,20);
        bLgn.setBounds(70,60,120,20);
        lblStatus.setBounds(85,80,120,20);
        
        setSize(270,150);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = username.getText();
        String Password = new String(password.getPassword());
        
        if(Username.equals("pbo") && Password.equals("if-d")){
            new HalamanUtama();
            dispose();
        } else
            lblStatus.setText("Gagal Login");
    }
}
