package trainning;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ReferenceTrain {
    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
//        testSoftReference();
        testWeakReference();
    }
    private static void testSoftReference() {
        for(int i = 0; i < 10; ++i) {
            byte[] buff = new byte[1024 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buff);
            list.add(sr);
        }
        System.gc();//主动通知垃圾回收

        for(int i = 0; i < list.size(); ++i) {
            Object obj = ((SoftReference) list.get(i)).get();
            System.out.println(obj);
        }
    }
    private static void testWeakReference() {
        for(int i = 0;  i < 10; ++i) {
            byte[] buff = new byte[1024 * 1024];
            WeakReference<byte[]> wr = new WeakReference<>(buff);
            list.add(wr);
        }
        System.gc();
        for (int i = 0; i < list.size(); ++i) {
            Object obj = ((WeakReference)list.get(i)).get();
            System.out.println(obj);
        }
    }

}
