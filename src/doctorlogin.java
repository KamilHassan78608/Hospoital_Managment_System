import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class doctorlogin extends JFrame{

    static JLabel headlogin, main, footer;
    static JButton view, changepass;
    static JToolBar toolbar;

    doctorlogin(int ind){

        this.setTitle("Doctor Login");
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

        main = new JLabel();
        main.setPreferredSize(new Dimension(400, 350));
        main.setOpaque(true);
        main.setBackground(new Color(72, 58, 160));
        main.setForeground(Color.WHITE);

        view = new JButton("View");
        view.setBounds(100, 113, 200, 40);
        view.setFont(new Font("Arial", Font.BOLD, 20));
        view.setForeground(new Color(14, 33, 72));
        view.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new viewDoc(ind);
            }
            
        });

        changepass = new JButton("Change Password");
        changepass.setBounds(100, 226, 200, 40);
        changepass.setFont(new Font("Arial", Font.BOLD, 20));
        changepass.setForeground(new Color(14, 33, 72));
        changepass.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ChangePass(ind);
            }
            
        });

        main.add(view);
        main.add(changepass);

        footer = new JLabel("Click on the one of the button to continue");
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
