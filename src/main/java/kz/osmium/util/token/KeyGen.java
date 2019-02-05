package kz.osmium.util.token;

public class KeyGen {
    private static final String DIGITS = "0123456789";
    private static final char[] digit = DIGITS.toCharArray();
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final char[] lower = LOWERCASE.toCharArray();
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] upper = UPPERCASE.toCharArray();

    public static String generate(int amount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            int chooseType = (int) (Math.random() * 3);
            switch (chooseType) {
                case 0: // lowercase
                    sb.append(lower[randomRange(0, 25)]);
                    break;
                case 1: // uppercase
                    sb.append(upper[randomRange(0, 25)]);
                    break;
                case 2: // digits
                    sb.append(digit[randomRange(0, 9)]);
                    break;
            }
        }
        return sb.toString();
    }

    private static int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
