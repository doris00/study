package question;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 寻找两只吵架的青蛙直接的最大距离
 * 给一个数组表示跳台，青蛙可以跳到比当前跳台高或者相等的块
 * 应该不是最优的解法，从前往后找到各自位置的增长长度
 * 从后往前找各自位置的增长长度
 * 最后相加求最大值-1
 */
public class Micro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] blocks = new int[N];
        for (int i = 0; i < N; ++i) {
            blocks[i] = sc.nextInt();
        }
        System.out.println(solution(blocks));
    }
    public static int[] dp1;
    public static int[] dp2;
    public static int solution(int[] blocks) {
        // write your code in Java SE 8
        int n = blocks.length;
        dp1 = new int[n];
        dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int i = 0;
        while (i < n - 1) {
            int j = findNum(blocks, i);
            i = j;
        }

        for (i = 1; i < n - 1; ++i) {
            if(blocks[i] >= blocks[i - 1]) {
                dp1[i] = dp1[i - 1] - 1;
            }
        }
        int j = n - 1;
        while (j > 0) {
            int k = findNum2(blocks, j);
            j = k;
        }
        for (i = 1; i < n - 1; ++i) {
            if(blocks[i] >= blocks[i - 1]) {
                dp1[i] = dp1[i - 1] - 1;
            }
        }
        for (i = n - 1; i > 0; --i) {
            if (blocks[i - 1] >= blocks[i]) {
                dp2[i - 1] = dp2[i] - 1;
            }
        }
        int ans = 0;
        for (i = 0; i < n; ++i) {
            int temp = dp1[i] + dp2[i];
            if(temp > ans) {
                ans = temp;
            }
        }
        return (ans - 1);
    }

    public static int findNum(int[] blocks, int k) {
        int i = 0;
        for (i = k + 1; i < blocks.length; ++i) {
            if (blocks[i] >= blocks[i - 1]) {
                dp1[k]++;
            } else {
                break;
            }
        }
        return i;
    }
    public static int findNum2(int[] blocks, int k) {
        int i = 0;
        for (i = k - 1; i >= 0; --i) {
            if (blocks[i] >= blocks[i + 1]) {
                dp2[k]++;
            } else {
                break;
            }
        }
        return i;
    }
}

