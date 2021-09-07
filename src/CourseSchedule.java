import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean solution(int numCourses, int[][] prerequisites) {
        // 广度遍历
        List<List<Integer>> edges = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        // 记录每个点的出度列表和入读数量
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indegree[info[0]]++;
        }

        // 入度为0的放入队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 如果有环，环内点的入度减不到0，visited一定小于课程数
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int course = queue.poll();
            for (int next : edges.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return visited == numCourses;
    }

    public boolean solution1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(edges, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> edges, int[] visited, int u) {
        visited[u] = 1;
        for (int v : edges.get(u)){
            if (visited[v] == 0) {
                if (!dfs(edges,visited, v)) {
                    return false;
                }
            } else if (visited[v] == 1) {
                return false;
            }
        }
        visited[u] = 2;
        return true;
    }
}
