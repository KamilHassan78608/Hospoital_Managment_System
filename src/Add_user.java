import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class DBConnection{
    static Connection connect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Managment_System", "root", "kamilhassan786");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + e, "Error", 0);
            return null;
        }
    }
}

public class Add_user extends JFrame {

    JLabel header, section, foot, role, id, name, special, age, contact, gender, password;
    JTextField idField, nameField, ageField, specField, contactField, genderField, passwordField;
    JComboBox<String> rolebox;
    JButton addButton;
    static JToolBar toolbar;
    


    Add_user(){
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
                new Admin_open();
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

        section = new JLabel();
        section.setLayout(new GridBagLayout());
        section.setOpaque(true);
        section.setBackground(new Color(72, 58, 160));
        section.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;


        gbc.gridx = 0;
        gbc.gridy = 0;
        role = new JLabel("Role:");
        role.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(role, gbc);
        gbc.gridx = 1;
        rolebox = new JComboBox<>(new String[] {"Doctor", "Patient"});
        rolebox.setPreferredSize(new Dimension(50, 25));
        section.add(rolebox, gbc);


        gbc.gridx = 0;
        gbc.gridy++;
        id  = new JLabel("User ID:");
        id.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(id, gbc);
        gbc.gridx = 1;
        idField = new JTextField();
        section.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(name, gbc);
        gbc.gridx = 1;
        nameField = new JTextField();
        section.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        special = new JLabel("Special:");
        special.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(special, gbc);
        gbc.gridx = 1;
        specField = new JTextField();
        section.add(specField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        contact = new JLabel("Contact:");
        contact.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(contact, gbc);
        gbc.gridx=1;
        contactField = new JTextField();
        section.add(contactField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gender= new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(gender, gbc);
        gbc.gridx=1;
        genderField = new JTextField();
        section.add(genderField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(password, gbc);
        gbc.gridx=1;
        passwordField = new JTextField();
        section.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        addButton = new JButton("Add");
        addButton.setFont(new Font("impact", Font.BOLD, 20));
        addButton.setPreferredSize(new Dimension(120, 40));
        section.add(addButton, gbc);
        addButton.addActionListener(e -> Add_User());

        //setting the fotter
        foot = new JLabel("Click on the Add button to add User");
        foot.setOpaque(true);
        foot.setBackground(new Color(14, 33, 72));
        foot.setForeground(new Color(227, 208, 149));
        foot.setFont(new Font("Arial", Font.BOLD, 18));
        foot.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(toolbar, BorderLayout.NORTH);
        this.add(section, BorderLayout.CENTER);
        this.add(foot, BorderLayout.SOUTH);
        this.setVisible(true);
    }


    void Add_User() {
        String role = rolebox.getSelectedItem().toString().toLowerCase();

        try (Connection conn = DBConnection.connect()){
            String sql;
            if (role.equalsIgnoreCase("Doctor")) {
                sql = "INSERT INTO Doctor(ID, Name, Specialization, Contact, Gender, Password) VALUES (?, ?, ?, ?, ?, ?)";
            }else{
                sql = "INSERT INTO Patient(ID, Name, Specialization, Contact, Gender, Password) VALUES (?, ?, ?, ?, ?, ?)";
            }
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idField.getText());
            stmt.setString(2, nameField.getText());
            stmt.setString(3, specField.getText());
            stmt.setString(4, contactField.getText());
            stmt.setString(5, genderField.getText());
            stmt.setString(6, passwordField.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Added Succesfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
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
