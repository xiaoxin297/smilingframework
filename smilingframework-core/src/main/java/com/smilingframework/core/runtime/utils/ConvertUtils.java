package com.smilingframework.core.runtime.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class ConvertUtils {

	/**
	 * 转换单个对象
	 * @param source
	 * @param target
	 */
	public static void convertObj(Object source,Object target){
		BeanUtils.copyProperties(source, target);
	}
	
	/**
	 * 转换List
	 * @param source
	 * @param target 
	 * @return
	 */
	public static <T> List<T>  convertList(List<?> source,Class<T> target){
		List<T> result = new ArrayList<>();
		try {
		for(Object o : source){
			T t = target.newInstance();
			BeanUtils.copyProperties(o, t);
			result.add(t);
		}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<A> list =new ArrayList<>();
		list.add(new A("1","2"));
		list.add(new A("1","2"));
		list.add(new A("1","2"));
		list.add(new A("1","2"));
		List<B> a = convertList(list, B.class);
		for(B b : a){
			System.out.println(b.p1 + " __  "+b.p2);
		}
	}
	public static class A{
		public A(){}
		public A(String p1 ,String p2){
			this.p1 = p1;
			this.p2 = p2;
		}
		String p1 = "";
		String p2 = "";
		public String getP1() {
			return p1;
		}
		public void setP1(String p1) {
			this.p1 = p1;
		}
		public String getP2() {
			return p2;
		}
		public void setP2(String p2) {
			this.p2 = p2;
		}
		
		
	}
	
	public static class B{
		public B(){}
		public B(String p1 ,String p2){
			this.p1 = p1;
			this.p2 = p2;
		}
		String p1 = "";
		String p2 = "";
		public String getP1() {
			return p1;
		}
		public void setP1(String p1) {
			this.p1 = p1;
		}
		public String getP2() {
			return p2;
		}
		public void setP2(String p2) {
			this.p2 = p2;
		}
	}
}
