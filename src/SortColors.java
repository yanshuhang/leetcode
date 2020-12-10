public class SortColors {
    // 遍历计数,然后遍历设置值
    public void solution(int[] nums) {
        int i = 0, j = 0, k = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    i++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    k++;
            }
        }
        int index = 0;
        while (i > 0) {
            nums[index++] = 0;
            i--;
        }
        while (j > 0) {
            nums[index++] = 1;
            j--;
        }
        while (k > 0) {
            nums[index++] = 2;
            k--;
        }
    }

    // 遍历第一遍将0全部交换到前面
    // 遍历第二部将1全部放到0的后面
    public void solution1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }

    // 双指针一次遍历
    // 将0交换到前面,2交换到后面
    public void solution2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        // 一次遍历之后0-p0肯定都是0,p2-最后肯定都是2
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i]  = nums[p0];
                nums[p0] = temp;
                p0++;
            }
            // 由于可能将2交换到前面,所以将交换来的2再次放到后面
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
        }
    }
}
