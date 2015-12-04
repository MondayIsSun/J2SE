package io.mook.rafTrain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * �����ı��ļ����еķ��з��Ƿ�Ҳ��ռ�ֽ����ģ�
 */

public class TestRaf {

	public static void main(String[] args) throws IOException {

		// ��ȡ�����Ե��ı��ļ�
		// ����>\\���ʵ������ת���ַ���
		File file = new File("F:\\test1.txt");

		// ʹ��RandomAccessFile�����ļ�
		@SuppressWarnings("resource")
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		// System.out.println(raf.length());

		// ��֤��ǰָ���λ��
		System.out.println("һ��ʼָ���λ�á���>" + raf.getFilePointer());

		System.out.println((char) raf.readByte());// 1

		System.out.println("һ��ʼָ���λ�á���>" + raf.getFilePointer());

		System.out.println((char) raf.readByte());// 2

		System.out.println((char) raf.readByte());// 3

		System.out.println((char) raf.readByte());// 4

		System.out.println((char) raf.readByte());// 5

		System.out.println(raf.readByte());// 13����>\r

		System.out.println(raf.readByte());// 10����>\n

		System.out.println((char) raf.readByte());// a

		System.out.println((char) raf.readByte());// b

		System.out.println((char) raf.readByte());// c

		// ===================================================

		raf.seek(0);
		System.out.println("��ʼ�ַ���" + (char) raf.readByte());
		// raf.seek(raf.length() - 1);
		// System.out.println("��β�ַ���" + (char) raf.readByte());

		raf.seek(raf.length());
		System.out.println(raf.getFilePointer());
		System.out.println(raf.length());

		// ===================================================

		raf.seek(0);
		System.out.println(raf.readChar());

		// ���Լ�ס�����������ķ���һ���Ǻ�writeһ������

	}

}
