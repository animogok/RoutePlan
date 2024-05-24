package GUI;

import java.awt.*;
import java.awt.event.ComponentAdapter;

import javax.swing.*;
import java.awt.Dialog.ModalExclusionType;


public class DataInput {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataInput window = new DataInput();
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
	public DataInput() {
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
	    frame.getContentPane().setLayout(null);

	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 1350, 729);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);

	    JLabel lblNewLabel = new JLabel("ROUTE PLANIFICATOR");
	    lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(582, 123, 149, 14);
	    panel.add(lblNewLabel);

	    // Set the frame size after adding all components
	    frame.setSize(windowSize);
	}
}
