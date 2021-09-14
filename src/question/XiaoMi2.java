package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XiaoMi2 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int temp;
        while (sc.hasNext()) {
            temp = sc.nextInt();
            nums.add(temp);
        }
        int[] numsArray = nums.stream().mapToInt(Integer::valueOf).toArray();
        int[] con = new int[4];
        for(int i = 0; i < numsArray.length; ++i) {
            con[numsArray[i]]++;
        }
        int j = 0;
        for(int i = 1; i <= 3; ++i) {
            while (con[i] != 0) {
                numsArray[j++] = i;
                con[i]--;
            }
        }
        for(int i = 0; i < numsArray.length; ++i) {
            System.out.print(numsArray[i] + " ");
        }
    }
}
