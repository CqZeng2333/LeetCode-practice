import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class _16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int curClosest = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - curClosest)) {
                    curClosest = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return curClosest;
    }
}
