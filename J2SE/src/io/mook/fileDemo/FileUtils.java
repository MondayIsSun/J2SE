package io.mook.fileDemo;

import java.io.File;

public class FileUtils {

	// �г�File���һЩ���ò�����������ˡ���������

	/**
	 * �г�ָ��Ŀ¼����������Ŀ¼���������ļ�
	 * 
	 * @param root
	 * @param spanToLeft
	 */
	private static void travel(File root, int spanToLeft) {

		// �ж�Ŀ¼�Ƿ����
		if (!root.exists()) {
			throw new IllegalArgumentException("Ŀ¼��" + root + "������.");
		}

		// �жϲ���Ŀ¼
		if (!root.isDirectory()) {
			throw new IllegalArgumentException(root + "����Ŀ¼.");
		}

		spanToLeft++;

		File[] files = root.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				StringBuffer str_span = new StringBuffer();

				for (int i = 0; i < spanToLeft; i++) {
					str_span.append("    ");
				}

				str_span.append("|-");

				if (file.isDirectory()) {
					System.out.println(str_span + file.getName());
					travel(file, spanToLeft);
				} else {
					System.out.println(str_span + file.getName());
				}

			}
		}

	}

	public static void travelFiles(File root) {

		travel(root, -1);

	}

}
