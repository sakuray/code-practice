package com.sakuray.code.practice.leetcode._0_99;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups
 * so that each group is a contiguous section all of the same character.
 * Then for each group, say the number of characters, then say the character.
 * To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 30
 *
 */
public class _038_CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String lastResult = countAndSay(n - 1);
        int count = 0; Character cur = null;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lastResult.length(); i++) {
            if (cur == null) {
                cur = lastResult.charAt(i);
                count++;
            } else {
                if (cur.equals(lastResult.charAt(i))) {
                    count++;
                } else {
                    result.append(count);
                    result.append(cur);
                    cur = lastResult.charAt(i);
                    count = 1;
                }
            }
        }
        result.append(count);
        result.append(cur);
        return result.toString();
    }
}
