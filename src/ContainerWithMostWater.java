public class ContainerWithMostWater {
    public static int solution(int[] height) {
        int result = 0;
        int i = 0;
        int k = height.length;
        while (i < k) {
            int h = 0;
            if (height[i] < height[k]) {
                h = height[i];
                result = Math.max(result, h * (k - i));
                while (i < k && height[i] <= h) {
                    i++;
                }
            } else {
                h = height[k];
                result = Math.max(result, h * (k - i));
                while (i < k && height[k] <= h) {
                    k--;
                }
            }
        }
        return result;
    }
}
