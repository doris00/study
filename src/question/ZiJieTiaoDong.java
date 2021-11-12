package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求字符串的不重复子串的最长长度
 */
public class ZiJieTiaoDong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> temp = new HashMap<>();
        int pre = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (temp.containsKey(s.charAt(i))) {
                pre = Math.max(pre, temp.get(s.charAt(i)));
            }
            temp.put(s.charAt(i), i);
            if((i - pre) > ans) {
                ans = i - pre;
            }
        }
        System.out.println(ans);
    }
}
