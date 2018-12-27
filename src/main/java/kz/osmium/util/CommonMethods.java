package kz.osmium.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CommonMethods {

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;

        try {
            InternetAddress emailAddr = new InternetAddress(email);

            emailAddr.validate();
        } catch (AddressException | NullPointerException ex) {
            result = false;
        }

        return result;
    }
}
