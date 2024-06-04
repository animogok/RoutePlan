package GUI;

import backend.InternalInformationRoute;
import backend.User;
import backend.errors.EmailException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Register_e extends buttons {

	JFrame frame;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;
	private InternalInformationRoute iir = new InternalInformationRoute();
	private JLabel email_fieldName;
	private JLabel password_Name;
	private JLabel password_NameC;

	/**
	 * Create the application.
	 */
	public Register_e(JFrame loginFrame) {
		initialize(loginFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame loginFrame) {
		frame = new JFrame();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension windowSize = new Dimension(screenSize.width, screenSize.height);

	    frame.getContentPane().setBackground(Color.white);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("Step by Step");
        frame.setUndecorated(true);
	    
	    Font customFont = CustomFont.loadFont("CDType - Voga Medium.ttf");

		// tittle panel created
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, screenSize.width, 40);
		titlePanel.setBackground(new Color(240, 240, 240));
		titlePanel.setLayout(new FlowLayout());

		// logo created
		ImageIcon logo = new ImageIcon(Register_e.class.getResource("/archivos/images/logo.png"));
		ImageIcon logoMin = new ImageIcon(new ImageIcon(Register_e.class.getResource("/archivos/images/logo.png")).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		logoLabel = new JLabel(logoMin);
		titlePanel.add(logoLabel);
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setLayout(null);

		// tittled created
		titleLabel = new JLabel("Step by Step");
		titleLabel.setFont(customFont.deriveFont(Font.BOLD, 25));
		titleLabel.setForeground(Color.BLACK);
		titlePanel.add(titleLabel);

		// Agregar el panel del título al frame
		frame.getContentPane().add(titlePanel);

	    JLabel Register_tittle = new JLabel("Register");
	    Register_tittle.setHorizontalAlignment(SwingConstants.CENTER);
	    Register_tittle.setFont(customFont.deriveFont(Font.BOLD, 65));
	    Register_tittle.setBounds(40, 180, 200, 80);
	    frame.getContentPane().add(Register_tittle);

		JLabel username_fieldName = new JLabel("Username");
	    username_fieldName.setFont(customFont.deriveFont(Font.BOLD, 35));
	    username_fieldName.setBounds(70, 300, 275, 30);
	    frame.getContentPane().add(username_fieldName);
	    
	    email_fieldName = new JLabel("Email");
	    email_fieldName.setFont(customFont.deriveFont(Font.BOLD, 35));
	    email_fieldName.setBounds(70, 400, 275, 30);
	    frame.getContentPane().add(email_fieldName);
	    
	    password_Name = new JLabel("Password");
	    password_Name.setFont(customFont.deriveFont(Font.BOLD, 35));
	    password_Name.setBounds(70, 500, 275, 30);
	    frame.getContentPane().add(password_Name);
	    
	    password_NameC = new JLabel("Password confirmation");
	    password_NameC.setFont(customFont.deriveFont(Font.BOLD, 35));
	    password_NameC.setBounds(70, 600, 300, 30);
	    frame.getContentPane().add(password_NameC);

		JTextField username_field = createTextField("Inserte el nombre de usuario aquí", 70, 350, 443, 30);
		frame.getContentPane().add(username_field);

		JTextField email_field = createTextField("Inserte el correo del usuario aquí", 70, 450, 443, 30);
		frame.getContentPane().add(email_field);

		JPasswordField password_creation = createPasswordField(70, 550, 443, 30);
		frame.getContentPane().add(password_creation);

		JPasswordField password_confirmation = createPasswordField(70, 650, 443, 30);
		frame.getContentPane().add(password_confirmation);

		// Register button
		JButton btnRegister_user = createButton("Register", new Color(70, 116, 93), 70, 700, 150, 50, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				while (true){
					User user = new User();
					String username = username_field.getText();
					String email = email_field.getText();
					try {
						iir.is_emailCorrect(email);
					} catch (EmailException ex) {
						JOptionPane.showMessageDialog(null, "Set a correct email direction", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
					String password = String.valueOf(password_creation.getPassword());
					String password2 = String.valueOf(password_confirmation.getPassword());

					if (password.length() < 8){
						JOptionPane.showMessageDialog(null, "Password must have more than 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
					if (!password.equals(password2)){
						JOptionPane.showMessageDialog(null, "Password mismatch", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}

					try {
						user.register(username, password, email);
						JOptionPane.showMessageDialog(null, "The registration has been completed, please go to the log in with the same information.", "Registration complete", JOptionPane.INFORMATION_MESSAGE);
						break;
					} catch (Exception ex) {
					}
				}
		    }
		});
		frame.getContentPane().add(btnRegister_user);
	    
		// Login button
		JButton btnLogin_user = createButton("Back to login",  new Color(80, 59, 204), 300, 700, 200, 50, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Crea y muestra la ventana estado cuando se hace clic en el botón
				Login_ex login = new Login_ex();
				login.frame.setVisible(true);
				
				// Cierra la ventana actual
				frame.setVisible(false);
		    }
		});
		frame.getContentPane().add(btnLogin_user);

		JLabel lblPortrait = new JLabel("");
        ImageIcon portrait = new ImageIcon(new ImageIcon(Register_e.class.getResource("/archivos/images/register.gif")).getImage().getScaledInstance(650, 650, Image.SCALE_DEFAULT));
        lblPortrait.setIcon(portrait);
        lblPortrait.setBounds(750, 110, 650, 650);
        frame.getContentPane().add(lblPortrait);

		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        // Solicita el foco en el JButton en lugar del JTextField
		        btnLogin_user.requestFocusInWindow();
		    }
		});

		// Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
	}
}
