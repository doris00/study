package question;

import java.util.*;

public class AiQiYi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        s = s.trim();
        List<int[]> nums = new ArrayList<>();
        for(int i = 1; i < s.length() - 2; ++i) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(s.charAt(i + 1) == ',') {
                    int[] temp = new int[2];
                    temp[0] = s.charAt(i) - '0';
                    i = i + 2;
                    temp[1] = s.charAt(i) - '0';
                    nums.add(temp);
                }
            }
        }
        for(int[] a : nums) {
            System.out.println(a[0] + " " + a[1]);
        }
        System.out.println(erase(nums));
    }
    public static int erase(List<int[]> nums) {
        if(nums.size() == 0) {
            return 0;
        }
        Collections.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = nums.size();
        int right = nums.get(0)[1];
        int ans = 1;
        for(int i = 1; i < n; ++i) {
            if(nums.get(i)[0] >= right) {
                ++ans;
                right = nums.get(i)[1];
            }
        }
        return n - ans;
    }
}
