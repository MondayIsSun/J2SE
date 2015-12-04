package io.mook.rafTrain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 测试文本文件当中的否换行符是否也是占字节数的？
 */

public class TestRaf {

	public static void main(String[] args) throws IOException {

		// 获取到测试的文本文件
		// ——>\\这个实际上是转义字符啦
		File file = new File("F:\\test1.txt");

		// 使用RandomAccessFile访问文件
		@SuppressWarnings("resource")
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		// System.out.println(raf.length());

		// 验证当前指针的位置
		System.out.println("一开始指针的位置——>" + raf.getFilePointer());

		System.out.println((char) raf.readByte());// 1

		System.out.println("一开始指针的位置——>" + raf.getFilePointer());

		System.out.println((char) raf.readByte());// 2

		System.out.println((char) raf.readByte());// 3

		System.out.println((char) raf.readByte());// 4

		System.out.println((char) raf.readByte());// 5

		System.out.println(raf.readByte());// 13——>\r

		System.out.println(raf.readByte());// 10——>\n

		System.out.println((char) raf.readByte());// a

		System.out.println((char) raf.readByte());// b

		System.out.println((char) raf.readByte());// c

		// ===================================================

		raf.seek(0);
		System.out.println("开始字符：" + (char) raf.readByte());
		// raf.seek(raf.length() - 1);
		// System.out.println("结尾字符：" + (char) raf.readByte());

		raf.seek(raf.length());
		System.out.println(raf.getFilePointer());
		System.out.println(raf.length());

		// ===================================================

		raf.seek(0);
		System.out.println(raf.readChar());

		// 所以记住啦，像这样的方法一般是和write一起搭配的

	}

}
