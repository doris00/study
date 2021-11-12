package question;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/string-compression-ii/solution/ya-suo-zi-fu-chuan-ii-by-leetcode-solution/
 * 压缩字符串变版：删除连续k个字符串之后，压缩字符串的最小值
 * 用k大小的滑动窗口进行删除可以解决。
 * 优化方面，可以用前缀和及后缀和进行删除后，左右字符串计算的优化。有错的话，感谢指出。
 *
 * 思路一：直接用一个窗口，每次删除窗口内的字母，然后压缩，一直遍历，每次取最短压缩为res,时间复杂度为O(n^2)
 *
 * 优化：每次只要比较窗口中重新暴露出来的字母与前一个字母是否一样，以及与后一个字符是否一样？暂时没啥想法
 */
public class Micro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(result(s, k));
    }
    public static int result(String s, int k) {
        if(k == 0) {
            return depress(s);
        }
        int j = k;
        int n = s.length();
        int res = Integer.MAX_VALUE;
        String subS;//存放删除k连续字母后的字符串
        while(j <= n) {
            subS = s.substring(0, j - k) + s.substring(j, n);
            res = Math.min(res, depress(subS));
            j++;
        }
        return res;
    }

    private static int depress(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i + 1;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            sb.append(c);
            if( j - i > 1) {
                sb.append(j - i);
            }
            i = j;
        }
        return sb.length();
    }
}
