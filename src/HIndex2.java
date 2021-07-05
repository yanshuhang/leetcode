public class HIndex2 {
    public int solution(int[] citations) {
        int i = 0;
        // 从大到小遍历引用数
        // i是已遍历的数量
        // 如果已遍历的数量大于下一个引用数，则当前i即使高引用次数，否则继续遍历
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

    public int solution2(int[] citations) {
        // 二分法
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] > len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
