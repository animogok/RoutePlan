package GUI;

import backend.InternalInformationRoute;
import backend.User;
import backend.errors.EmailException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register_e {

	JFrame frame;
	private InternalInformationRoute iir = new InternalInformationRoute();
	private JTextField username_field;
	private JTextField email_field;
	private JPasswordField password_creation;
	private JPasswordField password_confirmation;
	private JLabel email_fieldName;
	private JLabel password_Name;
	private JLabel password_NameC;

	/**
	 * Create the application.
	 */
	public Register_e() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	    frame.setAutoRequestFocus(false);
	       
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension windowSize = new Dimension(screenSize.width, screenSize.height);
	    frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
	    
	    JPanel right_Panel = new JPanel();
	    frame.getContentPane().add(right_Panel);
	    
	    JPanel innerPanel = new JPanel();
	    frame.getContentPane().add(innerPanel);
	    innerPanel.setLayout(null);
	    
	    Font customFont = CustomFont.loadFont("CDType - Voga Medium.ttf");
	    JLabel Register_tittle = new JLabel("Register");
	    Register_tittle.setHorizontalAlignment(SwingConstants.CENTER);
	    Register_tittle.setFont(customFont.deriveFont(Font.BOLD, 65));
	    Register_tittle.setBounds(91, 175, 240, 80);
	    innerPanel.add(Register_tittle);
	    
	    username_field = new JTextField();
	    username_field.setBounds(10, 300, 430, 25);
	    innerPanel.add(username_field);
	    username_field.setColumns(10);
	    
	    email_field = new JTextField();
	    email_field.setBounds(10, 375, 430, 25);
	    innerPanel.add(email_field);
	    email_field.setColumns(10);
	    
	    password_creation = new JPasswordField();
	    password_creation.setBounds(10, 450, 430, 25);
	    innerPanel.add(password_creation);
	    
	    password_confirmation = new JPasswordField();
	    password_confirmation.setBounds(10, 525, 430, 25);
	    innerPanel.add(password_confirmation);
	    
	    JLabel username_fieldName = new JLabel("Username");
	    username_fieldName.setFont(customFont.deriveFont(Font.BOLD, 35));
	    username_fieldName.setBounds(10, 270, 275, 25);
	    innerPanel.add(username_fieldName);
	    
	    email_fieldName = new JLabel("Email");
	    email_fieldName.setFont(customFont.deriveFont(Font.BOLD, 35));
	    email_fieldName.setBounds(10, 340, 275, 25);
	    innerPanel.add(email_fieldName);
	    
	    password_Name = new JLabel("Password");
	    password_Name.setFont(customFont.deriveFont(Font.BOLD, 35));
	    password_Name.setBounds(10, 415, 275, 25);
	    innerPanel.add(password_Name);
	    
	    password_NameC = new JLabel("Password confirmation");
	    password_NameC.setFont(customFont.deriveFont(Font.BOLD, 35));
	    password_NameC.setBounds(10, 490, 300, 25);
	    innerPanel.add(password_NameC);
	    
	    JButton register_user = new JButton("Register");
	    register_user.addActionListener((ActionEvent e) -> {
                User user = new User();
                String username = username_field.getText();
				String email = email_field.getText();
                try {
                    iir.is_emailCorrect(email);
                } catch (EmailException ex) {
                    JOptionPane.showMessageDialog(null, "Set a correct email direction", "Error", JOptionPane.ERROR_MESSAGE);
                }
				String password = String.valueOf(password_creation.getPassword());
				String password2 = String.valueOf(password_confirmation.getPassword());

				if (password.length() < 8){
					JOptionPane.showMessageDialog(null, "Password must have more than 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (!password.equals(password2)){
					JOptionPane.showMessageDialog(null, "Password mismatch", "Error", JOptionPane.ERROR_MESSAGE);
				}

                try {
                    user.register(username, email, password);
                } catch (Exception ex) {
				}
				
        });
		
	    register_user.setBounds(10, 580, 89, 23);
	    innerPanel.add(register_user);
	    
	    JButton login_user = new JButton("Login");
	    login_user.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				Login_ex login = new Login_ex();
				login.frame.setVisible(true);
				frame.dispose();
	    	}
	    });

	    login_user.setBounds(351, 580, 89, 23);
	    innerPanel.add(login_user);
	    
	    JPanel left_panel = new JPanel();
	    frame.getContentPane().add(left_panel);

		frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
	}
}
