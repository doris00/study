package leetcode.compitition;

import java.util.Scanner;

/**
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 *
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 *
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 */
public class vowelsOfAllSubstring {

    public static char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(countVowels2(word));
    }


    //遍历word,如果word[i]是元音字母，就去看他可能出现在哪些子字符串中，每个子字符串都加一
    //word[l...r]包含word[i],0 <= l<= i,i < r < n
    //就有(i + 1) * (n - i)个字符串
    public static long countVowels2(String word) {
        long ans = 0;
        int n = word.length();
        String v = "aeiou";
        for (int i = 0; i < n; i++) {
            if(v.contains(word.charAt(i) + "")) {
                ans += (long) (i + 1) * (long) (n - i);
            }
        }
        return ans;
    }

    //暴力一下,超时 41/51
    public static long countVowels(String word) {
        int n = word.length();
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            long flag = 0;
            if(isVowel(word.charAt(i))) {
                flag = 1;
                ans++;
            }
            for(int j = i + 1; j < n; ++j) {
                if(isVowel(word.charAt(j))) {
                    flag++;
                }
                ans += flag;
            }
        }
        return ans;
    }
    public static boolean isVowel(char c) {
        for (char v : vowel) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }
}
