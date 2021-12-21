/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月27日 下午11:14:14 
 */

/** 字符串转换整数 (atoi)
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月27日 下午11:14:14 
 */
public class _8 {

	public int myAtoi(String s) {
		// remove space
		if (s == null) return 0;
        s = s.trim();
        // deal with s of length 0 or length 1
        if (s.length() == 0) return 0;
        if (s.length() == 1) {
        	if (s.charAt(0) <= '9' && s.charAt(0) >= '0') {
        		return Integer.valueOf(s);
        	}
        	else {
        		return 0;
        	}
        }
        
        // decide symbol of s
        char c = s.charAt(0);
        boolean isPositive;
        int index;
        if (c == '-') {
        	isPositive = false;
        	index = 1;
        }
        else if (c == '+') {
        	isPositive = true;
        	index = 1;
        }
        else {
        	isPositive = true;
        	index = 0;
        }
        
        // remove zero
        while (index < s.length() && s.charAt(index) == '0') index++;
        
        // get the number
        StringBuffer sbf = new StringBuffer();
        while (index < s.length() && (c = s.charAt(index)) <= '9' && c >= '0') {
        	sbf.append(c);
        	index++;
        }
        if (sbf.length() == 0) return 0;
        
        // decide over integer
        boolean isInteger;
        String mInteger;
        int i;
    	if (!isPositive) { // negative
    		sbf.insert(0, '-');
    		mInteger = String.valueOf(Integer.MIN_VALUE);
    		i = 1;
    	}
    	else { // positive
    		mInteger = String.valueOf(Integer.MAX_VALUE);
    		i = 0;
    	}
		if (sbf.length() > mInteger.length()) {
			isInteger = false;
		}
		else if (sbf.length() == mInteger.length()) {
        	isInteger = true;
        	while (i < sbf.length()) {
        		if (sbf.charAt(i) == mInteger.charAt(i)) {
            		i++;
        		}
        		else if (sbf.charAt(i) < mInteger.charAt(i)) {
        			isInteger = true;
        			break;
        		}
        		else if (sbf.charAt(i) > mInteger.charAt(i)) {
        			isInteger = false;
        			break;
        		}
        	}
        }
		else {
			isInteger = true;
		}
    	return isInteger ? Integer.parseInt(sbf.toString()) : (isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE);
    }

	/**   
	* @Description: 
	*
	* @param:
	* @return：
	* @throws：
	*
	* @author: cqzeng
	* @date: 2021年4月27日 下午11:14:14 
	* 
	*/
	public static void main(String[] args) {
		_8 main = new _8();
		System.out.println(main.myAtoi("2147483646"));
	}

}
