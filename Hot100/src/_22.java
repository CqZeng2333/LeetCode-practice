import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class _22 {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        addOneSide("", 0, 0, n);
        return result;
    }

    public void addOneSide(String pre, int unmatched, int numOfLeft, int maxLength) {
        if (pre.length() == 2 * maxLength) {
            result.add(pre);
            return;
        }

        if (unmatched == 0) {
            // Add a left parentheses
            addOneSide(pre + '(', unmatched + 1, numOfLeft + 1, maxLength);
        } else {
            if (numOfLeft < maxLength) {
                // Add a left parentheses
                addOneSide(pre + '(', unmatched + 1, numOfLeft + 1, maxLength);
                // Or add a right parentheses
                addOneSide(pre + ')', unmatched - 1, numOfLeft, maxLength);
            } else {
                while ((unmatched--) > 0) {
                    pre += ')';
                }
                result.add(pre);
                return;
            }
        }
    }
}
