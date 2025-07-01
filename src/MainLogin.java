import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLogin extends JFrame {

    static JLabel welcome, main, footer;
    static JButton doctor, patient, records, new_user;


    MainLogin(){
        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());
        this.setResizable(false);


        welcome = new JLabel("Welcome to Hospital Mangment Center");
        welcome.setPreferredSize(new Dimension(400, 100));
        welcome.setOpaque(true);
        welcome.setBackground(new Color(14, 33, 72));
        welcome.setForeground(new Color(227, 208, 149));
        welcome.setFont(new Font("impact", Font.BOLD, 22));
        welcome.setVerticalAlignment(SwingConstants.CENTER);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        main = new JLabel();
        main.setPreferredSize(new Dimension(400, 350));
        main.setOpaque(true);
        main.setBackground(new Color(72, 58, 160));
        main.setForeground(Color.WHITE);

        doctor = new JButton("Doctor");
        doctor.setBounds(140, 50, 120, 40);
        doctor.setFont(new Font("Arial", Font.BOLD, 20));
        doctor.setForeground(new Color(14, 33, 72));
        doctor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
            
        });

        patient = new JButton("Patient");
        patient.setBounds(140, 110, 120, 40);
        patient.setFont(new Font("Arial", Font.BOLD, 20));
        patient.setForeground(new Color(14, 33, 72));
        patient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
            
        });

        new_user = new JButton("Admin");
        new_user.setBounds(140, 180, 120, 40);
        new_user.setFont(new Font("Arial", Font.BOLD, 20));
        new_user.setForeground(new Color(14, 33, 72));
        new_user.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin();
            }
            
        });
        
        

        main.add(doctor);
        main.add(patient);
        main.add(new_user);
        
        footer = new JLabel("Click on the one of the button to continue");
        footer.setOpaque(true);
        footer.setBackground(new Color(14, 33, 72));
        footer.setForeground(new Color(227, 208, 149));
        footer.setFont(new Font("Arial", Font.BOLD, 18));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        this.add(welcome, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
