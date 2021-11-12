package trainning;
/**
 * 双检锁
 */
public class SingleTon {
    private static volatile SingleTon instance;

    private SingleTon(){}

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
