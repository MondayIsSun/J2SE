package io.mook.rafTrain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafOP {

	public static void main(String[] args) throws IOException {

		// 创建File
		File demo = new File("demo");
		// 注意如果我们在创建File的时候没有指定路径，那么默认是相对路径的，
		// 就是在我们的项目的主目录下
		if (!demo.exists())
			demo.mkdir();

		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		// ==================================================================

		// 使用RandomAccessFile访问文件
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		// 验证当前指针的位置
		System.out.println("一开始指针的位置——>" + raf.getFilePointer());

		// 使用RandomAccessFile的好处
		// 断点续传，迅雷，多个线程下载文件的部分，每个部分下载好了以后需要拼接在一起，
		// 这个就是使用到了RandomAccessFile

		raf.write('A');// --->只写了一个字节,
		// 但是有可能这个字节就足够表示一个字符了，比如英文字符
		System.out.println("写一个字节后指针的位置——>" + raf.getFilePointer());

		// ==================================================================

		// java底层如何写入一个int类型的数据
		int i = 0x7fffffff;
		// 分四次写
		raf.write(i >>> 24);// 写高8位
		raf.write(i >>> 16);// 写第二个高8位
		raf.write(i >>> 8);// 写第三个高8位
		raf.write(i);// 默认就是写一个字节(低八位)
		// 这样才正真地把一个int类型的数据写入文件
		System.out.println("继续写完一个int类型数据后指针的位置——>" + raf.getFilePointer());

		// 但是其实raf也提供了直接写int的方法
		// 你可以点开查看源码——>实际上也是上面我们的处理方式的
		raf.writeInt(i);

		// ==================================================================

		// raf其实也可以直接写一个字节数组
		String s = "中";
		// 把字符串转换成字节数组
		byte[] gbk_byte = s.getBytes("gbk");
		raf.write(gbk_byte);

		System.out.println("此时文件的长度(字节数)——>" + raf.length());

		// ==================================================================

		// 读文件
		// 首先要做的必须是把指针移到开头位置
		raf.seek(0);

		// ==================================================================

		// 一次性读取，把文件当中的内容读到内存当中的字节数组中去
		// 定义字节数组
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);

		System.out.println(Arrays.toString(buf));

		String str = new String(buf);
		System.out.println(str);

		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		raf.close();

	}

}
