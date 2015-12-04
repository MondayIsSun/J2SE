package io.mook.ioTrain.client;

import io.mook.ioTrain.IOUtil;

import java.io.IOException;

public class IOUtilTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			long start = System.currentTimeMillis();

			// 两种方式的效率对比：

			// IOUtil.printHexByByteArray("F:\\workspace\\myeclipse\\J2SE\\src\\io\\mook\\ioTrain\\IOUtil.java");

			IOUtil.printHex("F:\\workspace\\myeclipse\\J2SE\\src\\io\\mook\\ioTrain\\IOUtil.java");

			// IOUtil.printHexByByteArray("e:\\javaio\\1.mp3");

			System.out.println();

			long end = System.currentTimeMillis();

			System.out.println(end - start);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
