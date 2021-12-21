/**
 * 最长回文子串
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:03:34
 */
public class _5 {
	int index;
	int len;
	public String longestPalindrome (String s) {
		if (s == null || s.length() == 0) return "";
		
        int length = s.length();
        index = 0;
        len = 1;
        for (int i = 0; i < length - 1; i++) {
        	this.decidePalidrome(s, i, i);
        	this.decidePalidrome(s, i, i+1);
        }
        return s.substring(index, index + len);
    }
	
	private void decidePalidrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		
		if (r - l - 1 > this.len) {
			index = l + 1;
			this.len = r - l - 1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new _5().longestPalindrome("ac"));
	}

}
