/**
 * @Package:  
 * @author: cqzeng   
 * @date: 2021��4��26�� ����11:57:33 
 */

/** ������ת
 * @Package:  
 * @author: cqzeng   
 * @date: 2021��4��26�� ����11:57:33 
 */
public class _7 {
	public int reverse(int x) {
        int result = 0;
        int last;

        while (x != 0) {
            last = x % 10;
        	if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && last > 7) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && last < -8)) {
                return 0;
            }
            result = 10 * result + last;
            x /= 10;
        }

        return result;
    }
	
	public static void main(String[] args) {
		_7 main = new _7();
		System.out.println(main.reverse(1534236469));
	}
}
