package question;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 两个有序（升序）列表求交集，例如a=[1,3,4,5,6,6,7,7,9,10], b=[3,7,7,10,11,12], 输出[3,7,10]
 */
public class Test10 {
    public static void main(String[] args) {
        int[] a = {1,3,4,5,6,6,7,7,9,10};
        int[] b = {3,7,7,10,11,12};
        int[] ans = cal(a, b);
        for(int i = 0; i < ans.length; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] cal(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if(n == 0 || m == 0) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if(a[i] == b[j]) {
                if(!ans.contains(a[i])) {
                    ans.add(a[i]);
                }
                i++;
                j++;
            } else if(a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ansArray = new int[ans.size()];
        for(int k = 0; k < ans.size(); ++k) {
            ansArray[k] = ans.get(k);
        }
        return  ansArray;
    }
}
