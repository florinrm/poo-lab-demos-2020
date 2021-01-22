package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

interface InnerInterface {

}

class Outer {
    private int x; // membru al clasei

    public Outer (int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }

    public class InnerClass implements InnerInterface {
        private int x, y;

        public InnerClass(int x, int y) {
            Outer.this.x = x; // avem x atat in clasa externa / mare, cat si in clasa interna
            // prin acest mod ne referim la x-ul din clasa interna
            //this.x = 10;
            System.out.println("Outer: " + this.x); // va afisa 0
            System.out.println("Inner:" + Outer.this.x);
            this.y = y;
        }

        public int getInnerX() {
            return Outer.this.x; // daca avem doar return x -> va returna 0
        }

        public int getX() {
            return x;
        }

        public int getInnerY() {
            return y;
        }
    }

    public InnerInterface getInnerInstace(int x, int y) {
        return new InnerClass(x, y);
    }

    // daca clasa interna are modificatorul private, ne folosim de un getter (clasic, ca inainte cu membrii privati)
    public InnerClass getInstance (int x, int y) {
        return new InnerClass(x, y);
    }

    public static class StaticInnerClass {
        private int x, y;

        public StaticInnerClass(int x, int y) {
            this.x = x; // aici nu merge cu Outer.this.x
            // Outer.this.x = x;
            // decomentand linia de mai sus, vom avea eroarea "non-static variable this cannot be referenced from a static context"
            System.out.println("Inner static:" + this.x);
            this.y = y;
        }

        public int getInnerX() {
            //return Outer.this.x; // daca avem doar return x -> va returna 0
            return x;
        }

        public int getX() {
            return x;
        }

        public int getInnerY() {
            return y;
        }

        /*
        public interface InnerInterface {
        } */
    }

    public interface InnerInterface {

    }

    private class SecondInnnerClass implements InnerInterface {

    }

    public InnerInterface getPrivateInnerClassInstance() {
        return new SecondInnnerClass();
    }

    public void someStuff() {
        // clasa locala -> nu poate fi abstracta sau finala
        class Student {
            public String name, surname;
            public Student (String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            @Override
            public String toString () {
                return name + " " + surname;
            }
        }

        Student first = new Student ("Bogdanel", "Bombonel");
        Student second = new Student ("Malonel", "Frumushel");
        System.out.println(first);
        System.out.println(second);
    }
}

// mostenirea unei clase nested
class SubInnerClass extends Outer.InnerClass {

    public SubInnerClass(Outer o, int x, int y) {
        o.super(x, y);
    }
}

interface LambdaInterface {
    int add(int x, int y);
}

interface AnotherLambdaInterface {
    void doStuff();
}

public class Main {
    public static void main (String[] args) {
        Outer out = new Outer(420);
        System.out.println(out.getX());

        Outer.InnerClass in = out.new InnerClass(69, 69); // instantierea unei clase nested non-statice
        System.out.println("Inner x: " + in.getInnerX());
        System.out.println("Inner y: " + in.getInnerY());
        System.out.println("Just x in inner class: " + in.getX());

        Outer.InnerClass in2 = out.getInstance(100, 100);
        System.out.println("Inner x: " + in2.getInnerX());
        System.out.println("Inner y: " + in2.getInnerY());
        System.out.println("Just x in inner class: " + in2.getX());

        Outer.InnerInterface obj = out.getInnerInstace(10, 20);

        Outer.StaticInnerClass in3 = new Outer.StaticInnerClass(69, 69);
        System.out.println("Static inner x: " + in3.getInnerX());
        System.out.println("Static inner y: " + in3.getInnerY());
        System.out.println("Just x in static inner class: " + in3.getX());

        // asa putem instantia o clasa nested privata. folosind o interfata (in principiu folosind upcast)
        Outer.InnerInterface in4 = out.getPrivateInnerClassInstance();
        System.out.println(in4.getClass());

        // cream o clasa anonima prin extinderea clasei ArrayList, in care suprascriem metoda add
        // pentru a face astfel incat sa se adauge doar numere pare
        ArrayList<Integer> vect = new ArrayList<>() {
            @Override
            public boolean add(Integer e) {
                if (e % 2 == 0)
                    return super.add(e);
                return false;
            }
        };
        for (int i = 0; i < 30; i++) {
            Random rand = new Random();
            vect.add(rand.nextInt(100));
        }
        System.out.println(vect);
        // vrem sa sortam vect in ordine descrescatoare
        // astfel cream o clasa anonima care implementeaza Comparator -> criteriu de comparare la sortare
        // Collection.sort primeste ca parametru un obiect de tip Comparator
        Collections.sort(vect, (e1, e2) -> e2 - e1); // clasa anonima implementeaza interfata Comparator in acest caz
        // pe scurt, clasele anonime sunt mostenire in forma minimalista

        System.out.println(vect);

        // functii lambda
        LambdaInterface lambda1 = (int x, int y) -> x + y;
        LambdaInterface lambda3 = Integer::sum;
        LambdaInterface lambda2 = (int x, int y) -> {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            return x + y;
        };
        System.out.println(lambda1.add(6, 9));
        System.out.println(lambda2.add(6, 9));

        AnotherLambdaInterface lambda4 = () -> System.out.println("PP RULLZ");
        lambda4.doStuff();
    }
}
