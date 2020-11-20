package lab4;

public class Main {
    public static void main(String[] args) {
        String str = "in weekend apare tema la poo :(";
        str = "tema este usoara, no worries :)";

        str = "p" + str.substring(1);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.setCharAt(4, 'h');
        str = stringBuilder.toString();
        System.out.println(str);

        System.out.println(Utils.repeatString(str, 4));
    }
}
