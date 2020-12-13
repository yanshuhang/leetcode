import java.util.*;

public class RestoreIPAdress {
    public List<String> solutoin(String s) {
        int len = s.length();
        if (len < 4 || len > 12) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        // 存储ip地址的四段的数值
        int[] ip = new int[4];
        backtrack(ans, ip, s, 0, 0);
        return ans;
    }

    public void backtrack(List<String> ans, int[] ip, String s, int count, int start) {
        // ip地址的4段都填上后,判断是否使用了s中的所有字符
        // 如果是,则拼成字符串加入结果中
        if (count == 4) {
            if (start == s.length()) {
                ans.add(new StringBuilder().append(ip[0]).append('.').append(ip[1]).append('.').append(ip[2]).append('.').append(ip[3]).toString());
            }
            return;
        }
        // 已经使用完s中所有的字符,但是没有填完ip的4段
        if (start == s.length()) {
            return;
        }
        // 如果开头是0,直接填入
        if (s.charAt(start) == '0') {
            ip[count] = 0;
            backtrack(ans, ip, s, count + 1, start + 1);
        }

        int addr = 0;
        // 如果开头不是0,尝试能否将其放入ip段中
        // 如果能则放入然后进入递归,尝试放下一个ip段
        // 递归返回后将下一个字符放入当前ip段,
        // 递归返回后不需要剪枝,因为再次进入填写同一个ip段的方法时,addr为0,不会使用旧数据
        // 数值不符合规定时,跳出循环,因为继续for循环数值只会更大
        for (int end = start; end < s.length(); end++) {
            addr = addr * 10 + (s.charAt(end) - '0');
            if (addr > 0 && addr <= 255) {
                ip[count] = addr;
                backtrack(ans, ip, s, count + 1, end + 1);
            } else {
                break;
            }
        }
    }

    // 暴力法:找出ip地址的4段长度分别为1-3的所有情况
    // 1. 将字符串转换为int数值
    // 2. 只有数值在0-255之间,组合数值为ip字符串
    // 3. 判断ip长度是否是刚好多了3个点的长度: 如果不是说明4个数值对应的字符串中有0开头的,在转换为数值时0被删掉,导致长度变短了
    // 这个情况需要跳过
    // 4. 清理stringbuild对象进行下一个循环
    public List<String> solution1(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
                                if (ip.length() == s.length() + 3) {
                                    ans.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
