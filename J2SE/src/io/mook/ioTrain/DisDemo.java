package io.mook.ioTrain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		String file = "demo/dos.dat";
		IOUtil.printHex(file);

		DataInputStream dis = new DataInputStream(new FileInputStream(file));

		// 下面读的顺序是与我们之前在DosDemo当中写的顺一致的

		int i = dis.readInt();
		System.out.println(i);

		i = dis.readInt();
		System.out.println(i);

		long l = dis.readLong();
		System.out.println(l);

		double d = dis.readDouble();
		System.out.println(d);

		String s = dis.readUTF();
		System.out.println(s);

		dis.close();
	}

}
