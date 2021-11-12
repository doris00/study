package trainning;

/**
 * 交替打印
 */
public class FooBar {

    static class Foo implements Runnable{

        @Override
        public void run() {
            System.out.print("foo");
        }
    }
    static class Bar implements Runnable{

        @Override
        public void run() {
            System.out.println("bar");
        }
    }
    private static volatile boolean finish = false;

    private static int n = 10;

    private static Thread t1;
    private static Thread t2;

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Bar bar = new Bar();
        new Thread(() -> {
            for (int i = 0; i < n; ++i) {
                while (finish) {
                    Thread.yield();
                }
                foo.run();
                finish = true;
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; ++i) {
                while (!finish) {
                    Thread.yield();
                }
                bar.run();
                finish = false;
            }
        }).start();
    }

}


