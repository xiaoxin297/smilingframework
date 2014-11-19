package com.smilingframework.core.runtime.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本处理工具
 * @author 王继永
 *
 */
public class TextUtils {

	public static boolean isEmail(String email){
		if (email == null || !email.contains("@") || email.length() < 5) {// 判断是否含有@符号
			return false;// 没有@则肯定不是邮箱
		}
		return true;
	}
	
	public static boolean isPhone(String phone){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	public static void main(String[] args) {
		boolean result = isPhone("13321439249");
		System.out.println(result);
	}
}

