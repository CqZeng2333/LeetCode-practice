/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class _14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int len = 0;
        boolean flag = true;
        while (flag) {
            if (len >= strs[0].length()) {
                break;
            }
            char ch = strs[0].charAt(len);
            for (int i = 1; i < strs.length; i++) {
                if (len >= strs[i].length() || strs[i].charAt(len) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                len++;
            }
        }
        return len == 0 ? "" : strs[0].substring(0, len);
    }
}
