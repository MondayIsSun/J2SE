package io.mook.ioTrain.charStreamOP;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
	public static void main(String[] args) throws IOException {

		// ע�⣺���ķ���֮���ǲ���Ҫָ��������
		// ���ǲ�����˵�㲻��Ҫȥ�����ļ����������ˣ���������������Ĭ�Ͼ���ʹ�õ���ĿĬ�ϵı�����д����
		// �������Ĭ�ϵ���Ŀ���ļ�ͬ��������������⣬��ô���ʱ��͵�ʹ��FileInputStream��InputStreamReader������

		FileReader fr = new FileReader("e:\\javaio\\imooc.txt");
		FileWriter fw = new FileWriter("e:\\javaio\\imooc2.txt");
		// FileWriter fw = new FileWriter("e:\\javaio\\imooc2.txt",true);

		char[] buffer = new char[2056];
		int c;
		while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
			fw.write(buffer, 0, c);
			fw.flush();
		}

		fr.close();
		fw.close();
	}

}
