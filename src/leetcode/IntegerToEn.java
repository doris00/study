package leetcode;

import java.util.Scanner;

/**
 * 273:整数转换英文表示
 */
public class IntegerToEn {
    private static String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] thousands = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numberToWords(num));
    }

    private static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuilder curr = new StringBuilder();
                help(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    private static void help(StringBuilder curr, int curNum) {
        if(curNum == 0) {
            return;
        }
        if (curNum < 10) {
            curr.append(singles[curNum]).append(" ");
        } else if (curNum < 20) {
            curr.append(teens[curNum - 10]).append(" ");
        } else if (curNum < 100) {
            curr.append(tens[curNum / 10]).append(" ");
            help(curr, curNum % 10);
        } else {
            curr.append(singles[curNum / 100]).append(" ");
            help(curr, curNum % 100);
        }
    }
}
