import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class Help extends JFrame {

    static JLabel main, footer, text1, text2, text3, text4, text5;
    static JToolBar toolbar;
    static JTextArea textArea;
    static JButton submit;
    
    Help(){
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
                new Login();
            }
            
        });
        toolbar.add(helpButton);
        
        
        main = new JLabel();
        main.setPreferredSize(new Dimension(400, 350));
        main.setOpaque(true);
        main.setBackground(new Color(72, 58, 160));
        main.setForeground(Color.WHITE);
        main.setLayout(new FlowLayout());


        text1 = new JLabel("This is System Hospital Mangment System");
        text2 = new JLabel("The first Section is Admin Used only by Admin");
        text3 = new JLabel("The second Secction is for Doctor");
        text4 = new JLabel("The other Secction is for Patient");
        text5 = new JLabel("               Leave a Comment!                  ");
        text1.setFont(new Font("Arial", Font.BOLD, 18));
        text2.setFont(new Font("Arial", Font.BOLD, 18));
        text3.setFont(new Font("Arial", Font.BOLD, 18));
        text4.setFont(new Font("Arial", Font.BOLD, 18));
        text5.setFont(new Font("Arial", Font.BOLD, 18));

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 200));

        submit = new JButton("Submit");
        submit.setFont(new Font("impact", Font.BOLD, 20));
        submit.setPreferredSize(new Dimension(120, 40));
        
        main.add(text1);
        main.add(text2);
        main.add(text3);
        main.add(text4);
        main.add(text5);
        main.add(textArea);
        main.add(submit);

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
