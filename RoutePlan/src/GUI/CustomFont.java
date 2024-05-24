package GUI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class CustomFont {
	
	/*
	 * Esta clase selecciona un string el cual sera el nombre de la fuente, esta sera obtenida de su carpeta especifica la cual
	 * se llama "fonts", pues lo que genera es importar el archivo a los graficos donde luego crea la fuente para poder ser usada
	 * esta creacion es por medio de instancia dentro de su propia clase nativa "Font"
	 */

	public static Font loadFont(String fontName) {
	    File fontFile = new File("RoutePlan\\src\\GUI\\fonts\\" + fontName);
	    try {
	        
	    	Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(font);
	        return font.deriveFont(Font.PLAIN, 24); // Set the font size and style as needed
	    } catch (FontFormatException | IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
