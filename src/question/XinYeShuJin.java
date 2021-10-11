package question;

import java.util.Arrays;
import java.util.Scanner;

public class XinYeShuJin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        s = sc.nextLine();
        String[] arr = s.split(" ");
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}
