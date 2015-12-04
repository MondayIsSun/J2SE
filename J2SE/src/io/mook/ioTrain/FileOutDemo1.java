package io.mook.ioTrain;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// 如果该文件不存在，则直接创建，如果存在，删除后创建(所以看起来是每次都覆盖)
		// new FileOutputStream("demo/out.dat",true)——>表示不是覆盖而是追加
		FileOutputStream out = new FileOutputStream("demo/out.dat");

		out.write('A');// 写出了'A'的低八位
		out.write('B');// 写出了'B'的低八位

		// write只能写八位,那么写一个int需要些4次每次8位
		int a = 10;
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);

		// 也可以直接写字节数组
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();

		IOUtil.printHex("demo/out.dat");

	}

}
