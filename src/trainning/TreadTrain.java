package trainning;

/**
 * 死锁的例子
 * https://www.cnblogs.com/yaphetsfang/p/11818483.html
 */
public class TreadTrain{
    static Object objA = new Object();
    static Object objB = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println("Thread1 get objA");
                    try {
                        Thread.sleep(1000);
                        synchronized (objB) {
                            System.out.println("Thread1 get objB");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objB) {
                    System.out.println("Thread2 get objB");
                    synchronized (objA) {
                        System.out.println("Thread2 get objA");
                    }
                }
            }
        }).start();
    }

}
