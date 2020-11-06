package lab4;

public class SingletonEager {
    private final static SingletonEager instance = new SingletonEager();

    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return instance;
    }
}
