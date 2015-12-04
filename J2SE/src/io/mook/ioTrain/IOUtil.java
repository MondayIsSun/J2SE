package io.mook.ioTrain;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 首先在字节流这一章节需要弄清楚的是我们只是提供了可以使用字节来操作文件的方式，但是你从文件读取到一个字节的时候，
	 * 可能读取到的这个字节数据是没有意义的
	 */

	/**
	 * 读取指定文件内容，按照16进制输出到控制台 并且每输出10个byte换行
	 * 
	 * @param fileName
	 * 
	 *            单字节读取不适合大文件，大文件效率很低
	 */
	public static void printHex(String fileName) throws IOException {

		// 把文件作为字节流进行读操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		// 注意：in.read()是读取一个字节无符号填充到int(32位的)低八位.
		// -1是 EOF，表示文件已经读到尾了
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// 单位数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + "  ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	/**
	 * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {

		FileInputStream in = new FileInputStream(fileName);

		// 定义缓冲区及其大小
		byte[] buf = new byte[8 * 1024];// 8M
		/*
		 * 从in中批量读取字节，放入到buf这个字节数组中， 从第0个位置开始放，最多放buf.length个 返回的是读到的字节的个数
		 */
		/*
		 * int bytes = in.read(buf,0,buf.length);//一次性读完，说明字节数组足够大 int j = 1;
		 * for(int i = 0; i < bytes;i++){
		 * System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
		 * if(j++%10==0){ System.out.println(); } }
		 */

		// in.read(byte[] buf)
		// in.read(byte[] buf,int start,int size)
		// bytes = in.read(buf, 0, buf.length);
		// 注意是把读到的内容放在buf缓冲区里面，
		// 但是返回的是实际读到的字节数

		int bytes = 0;
		int j = 1;
		while ((bytes = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}
		in.close();
	}

	/**
	 * 文件拷贝，字节批量读取
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}

		// 开心进行copy的操作
		FileInputStream in = new FileInputStream(srcFile);
		// 注意：没有必要判断destFile是否存在，因为不存在会自动创建
		FileOutputStream out = new FileOutputStream(destFile);

		byte[] buf = new byte[8 * 1024];
		int b;
		// 读——>写
		// 所以当有读取到数据的时候b(读取到的字节数)和buf里面有数据的长度是一样的
		while ((b = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, b);
			out.flush();// 最好加上
		}
		in.close();
		out.close();

	}

	/**
	 * 进行文件的拷贝，利用带缓冲的字节流
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)
			throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));

		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();
			// 刷新缓冲区
			// 注意了，这个时候必须要flush了，否者它没办法写入到文件中去
		}

		bis.close();
		bos.close();
	}

	/**
	 * 单字节，不带缓冲进行文件拷贝
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile)
			throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
			out.flush();
			// 注意这个地方，不flush是没有问题的，与上面的区别开来
		}

		in.close();
		out.close();
	}

}
