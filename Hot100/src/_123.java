/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:11:54 
 */

/**买卖股票的最佳时期，最多买卖2次
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:11:54 
 */
public class _123 {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length, max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++) {
        	dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            if (i == 0) {
                for (int k = 0; k <= max_k; k++) {
                	dp[i][k][0] = 0;
                	dp[i][k][1] = -prices[i];
                }
                continue;
            }
            
            for (int k = 1; k <= max_k; k++) {
            	dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
            	dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        
        return dp[n - 1][max_k][0];
    }
}
