package com.smilingframework.core.code;

import java.util.HashMap;
import java.util.Map;

public class SysCode {

	protected static Map<String, String> codeMap;
	
	public static final String SUCCESS = "000000";
	public static final String REQUESTERROR = "010000";
	
	
	static{
		if(codeMap == null){
			codeMap = new HashMap<>();
		}
		codeMap.put(SUCCESS, "成功");
		codeMap.put(REQUESTERROR, "请求参数错误");
	}
	
	/**
	 * 根据CODE获取对应的memo
	 * @param code
	 * @return
	 */
	public static String getMemo(String code){
		return codeMap.get(code);
	}
}
