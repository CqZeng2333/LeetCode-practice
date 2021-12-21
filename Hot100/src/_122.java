/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:10:28 
 */

/**买卖股票的最佳时期，不限制交易次数
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:10:28 
 */
public class _122 {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length, max_k = n / 2;
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
