import java.util.*;

public class WordLadder {
    public int solution(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // bfs每遍历一层+1
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (canConvert(Objects.requireNonNull(word), s)) {
                        if (s.equals(endWord)) {
                            return count+1;
                        }
                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }

    // 使用数组代替set
    public int solution1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) {
            visited[index] = true;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) {
                        continue;
                    }
                    String s = wordList.get(j);
                    if (canConvert(Objects.requireNonNull(word), s)) {
                        if (s.equals(endWord)) {
                            return count+1;
                        }
                        visited[j] = true;
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }

    // 双向bfs, 分别从beginword和endword遍历图, 如果遇到对方已遍历过的word说明已找到路径
    public int solution2(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        // 双向bfs的两个队列
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count1 = 0;
        int count2 = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count1++;
            int size1 = queue1.size();
            while (size1-- > 0) {
                String word = wordList.get(Objects.requireNonNull(queue1.poll()));
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (canConvert(word, wordList.get(i))) {
                        if (visited2.contains(i)) {
                            return count1 + count2 + 1;
                        }
                        visited1.add(i);
                        queue1.offer(i);
                    }
                }
            }
            count2++;
            int size2 = queue2.size();
            while (size2-- > 0) {
                String word = wordList.get(Objects.requireNonNull(queue2.poll()));
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited2.contains(i)) {
                        continue;
                    }
                    if (canConvert(word, wordList.get(i))) {
                        if (visited1.contains(i)) {
                            return count1 + count2 + 1;
                        }
                        visited2.add(i);
                        queue2.offer(i);
                    }
                }
            }
        }
        return 0;
    }

    // 优化双向bfs: 每次遍历一层时,选择节点更少的一端
    public int solution3(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<Integer> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<Integer> set_temp = visited1;
                visited1 = visited2;
                visited2 = set_temp;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String word = wordList.get(Objects.requireNonNull(queue1.poll()));
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (canConvert(word, wordList.get(i))) {
                        if (visited2.contains(i)) {
                            return count+1;
                        }
                        visited1.add(i);
                        queue1.offer(i);
                    }
                }
            }
        }
        return 0;
    }

    // 优化每个单词的下一层单词方法
    public int solution4(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> q_temp = queue1;
                queue1 = queue2;
                queue2 = q_temp;
                Set<String> s_temp = visited1;
                visited1 = visited2;
                visited2 = s_temp;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String word = Objects.requireNonNull(queue1.poll());
                ArrayList<String> neighbors = findNeighbors(word, dict);
                for (String neighbor : neighbors) {
                    if (visited1.contains(neighbor)) {
                        continue;
                    }
                    if (visited2.contains(neighbor)) {
                        return count+1;
                    }
                    queue1.offer(neighbor);
                    visited1.add(neighbor);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public ArrayList<String> findNeighbors(String word, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String new_word = String.valueOf(chars);
                if (dict.contains(new_word)) {
                    list.add(new_word);
                }
            }
            chars[i] = old;
        }
        return list;
    }
}
