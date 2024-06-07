package backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class User {

    /*
     * Genero pues la estructura basica para poder escribir dentro de archivos txt para poder generar un tipo de base de datos
     */
    
    private static final Exception NullPointerException = null;
    private DataOutputStream fake_db = null;

    public User(){
    }

    /*
     * El register consiste en el constructor, donde este debera de escribir dentro del archivo los datos, se genera el hecho de que dado el caso ingresen campos vacios
     * Se genera tambien el error el cual es una clase dentro de la carpeta "errors" donde especifica una longitud de contraseña minimo 8
     */

    public void register(String username, String password, String email) throws Exception{

        if (username.matches("") | password.matches("") | email.matches("")){
            throw NullPointerException;
        }

        try{
            fake_db = new DataOutputStream(new FileOutputStream("c:RoutePlan/src/archivos/fake_db.txt", true));
            fake_db.writeUTF(username);
            fake_db.writeUTF(password);
            fake_db.writeUTF(email);
            fake_db.close();
        } catch (IOException e) {
            System.out.println("Somethin went wrong, please try again");
        }
    }

    /*
     * Este metodo se encarga de iterar sobre el archivo txt hasta encontrar las cosas que se le especifican que sean iguales, para poder dar ingreso a la app
     */

     public boolean login(String username, String password) throws Exception{
        try {
            if (username.isEmpty() || password.isEmpty()) {
                throw new NullPointerException();
            }
    
            DataInputStream fake_db = new DataInputStream(new FileInputStream("c:RoutePlan/src/archivos/fake_db.txt"));
            while (true) {
                String user_username = fake_db.readUTF();
                String user_password = fake_db.readUTF();
                String user_email = fake_db.readUTF();
                System.err.println(user_username);
                System.err.println(user_password);
                if (username.equals(user_username) && password.equals(user_password)){
                    fake_db.close();
                    return true;
                } 
            }
        } catch (IOException e) {
            System.out.println("User hasn't registered yet");
            return false;
        }
    }
}
