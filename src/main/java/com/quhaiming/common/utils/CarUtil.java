package com.quhaiming.common.utils;


public class CarUtil {
	//判断是否为小汽车
	public static boolean isTypeC(String typestr) {
			if("C".equals(typestr)) {
				return true;
			}
			return false;
		}
		
	//判断是否是摩托车A型
	public static boolean isTypeMA(String typestr) {
			if("MA".equals(typestr)) {
				return true;
			}
			return false;
		}
	//获取车牌单双号，单号为1，双号为0
	public static int getCarIdNum(String CarId) {
			
			String param="\\d";
			for(int i=CarId.length()-1;i>-1;i--) {
				if(String.valueOf(CarId.charAt(i)).matches(param)) {
					return Integer.parseInt(String.valueOf(CarId.charAt(i)));
				}
			}
			return 0;
		}
	
	//判断是否为京牌
		public static boolean getIsJing(String CarId) {
			String jing=String.valueOf(CarId.charAt(0));
			if("京".equals(jing)) {
				return true;
			}
			return false;
		}
}
