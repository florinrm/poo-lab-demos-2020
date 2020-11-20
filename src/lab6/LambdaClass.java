package lab6;

import java.util.ArrayList;

interface Lambda {
    int sumList(ArrayList<Integer> list);
}

public class LambdaClass {
    public static void main(String[] args) {
        // clasa anonima
        Lambda l1 = new Lambda() {
            @Override
            public int sumList(ArrayList<Integer> list) {
                int sum = 0;
                for (var elem: list) {
                    sum += elem;
                }
                return sum;
            }
        };

        // lambda function
        /*
        implementam o interfata care are o singura metoda (neimplementata)
        folosind functii lambda / anonime
         */
        Lambda l2 = (list) -> {
            int sum = 0;
            for (var elem: list) {
                sum += elem;
            }
            return sum;
        };
    }
}
