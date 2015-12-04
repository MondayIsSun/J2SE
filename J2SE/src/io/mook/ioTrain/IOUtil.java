package io.mook.ioTrain;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * �������ֽ�����һ�½���ҪŪ�����������ֻ���ṩ�˿���ʹ���ֽ��������ļ��ķ�ʽ����������ļ���ȡ��һ���ֽڵ�ʱ��
	 * ���ܶ�ȡ��������ֽ�������û�������
	 */

	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨ ����ÿ���10��byte����
	 * 
	 * @param fileName
	 * 
	 *            ���ֽڶ�ȡ���ʺϴ��ļ������ļ�Ч�ʺܵ�
	 */
	public static void printHex(String fileName) throws IOException {

		// ���ļ���Ϊ�ֽ������ж�����
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		// ע�⣺in.read()�Ƕ�ȡһ���ֽ��޷�����䵽int(32λ��)�Ͱ�λ.
		// -1�� EOF����ʾ�ļ��Ѿ�����β��
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// ��λ��ǰ�油0
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
	 * ������ȡ���Դ��ļ�����Ч�ʸߣ�Ҳ��������õĶ��ļ��ķ�ʽ
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {

		FileInputStream in = new FileInputStream(fileName);

		// ���建���������С
		byte[] buf = new byte[8 * 1024];// 8M
		/*
		 * ��in��������ȡ�ֽڣ����뵽buf����ֽ������У� �ӵ�0��λ�ÿ�ʼ�ţ�����buf.length�� ���ص��Ƕ������ֽڵĸ���
		 */
		/*
		 * int bytes = in.read(buf,0,buf.length);//һ���Զ��꣬˵���ֽ������㹻�� int j = 1;
		 * for(int i = 0; i < bytes;i++){
		 * System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
		 * if(j++%10==0){ System.out.println(); } }
		 */

		// in.read(byte[] buf)
		// in.read(byte[] buf,int start,int size)
		// bytes = in.read(buf, 0, buf.length);
		// ע���ǰѶ��������ݷ���buf���������棬
		// ���Ƿ��ص���ʵ�ʶ������ֽ���

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
	 * �ļ��������ֽ�������ȡ
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�:" + srcFile + "������");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}

		// ���Ľ���copy�Ĳ���
		FileInputStream in = new FileInputStream(srcFile);
		// ע�⣺û�б�Ҫ�ж�destFile�Ƿ���ڣ���Ϊ�����ڻ��Զ�����
		FileOutputStream out = new FileOutputStream(destFile);

		byte[] buf = new byte[8 * 1024];
		int b;
		// ������>д
		// ���Ե��ж�ȡ�����ݵ�ʱ��b(��ȡ�����ֽ���)��buf���������ݵĳ�����һ����
		while ((b = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, b);
			out.flush();// ��ü���
		}
		in.close();
		out.close();

	}

	/**
	 * �����ļ��Ŀ��������ô�������ֽ���
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)
			throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�:" + srcFile + "������");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));

		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();
			// ˢ�»�����
			// ע���ˣ����ʱ�����Ҫflush�ˣ�������û�취д�뵽�ļ���ȥ
		}

		bis.close();
		bos.close();
	}

	/**
	 * ���ֽڣ�������������ļ�����
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile)
			throws IOException {

		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�:" + srcFile + "������");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
			out.flush();
			// ע������ط�����flush��û������ģ��������������
		}

		in.close();
		out.close();
	}

}
