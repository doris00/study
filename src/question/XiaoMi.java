package question;

import java.util.Scanner;

public class XiaoMi {
    public static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 < n2) {
            return lcs(s2, s1);
        }
        int[] dp = new int[n2 + 1];
        for(int i = 0; i < n1; ++i) {
            int temp1 = 0;
            int temp2 = 0;
            for(int j = 0; j < n2; ++j) {
                temp2 = dp[j + 1];
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = temp1 + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                }
                temp1 = temp2;
            }
        }
        return dp[n2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int ans = lcs(s1, s2);
        System.out.println(ans);
    }
}
