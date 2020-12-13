public class MaximalRectangle {
    // 每一层的每个点的高度找出其最大宽度即可
    // 相当于每一层求一次柱状图最大矩形
    public int solution(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];

        int ans = 0;
        for (char[] chars : matrix) {
            int[] left = new int[col];
            int[] right = new int[col];
            left[0] = -1;
            right[col - 1] = col;
            // 高度可以继承到下一层使用
            for (int j = 0; j < col; j++) {
                height[j] = chars[j] == '1' ? height[j] + 1 : 0;
            }
            for (int j = 1; j < col; j++) {
                int temp = j - 1;
                while (temp >= 0 && height[temp] >= height[j]) {
                    temp = left[temp];
                }
                left[j] = temp;
            }
            for (int j = col - 2; j >= 0; j--) {
                int temp = j + 1;
                while (temp < col && height[temp] >= height[j]) {
                    temp = right[temp];
                }
                right[j] = temp;
            }
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, (right[j] - left[j] - 1) * height[j]);
            }
        }
        return ans;
    }
}
