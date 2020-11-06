package lab4;

public class Main {
    public static void main(String[] args) {
        String str = "apare in weekend tema la POO";
        String str2 = str.substring(0, str.length() - 1);
        String str3 = str.substring(0, str.length() - 7) + str.substring(str.length() - 6);
        System.out.println(str2);
        System.out.println(str3);

        String result = StringUtils.repeatString(str, 10);
        System.out.println(result);
    }
}
