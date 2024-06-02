package backend;

import backend.errors.EmailException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InternalInformationRoute {
    /*
     * This class will manage the information between Login and Register, in terms of authentication and autorization
     */

    public boolean is_emailCorrect(String email) throws EmailException{
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if (m.matches()){
            return true;
        } else{
            throw new EmailException();
        }
    }
}