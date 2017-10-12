package com.sakuray.code_practice;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class _2_替换空格 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append(" We Are Happy ");
		System.out.println(replaceSpace(sb));
	}
	
	public static String replaceSpace(StringBuffer str) {
		if(str == null) return null;
		for(int i = 0; i < str.length(); i++) {
			if(' ' == str.charAt(i)) {
				str.replace(i, i+1, "%20");
			}
		}
		return str.toString();
    }
	
	// 最佳答案
	public String replaceSpace_S(StringBuffer str) {
        if(str==null){
            return null;
        }
       StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
