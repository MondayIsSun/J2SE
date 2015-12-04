package io.fileOperationTest;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		// ����Ҫ֪������File�಻��IO�����Բ�����Ҫ�쳣����
		// File����һ��������,��IO����һ��������
		// File������ļ�Ŀ¼����ͨ�ļ��������

		File file = new File(".");

		try {

			String absolutePath = file.getAbsolutePath();
			/*
			 * ��ȡ�����������̵�����·�� H:\MyEclipseWorkSpace\A_IO_operation
			 */
			String canonicalPath = file.getCanonicalPath();
			System.out.println("����·����" + absolutePath);
			System.out.println("���·����" + canonicalPath);

			File dir = new File("register");
			// File�ļ��кܶ෽�����Ƿ���Boolean���͵Ľ����
			System.out.println("���·��:" + dir.exists());
			if (!dir.exists()) {
				dir.mkdirs();// ����·��
			}

			File file1 = new File(dir, "register.txt");// ͨ��·����ȡ�ļ�
			if (!file1.exists()) {
				file.createNewFile();// �������㴴��register.txt
			} else {
				file.canExecute();// ִ���ļ�
			}
			System.out.println(file.getParent());
			System.out.println("�Ƿ��ִ��:" + file.canExecute());
			System.out.println("�Ƿ�ɶ�:" + file.canRead());
			System.out.println("��ȡ��ǰ�ļ�:" + file.getAbsoluteFile());
			file.delete();
			dir.delete();
			// file.deleteOnExit();//ɾ���ļ����˳�
			// dir.delete();//ɾ��·�����˳�
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
