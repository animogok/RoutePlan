package GUI;

import backend.InternalInformationRoute;
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends buttons{

    JFrame frame;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;

	/**
	 * Create the application.
	 */
	public Board(String username, InternalInformationRoute user) {
		initialize(username, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username, InternalInformationRoute user) {
	    frame = new JFrame();
	       
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension windowSize = new Dimension(screenSize.width, screenSize.height);

	    frame.getContentPane().setBackground(Color.white);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("Step by Step");
        frame.setUndecorated(true);

        // Custom font
		Font customFont = CustomFont.loadFont("CDType - Voga Medium.ttf");

        // tittle panel created
 		titlePanel = new JPanel();
 		titlePanel.setBounds(0, 0, screenSize.width, 40);
 		titlePanel.setBackground(new Color(240, 240, 240));
 		titlePanel.setLayout(new FlowLayout());

 		// logo created
 		ImageIcon logo = new ImageIcon(Planificator.class.getResource("/archivos/images/logo.png"));
 		ImageIcon logoMin = new ImageIcon(new ImageIcon(Planificator.class.getResource("/archivos/images/logo.png")).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
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

        // Welcome to the user
 		JLabel lblWelcome = new JLabel("Welcome " + username + ", what do you want to do?"); // poner el nombre del usuario registrado
        lblWelcome.setFont(customFont.deriveFont(Font.BOLD, 40));
        lblWelcome.setForeground(Color.DARK_GRAY);
        lblWelcome.setBounds(28, 110, 700, 40);
        frame.getContentPane().add(lblWelcome);

		// General map
		JLabel lblGeneralMap = new JLabel("Here is the map to take a look");
		lblGeneralMap.setFont(customFont.deriveFont(Font.BOLD, 40));
		lblGeneralMap.setForeground(Color.DARK_GRAY);
		lblGeneralMap.setBounds(28, 170, 700, 40);
		frame.getContentPane().add(lblGeneralMap);

        // My routes button
		JButton btnMyRoutes = createButton("My routes", new Color(80, 59, 204), 750, 700, 200, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				// Aquí tengo que crear otra ventana en la que se almacenen las rutas ingresadas anteriormente...
		    }
		});
		frame.getContentPane().add(btnMyRoutes);

        // Planificate a route button
		JButton btnPlanificate = createButton("Planificate a route", new Color(70, 116, 93), 1000, 700, 250, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				// Crea y muestra la ventana estado cuando se hace clic en el botón
				Planificator planificator = new Planificator(frame, user);
				planificator.frame.setVisible(true);
				
				// Cierra la ventana actual
				frame.setVisible(false);
		    }
		});
		frame.getContentPane().add(btnPlanificate);
 		
        // Exit button
		JButton btnExit = createButton("Exit", new Color(229, 57, 53), 1300, 700, 150, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				user.save_infoByclossinSession();
		    	System.exit(0);
		    }
		});
		frame.getContentPane().add(btnExit);

		JLabel lblMap = new JLabel("");
        ImageIcon map = new ImageIcon(new ImageIcon(Planificator.class.getResource("/archivos/images/General_map.PNG")).getImage().getScaledInstance(700, 550, Image.SCALE_DEFAULT));
        lblMap.setIcon(map);
        lblMap.setBounds(28, 240, 700, 550);
		// Agregar un marco a la imagen
		lblMap.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        frame.getContentPane().add(lblMap);

        JLabel lblPortrait = new JLabel("");
        ImageIcon portrait = new ImageIcon(new ImageIcon(Planificator.class.getResource("/archivos/images/portrait2.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));
        lblPortrait.setIcon(portrait);
        lblPortrait.setBounds(900, 90, 550, 550);
        frame.getContentPane().add(lblPortrait);

        // Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
	    
	}
    
}
