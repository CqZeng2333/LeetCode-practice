import java.util.HashMap;
/**
 * 无重复字符的最长子串
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:02:30
 */
public class _3 {
	
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        
        int i = 0, j = 0;
        int max = 1;
        HashMap<Character, Integer> cList = new HashMap<>();
        cList.put(s.charAt(0), 0);
        
        while (j < s.length() - 1) {
        	j++;
        	
        	if (cList.containsKey(s.charAt(j)) && i <= cList.get(s.charAt(j))) {
        		i = cList.get(s.charAt(j)) + 1;
        	}
        	else {
        		if (max < j - i + 1) {
        			max = j - i + 1;
        		}
        	}
        	cList.put(s.charAt(j), j);
        	System.out.println(i+" "+j);
        }
        return max;
    }
	
	public static void main(String[] args) {
		_3 test = new _3();
		System.out.println(test.lengthOfLongestSubstring("bbbbbb"));
	}
}
