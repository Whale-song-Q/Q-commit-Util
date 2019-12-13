package com.quhaiming.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月5日 下午2:20:43 

* 类说明 

*/
public class FileUtil {

	public static String getExtName(String filename){
		
		//处理空异常
		if(filename==null||"".equals(filename)){
			
			throw new RuntimeException("文件名不能为空");
			
		}
		String extend = filename.substring(filename.lastIndexOf("."));
		return extend;
		
	}
	//获取系统当前用户目录
	public static String getSystemUserHome(){
		
		return System.getProperty("user.home");
	}
	//获取系统临时文件
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	//读取文件内容
	public static String readTextFileLine(String pathname){
		
		BufferedReader br=null;
		StringBuffer sb = new StringBuffer();
		try {
			//先把文件名格式化为文件，后通过读流操作
			 br = new BufferedReader(new FileReader(new File(pathname)));
			do{
				//拼接字符串
				sb.append(br.readLine());
				sb.append("\r\n");
				
				
			}while(br.read()!=-1);	 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		StreamUtil.closeAll(br);
		}

		return sb.toString();
	}
	//按行读取文件内容到List集合
	@SuppressWarnings("resource")
	public static List<String> readTextFileOfList(String pathname){
		
		BufferedReader br=null;
		ArrayList<String> strlist = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));

			
			do {
				strlist.add(br.readLine());

			} while (br.read()!=-1);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			StreamUtil.closeAll(br);
		}
		return strlist;
	}
	
	//递归删除文件
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for(File theFile:listFiles) {
				deleteFile(theFile);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	//返回文件以指定单位大小表示
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
//		return Math.round((length/1024.0))+"kb";
		return String.format("%.2f",len)+"kb";
	}
	public static String getFileSize(String fileFullName) {
		return getFileSize(new File(fileFullName));
	}	
	
	public static void main(String[] args) {
		System.out.println(getSystemTempDirectory());
	}
	
	
	
	
	
	
	
	
	
	

	
	
}
