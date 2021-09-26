package question;

import java.util.*;

public class Tencent3 {
    public static void main(String[] args) {
        Map<String, Long> hashmap = new HashMap<>();
        hashmap.put("+", 1L);
        hashmap.put("x", 2L);
        hashmap.put("@", 3L);

        String str = null;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        Stack<Long> nums = new Stack<>();
        Stack<String> opt = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        Long tmp = 0L;

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                tmp = tmp * 10 + str.charAt(i) - '0';
            } else {
                list.add(tmp + "");
                list.add(str.charAt(i) + "");
                tmp = 0L;
            }

            if(i == str.length() - 1) {
                list.add(tmp + "");
            }
        }

        for (int i = 0; i < list.size(); ++i) {
            String s = list.get(i);

            if (!s.equals("+") && !s.equals("x") && !s.equals("@")) {
                nums.push(Long.valueOf(s));
            } else {
                while (!opt.isEmpty() && !comp(opt.peek(), s, hashmap)) {
                    Long a = nums.pop();
                    Long b = nums.pop();
                    nums.push(cal(b, a, opt.pop()));
                }
                opt.push(s);
            }
        }
        while (!opt.isEmpty()) {
            Long a = nums.pop();
            Long b = nums.pop();
            nums.push(cal(b, a, opt.pop()));
        }
        System.out.println(nums.pop());
    }
    public static boolean comp (String s1, String s2, Map<String, Long> hashmap) {
        return hashmap.get(s2) > hashmap.get(s1);
    }
    public static long cal (long a, long b, String s) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("x")) {
            return a * b;
        } else {
            return a | (a + b);
        }
    }
}
