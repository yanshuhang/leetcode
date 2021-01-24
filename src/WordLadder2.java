import java.util.*;

public class WordLadder2 {
    public List<List<String>> solution(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 在生存路径的一层时, 一个未使用过节点可以与上一层的多个节点形成路径
            // 在下面的for循环中不在visited中的节点可以重复利用
            // 在for循环结束后新使用的节点全部加入到visited中,不可以再使用
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                String word = Objects.requireNonNull(list).get(list.size() - 1);
                ArrayList<String> neighbors = findNeighbors(word, dict);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            list.add(neighbor);
                            ans.add(new ArrayList<>(list));
                        } else {
                            list.add(neighbor);
                            queue.offer(new ArrayList<>(list));
                            list.remove(list.size() - 1);
                            subVisited.add(neighbor);
                        }
                    }
                }
            }
            // 生成路径的最新一层的所有节点加入到visited中
            visited.addAll(subVisited);
            // 如果找到,不需再找下一层了,bfs表明同一层的已经都找完了
            if (isFound) {
                break;
            }
        }
    }

    // 在dict中找到与word具有一个位置不同的所有单词
    private ArrayList<String> findNeighbors(String word, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) {
                    continue;
                }
                char old_ch = chars[i];
                chars[i] = ch;
                String neighbor = String.valueOf(chars);
                if (dict.contains(neighbor)) {
                    list.add(neighbor);
                }
                chars[i] = old_ch;
            }
        }
        return list;
    }
}
