package com.quhaiming.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

import javax.sound.midi.SysexMessage;
/**
 * 流工具类
 * @Description:TODO(描述这个类的作用)   
 * @author: quhaiming1002
 * @date:   2019年12月5日 下午1:31:39
 */
public class StreamUtil {
	/**
	 * 关闭流的方法
	 * @Title: closeAll   
	 * @Description: 数组参数，可以批量删除多个打开的流   
	 * @param: @param autoCloseables      
	 * @return: void      
	 * @throws
	 */
	public static void closeAll(AutoCloseable... autoCloseables ) {
		if(autoCloseables!=null) {
			for(AutoCloseable autoCloseable:autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @Title: readTextFile   
	 * @Description: 以流的方式，读取文本文件内容   
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			String str = null;
			while (inputStream.read(b)!=-1) {
				str += new String(b);
			}
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll(inputStream);
		}
	}
	/**
	 * @Title: getFileContent   
	 * @Description: 根据文件全名读取文件内容   
	 * @param: @param fileFullName
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(String fileFullName) {
		return readTextFile(new File(fileFullName));
	}
	
	public static void writeTextFile(String content,File file,boolean append) {
		BufferedWriter writer = null;
		try {
			//判断写文件的文件夹是否存在
			String parent = file.getParent();
			File parentFile = new File(parent);
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			//写文件
			writer = new BufferedWriter(new FileWriter(file,append));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeAll(writer);
		}
	}
	
	public static void writeTextFile(String content,String fileFullName,boolean append) {
		writeTextFile(content,new File(fileFullName), append);
	}

	public static void main(String[] args) throws ParseException  {
		/*String readTextFile = readTextFile("C:\\Users\\Administrator\\Desktop\\pom.xml");
		writeTextFile(readTextFile, "C:\\Users\\Administrator\\Desktop\\aa\\aa.xml",false);*/
		
		//关闭流方法
/*		BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/72348/Desktop/aaa.txt")));
		System.err.println("br信息"+br);
		closeAll(br);
		System.err.println("关闭字符输入流"+br);*/
		
		//内部调用关闭流方法
/*		BufferedReader br = null;
		try {
			
					br=new BufferedReader(new FileReader(new File("C:/Users/72348/Desktop/aaa.txt")));
					System.err.println("br:"+br);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			closeAll(br);
			System.err.println("关闭流成功");
		}*/
		
		DateUtil dateUtil = new DateUtil();
		String data1="2019-05-18 11:37:22";
		Date date = dateUtil.dateFormat.parse(data1);
		
		
		String  data2="2019-02-28 23:59:59";
		 Date parse = dateUtil.dateFormat.parse(data1);
		 
		
		String sql = "select * from t_order where create_time>='{"+dateUtil.getFirstDateInMonth(date)+"}' and create_time<='{"+dateUtil.getLastDateInMonth(parse)+"}' ";
		
		System.err.println("拼凑后的sql语句"+sql);
		
	}
}
