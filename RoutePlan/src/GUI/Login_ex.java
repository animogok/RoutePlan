package GUI;

import backend.InternalInformationRoute;
import backend.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Login_ex extends buttons{
	
	private boolean sign_up = false;
	
	private String username;
	private String password;

	private final User user = new User();

	JFrame frame;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;

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
		ImageIcon logo = new ImageIcon(Login_ex.class.getResource("/archivos/images/logo.png"));
		ImageIcon logoMin = new ImageIcon(new ImageIcon(Login_ex.class.getResource("/archivos/images/logo.png")).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
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

	    JLabel login_tittle = new JLabel("Welcome to Step by Step");
	    login_tittle.setHorizontalAlignment(SwingConstants.CENTER);
	    login_tittle.setFont(customFont.deriveFont(Font.BOLD, 65));
	    login_tittle.setBounds(40, 150, 500, 80);
	    frame.getContentPane().add(login_tittle);

		JLabel user_loginTittle = new JLabel("Username");
	    user_loginTittle.setFont(customFont.deriveFont(Font.BOLD, 30));
	    user_loginTittle.setBounds(70, 300, 150, 35);
	    frame.getContentPane().add(user_loginTittle);
	    
	    JLabel password_loginTittle = new JLabel("Password");
	    password_loginTittle.setFont(customFont.deriveFont(Font.BOLD, 30));
	    password_loginTittle.setBounds(70, 400, 150, 35);
	    frame.getContentPane().add(password_loginTittle);

		JTextField user_login = createTextField("Inserte el nombre de usuario aquí", 70, 350, 443, 30);
		frame.getContentPane().add(user_login);

		JPasswordField password_login = createPasswordField(70, 450, 443, 30);
		frame.getContentPane().add(password_login);
	    
		// login button
		JButton log_in;
            log_in = createButton("Log In", new Color(70, 116, 93), 70, 500, 150, 50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    username = user_login.getText();
                    password = String.valueOf(password_login.getPassword());
                    
                    try {
                        if(user.login(username, password)){
                            // Crea y muestra la ventana estado cuando se hace clic en el botón
                            InternalInformationRoute internal = new InternalInformationRoute();
							internal.set_userExist(username, password);
							if (!internal.get_userExist()){
								System.out.println("Gola");
								internal.seriralize_User(username, password);
								Board board = new Board(username, internal);
								board.frame.setVisible(true);
								// Cierra la ventana actual
								frame.setVisible(false);
							} else if(internal.get_userExist()){
								System.out.println("Gola");
								internal.delete_user(username, password);
								InternalInformationRoute internal2 = new InternalInformationRoute();
								internal2.seriralize_User(internal.get_userExMap().get("username"), internal.get_userExMap().get("password"));
								internal2.set_update_userInfo(internal.get_userExMap());
								Board board = new Board(username, internal2);
								board.frame.setVisible(true);
								// Cierra la ventana actual
								frame.setVisible(false);
							}
                        } else {
                            int choice = JOptionPane.showConfirmDialog(null, "Want to create an account?", "choose one", JOptionPane.YES_NO_OPTION);
                            
                            if (choice == JOptionPane.YES_OPTION) {
                                // Crea y muestra la ventana estado cuando se hace clic en el botón
                                Register_e register = new Register_e(frame);
                                register.frame.setVisible(true);
                                
                                // Cierra la ventana actual
                                frame.setVisible(false);
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Username or Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
		frame.getContentPane().add(log_in);

		// Register button
		JButton btnRegister = createButton("Register",  new Color(80, 59, 204), 350, 500, 150, 50, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			
		    	// Crea y muestra la ventana estado cuando se hace clic en el botón
				Register_e register = new Register_e(frame);
				register.frame.setVisible(true);
				
				// Cierra la ventana actual
				frame.setVisible(false);
		    }
		});
		frame.getContentPane().add(btnRegister);

		// Exit button
		JButton btnExit = createButton("Exit", new Color(229, 57, 53), 200, 700, 150, 50, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		});
		frame.getContentPane().add(btnExit);

		JLabel lblPortrait = new JLabel("");
        ImageIcon portrait = new ImageIcon(new ImageIcon(Login_ex.class.getResource("/archivos/images/welcome.gif")).getImage().getScaledInstance(650, 650, Image.SCALE_DEFAULT));
        lblPortrait.setIcon(portrait);
        lblPortrait.setBounds(750, 110, 650, 650);
        frame.getContentPane().add(lblPortrait);

		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        // Solicita el foco en el JButton en lugar del JTextField
		        btnExit.requestFocusInWindow();
		    }
		});

		// Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
		
	}
	
	public boolean get_sign_up() {
		return sign_up;
	}
	

    private void setSign_up(boolean sign_up) {
        this.sign_up = sign_up;
    }

}
