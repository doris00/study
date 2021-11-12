package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 贪心+单调栈
 * 用单调栈保存中间结果
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(removeKdigits(s, k));
    }
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;//处理最前面的0
        while(!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if(leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
