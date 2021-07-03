public class HIndex2 {
    public int solution(int[] citations) {
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    public int solution1(int[] citations) {
        int len = citations.length;
        int index = 0;
        // 从小到大遍历引用数citation
        // 有len-index个论文的引用数大于等于citation
        // 根据定义，如果引用数citation比len-index大那么len-index即是高引用次数
        for (int citation : citations) {
            if (citation >= len - index) {
                return len - index;
            } else {
                index++;
            }
        }
        return 0;
    }
}
