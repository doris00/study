package leetcode;

import java.util.*;

/**
 * 752打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'。每个拨轮可以自由旋转：例如把'9'变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenTheLock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] deadens = new String[n + 1];
        for(int i = 0; i <= n; ++i) {
            deadens[i] = sc.nextLine();
        }
        String target = sc.nextLine();
        System.out.println(openLock(deadens, target));

    }
    public static int openLock(String[] deadens, String target) {
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>(Set.of("0000"));
        Set<String> deadSet = new HashSet<>();
        for(String s : deadens) {
            if(s.equals("")) {
                continue;
            }
            deadSet.add(s);
        }
        for(int i = 0; !deque.isEmpty(); i++) {
            for (int j = deque.size(); j > 0; j--) {
                String poll = deque.poll();
                if(poll.equals(target)) {
                    return i;
                } else if (!deadSet.contains(poll) && !visited.contains(poll)) {
                    visited.add(poll);
                    List<String> nums = getNum(poll);
                    for(int k = 0; k < nums.size(); ++k) {
                        deque.offer(nums.get(k));
                    }
                }
            }
        }
        return -1;
    }

    private static List<String> getNum(String poll) {
        List<String> res = new ArrayList<>();
        char[] array = poll.toCharArray();
        for(int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            res.add(new String(array));
            array[i] = numSucc(num);
            res.add(new String(array));
            array[i] = num;
        }
        return res;
    }

    private static char numSucc(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }

    private static char numPrev(char num) {
        return num == '0' ? '9' : (char)(num - 1);
    }

}
