package kz.osmium.util;

import org.joda.time.DateTime;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String getDateText(Date date) {
        return new SimpleDateFormat(DataConfig.GLOBAL_DATE_FORMAT).format(date);
    }

    public static String getDateTimeText(DateTime dateTime) {
        return new SimpleDateFormat(DataConfig.GLOBAL_DATE_FORMAT).format(dateTime.toDate());
    }
}
