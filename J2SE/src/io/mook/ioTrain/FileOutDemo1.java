package io.mook.ioTrain;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// ������ļ������ڣ���ֱ�Ӵ�����������ڣ�ɾ���󴴽�(���Կ�������ÿ�ζ�����)
		// new FileOutputStream("demo/out.dat",true)����>��ʾ���Ǹ��Ƕ���׷��
		FileOutputStream out = new FileOutputStream("demo/out.dat");

		out.write('A');// д����'A'�ĵͰ�λ
		out.write('B');// д����'B'�ĵͰ�λ

		// writeֻ��д��λ,��ôдһ��int��ҪЩ4��ÿ��8λ
		int a = 10;
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);

		// Ҳ����ֱ��д�ֽ�����
		byte[] gbk = "�й�".getBytes("gbk");
		out.write(gbk);
		out.close();

		IOUtil.printHex("demo/out.dat");

	}

}
