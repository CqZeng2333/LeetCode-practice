/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class _28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        int[] next = generateNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] generateNext(String pat) {
        char[] charPat = pat.toCharArray();
        int[] next = new int[charPat.length];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < charPat.length - 1) {
            if (k == -1 || charPat[j] == charPat[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
