package lab4;

public class SingletonStaticBlock {
    private static SingletonStaticBlock instance = null;

    static {
        instance = new SingletonStaticBlock();
    }

    private SingletonStaticBlock() {

    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
