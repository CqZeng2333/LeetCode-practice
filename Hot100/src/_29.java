/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 * For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1,
 * and if the quotient is strictly less than -2^31, then return -2^31.
 */
public class _29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }

        int quo = 0, sign;
        if (dividend == Integer.MIN_VALUE) { // Avoid -dividend over Integer.MAX_VALUE
            if (Math.abs(divisor) == 1) {
                return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (divisor == Integer.MIN_VALUE) {
                return 1;
            } else if (divisor > 0) {
                quo++;
                dividend += divisor;
            } else {
                quo++;
                dividend -= divisor;
            }
        } else if (divisor == Integer.MIN_VALUE) { // Avoid -divisor over Integer.MAX_VALUE
            return 0;
        } else if (Math.abs(divisor) == 1) { // Avoid too much iteration
            return divisor == 1 ? dividend : -1 * dividend;
        }

        if (dividend >= 0 && divisor > 0) {
            sign = 1;
        } else if (dividend >= 0 && divisor < 0) {
            sign = -1;
            divisor = -1 * divisor;
        } else if (dividend < 0 && divisor > 0) {
            sign = -1;
            dividend = -1 * dividend;
        } else {
            sign = 1;
            dividend = -1 * dividend;
            divisor = -1 * divisor;
        }

        while (dividend >= divisor) {
            int tot = divisor;
            int add = 1;
            while (dividend - tot >= tot) {
                tot += tot;
                add += add;
            }
            dividend -= tot;
            quo += add;
        }

        return sign * quo;
    }
}
