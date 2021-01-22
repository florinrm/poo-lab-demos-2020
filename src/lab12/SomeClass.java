package lab12;

interface FirstInterface {
    default void doSomeAction() {
        System.out.println("FirstInterface action");
    }

    void doJob();
}

interface SecondInterface {
    default void doSomeAction() {
        System.out.println("SecondInterface action");
    }

    void doStuff();
}

public class SomeClass implements FirstInterface, SecondInterface {
    // dacă nu am face override la doSomeAction, am avea eroare de compilare!
    @Override
    public void doSomeAction() {
        System.out.println("Action by SomeClass");
    }

    @Override
    public void doJob() {
        System.out.println("Do the job");
    }

    @Override
    public void doStuff() {
        System.out.println("Do the stuff");
    }
}