package trainning;

import java.util.Vector;

public class ThreadTrain {
    //对Vector线程安全的测试
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        synchronized (vector) {
            for (int i = 0; i < 10; ++i) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); ++i) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < 10; ++i) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20);
        }
    }
}