import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Admin_open extends JFrame {
    
    static JLabel welcome_1 , main_1 , footer_1;
    static JButton AddUser , RemoveUser, UpdateUser;
    static JToolBar toolbar;

    Admin_open(){
        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton backButton = createBlueButton("< Back");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin();
            }
            
        });
        toolbar.add(backButton);

        JButton adminButton = createBlueButton("Admin");
        adminButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin();
            }
            
        });
        toolbar.add(adminButton);

        JButton doctorButton = createBlueButton("Doctor");
        doctorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
            
        });
        toolbar.add(doctorButton);

        JButton patientButton = createBlueButton("Patient");
        patientButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
            
        });
        toolbar.add(patientButton);

        JButton helpButton = createBlueButton("Help");
        doctorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Help();
            }
            
        });
        toolbar.add(helpButton);

        main_1 = new JLabel();
        main_1.setPreferredSize(new Dimension(400, 350));
        main_1.setOpaque(true);
        main_1.setBackground(new Color(72, 58, 160));
        main_1.setForeground(Color.WHITE);

        AddUser = new JButton("Add User");
        AddUser.setBounds(120, 70, 150, 40);
        AddUser.setFont(new Font("Arial", Font.BOLD, 20));
        AddUser.setForeground(new Color(14, 33, 72));
        AddUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Add_user();
            }
            
        });

        RemoveUser = new JButton("Remove User");
        RemoveUser.setBounds(120, 140, 150, 40);
        RemoveUser.setFont(new Font("Arial", Font.BOLD, 20));
        RemoveUser.setForeground(new Color(14, 33, 72));
        RemoveUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Remove_User();
            }
            
        });

        UpdateUser = new JButton("Update User");
        UpdateUser.setBounds(120, 210, 150, 40);
        UpdateUser.setFont(new Font("Arial", Font.BOLD, 20));
        UpdateUser.setForeground(new Color(14, 33, 72));
        UpdateUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Update_User();
            }
            
        });


        main_1.add(AddUser);
        main_1.add(RemoveUser);
        main_1.add(UpdateUser);
        
        footer_1 = new JLabel("Click on the one of the button to continue.....");
        footer_1.setOpaque(true);
        footer_1.setBackground(new Color(14, 33, 72));
        footer_1.setForeground(new Color(227, 208, 149));
        footer_1.setFont(new Font("Arial", Font.BOLD, 18));
        footer_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.add(toolbar, BorderLayout.NORTH);
        this.add(main_1, BorderLayout.CENTER);
        this.add(footer_1, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private static JButton createBlueButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLUE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
