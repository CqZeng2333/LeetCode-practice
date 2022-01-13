/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class _11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int min(int a, int b) {
        return a <= b ? a : b;
    }
}
