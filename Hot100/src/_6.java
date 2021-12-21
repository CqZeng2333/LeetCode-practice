import java.util.ArrayList;
import java.util.List;

/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:58:42 
 */

/** Z字形变换
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:58:42 
 */
public class _6 {
	
	public String convert(String s, int numRows) {
		if (s.length() <= numRows || numRows == 1) return s;
		
        List<List<Character>> heads = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
        	heads.add(new ArrayList<>());
        }
        
        int count = 0;
        int pos = 0;
        while (count < s.length()) {
        	while (pos != numRows - 1) {
        		if (count == s.length()) break;
        		
        		heads.get(pos).add((s.charAt(count)));
        		count++;
        		pos++;
        	}
        	
        	while (pos != 0) {
        		if (count == s.length()) break;
        		
        		heads.get(pos).add((s.charAt(count)));
        		count++;
        		pos--;
        	}
        }
        
        StringBuffer sbf = new StringBuffer();
        for (List<Character> list : heads) {
        	for (char c : list) {
        		sbf.append(c);
        	}
        }
        return sbf.toString();
    }
	
	public static void main(String[] args) {
		_6 main = new _6();
		System.out.println(main.convert("PAYPALISHIRING", 3));
	}
}
