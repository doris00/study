package question;

import java.util.Scanner;

/**
 * 乱序整数数组，找出超过1/2的数
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; ++i) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        int ans = 0;
        for(int num : nums) {
            if(count == 0) {
                count = 1;
                ans = num;
            } else {
                if(num == ans) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        System.out.println(ans);
    }
}
