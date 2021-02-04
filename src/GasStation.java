public class GasStation {
    public int solution(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            // count表示走了的站数
            int count = 0;
            while (count < n) {
                // 由于绕圈走,所以走到了哪一站需要求余
                int j = (i + count) % n;
                // 从i走到j的汽油和消耗
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                // 消耗大于汽油,走不到,重新选择起始站
                if (sumOfCost > sumOfGas) {
                    break;
                }
                count++;
            }
            // 走完了所有站,返回i即可
            if (count == n) {
                return i;
            } else {
                // 重新选择i: 从已走过的站起始肯定都还是走不过,所有选择下一站
                i = i + count + 1;
            }
        }
        return -1;
    }
}
