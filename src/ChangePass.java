import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class ChangePass extends JFrame {

    static JLabel headlogin, section1, footLabel, id1, name1, password1;
    static JTextArea oldPassword, newPassword, confirmPassword;
    static JPasswordField password1Area;
    static JComboBox<String> comboBox1;
    static JButton loginButton;
    static JToolBar toolbar;

    ChangePass(int ind) {
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
                new doctorlogin(ind);
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
                new doctorlogin(ind);
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

        gbc.gridx = 0;
        gbc.gridy++;
        id1 = new JLabel("Old Password");
        id1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(id1, gbc);
        gbc.gridx = 1;
        oldPassword = new JTextArea();
        oldPassword.setPreferredSize(new Dimension(200, 30));
        oldPassword.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        oldPassword.setMinimumSize(new Dimension(200, 30));
        oldPassword.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(oldPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        name1 = new JLabel("New Password: ");
        name1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(name1, gbc);
        gbc.gridx = 1;
        newPassword = new JTextArea();
        newPassword.setPreferredSize(new Dimension(200, 30));
        newPassword.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        newPassword.setMinimumSize(new Dimension(200, 30));
        newPassword.setColumns(4);
        newPassword.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(newPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        password1 = new JLabel("Confirm: ");
        password1.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(password1, gbc);
        gbc.gridx = 1;
        confirmPassword = new JTextArea();
        confirmPassword.setPreferredSize(new Dimension(200, 30));
        confirmPassword.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
        confirmPassword.setMinimumSize(new Dimension(200, 30));
        confirmPassword.setFont(new Font("Arial", Font.BOLD, 24));
        section1.add(confirmPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        loginButton = new JButton("Change");
        loginButton.setFont(new Font("impact", Font.BOLD, 20));
        loginButton.setPreferredSize(new Dimension(120, 40));
        section1.add(loginButton, gbc);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_Password(ind);
                dispose();
                new doctorlogin(ind);
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

    private void change_Password(int ind) {
        String oldPass = oldPassword.getText().trim();
        String newPass = newPassword.getText().trim();
        String confirmPass = confirmPassword.getText().trim();

        if (oldPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }

        if (!newPass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "New passwords do not match!");
            return;
        }

        try (Connection con = DBConnection.connect()) {

            String sql = "SELECT Password FROM Doctor WHERE ID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, ind); // `ind` is the doctor ID passed to constructor
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String dbOldPass = rs.getString("Password");

                if (dbOldPass.equals(oldPass)) {
                    String updateSql = "UPDATE Doctor SET Password = ? WHERE ID = ?";
                    PreparedStatement updatePst = con.prepareStatement(updateSql);
                    updatePst.setString(1, newPass);
                    updatePst.setInt(2, ind);
                    int updated = updatePst.executeUpdate();

                    if (updated > 0) {
                        JOptionPane.showMessageDialog(null, "Password changed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password update failed.");
                    }

                    updatePst.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Old password is incorrect!");
                }
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
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
