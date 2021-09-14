package question;

import java.util.Scanner;

/**
 * 切割网格
 */
public class Alibaba2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m;
        long sum;
        for(int i = 0; i < t; ++i) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 1) {
                System.out.println("V" + (m / 2 + 1));
                return;
            }
            if (m == 1) {
                System.out.println("H" + (m / 2 + 1));
                return;
            }
            sum = (n * m + 1) / 2 * n * m;
            long mid = sum / 2;
            //case1 竖直
            long sum1 = 0, sum2 = 0, l1 = m, l2 = n;
            for (int j = m; j > m / 2; --j) {
                int a1 = (j + m) / 2 * (m - j + 1);
                int d = m * (m - j + 1);
                int sum_te = n * a1 + (n - 1) * n * d / 2;
                if(Math.abs(mid - sum_te) < Math.abs(mid - sum1)) {
                    sum1 = sum_te;
                    l1 = j;
                }
            }
            //case2 水平
            for(int h = n; h > n / 2; --h) {
                int a1 = m * (h - 1) + 1;
                int an = a1 + (n - h + 1) * m - 1;
                int sum_te = (n - h + 1) * m / 2 * (a1 + an);
                if(Math.abs(mid - sum_te) < Math.abs(mid - sum2)) {
                    sum2 = sum_te;
                    l2 = h;
                }
            }
            if(Math.abs(sum1 - mid) < Math.abs(sum2 - mid)) {
                System.out.println("V " + l1);
            } else {
                System.out.println("H " + l2);
            }
        }
    }
}
