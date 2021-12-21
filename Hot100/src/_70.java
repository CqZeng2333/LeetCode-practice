/**
 * 爬楼梯
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:14:10
 */
public class _70 {
	public int climbStairs(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		int dpMinus1 = 2;
		int dpMinus2 = 1;
		
		int max = 0;
		for (int i = 3; i <= n; i++) {
			max = dpMinus1 + dpMinus2;
			dpMinus2 = dpMinus1;
			dpMinus1 = max;
		}
		return max;
    }
	
	public static void main(String[] args) {
		System.out.println(new _70().climbStairs(4));
	}
}
