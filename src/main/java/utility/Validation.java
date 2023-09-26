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

    public static boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern =Pattern.compile("^[0-9]{8}$");
        return phoneNumber.matches(pattern.pattern());
    }
    public static boolean validationNationalCode(String nationalCode){
        Pattern pattern =Pattern.compile("^[0-9]{10}$");
        return nationalCode.matches(pattern.pattern());
    }
    public static boolean validationWebsite(String website){
        Pattern pattern=Pattern.compile("/^((ftp|http|https):\\/\\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-]+(\\.[a-zA-Z]+)+((\\/)[\\w#]+)*(\\/\\w+\\?[a-zA-Z0-9_]+=\\w+(&[a-zA-Z0-9_]+=\\w+)*)?\\/?$/gm");
        return website.matches(pattern.pattern());
    }
}
