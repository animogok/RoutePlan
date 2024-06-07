package GUI;

import backend.InternalInformationRoute;
import backend.RouteInformation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Planificator extends buttons{

	private String vehicle = "";
	private String city1 = "";
    private String city2 = "";
	
    JFrame frame;

	JRadioButton radioBtnPlane = null;
	JRadioButton radioBtnCar = null;
	JRadioButton radioBtnMotorbike = null;
	JRadioButton radioBtnPassengerbus = null;
	JRadioButton radioBtnHeavyvehicle = null;

	private JRadioButton radioBtnBogota1 = null;
	private JRadioButton radioBtnIbague1 = null;
	private JRadioButton radioBtnArmenia1 = null;
	private JRadioButton radioBtnPereira1 = null;
	private JRadioButton radioBtnManizales1 = null;
	private JRadioButton radioBtnMedellin1 = null;
	private JRadioButton radioBtnTunja1 = null;

	private JRadioButton radioBtnBogota2 = null;
	private JRadioButton radioBtnIbague2 = null;
	private JRadioButton radioBtnArmenia2 = null;
	private JRadioButton radioBtnPereira2 = null;
	private JRadioButton radioBtnManizales2 = null;
	private JRadioButton radioBtnMedellin2 = null;
	private JRadioButton radioBtnTunja2 = null;

	private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;

	/**
	 * Create the application. 
	 */
	public Planificator(JFrame board, InternalInformationRoute user) {
		initialize(board, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame board, InternalInformationRoute user) {
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
		lblVehicles.setBounds(250, 110, 220, 40);
		frame.getContentPane().add(lblVehicles);
		
		// Radio buttons with cyan color from Material Design
		radioBtnPlane = createRadioButton("Plane", new Color(0, 188, 212), 250, 170, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón Plane

				vehicle = radioBtnPlane.getText();
		    }
		});
		frame.getContentPane().add(radioBtnPlane);

		radioBtnCar = createRadioButton("Car", new Color(0, 188, 212), 250, 210, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón Car

				vehicle = radioBtnCar.getText();
		    }
		});
		frame.getContentPane().add(radioBtnCar);
        
		radioBtnMotorbike = createRadioButton("Motorbike", new Color(0, 188, 212), 250, 250, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				vehicle = radioBtnMotorbike.getText();
		    }
		});
		frame.getContentPane().add(radioBtnMotorbike);
		
		radioBtnPassengerbus = createRadioButton("Passenger bus", new Color(0, 188, 212), 250, 290, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				vehicle = radioBtnPassengerbus.getText();
		    }
		});
		frame.getContentPane().add(radioBtnPassengerbus);
		
		radioBtnHeavyvehicle = createRadioButton("Heavy vehicle", new Color(0, 188, 212), 250, 330, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				vehicle = radioBtnHeavyvehicle.getText();
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
        JLabel lblCities1 = new JLabel("Inicial city of the travel:");
        lblCities1.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCities1.setForeground(Color.DARK_GRAY);
        lblCities1.setBounds(28, 410, 483, 40);
		frame.getContentPane().add(lblCities1);
		
		// Radio buttons with blue color from Material Design
		radioBtnBogota1 = createRadioButton("Bogotá", new Color(0, 145, 234), 28, 470, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city1 = radioBtnBogota1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnBogota1);
		
		radioBtnIbague1 = createRadioButton("Ibagué", new Color(0, 145, 234), 28, 510, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city1 = radioBtnIbague1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnIbague1);
		
		radioBtnArmenia1 = createRadioButton("Armenia", new Color(0, 145, 234), 28, 550, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city1 = radioBtnArmenia1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnArmenia1);
		
		radioBtnPereira1 = createRadioButton("Pereira", new Color(0, 145, 234), 28, 590, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city1 = radioBtnPereira1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnPereira1);
		
		radioBtnManizales1 = createRadioButton("Manizales", new Color(0, 145, 234), 28, 630, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city1 = radioBtnManizales1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnManizales1);
		
		radioBtnMedellin1 = createRadioButton("Medellín", new Color(0, 145, 234), 28, 670, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city1 = radioBtnMedellin1.getText();
		    }
		});
		frame.getContentPane().add(radioBtnMedellin1);
		
		radioBtnTunja1 = createRadioButton("Tunja", new Color(0, 145, 234), 28, 710, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city1 = radioBtnTunja1.getText();
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
        JLabel lblCities2 = new JLabel("Final city of the travel:");
        lblCities2.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCities2.setForeground(Color.DARK_GRAY);
        lblCities2.setBounds(400, 410, 483, 40);
		frame.getContentPane().add(lblCities2);
		
		// Radio buttons with blue color from Material Design
		radioBtnBogota2 = createRadioButton("Bogotá", new Color(156, 39, 176), 400, 470, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city2 = radioBtnBogota2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnBogota2);
		
		radioBtnIbague2 = createRadioButton("Ibagué", new Color(156, 39, 176), 400, 510, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón

				city2 = radioBtnIbague2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnIbague2);
		
		radioBtnArmenia2 = createRadioButton("Armenia", new Color(156, 39, 176), 400, 550, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city2 = radioBtnArmenia2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnArmenia2);
		
		radioBtnPereira2 = createRadioButton("Pereira", new Color(156, 39, 176), 400, 590, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city2 = radioBtnPereira2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnPereira2);
		
		radioBtnManizales2 = createRadioButton("Manizales", new Color(156, 39, 176), 400, 630, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city2 = radioBtnManizales2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnManizales2);
		
		radioBtnMedellin2 = createRadioButton("Medellín", new Color(156, 39, 176), 400, 670, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city2 = radioBtnMedellin2.getText();
		    }
		});
		frame.getContentPane().add(radioBtnMedellin2);
		
		radioBtnTunja2 = createRadioButton("Tunja", new Color(156, 39, 176), 400, 710, 190, 40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Acción específica del botón
				city2 = radioBtnTunja2.getText();
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
		
		// Travel button
		JButton btnRoute = createButton("Route", new Color(70, 116, 93), 1100, 700, 150, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				while (true){
					if (city1 == city2 || vehicle == "" || city1 == "" || city2 == ""){
						JOptionPane.showMessageDialog(null, "Por favor seleccionar una opción, las ciudades no pueden ser las mismas", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					user.set_update_userInfo(city1, city2, vehicle);
					user.texto();
					RouteInformation routeInfo = new RouteInformation();
					routeInfo.view(frame, vehicle.toLowerCase(), city1.toLowerCase(), city2.toLowerCase());

					// Cierra la ventana actual
					frame.setVisible(false);
					break;
				}
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

	public String getVehicle() {
        return vehicle;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }
    
}
