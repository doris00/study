package question;

import java.util.Scanner;

/**
 * 很赞整数对
 * （1， 2） 5
 * 1 + 2 = 3， （3， 2） 5
 * 2 + 3 = 5， （5， 3） 5
 * 两次操作
 */
public class ShenCe3 {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();
        if(x <= 0 && y <= 0) {
            System.out.println(-1);
            return;
        }
        if(x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        calculate(x, y, m);
        System.out.println(ans);
    }
    public static void calculate (int x, int y, int m) {
        if(y >= m) {
            return;
        }
        int temp = x + y;
        x = y;
        y = temp;
        ans++;
        calculate(x, y, m);
    }
}
