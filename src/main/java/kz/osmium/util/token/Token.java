package kz.osmium.util.token;

import com.google.gson.Gson;
import kz.osmium.util.DataConfig;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private static String TOKEN_ADMIN;
    private static String TOKEN_USER;
    private static long DATE = 0L;
    private static final int MAX_AMOUNT = 40;

    public static void updateToken() {

        if (checkDate()){
            TOKEN_ADMIN = KeyGen.generate(MAX_AMOUNT);
            TOKEN_USER = KeyGen.generate(MAX_AMOUNT);
        }
    }

    public static String getTokenAdmin() {
        Map<String, String> map = new HashMap<>();
        map.put(DataConfig.GLOBAL_TOKEN, TOKEN_ADMIN);

        return new Gson().toJson(map);
    }

    public static String getTokenUser() {
        return TOKEN_USER;
    }

    public static boolean checkToken(String token, RuleToken ruleToken) {
//        switch (ruleToken) {
//            case ADMIN:
//                return checkAdmin(token);
//            case USER:
//                return checkUser(token);
//            default:
//                return false;
//        }

        return true;
    }

    private static boolean checkAdmin(String token) {

        if (token != null)
            return token.equals(TOKEN_ADMIN);

        return false;
    }

    private static boolean checkUser(String token) {

        if (token != null)
            return checkAdmin(token) || token.equals(TOKEN_USER);

        return false;
    }

    private static boolean checkDate(){
        DateTime dateTime = new DateTime(System.currentTimeMillis());

        if (dateTime.getMillis() <= DATE){

            return false;
        } else {

            DATE = dateTime.plusDays(1).getMillis();

            return true;
        }
    }
}
