package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 接雨水2
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 * 优先队列+BFS
 */
public class TrapRainWater {
    public static void main(String[] args) {

    }
    public static int trapRainWater(int[][] heightMap) {
        //解决特殊i情况
        int r = heightMap.length;
        int c = heightMap.length;
        if( r < 3 || c < 3) {
            return 0;
        }
        //构建pq,将最外圈放入pq，同时标记visited
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    queue.offer(new int[] {i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        //循环从pq取出元素，遍历其上下左右节点，如果找到比他小的内部节点，就灌水到等高
        //元素出队，入队内部节点，标记visited
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] dir = {-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i];
                int ny = cur[1] + dir[i + 1];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {
                    int temp = cur[2] - heightMap[nx][ny];
                    if(temp > 0) {
                        res += temp;
                    }
                    queue.offer(new int[] {nx, ny, Math.max(cur[2], heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
