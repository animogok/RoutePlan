package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class buttons {
    // Class that creates Buttons and RadioButtons
	
	// Custom font
	Font customFont = CustomFont.loadFont("CDType - Voga Medium.ttf");

	// Button with Material Design style
	public JButton createButton(String name, Color color, int x, int y, int width, int height, ActionListener action) {
	    JButton button = new JButton(name);
	    button.setForeground(Color.WHITE);
	    button.setFont(customFont.deriveFont(Font.BOLD, 30));
	    button.setFocusPainted(false);
	    button.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
	    button.setBackground(color);
	    button.addActionListener(action);
	    button.setBounds(x, y, width, height);
	    // Efecto de cambio de color al pasar el mouse
	    button.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	            button.setBackground(color.darker()); // Color más oscuro
	        }

	        public void mouseExited(MouseEvent e) {
	            button.setBackground(color); // Restaurar el color original
	        }
	    });
	    return button;
	}
	
	// Radio button with Material Design style
	public JRadioButton createRadioButton(String name, Color color, int x, int y, int width, int height, ActionListener action) {
	    JRadioButton radioButton = new JRadioButton(name);
	    radioButton.setForeground(Color.WHITE);
	    radioButton.setFont(customFont.deriveFont(Font.BOLD, 25));
	    radioButton.setFocusPainted(false);
	    radioButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	    radioButton.setBackground(color);
	    radioButton.addActionListener(action);
	    radioButton.setBounds(x, y, width, height);
		
	    // Efecto de cambio de color al pasar el mouse
	    radioButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e) {
	            radioButton.setBackground(color.darker()); // Color más oscuro
	        }

	        public void mouseExited(MouseEvent e) {
	            radioButton.setBackground(color); // Restaurar el color original
	        }
	    });
	    return radioButton;
	}
    
}
