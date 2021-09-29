package question;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小熊饼干，给定n块饼干 cookies[n]
 * 求第i块饼干到第n块，有几块不同的饼干
 */
public class GuangLianDa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cookies = new int[n];
        for (int i = 0; i < n; ++i) {
            cookies[i] = sc.nextInt();
        }
        for (int i = 0; i < m; ++i) {
            int start = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = start - 1; j < n; ++j) {
                set.add(cookies[j]);
            }
            System.out.println(set.size());
        }
    }

}
