package io.mook.fileDemo;

import java.io.File;

public class FileUtils {

	// 列出File类的一些常用操作，比如过滤、遍历操作

	/**
	 * 列出指定目录（包括其子目录）的所有文件
	 * 
	 * @param root
	 * @param spanToLeft
	 */
	private static void travel(File root, int spanToLeft) {

		// 判断目录是否存在
		if (!root.exists()) {
			throw new IllegalArgumentException("目录：" + root + "不存在.");
		}

		// 判断不是目录
		if (!root.isDirectory()) {
			throw new IllegalArgumentException(root + "不是目录.");
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
