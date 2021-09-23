package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QiAnXin {
    public static void main(String[] args) {
        char[] seed = new char[]{'0', '1', '2'};
        int size = 2;
        Permutation(seed, size);
    }

    public static void backtrack(int n, char[] seed, List<Character> output, List<String> ans, int first) {
        if(first == n) {
            ans.add(output.toString());
            return;
        }
        for(int i = first; i < seed.length; ++i) {
            output.add(seed[i]);
            backtrack(n, seed, output, ans, first + 1);
            output.remove(output.size() - 1);
        }
    }
    public static String[] Permutation (char[] seed, int size) {
        // write code here
        Arrays.sort(seed);
        List<String> ans = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        backtrack(size, seed, output, ans, 0);
        return ans.toArray(ans.toArray(new String[0]));
    }


    public int DoPermute (int M, int N) {
        // write code here
        List<Integer> monkeys = new ArrayList<>();
        for(int i = 1; i <= N; ++i) {
            monkeys.add(i);
        }
        int k = 0;
        int ans = 0;
        while (monkeys.size() > 0) {
            k = k + M;
            k = k % (monkeys.size()) - 1;//第m个人的索引位置
            if(k < 0) {
                ans = monkeys.get(monkeys.size() - 1);
                monkeys.remove(monkeys.size() - 1);
                k = 0;
            } else {
                ans = monkeys.get(k);
                monkeys.remove(k);
            }
            M++;
        }
        return ans;
    }
}
