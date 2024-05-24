package GUI;

import java.awt.*;

import javax.swing.*;

import backend.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Login_ex {
	
	/*
	 * 
	 * 
	 */

	private String username;
	private String password;
	private boolean user_registered = true;

	private User user = new User();

	private JFrame frame;
	private JTextField user_login;
	private JPasswordField password_login;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_ex window = new Login_ex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_ex() {
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

	    frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setLayout(new GridLayout(0, 3, 10, 0));

	    JPanel left_panel = new JPanel();
	    frame.getContentPane().add(left_panel);
	    left_panel.setLayout(new CardLayout(0, 0));

	    // Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
	    
	    JPanel inner_panel = new JPanel();
	    frame.getContentPane().add(inner_panel);
	    inner_panel.setLayout(null);
	    
	    Font customFont = CustomFont.loadFont("CDType - Voga Medium.ttf");
	    JLabel login_tittle = new JLabel("Step by Step");
	    login_tittle.setHorizontalAlignment(SwingConstants.CENTER);
	    login_tittle.setFont(customFont.deriveFont(Font.BOLD, 65));
	    login_tittle.setBounds(92, 200, 257, 80);
	    inner_panel.add(login_tittle);
	    
	    user_login = new JTextField();
	    user_login.setBorder(UIManager.getBorder("Tree.editorBorder"));
	    user_login.setBounds(0, 350, 443, 30);
	    inner_panel.add(user_login);
	    
	    password_login = new JPasswordField();
	    password_login.setBorder(UIManager.getBorder("Tree.editorBorder"));
	    password_login.setBounds(0, 440, 443, 30);
	    inner_panel.add(password_login);
	    
	    JLabel user_loginTittle = new JLabel("Username");
	    user_loginTittle.setFont(customFont.deriveFont(Font.BOLD, 30));
	    user_loginTittle.setBounds(10, 316, 150, 23);
	    inner_panel.add(user_loginTittle);
	    
	    JLabel password_loginTittle = new JLabel("Password");
	    password_loginTittle.setFont(customFont.deriveFont(Font.BOLD, 30));
	    password_loginTittle.setBounds(10, 400, 150, 23);
	    inner_panel.add(password_loginTittle);
	    
	    JButton log_in = new JButton("Log In");
	    log_in.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            username = user_login.getText();
	            password = String.valueOf(password_login.getPassword());

	            try {
	                if(user.login(username, password)){
	                } else {
	                	int choice = JOptionPane.showConfirmDialog(null, "Want to create an account", "choose one", JOptionPane.YES_NO_OPTION);
	                	
	                	if (choice == JOptionPane.YES_OPTION) {
	                		user_registered = false;
							frame.dispose();
	                	}
	                }
	            } catch (Exception e1) {
	                JOptionPane.showMessageDialog(null, "Username or Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    log_in.setBackground(UIManager.getColor("CheckBox.background"));
	    log_in.setBounds(0, 500, 89, 23);
	    inner_panel.add(log_in);
	    
	    JButton btnNewButton = new JButton("Sign Up");
	    btnNewButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frame.dispose();
	    	}
	    });
	    btnNewButton.setBounds(354, 500, 89, 23);
	    inner_panel.add(btnNewButton);
	    
	    
	    JPanel right_panel = new JPanel();
	    frame.getContentPane().add(right_panel);
	    right_panel.setLayout(new GridLayout(0, 1, 0, 0));;
	}
	
	public boolean get_userRegistered() {
		return user_registered;
	}
}
