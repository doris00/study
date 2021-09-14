package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AiQiYi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; ++i) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        int max = 0;
        int ans = 0;
        for(int count : map.values()) {
            if(count > max) {
                max = count;
                ans = 1;
            } else if(count == max) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
