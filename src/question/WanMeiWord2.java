package question;

import java.util.Arrays;

public class WanMeiWord2 {
    public static int pre[];
    public static int m, n;
    public static Edge []edges;
    static class Edge implements Comparable<Edge> {
        public int u, v, w;
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    public static int find(int x) {
        int r = x;
        while (pre[r] != r) {
            r = pre[r];
        }
        int j = x, tmp;
        while (j != r) {
            tmp = pre[j];
            pre[j] = r;
            j = tmp;
        }
        return r;
    }
    public static int kruskal() {
        int tot = 1, sum = 0;
        for(int i = 1; i <= m + 1 && tot <= n; i++) {
            int a = find(edges[i].u);
            int b = find(edges[i].v);
            if(a != b) {
                sum += edges[i].w;
                pre[a] = b;
                tot++;
            }
        }
        return sum;
    }

    public static int minCost (int N, int[][] roads) {
        m = roads.length;
        n = N;
        pre = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            pre[i] = i;
        }
        for(int i = 0; i < m; ++i) {
            edges[i].u = roads[i][0];
            edges[i].v = roads[i][1];
            edges[i].w = roads[i][2];
            if(roads[i][3] == 1) {
                edges[i].w = 0;
            }
        }
        Arrays.sort(edges, 1, edges.length);
        return kruskal();
    }

    public static void main(String[] args) {
//        int N = 3;
//        int[][] roads = new int[N * (N - 1) / 2][4];
//        for (int i = 0; i < )
//        minCost(3,)
    }
}
