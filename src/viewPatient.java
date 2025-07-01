
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class viewPatient extends JFrame{

    static JLabel headlogin, section, footer;
    static JLabel id, name, special, contact, gender, password;
    static JLabel idLabel, nameLabel, specLabel, contactLabel, genderLabel, passwordLabel;
    static JToolBar toolbar;
    static JTextField namefield;

    viewPatient(int ind){

        
        this.setTitle("View patient");
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
                new patientlogin(ind);
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
        section.setPreferredSize(new Dimension(400, 350));
        section.setOpaque(true);
        section.setBackground(new Color(72, 58, 160));
        section.setForeground(Color.WHITE);
        section.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy++;
        id  = new JLabel("User ID:");
        id.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(id, gbc);
        gbc.gridx = 1;
        idLabel = new JLabel(""+ind);
        idLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        section.add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(name, gbc);
        gbc.gridx = 1;
        nameLabel = new JLabel("Loading...");
        add(nameLabel);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        special = new JLabel("Major Problem:");
        special.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(special, gbc);
        gbc.gridx = 1;
        specLabel = new JLabel();
        specLabel.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(specLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        contact = new JLabel("Contact:");
        contact.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(contact, gbc);
        gbc.gridx=1;
        contactLabel = new JLabel();
        contactLabel.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(contactLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gender= new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(gender, gbc);
        gbc.gridx=1;
        genderLabel = new JLabel();
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(genderLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        password = new JLabel("Bills:");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(password, gbc);
        gbc.gridx=1;
        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        section.add(passwordLabel, gbc);
        
        footer = new JLabel("Click on the one of the button to continue");
        footer.setOpaque(true);
        footer.setBackground(new Color(14, 33, 72));
        footer.setForeground(new Color(227, 208, 149));
        footer.setFont(new Font("Arial", Font.BOLD, 18));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        getData(ind);
        this.add(toolbar, BorderLayout.NORTH);
        this.add(section, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
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

    private void getData(int i){
        int id = i;
        try (Connection conn = DBConnection.connect()) {
            String sql1 = "SELECT Name FROM Patient WHERE id = ?";
            String sql2 = "SELECT Specialization FROM Patient WHERE id = ?";
            String sql3 = "SELECT Contact FROM Patient WHERE id = ?";
            String sql4 = "SELECT Gender FROM Patient WHERE id = ?";
            String sql5 = "SELECT Bills FROM Patient WHERE id = ?";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            PreparedStatement stmt4 = conn.prepareStatement(sql4);
            PreparedStatement stmt5 = conn.prepareStatement(sql5);

            stmt1.setInt(1, id);
            stmt2.setInt(1, id);
            stmt3.setInt(1, id);
            stmt4.setInt(1, id);
            stmt5.setInt(1, id);
            
            ResultSet rs1 = stmt1.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();
            ResultSet rs3 = stmt3.executeQuery();
            ResultSet rs4 = stmt4.executeQuery();
            ResultSet rs5 = stmt5.executeQuery();

            if (rs1.next()) {
                String name = rs1.getString("Name");
                nameLabel.setText(""+name);
                System.out.println(name);
            }else{
                nameLabel.setText("Name Not Found");
            }
            if (rs2.next()) {
                String name = rs2.getString("Specialization");
                specLabel.setText(""+name);
                System.out.println(name);
            }else{
                specLabel.setText("Specialization Not Found");
            }
            if (rs3.next()) {
                String name = rs3.getString("Contact");
                contactLabel.setText(""+name);
                System.out.println(name);
            }else{
                contactLabel.setText("Contact Not Found");
            }
            if (rs4.next()) {
                String name = rs4.getString("Gender");
                genderLabel.setText(""+name);
                System.out.println(name);
            }else{
                genderLabel.setText("Gender Not Found");
            }
            if (rs5.next()) {
                String name = rs5.getString("Bills");
                passwordLabel.setText(""+name);
                System.out.println(name);
            }else{
                passwordLabel.setText("Bills Not Found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error! " + e, getTitle(), id);
            System.out.println("Error!"+e);
        }
    }
}
