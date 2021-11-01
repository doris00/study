package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
 *
 */
public class PaiLie {
    public static List<String> res;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        permutation(s);
        res.forEach(e -> {
            System.out.println(e);
        });
    }
    public static void permutation(String s) {
        int n = s.length();
        res = new ArrayList<String>();
        visited = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder perm = new StringBuilder();
        backtrack(arr, 0, n, perm);
    }

    private static void backtrack(char[] arr, int i, int n, StringBuilder perm) {
        if(i == n) {
            res.add(perm.toString());
            return;
        }
        for(int j = 0; j < n; ++j) {
            if ( visited[j] || (j > 0 && !visited[j - 1] && arr[j] == arr[j - 1])) {
                continue;
            }
            visited[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            visited[j] = false;
        }
    }
}
