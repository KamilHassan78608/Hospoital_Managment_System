import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_User extends JFrame {

    static JLabel welcome, main, footer;
    static JButton Salary, Bills;
    static JToolBar toolbar;


    Update_User(){
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
        
        main = new JLabel();
        main.setPreferredSize(new Dimension(400, 350));
        main.setOpaque(true);
        main.setBackground(new Color(72, 58, 160));
        main.setForeground(Color.WHITE);
        main.setLayout(null);


        Salary = new JButton("Set Salry of a Doctor");
        Salary.setFont(new Font("impact", Font.BOLD, 20));
        Salary.setBounds(100, 100, 200, 40);
        Salary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new setSalary();
            }
            
        });

        Bills = new JButton("Set Bills to a Patient");
        Bills.setFont(new Font("impact", Font.BOLD, 20));
        Bills.setBounds(100, 200, 200, 40);
        Bills.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new setBills();
            }
            
        });
        
        main.add(Bills);
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
