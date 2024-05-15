package backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class User {
    private DataOutputStream fake_db = null;

    public User(){
    }

    public void register(String name, String surname, String password, String email){
        try{
            fake_db = new DataOutputStream(new FileOutputStream("c:RoutePlan/src/archivos/fake_db.txt", true));
            fake_db.writeUTF(name);
            fake_db.writeUTF(surname);
            fake_db.writeUTF(password);
            fake_db.writeUTF(email);
            fake_db.close();
        } catch (IOException e) {
            System.out.println("Somethin went wrong, please try again");
        }
    }

    public Boolean login(String email, String password) throws IOException{
        try {
            DataInputStream fake_db = new DataInputStream(new FileInputStream("c:RoutePlan/src/archivos/fake_db.txt"));
            while (true) {
                String user_name = fake_db.readUTF();
                String user_surname = fake_db.readUTF();
                String user_password = fake_db.readUTF();
                String user_email = fake_db.readUTF();

                System.out.println(user_name);
                System.out.println(user_surname);
                System.out.println(user_email);
                System.out.println(user_password);

                if (user_email.matches(email) & user_password.matches(password)){
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
