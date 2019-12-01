package com.zy.util;

public class TextUtils {
	/**
	 * 判断某个字符串是否为空
	 * @param s
	 * @return
	 * CharSequence是String的父类接口
	 */
	public static boolean isEmpty(CharSequence s) {
		return s==null||s.length()==0;
	}
}
