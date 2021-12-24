/**
 * Given a sorted array (ascending order) and a target number,
 * find the first index of this number in O(log n)O(logn) time complexity.
 *
 * If the target number does not exist in the array, return -1.
 *
 * source：领扣（LintCode）
 * link：https://www.lintcode.com/problem/14/
 */
public class __14 {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int minFind = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
