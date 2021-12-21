import java.util.ArrayList;

/**
 * 二进制求和
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:05:30
 */
public class _67 {
	public String addBinary(String a, String b) {
		ArrayList<Character> stack = new ArrayList<>();
		int same = Math.min(a.length(), b.length());
		
		boolean carry = false;
		int i = a.length() - 1;
		int j = b.length() - 1;
		for (int k = 0; k < same; k++) {
			if (a.charAt(i) == '0' && b.charAt(j) == '0') {
				if (carry == false) {
					stack.add('0');
					carry = false;
				}
				else {
					stack.add('1');
					carry = false;
				}
			}
			else if (a.charAt(i) == '0' && b.charAt(j) == '1' || a.charAt(i) == '1' && b.charAt(j) == '0') {
				if (carry == false) {
					stack.add('1');
					carry = false;
				}
				else {
					stack.add('0');
					carry = true;
				}
			}
			else if (a.charAt(i) == '1' && b.charAt(j) == '1') {
				if (carry == false) {
					stack.add('0');
					carry = true;
				}
				else {
					stack.add('1');
					carry = true;
				}
			}
			i--;
			j--;
		}
		
		while (i > -1) {
			if (a.charAt(i) == '0' && carry == false) {
				stack.add('0');
				carry = false;
			}
			else if (a.charAt(i) == '0' && carry == true || a.charAt(i) == '1' && carry == false) {
				stack.add('1');
				carry = false;
			}
			else if (a.charAt(i) == '1' && carry == true) {
				stack.add('0');
				carry = true;
			}
			i--;
		}
		
		while (j > -1) {
			if (b.charAt(j) == '0' && carry == false) {
				stack.add('0');
				carry = false;
			}
			else if (b.charAt(j) == '0' && carry == true || b.charAt(j) == '1' && carry == false) {
				stack.add('1');
				carry = false;
			}
			else if (b.charAt(j) == '1' && carry == true) {
				stack.add('0');
				carry = true;
			}
			j--;
		}
		
		if (carry == true) {
			stack.add('1');
		}
		
		char[] temp = new char[stack.size()];
		int size = stack.size();
		for (int k = 0; k < size; k++) {
			temp[k] = stack.get(size - k - 1);
		}
		return new String(temp);
	}
	
	public static void main(String[] args) {
		System.out.println(new _67().addBinary("1010","1011"));
	}
}
