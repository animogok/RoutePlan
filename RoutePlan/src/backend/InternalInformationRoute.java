package backend;

import backend.errors.EmailException;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InternalInformationRoute {

    private DataOutputStream fake_userCache = null;
    private int counter = 0;
    private Map<String, Map<String,String>> user_Info ;
    private Map<String,String> user_session;
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

    public void set_update_userInfo(String route1, String route2){
        counter++;

        String routes = route1+","+route2;
        String key = "routes" + counter;

        user_session.put(key, routes);
    }

    public void save_infoByclossinSession(){
        try{
            fake_userCache = new DataOutputStream(new FileOutputStream("c:RoutePlan/src/archivos/routes_user.txt", true));
            fake_userCache.writeUTF(user_session.toString());
            
        } catch (IOException e) {
            System.out.println("Somethin went wrong, please try again");
        }
    }
}