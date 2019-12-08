package com.quhaiming.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月5日 下午1:42:47 

* 类说明 

*/
public class DateUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static int getAge(Date birthDate){
		
		//获得当前日期控件
		Calendar calendar = Calendar.getInstance();
		//获取当前年份
		int nowYear =calendar.get(calendar.YEAR);
		//获取当前月份
		int nowMonth=calendar.get(calendar.MONTH);
		//获取当前日期
		int nowDay=calendar.get(calendar.DAY_OF_MONTH);
		//设置生日
		calendar.setTime(birthDate);
		int birthYear =calendar.get(calendar.YEAR);
		int birthMonth=calendar.get(calendar.MONTH);
		int birthDay=calendar.get(calendar.DAY_OF_MONTH);
		//年龄
		int age =nowYear-birthYear;
		//如果生日月份大于当前月份时，年龄-1
		if(birthMonth>nowMonth){ 
			age--;
			
		}
		if(birthMonth==nowMonth && nowDay<birthDay){
			age--;
		}
		
		
		return age;
	}
	/**
	 * 根据出生日期计算年龄
	 * "2019-11-08"
	 * 
	 * */
	public static int getAge(String birthDateStr){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthDate=null;
		try {
			//将字符串转成日期格式
			birthDate = simpleDateFormat.parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用静态方法推算年龄
		return getAge(birthDate);
	}
	
	//获取开始日期和结束日期之间有多少天  
	public static int getDayNum(Date date1,Date date2) {
		//一天有多少毫秒
		Long dayTime = 1000*60*60*24L;
		Long startTime = date1.getTime();
		Long endTime = date2.getTime();
//		System.out.println(startTime);
//		System.out.println(endTime);
		Double dayNum = Math.abs(((endTime-startTime)/dayTime*1.0));
//		dayNum = Math.ceil(dayNum);
//		System.out.println(dayNum);
		return dayNum.intValue()+1;
	}
	//计算指定日期距离今天，过去了多少天或还有多少天
	public static int getDayNum(Date date) {
		Date date2 = new Date();
		return getDayNum(date,date2);
	}
	//验证指定日期是否为今天(日期形式的实参)
	public static boolean isToday(Date theDate) {
		Date nowDate = new Date();
		String nowDateStr = dateFormat.format(nowDate);
		String theDateStr = dateFormat.format(theDate);
		return nowDateStr.equals(theDateStr);
	}
	//验证指定日期是否为今天 （字符串形式的实参）
	public static boolean isToday(String theDateStr) {
		try {
			Date theDate = dateFormat.parse(theDateStr);
			return isToday(theDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	//判断指定日期是否在本周
	public static boolean isInWeek(Date theDate) {
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowWeek = c.get(Calendar.WEEK_OF_YEAR);
		c.setTime(theDate);
		int theYear = c.get(Calendar.YEAR);
		int theWeek = c.get(Calendar.WEEK_OF_YEAR);
		return nowYear==theYear && nowWeek==theWeek;
	}
	//获取指定月份的第一天
	public static Date getFirstDateInMonth(Date theDate) {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		String dateStr = format.format(theDate);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		Calendar c = Calendar.getInstance();
		c.setTime(theDate);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	//获取指定日期的最后一天
	public static Date getLastDateInMonth(Date theDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(theDate);
		c.add(Calendar.MONTH, 1);
		Date firstDateInMonth = getFirstDateInMonth(c.getTime());
		c.setTime(firstDateInMonth);
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}	
	//描述这个方法的作用
	public static int compareTime(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入格式为“yyyy-MM-dd”格式的出生年月日：");
		String birth=sc.nextLine();
		System.err.println("年龄："+getAge(birth));
		
	}
	
	
	
	
	
	
}
