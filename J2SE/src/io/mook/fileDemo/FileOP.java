package io.mook.fileDemo;

import java.io.File;
import java.io.IOException;

public class FileOP {

	public static void main(String[] args) throws IOException {

		// File类的API

		// File file = new File("F:\\fileOP");
		File file = new File("F:" + File.separator + "fileOP");
		// 这个只是告诉这个对象要处理的文件或文件夹的路径，但是这个文件或文件夹是否存在是另一回事了
		File file2 = new File("F:\\fileOP\\日记1");
		// File file2 = new File("F:\\fileOP","日记1.txt");
		// "\\",这个是转义字符

		// 由上面的两句代码可发现File类表示目录也表示文件

		System.out.println(file.exists() ? "该目录存在——>删除" : "该目录不存在——>创建");

		if (!file.exists()) {
			file.mkdir();// 注意mkdir和mkdirs只是创建目录
			// file.mkdirs();

			// 判断是否是目录，如果是目录返回true，如果不是目录或者目录不存在返回false
			System.out.println(file.isDirectory() ? "是目录" : "是文件");

			// 判断是否是文件
			System.out.println(file.isFile() ? "是目录" : "是文件");

			if (!file2.exists()) {
				file2.createNewFile();// 创建文件
			}

			// 常用方对象的api
			System.out.println(file);// F:\fileOP，file.toString的内容
			// 实际上是调用了file的toString方法进行打印输出的
			System.out.println("绝对路径——>" + file.getAbsolutePath());
			System.out.println("该文件目录的上层目录——>" + file.getParent());
			System.out.println(file2.getName());
			System.out.println(file2.getParent());

		} else {
			file2.delete();
			file.delete();
		}

	}

}
