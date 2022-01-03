package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class _043_MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply_S("2", "3"));
        System.out.println(multiply_S("123", "456"));
        System.out.println(multiply_S("123", "913"));
        System.out.println(multiply_S("9133", "0"));
    }

    public static String multiply_S(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int[] result = new int[n1.length + n2.length];
        for (int i = n1.length - 1; i >= 0; i--) {
            int target = n1[i] - '0';
            for (int j = n2.length - 1; j >= 0; j--) {
                int x1 = i + j;
                int multiply = (n2[j] - '0') * target + result[x1+1];
                result[x1] += multiply / 10;
                result[x1 + 1] = multiply % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            if(result[i] == 0 && sb.length() == 0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        StringBuilder result = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int target = num2.charAt(i) - '0', carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int multiply = (num1.charAt(j) - '0') * target + carry;
                carry = multiply / 10;
                int index = (num2.length() - i - 1) + (num1.length() - j - 1);
                add(result, multiply % 10, index);
            }
            if (carry > 0) { // 最后进位
                add(result, carry, (num2.length() - i - 1) + num1.length());
            }
        }
        return result.reverse().toString();
    }

    private static void add(StringBuilder pre, int add, int start) {
        if (pre.length() <= start) {
            pre.append(add);
        } else {
            int carry = add;
            for(int i = start; i < pre.length(); i++) {
                int c = pre.charAt(i) - '0' + carry;
                carry = c / 10;
                int x = '0' + (c % 10);
                pre.setCharAt(i, (char)x);
                if (carry == 0) break;
            }
            if (carry > 0) {
                pre.append("1");
            }
        }
    }
}
