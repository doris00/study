package question;

import java.util.*;

public class ShenCe2 {
    public static int[] money = {1, 2, 5, 10, 20, 50, 100};
    public static Map<Integer, Integer> map = new HashMap<>();
    public static List<int[]> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; ++i) {
            int n = sc.nextInt();
            map.put(money[i], map.getOrDefault(money[i], 0) + n);
        }
        int m = sc.nextInt();
        dfs(new int[7],0, m, 0);
        Collections.reverse(ans);
        for (int[] list : ans) {
            for(int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    public static void dfs (int[] list, int k, int sum, int current) {
        if(sum == current) {
            int[] temp = Arrays.copyOf(list, list.length);
            ans.add(temp);
        }
        if(sum <= current || k >= 7 || sum < current + money[k]) {
            return;
        }
        for (int i = k; i < 7; ++i) {
            if(map.get(money[i]) >= 1) {
                //选择该纸币
                map.put(money[i], map.get(money[i]) - 1);
                list[i]++;
                dfs(list, i, sum, current + money[i]);
                //回溯
                list[i]--;
                map.put(money[i], map.get(money[i]) + 1);
            }
        }
    }
}
