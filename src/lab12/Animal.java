package lab12;

public interface Animal {
    default void shakeTail() {
        System.out.println("Humans have no tail");
    }

    static void print() {
        System.out.println("This is an animal");
    }

    void makeSound();
}

class Human implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Ahhhh");
    }
}

