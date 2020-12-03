import java.util.ArrayList;
import java.util.List;

public class ZigZagconversion {
    public static void solution(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        int spaceNum = 2;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            for (int i = 0; i < spaceNum; i++) {
                list.get(curRow).append(" ");
            }
            spaceNum = spaceNum - 1;
            if (spaceNum < 0) {
                spaceNum = 2;
            }
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        for (StringBuilder stringBuilder : list) {
            System.out.println(stringBuilder);
        }
    }

    public static void main(String[] args) {
        solution("LEETCODEISHIRING", 4);
    }
}
