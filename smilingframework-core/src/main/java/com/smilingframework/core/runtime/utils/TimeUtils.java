package com.smilingframework.core.runtime.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 格式化时间辅助类
 * 
 * @author tom
 * 
 */
public class TimeUtils {
	/** 日期格式yyyy-MM-dd字符串常量 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	/** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_FORMAT);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

	/**
	 * Date 类型 转换 String 格式 2010-8-8
	 * 
	 * @param Date
	 *            时间
	 * @return String 类型的时间
	 * */
	public static String date2String(Date date) {
		if (date == null) {
			return "";
		}
		return TimeUtils.dateFormat.format(date);
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public static String getNowDate() {
		Date date = new Date();
		return date2String(date);
	}

	/**
	 * Date 类型 转换 String
	 * 
	 * @param Date
	 *            时间
	 * @return String 类型的时间 格式 2010-8-8 8:12:46
	 * */
	public static String dateTime2String(Date date) {
		if (date == null) {
			return "";
		}
		return TimeUtils.dateTimeFormat.format(date);
	}

	/**
	 * 日期类型转换为 XXXX年xx月xx日
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Chinese(Date date) {
		if (date == null) {
			return "";
		}
		return formatDate2Chinese(date, DATE_FORMAT);
	}

	/**
	 * 日期类型转换为 XXXX年xx月xx日 xx点xx分xx秒
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTime2Chinese(Date date) {
		if (date == null) {
			return "";
		}
		return formatDate2Chinese(date, DATETIME_FORMAT);
	}

	/**
	 * 比较时间<br>
	 * 当前时间与date进行相比<br>
	 * 如果当前时间在date之前则返回-1<br>
	 * 如果当前时间与date相等则返回0<br>
	 * 如果当前时间在date之后则返回1<br>
	 * 
	 * @param date
	 * @return
	 */
	public static int compare(Date date) {
		Date now = new Date();
		return compareBase(now, date);
	}

	/**
	 * 比较时间<br>
	 * before与after进行相比<br>
	 * 如果before在after之前则返回-1<br>
	 * 如果before与after相等则返回0<br>
	 * 如果before在after之后则返回1<br>
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static int compare(Date before, Date after) {
		return compareBase(before, after);
	}

	private static int compareBase(Date before, Date after) {
		if (before.after(after)) {
			String a = date2Chinese(after);
			String b = date2Chinese(before);
			if (a.equals(b)) {
				return 0;
			}
			return 1;
		}
		if (before.before(after)) {
			return -1;
		}
		return 0;
	}

	/**
	 * 字符串转换为日期
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date stringToDate(String dateStr){
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * b - e 相差天数
	 * @param b
	 * @param e
	 * @return
	 */
	public static long subDay(Date b,Date e){
		return ((b.getTime()-e.getTime())/(24*60*60*1000));  
	}

	private static String formatDate2Chinese(Date date, String type) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		String year = String.valueOf(cal.get(Calendar.YEAR));// 年
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);// 月
		String day = String.valueOf(cal.get(Calendar.DATE));// 日
		String time = year + "年" + month + "月" + day + "日";
		if (DATE_FORMAT.equals(type)) {
			return time;
		} else if (DATETIME_FORMAT.equals(type)) {
			String hour = String.valueOf(cal.get(Calendar.HOUR));// 小时
			String minute = String.valueOf(cal.get(Calendar.MINUTE));// 分钟
			String second = String.valueOf(cal.get(Calendar.SECOND));// 秒
			return time + "  " + hour + "点" + minute + "分" + second + "秒";
		}
		return "";
	}
	
	/**
	 * 计算两个日期之间相差天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1,Date date2)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date1);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(date2);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
          
       return Integer.parseInt(String.valueOf(between_days));         
    }

	public static void main(String[] args) {
		// for (;;) {
		// String a = Date2String(new Date());
		// if (!"2011-09-13".equals(a)) {
		// System.out.println(a);
		// }
		// }
		System.out.println(getNowDate());
	}
}
