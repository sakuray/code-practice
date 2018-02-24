package com.sakuray.code.practice.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
		string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	
	ZigZag 格式就是将一个字符串转成N行，形状就是倒过来的NNN
 *
 */
public class _006_ZigZagConversion {

	public static void main(String[] args) {
		System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING", 3)));
		System.out.println("PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4)));
		System.out.println("PYAIHRNAPLSIIG".equals(convert("PAYPALISHIRING", 2)));
	}
	
	public static String convert(String s, int numRows) {
		if(numRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		int row = 0;
		int index = 0;
		boolean isInternal = true;
		for(int i = 0; i < s.length(); i++) {
			if(index >= s.length()) {	// 换行
				row++;
				index = row;
				isInternal = true;
				sb.append(s.charAt(index));
			} else {
				sb.append(s.charAt(index));
			}
			if(row == 0 || row == numRows - 1) {	// 第一行和最后一行
				index += ((numRows << 1) - 2);
			} else {	// 中间行分成两段
				if(isInternal) {
					index += (((numRows-row)<<1) - 2);
					isInternal = false;
				} else {
					index += (row<<1);
					isInternal = true;
				}
			}
		}
        return sb.toString();
    }
}
