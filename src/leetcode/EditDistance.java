package leetcode;

import java.util.Scanner;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 思路：动态规划，dp[i][j]表示word1[0...i]和word2[0...j]的编辑距离
 * 如果word[i] == word[j],那么dp[i][j] = dp[i - 1][j - 1]
 * 插入：dp[i][j] = dp[i][j - 1] + 1
 * 删除：dp[i][j] = dp[i - 1][j] + 1
 * 替换：dp[i][j] = dp[i - 1][j - 1] + 1
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
