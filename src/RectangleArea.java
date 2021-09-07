public class RectangleArea {
    public int solution(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 两个面积和减去相交的部分面积
        int area_a = Math.abs((ax1 - ax2) * (ay1 - ay2));
        int area_b = Math.abs((bx1 - bx2) * (by1 - by2));
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return area_a + area_b - x * y;
    }
}
