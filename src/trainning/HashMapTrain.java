package trainning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 遍历删除map中的元素
 * https://www.cnblogs.com/summerday152/p/13626130.html#%E4%B8%80%E3%80%81%E8%BF%AD%E4%BB%A3%E5%99%A8%E9%81%8D%E5%8E%86
 */
public class HashMapTrain {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        //遍历1  迭代器entrySet
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        //迭代器删除
        while (iterator.hasNext()) {
            String key = iterator.next().getKey();
            if ("key1".equals(key)) {
                iterator.remove();
            }
        }
        System.out.println(map);

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
        }

        //遍历2 迭代器keySet
        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println(key + "-->" + map.get(key));
        }
        //遍历3 foreach entrySet
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        //遍历4 foreach keySet
        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        //遍历5 lambda
        map.forEach((key, value) -> {
            System.out.println(key + "-->" + value);
        });
        //遍历6 StreamAPI
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        });
        //https://blog.csdn.net/yy1098029419/article/details/89452380
        //https://blog.csdn.net/mu_wind/article/details/109516995
        map.entrySet().parallelStream().forEach(entry -> {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        });





        //lambda的removeIf
        map.keySet().removeIf("key1"::equals);
        System.out.println(map);


        //StreamAPI的filter
        map.entrySet()
                .stream()
                .filter(m -> !"key2".equals(m.getKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "-->" + entry.getValue());
                });
    }
}
