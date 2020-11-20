package lab4;

public class Utils {
    public static String repeatString(String str, int count) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < count; i++) {
//            stringBuilder.append(str);
//        }
//
//        return stringBuilder.toString();
        String result = "";
        for (int i = 0; i < count; i++) {
            result += str;
        }

        return result;
    }
}
