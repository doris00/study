package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 进制转换
 */
public class Alibaba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, k, ans;
        for(int i = 0; i < t; i++){
            ans = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            while (n != 0) {
                nums.add(n % k);
                n /= k;
            }
            for(int j = 0; j < nums.size(); ++j) {
                ans += nums.get(j) * Math.pow(k, nums.size() - j - 1);
            }
            System.out.println(ans);
        }
    }
}
