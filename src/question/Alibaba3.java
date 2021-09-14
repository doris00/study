package question;

import java.util.Scanner;

/**
 * a, b,k= 1, 求最少操作数
 */
public class Alibaba3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = 1;
            int nums = b - a;
            int sum = 1;
            while (sum < nums) {
                k++;
                sum = (1 + k) / 2 * k;
            }
            while (sum - nums > 0 && sum % 2 != 0) {
                k++;
                sum = (1 + k) / 2 * k;
            }
            System.out.println(k);
        }
    }
}
