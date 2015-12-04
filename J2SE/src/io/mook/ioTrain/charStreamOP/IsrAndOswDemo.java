package io.mook.ioTrain.charStreamOP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {

		// ǰ��˼ά��һ���ļ�ֻ������ĳһ�ֱ�����ʽ���ڵ�

		FileInputStream in = new FileInputStream(
				"F:\\workspace\\myeclipse\\J2SE\\src\\io\\mook\\ioTrain\\IOUtil.java");
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		// Ĭ����Ŀ�ı���,������ʱ��Ҫд�ļ�����ı����ʽ

		FileOutputStream out = new FileOutputStream(
				"e:\\javaio\\imoocutf81.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		/*
		 * int c ;
		 * 
		 * while((c = isr.read())!=-1){
		 * 
		 * System.out.print((char)c);
		 * 
		 * }
		 */

		char[] buffer = new char[8 * 1024];
		int c;
		/*
		 * ������ȡ������buffer����ַ����飬�ӵ�0��λ�ÿ�ʼ���ã�����buffer.length�� ���ص��Ƕ������ַ��ĸ���
		 */
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String s = new String(buffer, 0, c);
			System.out.print(s);
			osw.write(buffer, 0, c);
			osw.flush();
		}

		isr.close();
		osw.close();

	}

}
