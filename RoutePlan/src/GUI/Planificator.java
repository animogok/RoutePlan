package GUI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Planificator extends buttons{

    JFrame frame;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;

	/**
	 * Create the application. 
	 */
	public Planificator(JFrame board) {
		initialize(board);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame board) {
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

		// Title of the frame
		JLabel lblTitle = new JLabel("Select a vehicle and at least two cities to planificate the route");
        lblTitle.setFont(customFont.deriveFont(Font.BOLD, 40));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(380, 50, 1500, 40);
        frame.getContentPane().add(lblTitle);
 		
 		// Vehicle selection
 		JLabel lblVehicles = new JLabel("Select a vehicle:");
		lblVehicles.setFont(customFont.deriveFont(Font.BOLD, 35));
		lblVehicles.setForeground(Color.DARK_GRAY);
		lblVehicles.setBounds(28, 110, 220, 40);
		frame.getContentPane().add(lblVehicles);
		
		// Radio buttons with cyan color from Material Design
		JRadioButton radioBtnPlane = createRadioButton("Plane", new Color(0, 188, 212), 28, 170, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón Plane
		    }
		});
		frame.getContentPane().add(radioBtnPlane);

		JRadioButton radioBtnCar = createRadioButton("Car", new Color(0, 188, 212), 28, 210, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón Car
		    }
		});
		frame.getContentPane().add(radioBtnCar);
        
		JRadioButton radioBtnMotorbike = createRadioButton("Motorbike", new Color(0, 188, 212), 28, 250, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnMotorbike);
		
		JRadioButton radioBtnPassengerbus = createRadioButton("Passenger bus", new Color(0, 188, 212), 28, 290, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnPassengerbus);
		
		JRadioButton radioBtnHeavyvehicle = createRadioButton("Heavy vehicle", new Color(0, 188, 212), 28, 330, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnHeavyvehicle);

		// Creates button group of vehicles to be just one selected
		ButtonGroup bgVehicles = new ButtonGroup();
        bgVehicles.add(radioBtnPlane);
        bgVehicles.add(radioBtnCar);
		bgVehicles.add(radioBtnMotorbike);
        bgVehicles.add(radioBtnPassengerbus);
		bgVehicles.add(radioBtnHeavyvehicle);
        
        // Selection of the first city to travel
        JLabel lblCities1 = new JLabel("First city of the travel:");
        lblCities1.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCities1.setForeground(Color.DARK_GRAY);
        lblCities1.setBounds(28, 470, 483, 40);
		frame.getContentPane().add(lblCities1);
		
		// Radio buttons with blue color from Material Design
		JRadioButton radioBtnBogota1 = createRadioButton("Bogotá", new Color(0, 145, 234), 28, 530, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnBogota1);
		
		JRadioButton radioBtnIbague1 = createRadioButton("Ibagué", new Color(0, 145, 234), 28, 570, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnIbague1);
		
		JRadioButton radioBtnArmenia1 = createRadioButton("Armenia", new Color(0, 145, 234), 28, 610, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnArmenia1);
		
		JRadioButton radioBtnPereira1 = createRadioButton("Pereira", new Color(0, 145, 234), 28, 650, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnPereira1);
		
		JRadioButton radioBtnManizales1 = createRadioButton("Manizales", new Color(0, 145, 234), 28, 690, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnManizales1);
		
		JRadioButton radioBtnMedellin1 = createRadioButton("Medellín", new Color(0, 145, 234), 28, 730, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnMedellin1);
		
		JRadioButton radioBtnTunja1 = createRadioButton("Tunja", new Color(0, 145, 234), 28, 770, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnTunja1);

		// Creates button group of the first city to be just one selected
		ButtonGroup bgCities1 = new ButtonGroup();
        bgCities1.add(radioBtnBogota1);
        bgCities1.add(radioBtnIbague1);
		bgCities1.add(radioBtnArmenia1);
        bgCities1.add(radioBtnPereira1);
		bgCities1.add(radioBtnManizales1);
		bgCities1.add(radioBtnMedellin1);
		bgCities1.add(radioBtnTunja1);
		
		// Selection of the second city to travel
        JLabel lblCities2 = new JLabel("Second city of the travel:");
        lblCities2.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCities2.setForeground(Color.DARK_GRAY);
        lblCities2.setBounds(400, 110, 483, 40);
		frame.getContentPane().add(lblCities2);
		
		// Radio buttons with blue color from Material Design
		JRadioButton radioBtnBogota2 = createRadioButton("Bogotá", new Color(156, 39, 176), 400, 170, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnBogota2);
		
		JRadioButton radioBtnIbague2 = createRadioButton("Ibagué", new Color(156, 39, 176), 400, 210, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnIbague2);
		
		JRadioButton radioBtnArmenia2 = createRadioButton("Armenia", new Color(156, 39, 176), 400, 250, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnArmenia2);
		
		JRadioButton radioBtnPereira2 = createRadioButton("Pereira", new Color(156, 39, 176), 400, 290, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnPereira2);
		
		JRadioButton radioBtnManizales2 = createRadioButton("Manizales", new Color(156, 39, 176), 400, 330, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnManizales2);
		
		JRadioButton radioBtnMedellin2 = createRadioButton("Medellín", new Color(156, 39, 176), 400, 370, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnMedellin2);
		
		JRadioButton radioBtnTunja2 = createRadioButton("Tunja", new Color(156, 39, 176), 400, 410, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnTunja2);

		// Creates button group of the second city to be just one selected
		ButtonGroup bgCities2 = new ButtonGroup();
        bgCities2.add(radioBtnBogota2);
        bgCities2.add(radioBtnIbague2);
		bgCities2.add(radioBtnArmenia2);
        bgCities2.add(radioBtnPereira2);
		bgCities2.add(radioBtnManizales2);
		bgCities2.add(radioBtnMedellin2);
		bgCities2.add(radioBtnTunja2);
		
		// Selection of the third city to travel
        JLabel lblCities3 = new JLabel("Optional third city of the travel:");
        lblCities3.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCities3.setForeground(Color.DARK_GRAY);
        lblCities3.setBounds(400, 470, 483, 40);
		frame.getContentPane().add(lblCities3);
        
		// Radio buttons with blue color from Material Design
		JRadioButton radioBtnBogota3 = createRadioButton("Bogotá", new Color(80, 59, 204), 400, 530, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnBogota3);
		
		JRadioButton radioBtnIbague3 = createRadioButton("Ibagué", new Color(80, 59, 204), 400, 570, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnIbague3);
		
		JRadioButton radioBtnArmenia3 = createRadioButton("Armenia", new Color(80, 59, 204), 400, 610, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnArmenia3);
		
		JRadioButton radioBtnPereira3 = createRadioButton("Pereira", new Color(80, 59, 204), 400, 650, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnPereira3);
		
		JRadioButton radioBtnManizales3 = createRadioButton("Manizales", new Color(80, 59, 204), 400, 690, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnManizales3);
		
		JRadioButton radioBtnMedellin3 = createRadioButton("Medellín", new Color(80, 59, 204), 400, 730, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnMedellin3);
		
		JRadioButton radioBtnTunja3 = createRadioButton("Tunja", new Color(80, 59, 204), 400, 770, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
		    }
		});
		frame.getContentPane().add(radioBtnTunja3);

		// Creates button group of the thrid city to be just one selected
		ButtonGroup bgCities3 = new ButtonGroup();
        bgCities3.add(radioBtnBogota3);
        bgCities3.add(radioBtnIbague3);
		bgCities3.add(radioBtnArmenia3);
        bgCities3.add(radioBtnPereira3);
		bgCities3.add(radioBtnManizales3);
		bgCities3.add(radioBtnMedellin3);
		bgCities3.add(radioBtnTunja3);
		
		// Travel button
		JButton btnRoute = createButton("Route", new Color(70, 116, 93), 1100, 700, 150, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Se supone que aca se llaman a la lógica para hacer la ruta
		    }
		});
		frame.getContentPane().add(btnRoute);
		
 		// Back button
		JButton btnBack = createButton("Back", new Color(229, 57, 53), 1300, 700, 150, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Muestra la ventana anterior (la del board) y oculta esta ventana
                board.setVisible(true);
                frame.setVisible(false);
		    }
		});
		frame.getContentPane().add(btnBack);
		
		JLabel lblPortrait = new JLabel("");
        ImageIcon portrait = new ImageIcon(new ImageIcon(Planificator.class.getResource("/archivos/images/portrait1.gif")).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        lblPortrait.setIcon(portrait);
        lblPortrait.setBounds(800, 110, 600, 600);
        frame.getContentPane().add(lblPortrait);
     		
	    // Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
	    
	    
	}
    
}
