package leetcode.compitition;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 *
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 *
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目
 */
public class CountVowelSubstring5918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(countVowelSubstrings(word));
    }
    public static int countVowelSubstrings(String word) {
        int n = word.length();
        if (n < 5) {
            return 0;
        }
        Set<Character> vowel = new HashSet<>();
        int i = 0, count = 0;
        while (i <= n - 5) {
            for(int j = i; j < n; j++) {
                if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u') {
                    vowel.add(word.charAt(j));
                    if (vowel.size() == 5) {
                        count++;
                    }
                } else {
                    break;
                }
            }
            vowel.clear();
            i++;
        }
        return count;
    }
}
