import graph.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node solution(Node node) {
        if (node == null) {
            return null;
        }
        // 1. 已处理过的旧node不再放入queue中
        // 2. node会被多个其它node连接,缓存下新node
        HashMap<Node, Node> visited = new HashMap<>();
        // 即将处理的旧node按层次放入队列
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            List<Node> neighbors = visited.get(n).neighbors;
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
