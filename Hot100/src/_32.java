import java.util.Stack;
/**
 * ���Ч����
 * @Package:  
 * @author: cqzeng   
 * @date: 2021��4��26�� ����10:04:12
 */
public class _32 {
	public int longestValidParentheses (String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.push(i);
        	}
        	else {
        		if (stack.isEmpty()) {
        			start = i + 1;
        		}
        		else {
        			stack.pop();
        			maxLen = stack.isEmpty() ? Math.max(maxLen, i - start + 1) : Math.max(maxLen, i - stack.peek());
        		}
        	}
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new _32().longestValidParentheses("))))((()(("));
	}
}
