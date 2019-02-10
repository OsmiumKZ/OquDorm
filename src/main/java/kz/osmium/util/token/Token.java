package kz.osmium.util.token;

import com.google.gson.Gson;
import kz.osmium.util.DataConfig;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private static String TOKEN_ADMIN;
    private static String TOKEN_USER;
    private static final int MAX_AMOUNT = 40;

    public static void updateToken() {
        TOKEN_ADMIN = KeyGen.generate(MAX_AMOUNT);
        TOKEN_USER = KeyGen.generate(MAX_AMOUNT);
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
        switch (ruleToken) {
            case ADMIN:
                return checkAdmin(token);
            case USER:
                return checkUser(token);
            default:
                return false;
        }
    }

    private static boolean checkAdmin(String token) {
        return token.equals(TOKEN_ADMIN);
    }

    private static boolean checkUser(String token) {
        return checkAdmin(token) || token.equals(TOKEN_USER);
    }
}
