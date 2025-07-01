import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame {

    static JLabel headlogin, section1, footLabel, id1, name1, password1;
    static JTextArea id1Area, name1Area;
    static JPasswordField password1Area;
    static JComboBox<String> comboBox1;
    static JButton loginButton;
    static JToolBar toolbar;

    Login() {
        this.setTitle("Add User");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton backButton = createBlueButton("< Back");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainLogin();
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

        section1 = new JLabel();
        section1.setLayout(new GridBagLayout());
        section1.setOpaque(true);
        section1.setBackground(new Color(72, 58, 160));
        section1.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 1;
        gbc.gridy = 0;
        comboBox1 = new JComboBox<>(new String[] { "Doctor", "Patient" });
        comboBox1.setPreferredSize(new Dimension(200, 50));
        section1.add(comboBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        id1 = new JLabel("User ID:");
        id1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(id1, gbc);
        gbc.gridx = 1;
        id1Area = new JTextArea();
        id1Area.setPreferredSize(new Dimension(200, 30));
        id1Area.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        id1Area.setMinimumSize(new Dimension(200, 30));
        id1Area.setFont(new Font("Arial", Font.BOLD, 24));

        section1.add(id1Area, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        name1 = new JLabel("Name: ");
        name1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(name1, gbc);
        gbc.gridx = 1;
        name1Area = new JTextArea();
        name1Area.setPreferredSize(new Dimension(200, 30));
        name1Area.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        name1Area.setMinimumSize(new Dimension(200, 30));
        name1Area.setColumns(4);
        name1Area.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(name1Area, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        password1 = new JLabel("Password: ");
        password1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(password1, gbc);
        gbc.gridx = 1;
        password1Area = new JPasswordField();
        password1Area.setPreferredSize(new Dimension(200, 30));
        password1Area.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        password1Area.setMinimumSize(new Dimension(200, 30));
        password1Area.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(password1Area, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("impact", Font.BOLD, 20));
        loginButton.setPreferredSize(new Dimension(120, 40));
        section1.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                user_login();
            }
        });

        footLabel = new JLabel("Click on Login button to Login");
        footLabel.setOpaque(true);
        footLabel.setBackground(new Color(14, 33, 72));
        footLabel.setForeground(new Color(227, 208, 149));
        footLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(toolbar, BorderLayout.NORTH);
        this.add(section1, BorderLayout.CENTER);
        this.add(footLabel, BorderLayout.SOUTH);
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

    void user_login() {
        int ID = Integer.parseInt(id1Area.getText());
        try (Connection conn = DBConnection.connect()) {
            String role = comboBox1.getSelectedItem().toString();
            String table;
            if (role.equalsIgnoreCase("doctor")) {
                table = "Doctor";
            } else {
                table = "Patient";
            }
            String sql = "SELECT * FROM " + table + " WHERE " + "ID = ? AND Name = ? AND Password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(id1Area.getText()));
            stmt.setString(2, name1Area.getText());
            stmt.setString(3, new String(password1Area.getPassword()));
            // this will execute the querry and store the result in a variable rs
            ResultSet rs = stmt.executeQuery();
            // if a matching vaiable to that of the rs is found it will return true
            // otherwise false
            if (rs.next()) {
                if (role.equalsIgnoreCase("doctor")) {
                    table = "Doctor";
                    new doctorlogin(ID);
                } else {
                    table = "Patient";
                    new patientlogin(ID);
                }
                JOptionPane.showMessageDialog(rootPane, "Login Succesfully");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Invalid Login!");
                new Login();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Login!" + e.getMessage());
        }
    }
}
