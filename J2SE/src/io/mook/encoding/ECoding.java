package io.mook.encoding;

/**
 * 初步了解编码
 */
public class ECoding {

	public static void main(String[] args) throws Exception {

		String s = "慕课ABC";
		byte[] byte1 = s.getBytes();
		// 注意这样获取到的本来就是以某种编码的字节序列(工程默认的编码)
		// 把字符串转换成字节序列，用的是项目默认的编码（gbk）

		// 这里很好理解，因为整个工程指定了编码了，所以程序必须使用该编码来获取，这样保证了获取的数据源不是乱码了
		// 但是JVM内部是按照Unicode编码进行处理了，所以其实会再次进行编码间的转换？

		// 什么是编码？
		// 编码实际上就是使用多少个bit位表示的一组序列来代表某一个字符
		// 所以，编码的计算机内部实际上就是以值的形式存储的

		// 所以我们完全可以使用程序把该字符转化成内部的编码以二进制或者十六进制显示给我们参考

		// 但是注意，计算机一次能处理的数据叫做字（注意字节是单位）

		// 以0x开头表示16进制
		// 以0开头表示8进制

		// 实际上这里的数组长度就可以验证该编码是使用多少字节进行编码的了
		System.out.println(byte1.length);
		// 7 = 2+2+1+1+1

		for (byte b : byte1) {

			// System.out.println("--->"+b);

			// 把字节转换成int类型并以16进制方式显示
			// 注意在Java当中int是4byte的
			// 注意我们已经是可以得知gbk的编码形式是使用几个字节进行编码的了，所以这里的位与运算是可以由此得知的

			// 由此得知GBK是使用两个字节进行编码的，由于被转化成了int类型，所以实际上高24位是用0补齐的
			// 但是前面的24个0是没有必要显示的，所以这里使用&去掉前面的24个0，只留下后8位，也就是一个一个字节地显示
			// 这里就不用考虑什么补码乱七八糟的东西了，顺着来就可以了
			// 1&1=1
			// 1&0=0
			System.out.print(Integer.toHexString(b & 0xff) + "  ");// ————>取低8位
		}

		// 上面的结论，GBK编码，中文占用两个字节，英文占用一个字节
		// 也就是说对于不同的字符GBK会自动缩减所需要的字节数

		System.out.println();

		// 当然我们也可以显示地指定编码
		byte[] byte2 = s.getBytes("utf-8");
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}

		// 上面的结论是，UTF-8编码中文占用三个字节，英文占用1个字节

		System.out.println();

		// java是双字节编码，无论是中文字符还是英文字符都是占用两个字节，所有字符都是双字节的
		byte[] byte3 = s.getBytes("utf-16be");
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}

		System.out.println();

		// 特别注意下面的知识点
		// 从上面我们知道我们获取字节数组或者字节流是可以指定编码的
		// 也就是字节有自己的编码

		// 那么当字节序列以某种编码时，这个时候想把这个字节序列变成字符串那么也需要使用这种编码方式，否则会出现乱码
		String str2 = new String(byte2);// 默认采用项目的编码，所以会乱码
		System.out.println(str2);

		String str3 = new String(byte2, "utf-8");
		System.out.println(str3);

		// 记住，文本文件里面放点其实就是字节序列
		// 可以是任意编码的字节的序列
		// 但是如果我们是在中文操作系统里面创建的文本，那么该文本只认识ansi编码

	}

}
