import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class setSalary extends JFrame {

    static JLabel welcome, main, footer;
    static JTextArea IdArea, SalaryArea;
    static JButton Salary, Id1;
    static JToolBar toolbar;


    setSalary(){
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
                new Update_User();
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
        
        
        main = new JLabel();
        main.setPreferredSize(new Dimension(400, 350));
        main.setOpaque(true);
        main.setBackground(new Color(72, 58, 160));
        main.setForeground(Color.WHITE);
        main.setLayout(new FlowLayout());

        IdArea = new JTextArea();
        IdArea.setPreferredSize(new Dimension(200, 30));
        IdArea.setFont(new Font("Arial", Font.BOLD, 24));

        Id1 = new JButton("Enter ID");
        Id1.setEnabled(false);
        Id1.setFont(new Font("impact", Font.BOLD, 20));
        Id1.setPreferredSize(new Dimension(120, 40));

        SalaryArea = new JTextArea();
        SalaryArea.setPreferredSize(new Dimension(200, 30));
        SalaryArea.setFont(new Font("Arial", Font.BOLD, 24));
        
        Salary = new JButton("Set Salary");
        Salary.setFont(new Font("impact", Font.BOLD, 20));
        Salary.setPreferredSize(new Dimension(120, 40));
        Salary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateDoctorSalary();
                new Update_User();
                dispose();
            }
        });

        main.add(IdArea);
        main.add(Id1);
        main.add(SalaryArea);
        main.add(Salary);
        
        footer = new JLabel("Press Add Salary to add Salary to the person");
        footer.setOpaque(true);
        footer.setBackground(new Color(14, 33, 72));
        footer.setForeground(new Color(227, 208, 149));
        footer.setFont(new Font("Arial", Font.BOLD, 18));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        this.add(toolbar, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.setVisible(true);
    }


    public void updateDoctorSalary() {
    String idText = IdArea.getText().trim();
    String salaryText = SalaryArea.getText().trim();

    if (idText.isEmpty() || salaryText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try(Connection conn = DBConnection.connect()) {
        int id = Integer.parseInt(idText);
        double salary = Double.parseDouble(salaryText);

        String sql = "UPDATE Doctor SET Salary = ? WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, salary);
        stmt.setInt(2, id);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Salary updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Doctor not found with ID: " + id);
        }

        stmt.close();
        conn.close();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Format Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
