package com.quhaiming.common.utils;

import java.util.Random;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月5日 下午2:37:04 

* 类说明 

*/
public class RandomUtil {

	
	//获取最小数和最大数值之间的随机数
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	//获得最小数和最大数之间的多个随机数
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
	
	
}
