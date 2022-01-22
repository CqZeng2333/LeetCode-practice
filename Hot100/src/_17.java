import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class _17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> num2letter = new HashMap<>();
        num2letter.put('2', "abc");
        num2letter.put('3', "def");
        num2letter.put('4', "ghi");
        num2letter.put('5', "jkl");
        num2letter.put('6', "mno");
        num2letter.put('7', "pqrs");
        num2letter.put('8', "tuv");
        num2letter.put('9', "wxyz");

        LinkedList<String> resultList = new LinkedList<>();
        String origStr = "";
        resultList.push(origStr);

        for (int i = 0; i < digits.length(); i++) {
            int count = resultList.size();
            while ((count--) > 0) {
                String preStr = resultList.pop();
                String rep = num2letter.get(digits.charAt(i));
                if (rep != null) {
                    for (int j = 0; j < rep.length(); j++) {
                        resultList.add(preStr + rep.charAt(j));
                    }
                }
            }
        }

        if (resultList.size() == 1 && resultList.peek().equals("")) {
            resultList.pop();
        }

        return resultList;
    }
}
