/**
 * 买卖股票的最佳时期，最多买卖k次
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:06:39
 */
public class _188 {
	public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length, max_k = k <= n / 2 ? k : n / 2;
        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++) {
        	dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            if (i == 0) {
                for (int j = 0; j <= max_k; j++) {
                	dp[i][j][0] = 0;
                	dp[i][j][1] = -prices[i];
                }
                continue;
            }
            
            for (int j = 1; j <= max_k; j++) {
            	dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            	dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        
        return dp[n - 1][max_k][0];
    }
}
