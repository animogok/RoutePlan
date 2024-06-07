package backend;

import backend.errors.EmailException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InternalInformationRoute {

    private Map<String,String> user_existMap = null;
    private boolean user_exist = false;
    private DataOutputStream fake_userCache = null;
    private int counter = 0;
    private Map<String, Map<String,String>> user_Info ;
    private Map<String,String> user_session;

    public InternalInformationRoute(){
        
    }

    /*
     * This class will manage the information between Login and Register, in terms of authentication and autorization
     */
    public EmailException is_emailCorrect(String email) throws EmailException{
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if (m.matches()){
            return null;
        } else{
            throw new EmailException();
        }
    }

    /*
     * This class will manage user information saving per route they implement
     */
    
    public void seriralize_User(String username, String password) throws FileNotFoundException, Exception{
        user_Info = new HashMap<>();
        user_session = new HashMap<>();
        
        user_session.put("username", username);
        user_session.put("password", password);

        user_Info.put("User_info", user_session);

    }
    
    public void set_update_userInfo(String route1, String route2, String vehicle){
        this.counter++;

        String key_v = "vehicle_Route" + this.counter;
        String routes = route1+","+route2;
        String key = "routes" + this.counter;

        user_session.put(key, routes);
        user_session.put(key_v, vehicle);
    }

    public void set_update_userInfo(Map<String,String> internal_user){
        while(true){
            this.counter++;
            if (internal_user.get("routes"+this.counter) != null){
                user_session.put("routes"+this.counter, internal_user.get("routes"+this.counter));
                user_session.put("vehicle_Route" + this.counter, internal_user.get("vehicle_Route" + this.counter));
            } else {
                this.counter--;
                break;
            }
        }
    }

    public void save_infoByclossinSession(){
        try{
            fake_userCache = new DataOutputStream(new FileOutputStream("c:RoutePlan/src/archivos/routes_user.txt", true));
            fake_userCache.writeUTF(user_session.toString());
            
        } catch (IOException e) {
            System.out.println("Somethin went wrong, please try again");
        }
    }
    
    public void set_userExist(String username, String password) throws FileNotFoundException{
        DataInputStream fake_userCache = new DataInputStream(new FileInputStream("c:RoutePlan/src/archivos/routes_user.txt"));
        
        while (true){
            String user_Info;
             try {
                user_Info = fake_userCache.readUTF();
                Map<String, String> hashMap = new HashMap<>();
                Pattern pattern = Pattern.compile("(\\w+)=([^,\\s]+(?:,[^,\\s]+)*)");
                Matcher matcher = pattern.matcher(user_Info.substring(1, user_Info.length() - 1));

                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    hashMap.put(key, value);
                }
                if(hashMap.get("username").equals(username) && hashMap.get("password").equals(password)){
                    this.user_exist = true;
                    this.user_existMap = hashMap;
                    break;
                }
             } catch (IOException ex){
                this.user_exist = false; 
                break;
             } 
        }     
    }

    
    public void delete_user(String username, String password) throws FileNotFoundException, IOException {
    
        File file = new File("c:RoutePlan/src/archivos/routes_user.txt");
        File tempFile = new File("c:RoutePlan/src/archivos/temp.txt");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    
            String user_Info;
            while ((user_Info = reader.readLine()) != null) {
                Map<String, String> hashMap = new HashMap<>();
                Pattern pattern = Pattern.compile("(\\w+)=([^,\\s]+(?:,[^,\\s]+)*)");
                Matcher matcher = pattern.matcher(user_Info);
    
                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    hashMap.put(key, value);
                }
                // Verificar si el usuario y la contraseña coinciden y omitir la escritura en el archivo temporal
                if (hashMap.containsKey("username") && hashMap.containsKey("password")) {
                    if (hashMap.get("username").equals(username) && hashMap.get("password").equals(password)) {
                        continue; // Saltar la escritura al archivo temporal
                    }
                }
                writer.write(user_Info + "\n");
            }
        }
    
        // Reemplazar el archivo original con el archivo temporal
        file.delete();
        tempFile.renameTo(file);
    }
    

    public void return_hashmap(){
        System.err.println(user_Info);
    }

    public boolean get_userExist(){
        return this.user_exist;
    }

    public Map<String,String> get_userExMap(){
        return this.user_existMap;
    }

    public static void main(String[] args) throws Exception {
        InternalInformationRoute internal = new InternalInformationRoute();
        internal.set_userExist("Carlos", "123456789");
        if(internal.get_userExist()){
            internal.delete_user("Carlos", "123456789");
            InternalInformationRoute internal2 = new InternalInformationRoute();
            internal2.seriralize_User(internal.get_userExMap().get("username"), internal.get_userExMap().get("password"));
            internal2.set_update_userInfo(internal.get_userExMap());
            internal2.set_update_userInfo("Cali", "Pitalito", "carro");
            internal2.set_update_userInfo("Cali", "Itagüi", "carro");
            internal2.save_infoByclossinSession();
            internal2.return_hashmap();
        }
    }
}