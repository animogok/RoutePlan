package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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

	public JTextField createTextField(String text, int x, int y, int width, int height) {
		JTextField textField = new JTextField(20);
		textField.setBackground(Color.WHITE);
		textField.setBounds(x, y, width, height);
		textField.setFont(customFont.deriveFont(Font.BOLD, 25));
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
		textField.setForeground(Color.GRAY);
		textField.setText(text);
		textField.setColumns(10);
	
		// Add a focus listener to clear the suggestion text when the text field gains focus
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(text)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}
	
			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setForeground(Color.GRAY);
					textField.setText(text);
					textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Cambiar a gris
				}
			}
		});
		
		// Agregar un escuchador de eventos del mouse para cambiar el color de la línea inferior y el texto a un azul Material Design cuando se hace clic en el campo de texto
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color materialDesignBlue =  new Color(80, 59, 204); // Azul Material Design
				textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, materialDesignBlue));
				textField.setForeground(materialDesignBlue);
			}
		});
	
		return textField;
	}
	

	// Text field with Material Design style
	public JPasswordField createPasswordField( int x, int y, int width, int height) {
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(x, y, width, height);
		passwordField.setFont(customFont.deriveFont(Font.BOLD, 25));
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
		passwordField.setForeground(Color.GRAY);
		passwordField.setColumns(10);

		// Add a focus listener to clear the suggestion text when the text field gains focus
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getPassword().length == 0) {
					passwordField.setForeground(Color.GRAY);
					passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Cambiar a gris
				}
			}
		});		

		// Agregar un escuchador de eventos del mouse para cambiar el color de la línea inferior y el texto a un azul Material Design cuando se hace clic en el campo de texto
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color materialDesignBlue =  new Color(80, 59, 204); // Azul Material Design
				passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, materialDesignBlue));
				passwordField.setForeground(materialDesignBlue);
			}
		});
	
		return passwordField;
		}

    
}
