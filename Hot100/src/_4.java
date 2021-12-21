
public class _4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] sum = new int[length];
//        if ()
//        // 单数
//        if (length % 2 == 1) {
//        	int midIndex = length / 2;
//        	int i = 0, i1 = 0, i2 = 0;
//        	double mid;
//        	boolean isOne = nums1.length == 0 ? false : true;
//        	while (i != midIndex && i1 < nums1.length && i2 < nums2.length) {
//        		i++;
//        		if (nums1[i1] < nums2[i2]) {
//        			i1++;
//        			if (i == midIndex) {
//        				isOne = true;
//        			}
//        		}
//        		else {
//        			i2++;
//        			if (i == midIndex) {
//        				isOne = false;
//        			}
//        		}
//        	}
//        	// 找到中位数
//        	if (i == midIndex) {
//        		if (isOne) return nums1[i1];
//        		else return nums2[i2];
//        	}
//        	else {
//        		// 中位数在nums2
//        		if (i1 == nums1.length) {
//        			isOne = false;
//        			while (i != midIndex) {
//        				i2++;
//        				i++;
//        			}
//        			return nums2[i];
//        		}
//        		// 中位数在nums1
//        		else if (i2 == nums2.length) {
//        			isOne = true;
//        			while (i != midIndex) {
//        				i1++;
//        				i++;
//        			}
//        			return nums1[i];
//        		}
//        	}
//        }
//        // 偶数
//        else {
//        	int midIndex1 = length / 2 - 1;
//        	int midIndex2 = midIndex1 + 1;
//        }
        return 0;
	}
}
