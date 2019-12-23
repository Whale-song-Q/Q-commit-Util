package com.quhaiming.common.utils;

import java.awt.geom.Point2D;

public class RoadUtil {
	
	public static Point2D file (double X,double Y) {
		Point2D point2d=new Point2D.Double(X,Y);
		return point2d;
	}
	
	
	//计算距离
	public static double journey(double X,double Y) {
		//将输入得数字转换成角度
		double radiansAX=Math.toRadians(X);
		double radiansAY=Math.toRadians(Y);
		double radiansBX=Math.toRadians(116.5);
		double radiansBY=Math.toRadians(39.9);
		//long round = Math.round(Math.sqrt(Math.pow(X-39,2)+Math.pow(Y-116,2)));
		double cos=Math.cos(radiansAY)*Math.cos(radiansBY)*Math.cos(radiansAX-radiansBX)+Math.sin(radiansAY)*Math.sin(radiansBY);
		System.err.println("cos="+cos);
		double round=6371*Math.acos(cos);
		return round;
	}
	
	//判断是否在二环以内
	public static boolean two(double num) {
		if(num<15) {
			return true;
		}
		return false;
	} 
	
	//判断是否在四环以内
	public static boolean four(double num) {
		if(num<40) {
			return true;
		}
		return false;
	} 
	
	//判断是否在六环以内
		public static boolean five(double num) {
			if(num<60) {
				return true;
			}
			return false;
		} 
	
	public static double jo(double X,double Y) {
		double radiansAX=Math.toRadians(X);
		double radiansAY=Math.toRadians(Y);
		double radiansBX=Math.toRadians(116.5);
		double radiansBY=Math.toRadians(39.9);
		long round = Math.round(Math.sqrt(Math.pow(radiansAY-radiansBY,2)+Math.pow(radiansAX-radiansBX,2)));
		return round;
	}
}
