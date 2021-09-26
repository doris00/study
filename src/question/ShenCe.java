package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShenCe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        StringBuffer sb = new StringBuffer();
        List<String> sbList = new ArrayList<>();
        for(int i = 0; i <s.length();) {
            if(s.charAt(i) != ' ') {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                    i++;
                }
                sbList.add(sb.reverse().toString());
            }
            i++;
        }
        for(int i = 0; i < sbList.size() - 1; ++i) {
            System.out.print(sbList.get(i) + " ");
        }
        System.out.println(sbList.get(sbList.size() - 1));
    }
}
