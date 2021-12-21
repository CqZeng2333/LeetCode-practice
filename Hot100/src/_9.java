/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月28日 上午12:27:01 
 */

/** 回文数
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月28日 上午12:27:01 
 */
public class _9 {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int tempX = x;
		int reverse = 0;
		int last;
		while (tempX != 0) {
			last = tempX % 10;
			reverse = 10 * reverse + last;
			tempX /= 10;
		}
		
		return reverse == x;
	}
	
	public boolean isPalindrome2(int x) {
		if (x < 0) return false;
		
		String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
        	if (s.charAt(i) != s.charAt(j)) return false;
        	i++;
        	j--;
        }
        return true;
    }
	
	/**   
	* @Description: 
	*
	* @param:
	* @return：
	* @throws：
	*
	* @author: cqzeng
	* @date: 2021年4月28日 上午12:27:01 
	* 
	*/
	public static void main(String[] args) {
		_9 main = new _9();
		System.out.println(main.isPalindrome(11));
	}

}
