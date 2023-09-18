package utility;

import java.util.regex.Pattern;

public class Validation {
    public static boolean validationPassword(String password){
        Pattern pattern=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        return password.matches(pattern.pattern());
    }

    public static boolean validationEmail(String email){
        Pattern pattern=Pattern.compile("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}");
        return email.matches(pattern.pattern());

    }
}
