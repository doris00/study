package question;

import java.util.Scanner;

/**
 * 求三个数之和最接近目标值
 * 暴力
 */
public class TencentCS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int aim = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; ++i) {
            num[i] = sc.nextInt();
        }
        int sum = 0, error = 0, res = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                for (int k = j + 1; k < N; ++k) {
                    sum = num[i] + num[j] + num[k];
                    error = Math.abs(sum - aim);
                    if (error == 0) {
                        System.out.println(sum);
                        return;
                    }
                    if (error < min) {
                        min = error;
                        res = sum;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
