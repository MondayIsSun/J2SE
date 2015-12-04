package io.fileOperationTest;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		// 首先要知道的是File类不是IO，所以并不需要异常处理
		// File类是一个工具类,是IO里面一个辅助类
		// File处理的文件目录和普通文件当作句柄

		File file = new File(".");

		try {

			String absolutePath = file.getAbsolutePath();
			/*
			 * 获取的是整个工程的所在路径 H:\MyEclipseWorkSpace\A_IO_operation
			 */
			String canonicalPath = file.getCanonicalPath();
			System.out.println("绝对路径：" + absolutePath);
			System.out.println("相对路径：" + canonicalPath);

			File dir = new File("register");
			// File文件中很多方法都是返回Boolean类型的结果。
			System.out.println("相对路径:" + dir.exists());
			if (!dir.exists()) {
				dir.mkdirs();// 创建路径
			}

			File file1 = new File(dir, "register.txt");// 通过路径获取文件
			if (!file1.exists()) {
				file.createNewFile();// 条件满足创建register.txt
			} else {
				file.canExecute();// 执行文件
			}
			System.out.println(file.getParent());
			System.out.println("是否可执行:" + file.canExecute());
			System.out.println("是否可读:" + file.canRead());
			System.out.println("获取当前文件:" + file.getAbsoluteFile());
			file.delete();
			dir.delete();
			// file.deleteOnExit();//删除文件并退出
			// dir.delete();//删除路径并退出
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
