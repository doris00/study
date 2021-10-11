package trainning;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOUtOfMemoryError
 */
public class OutOfMemorryTrain {
    static class OOMObject {

    }

    public static void main(String[] args) {
        int x = 4;
        x <<= 2;
        System.out.println(x);
//        List<OOMObject> list = new ArrayList<>();
//        while (true) {
//            list.add(new OOMObject());
//        }
    }
}
