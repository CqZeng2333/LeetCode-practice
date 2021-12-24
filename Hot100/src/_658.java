import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 * source：力扣（LeetCode）
 * link：https://leetcode-cn.com/problems/find-k-closest-elements
 */
public class _658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int posX = findNearestPos(arr, x);
        List<Integer> result = new ArrayList<>();
        result.add(arr[posX]);

        int left = posX - 1, right = posX + 1;
        while ((--k) > 0) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(arr[left]);
                    left -= 1;
                } else {
                    result.add(arr[right]);
                    right += 1;
                }
            } else if (left >= 0) {
                result.add(arr[left]);
                left -= 1;
            } else {
                result.add(arr[right]);
                right += 1;
            }
        }

        result.sort(Comparator.comparingInt(o -> o));
        return result;
    }

    public int findNearestPos(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        int mid = start + (end - start) / 2;;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (arr[mid] < x) {
                start = mid;
            } else if (arr[mid] == x){
                return mid;
            } else {
                end = mid;
            }
        }
        if (start == end) {
            return start;
        } else {
            return Math.abs(arr[start] - x) <= Math.abs(arr[end] - x) ? start : end;
        }
    }
}
