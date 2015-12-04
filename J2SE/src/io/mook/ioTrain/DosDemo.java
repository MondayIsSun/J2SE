package io.mook.ioTrain;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	public static void main(String[] args) throws IOException {

		String file = "demo/dos.dat";

		// 装饰者模式的典型应用
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);

		// 采用utf-8编码写出到文件中去
		dos.writeUTF("中国");

		// 采用utf-16be编码写出到文件中去
		dos.writeChars("中国");

		dos.close();

		IOUtil.printHex(file);
	}

}
