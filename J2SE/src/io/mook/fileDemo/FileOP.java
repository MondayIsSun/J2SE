package io.mook.fileDemo;

import java.io.File;
import java.io.IOException;

public class FileOP {

	public static void main(String[] args) throws IOException {

		// File���API

		// File file = new File("F:\\fileOP");
		File file = new File("F:" + File.separator + "fileOP");
		// ���ֻ�Ǹ����������Ҫ������ļ����ļ��е�·������������ļ����ļ����Ƿ��������һ������
		File file2 = new File("F:\\fileOP\\�ռ�1");
		// File file2 = new File("F:\\fileOP","�ռ�1.txt");
		// "\\",�����ת���ַ�

		// ��������������ɷ���File���ʾĿ¼Ҳ��ʾ�ļ�

		System.out.println(file.exists() ? "��Ŀ¼���ڡ���>ɾ��" : "��Ŀ¼�����ڡ���>����");

		if (!file.exists()) {
			file.mkdir();// ע��mkdir��mkdirsֻ�Ǵ���Ŀ¼
			// file.mkdirs();

			// �ж��Ƿ���Ŀ¼�������Ŀ¼����true���������Ŀ¼����Ŀ¼�����ڷ���false
			System.out.println(file.isDirectory() ? "��Ŀ¼" : "���ļ�");

			// �ж��Ƿ����ļ�
			System.out.println(file.isFile() ? "��Ŀ¼" : "���ļ�");

			if (!file2.exists()) {
				file2.createNewFile();// �����ļ�
			}

			// ���÷������api
			System.out.println(file);// F:\fileOP��file.toString������
			// ʵ�����ǵ�����file��toString�������д�ӡ�����
			System.out.println("����·������>" + file.getAbsolutePath());
			System.out.println("���ļ�Ŀ¼���ϲ�Ŀ¼����>" + file.getParent());
			System.out.println(file2.getName());
			System.out.println(file2.getParent());

		} else {
			file2.delete();
			file.delete();
		}

	}

}
