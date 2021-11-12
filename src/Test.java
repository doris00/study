import java.util.Scanner;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
 * 压缩规则：
 * 1、仅压缩连续重复出现的字符。比如字符串"abcbc"由于无连续重复字符，压缩后的字符串还是"abcbc"。
 * 2、压缩字段的格式为"字符重复的次数+字符"。例如：字符串"xxxyyyyyyz"压缩后就成为"3x6yz"。￼
 */

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s.length() < 2) {
            System.out.println(s);
            return;
        }
        StringBuilder ans = new StringBuilder();
        int count = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (ch == s.charAt(i)) {
                count++;
            } else {
                if (count > 1) {
                    ans.append(count);
                }
                ans.append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        if (count == 1) {
            ans.append(ch);
        } else {
            ans.append(count);
            ans.append(ch);
        }
        System.out.println(ans.toString());
    }
}
