package question;

import java.util.Arrays;
import java.util.Scanner;

public class WeiZhong2 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] serial = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            serial[i] = sc.nextInt();
        }

        res[0] = serial[0];
        int carry = 1;
        for (int i = 1; i < n; ++i) {
            if((i + 1) % 2 == 0) {
                carry = 1;
            } else {
                carry = -1;
            }
            res[i] = carry * (serial[i - 1] - serial[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
