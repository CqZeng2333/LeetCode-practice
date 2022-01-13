/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 */
public class _12 {
    public String intToRoman(int num) {
        StringBuffer str = new StringBuffer("");
        int cur;
        if (num >= 1000) {
            cur = num / 1000;
            for (int i = 0; i < cur; i++) {
                str.append("M");
            }
            num -= cur * 1000;
        }
        if (num >= 900) {
            num -= 900;
            str.append("CM");
        }
        if (num >= 500) {
            str.append("D");
            num -= 500;
        }
        if (num >= 400) {
            num -= 400;
            str.append("CD");
        }

        if (num >= 100) {
            cur = num / 100;
            for (int i = 0; i < cur; i++) {
                str.append("C");
            }
            num -= cur * 100;
        }
        if (num >= 90) {
            num -= 90;
            str.append("XC");
        }
        if (num >= 50) {
            str.append("L");
            num -= 50;
        }
        if (num >= 40) {
            num -= 40;
            str.append("XL");
        }

        if (num >= 10) {
            cur = num / 10;
            for (int i = 0; i < cur; i++) {
                str.append("X");
            }
            num -= cur * 10;
        }
        if (num >= 9) {
            num -= 9;
            str.append("IX");
        }
        if (num >= 5) {
            str.append("V");
            num -= 5;
        }
        if (num >= 4) {
            num -= 4;
            str.append("IV");
        }

        while ((num--) > 0) {
            str.append("I");
        }

        return str.toString();
    }
}
