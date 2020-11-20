package lab4;

public class SingletonSynchronized {
    private static SingletonSynchronized instance = null;

    private SingletonSynchronized() {

    }

    public synchronized static SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
