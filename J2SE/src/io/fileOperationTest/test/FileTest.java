package io.fileOperationTest.test;

import java.io.File;
import java.io.IOException;

public class FileTest {

	/*
	 * P19 任务：在学习File类的同时把java工程中的路径搞明白.
	 */

	/*
	 * File类的设计意图是:File类出现是对文件系统的---文件---以及---文件夹---进行对象的封装
	 * 以达到通过对象的思想来操作文件以及文件夹...
	 * 
	 * 在Java中，可以用File类来表示一个文件！！！（注意这里的文件可以是所有文件，包括文件夹）
	 * 
	 * 在Java中表示路径的时候,'\\'与'/'
	 */

	public static void main(String[] args) throws IOException {

		// 建立一个文件夹:
		File file_0 = new File("H:\\Dropbox\\file_0");
		// 单单这一句是没办法创建出文件或者文件夹,还得配合上file.mkdir()这一句才能创建出实实在在的文件夹
		if (!file_0.exists()) {
			// 如果不存在该文件夹
			file_0.mkdir();// 新建单个文件夹
		}

		// 建立多个文件夹:
		File file_1 = new File(
				"H:\\Dropbox\\file_1\\file_1_2\\file_1_2_3\\file_1_2_3_4");
		if (!file_1.exists()) {// 如果不存在该文件夹
			file_1.mkdirs();// 多个文件夹一起建
		}

		// File类新建普通的文件:
		File f_0 = new File("H:\\Dropbox\\file_0\\f_0.txt");
		f_0.createNewFile();
		/*
		 * 只有上面的两句配合才能实实在在地创建出一个文件 因为是创建文件而不是文件夹,所以如果没有事先执行前面的创建文件夹的代码,那么会报
		 * "java.io.IOException: 系统找不到指定的路径"异常
		 */

		// 获取文件或文件夹的名称,至于是文件还是文件夹那么要看程序员创建的是文件还是文件夹了:
		System.out.println("获取文件或文件夹的名字:" + f_0.getName());

		// 无论File对象封装的路径是什么都是获取绝对路径(即该文件或文件夹存在与硬盘上的物理位置):
		System.out.println("获取文件或文件夹的绝对路径:" + f_0.getAbsolutePath());

		// 当时File对象封装的路径是什么获取的就是什么:
		System.out.println("获取当时封装文件或文件夹时给出的路径:" + f_0.getPath());

		// 获取File对象封装文件或文件夹的父目录:
		System.out.println("获取File对象封装文件或文件夹的父目录:" + f_0.getParent());

		// 获取文件或文件夹的大小:
		System.out.println("获取文件的大小:" + f_0.length());

		// 获取文件或文件夹最后一次修改的时间:
		System.out.println("获取文件或文件夹最后一次修改的时间:" + f_0.lastModified());

		/*
		 * 利用下面的9行代码理解这两点知识点:
		 * 1、Java工程当中相对路径的基准目录是指这个Java工程所在的目录(至于Web工程的路径问题一般看使用的服务器)
		 * 2、(./)代表的是当前目录就是当前这个Java工程所在的目录; (../)代表的是当前目录的上一层目录; (/)代表上级目录;
		 */
		// 注意:---'./'---代表的含义:
		File f_1 = new File("./f_1.txt");
		f_1.createNewFile();
		// System.out.println(f_1.getAbsolutePath());

		// 下面这三行和上面三行的效果是一样的:
		File f_2 = new File("f_2.txt");
		f_2.createNewFile();
		// System.out.println(f_2.getAbsolutePath());

		// 注意:---'../'---代表的含义:
		File f_3 = new File("../f_3.txt");
		f_3.createNewFile();
		// System.out.println(f_3.getAbsolutePath());

		// 注意:---'/'---代表的含义:
		// File f_4 = new File("/f_4.txt");
		// f_4.createNewFile();

		// 删除文件或文件夹的操作(file_0、file_1):
		/*
		 * 注意:对于文件夹只能删除不带内容的空文件夹 对于带有内容的文件夹，不可直接删除，必须要从里往外删除
		 * 一句话就是:File.delete()用于删除某个文件或者空目录
		 */
		// if(f_0.exists()){
		// //判断是否为文件,是文件可以直接删除:
		// if(f_0.isFile()){
		// f_0.delete();
		// }else if (f_0.is) {
		//
		// }
		// }

	}

}
