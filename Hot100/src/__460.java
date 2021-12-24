import java.util.Arrays;

/**
 * Given target, a non-negative integer k and an integer array A sorted in ascending order,
 * find the k closest numbers to target in A,
 * sorted in ascending order by the difference between the number and target.
 * Otherwise, sorted in ascending order by number if the difference is same.
 *
 * source：领扣（LintCode）
 * link：https://www.lintcode.com/problem/460/
 */
public class __460 {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (k <= 0) {
            return new int[0];
        }

        int pos = findNearestPos(A, target);
        int[] result = new int[k];
        int i = 0;
        result[i++] = A[pos];

        int left = pos - 1, right = pos + 1;
        while ((--k) > 0 && (left >= 0 || right < A.length)) {
            if (left >= 0 && right < A.length) {
                if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                    result[i++] = A[left];
                    left -= 1;
                } else {
                    result[i++] = A[right];
                    right += 1;
                }
            } else if (left >= 0) {
                result[i++] = A[left];
                left -= 1;
            } else {
                result[i++] = A[right];
                right += 1;
            }
        }

        Arrays.sort(result);
        return result;
    }

    public int findNearestPos(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        int mid = start + (end - start) / 2;;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] == target){
                return mid;
            } else {
                end = mid;
            }
        }
        if (start == end) {
            return start;
        } else {
            return Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;
        }
    }

    public static void main(String[] args) {
        __460 main = new __460();
        System.out.println(main.kClosestNumbers(new int[] {1,2,3,4,6}, 4, 5));
    }
}
