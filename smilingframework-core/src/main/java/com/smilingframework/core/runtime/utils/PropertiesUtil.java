package com.smilingframework.core.runtime.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

import org.springframework.util.StringUtils;

/**
 * properties 文件读取工具
 * 
 * @author robin wang
 * 
 */
public class PropertiesUtil {

	// 配置文件对象
	private static Properties prperties;
	private static PropertiesUtil propertiesInfo;

	/**
	 * 根据key取value
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		if (prperties != null && !StringUtils.isEmpty(key)) {
			return prperties.getProperty(key);
		}
		return "";
	}


	/**
	 * 
	 * 初始化配置文件
	 * 
	 * @param pathes
	 */
	public void init(String... pathes) {
		if (pathes != null) {
			pathes = getPropertiesInfo(pathes);
			loadProperties(pathes);// 读取配置文件
			return;
		} else {
			System.out.println("System:配置文件加载失败，原因：init初始化参数为 null");
		}
	}

	/**
	 * 载入配置文件信息
	 * 
	 * @param pathes
	 */
	private void loadProperties(String... pathes) {
		if (pathes == null || pathes.length == 0) {
			return;
		}
		String name = "";
		try {
			for (int i = 0; i < pathes.length; i++) {
				name = pathes[i];
				FileInputStream file;
				file = new FileInputStream(new File(pathes[i]));
				prperties.load(file);
				file.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("System警告：系统找不到指定文件:" + name);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("System警告：打开文件出现错误 ");
			e.printStackTrace();
		}

	}

	/**
	 * 初始化参数
	 * 
	 * @param pathes
	 * @return
	 */
	private String[] getPropertiesInfo(String[] pathes) {
		propertiesInfo = new PropertiesUtil();
		prperties = new Properties();
		return combinationPath(pathes);
	}

	/**
	 * 文件路径
	 * 
	 * @param pathes
	 * @return
	 */
	private String[] combinationPath(String[] pathes) {
		String bacePath = this.getClass().getResource("/").getPath();
		for (int i = 0; i < pathes.length; i++) {
			try {
				bacePath = URLDecoder.decode(bacePath, "UTF-8");
				pathes[i] = bacePath + pathes[i];
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return pathes;
	}

	/**
	 * 增加配置文件
	 * 
	 * @param path
	 *            单个文件
	 */
	public void add(String path) {
		if (prperties == null) {
			return;
		}
		String[] pathes = new String[] { path };
		add(pathes);
	}

	/**
	 * 增加配置文件
	 * 
	 * @param pathes
	 *            多个文件
	 */
	public void add(String[] pathes) {
		if (prperties == null) {
			return;
		}
		combinationPath(pathes);
		loadProperties(pathes);
	}

	// ///////////////////TEST/////////////////////////////////////
	public static void main(String[] args) {
		String[] infs = new String[] { "config/crm-interface-url.properties","config/crm-interface-code.properties" };
		PropertiesUtil pi = new PropertiesUtil();
		pi.loadProperties(infs);
		System.out.println("-------1---" + PropertiesUtil.getValue("service.host"));
		System.out.println("-------2---" + PropertiesUtil.getValue("respCode"));
	}
}
