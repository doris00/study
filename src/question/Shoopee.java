package question;

import java.util.ArrayList;
import java.util.Collections;

public class Shoopee {
    public int minEffort(ArrayList<Integer> cases) {
        // write code here
        Collections.sort(cases);
        int n = cases.size();
        int[] pre = new int[n];
        pre[0] = cases.get(0);
        for(int i = 1; i < cases.size(); ++i) {
            pre[i] = pre[i - 1] + cases.get(i);
        }
        int ans = 0;
        for(int i = 1; i < n; ++i) {
            ans += pre[i];
        }
        return ans;
    }
    public static long Solve(int n, int m, int[] weights) {
        // write code here
        long[] k = new long[n];
        k[0] = weights[0];
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            long memory = k[i];
            int bag_num = m - 1;
            int pre = i;
            for(int j = i + 1; j < n; ++j) {
                while (bag_num > 0 && j < n && k[j] - k[pre] <= memory) {
                    j++;
                }
                if( bag_num == 0) {
                    break;
                } else if (j == n){
                    ans = k[i];
                    break;
                } else {
                    j--;
                    bag_num--;
                    pre = j;
                }
            }
            if(ans != 0) {
                break;
            }
        }
        return ans;
    }

    public String didYouMean(String[] commands, String input) {
        // write code here
        String ans = "";
        if (commands.length <= 1) {
            ans = commands[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights = new int[] {4, 2, 3, 1};
        long ans = Solve(4,3, weights);
        System.out.println(ans);
    }
}
