package io.mook.ioTrain.client;

import io.mook.ioTrain.IOUtil;

import java.io.IOException;

public class IOUtilTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			IOUtil.printHex("F:\\workspace\\myeclipse\\J2SE\\src\\io\\mook\\ioTrain\\IOUtil.java");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
