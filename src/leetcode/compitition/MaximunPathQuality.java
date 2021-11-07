package leetcode.compitition;


import java.util.ArrayList;

/**
 * 给你一张 无向图，图中有 n个节点，节点编号从 0到 n - 1（都包括）。同时给你一个下标从 0开始的整数数组values，其中values[i]是第 i个节点的 价值。同时给你一个下标从 0开始的二维整数数组edges
 * 其中edges[j] = [uj, vj, timej]表示节点uj 和vj之间有一条需要timej秒才能通过的无向边。最后，给你一个整数maxTime。
 *
 * 合法路径指的是图中任意一条从节点0开始，最终回到节点 0，且花费的总时间 不超过maxTime 秒的一条路径。你可以访问一个节点任意次。一条合法路径的价值定义为路径中不同节点的价值之和（每个节点的价值至多算入价值总和中一次）。
 *
 * 请你返回一条合法路径的 最大价值。
 *
 * 注意：每个节点 至多有四条边与之相连。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-path-quality-of-a-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//用回溯做，我回溯还是不会，好差劲呜呜
public class MaximunPathQuality {
    private int res = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        //list存放，节点对应的下一个节点信息
        ArrayList<int[]>[] list = new ArrayList[values.length];
        for (int i = 0; i < values.length; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(new int[] {edge[1], edge[2]});
            list[edge[1]].add(new int[] {edge[0], edge[2]});
        }
        int[] map = new int[values.length];
        map[0] = 1;
        dfs(0, maxTime, values[0], map, values, list);
        return res;
    }
    private void dfs(int node, int time, int curVal, int[] map, int[] values, ArrayList<int[]>[] list) {
        if (node == 0) {
            res = Math.max(res, curVal);
        }
        for (int[] next : list[node]) {
            if(time - next[1] < 0) {
                continue;
            }
            if (map[next[0]] == 0) {
                map[next[0]]++;
                dfs(next[0], time - next[1], curVal + values[next[0]], map, values, list);
            } else {
                map[next[0]]++;
                dfs(next[0], time - next[1], curVal, map, values, list);
            }
            map[next[0]]--;
        }
    }
}
