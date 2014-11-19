package com.smilingframework.core.runtime.utils;

import java.util.Random;

/**
 * 随机生成随机数
 * @author 王继永
 *
 */
public class RandomUtils {

	private static final String temp = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String[] temps = temp.split("");
	/**
	 * 生成自定义长度字符串
	 * @param size
	 * @return
	 */
	public static String random(int size){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < size; i ++){
			int num = Math.abs(random.nextInt()%temp.length()) ;
			sb.append(temps[num]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(random(10));
	}
}
