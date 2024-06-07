package GUI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouteInfo extends buttons{
    // Clase para que desde la lógica se instancie con la info del viaje
    
    JFrame frame;
    private JPanel titlePanel;
	private JLabel titleLabel;
	private JLabel logoLabel;

    // Cambien los parametros si lo consideran más comodo o efectivo...
    public RouteInfo(JFrame planificator, String map, String vehicle, String city1, String city2, Double totalDistance, 
                    String time, Double speed, String refuelMessage, Double neededFuel, String activePauses){

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

        // Title
 		JLabel lblTitle = new JLabel("Here is the route");
        lblTitle.setFont(customFont.deriveFont(Font.BOLD, 40));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(28, 110, 700, 40);
        frame.getContentPane().add(lblTitle);

        // Info about the route
 		JLabel lblVehicle = new JLabel("Vehicle used: " + vehicle);
        lblVehicle.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblVehicle.setForeground(Color.DARK_GRAY);
        lblVehicle.setBounds(28, 170, 700, 40);
        frame.getContentPane().add(lblTitle);

 		JLabel lblCity1 = new JLabel("First city in the travel: " + city1);
        lblCity1.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCity1.setForeground(Color.DARK_GRAY);
        lblCity1.setBounds(28, 230, 700, 40);
        frame.getContentPane().add(lblCity1);

 		JLabel lblCity2 = new JLabel("Second city in the travel: " + city2);
        lblCity2.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblCity2.setForeground(Color.DARK_GRAY);
        lblCity2.setBounds(28, 290, 700, 40);
        frame.getContentPane().add(lblCity2);

        JLabel lblTotalDistance = new JLabel("Total distance of the travel: " + (Math.round(totalDistance * 100)/100));
        lblTotalDistance.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblTotalDistance.setForeground(Color.DARK_GRAY);
        lblTotalDistance.setBounds(28, 350, 700, 40);
        frame.getContentPane().add(lblCity2);

        JLabel lblMaxTime = new JLabel("Time of the travel: " + time + " hours");
        lblMaxTime.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblMaxTime.setForeground(Color.DARK_GRAY);
        lblMaxTime.setBounds(28, 410, 700, 40);
        frame.getContentPane().add(lblMaxTime);
 
        JLabel lblTotalFuel = new JLabel("Total of fuel needed: " + (Math.round(neededFuel * 100)/100) + "% of the fuel tank");
        lblTotalFuel.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblTotalFuel.setForeground(Color.DARK_GRAY);
        lblTotalFuel.setBounds(28, 470, 700, 40);
        frame.getContentPane().add(lblTotalFuel);

        JLabel lblSpeed = new JLabel("Medium speed of the travel: " + speed + "km/h");
        lblSpeed.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblSpeed.setForeground(Color.DARK_GRAY);
        lblSpeed.setBounds(28, 530, 700, 40);
        frame.getContentPane().add(lblSpeed);

        JLabel lblRefuelMessage = new JLabel("Refuel recomendation: " + refuelMessage);
        lblRefuelMessage.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblRefuelMessage.setForeground(Color.DARK_GRAY);
        lblRefuelMessage.setBounds(28, 590, 1500, 40);
        frame.getContentPane().add(lblRefuelMessage);

        JLabel lblActivePauses = new JLabel("Active pauses recomendation: " + activePauses);
        lblActivePauses.setFont(customFont.deriveFont(Font.BOLD, 35));
        lblActivePauses.setForeground(Color.DARK_GRAY);
        lblActivePauses.setBounds(28, 650, 1500, 40);
        frame.getContentPane().add(lblActivePauses);

        // Map of the route
        JLabel lblMap = new JLabel("");
        ImageIcon imgMap = new ImageIcon(new ImageIcon(Planificator.class.getResource(map)).getImage().getScaledInstance(700, 550, Image.SCALE_DEFAULT));
        lblMap.setIcon(imgMap);
        lblMap.setBounds(760, 90, 700, 550);
		// Agregar un marco a la imagen
		lblMap.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        frame.getContentPane().add(lblMap);

        // Back button
		JButton btnBack = createButton("Back", new Color(229, 57, 53), 1300, 700, 150, 90, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// Muestra la ventana anterior (la del planificator) y oculta esta ventana
                planificator.setVisible(true);
                frame.setVisible(false);
		    }
		});
		frame.getContentPane().add(btnBack);

        // Set the frame size after adding all components
	    frame.setSize(windowSize);
	    frame.getContentPane().setSize(windowSize);
        frame.setVisible(true);
        // Cierra la ventana anterior
        planificator.setVisible(false);
    }
}
