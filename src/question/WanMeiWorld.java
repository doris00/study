package question;

public class WanMeiWorld {
    public static String multiply (String num1, String num2) {
        // write code here
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int tag1 = 0, tag2 = 0;
        if(num1.charAt(0) == '-') {
            tag1 = 1;
        }
        if(num2.charAt(0) == '-') {
            tag2 = 1;
        }
        int[] ans = new int[m + n];
        for(int i = m - 1; i >= tag1; i--) {
            int x = num1.charAt(i) - '0';
            for(int j = n - 1; j >= tag2; j--) {
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }
        for(int i = m + n - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        int index = ans[0] == 0 ? 1 : 0;
        if((tag1 ^ tag2) == 1) {
            index = ans[1] == 0 ? 2 : 1;
        } else if (tag1 + tag2 == 2){
            index = ans[2] == 0 ? 3 : 2;
        }

        StringBuffer ansString = new StringBuffer();
        if((tag1 ^ tag2) == 1) {
            ansString.append('-');
        }
        while (index < m + n) {
            ansString.append(ans[index]);
            index++;
        }
        return ansString.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2","-2"));
    }
}
