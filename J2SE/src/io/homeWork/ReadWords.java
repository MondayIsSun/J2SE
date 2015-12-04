package io.homeWork;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadWords {

	public static void ByteRead() {

		InputStream readText = null;

		String reg_1 = "[a-zA-Z]", reg_2 = "[ |,|.]";
		String r = "", result_1, result_2;
		int sum = 0, result;

		try {
			readText = new BufferedInputStream(new FileInputStream(
					"./data/readWords.txt"));

			while ((result = readText.read()) != -1) {
				r = r + (char) result;
			}

			int i = 0;
			for (i = 0; i < r.length() - 1; i++) {

				result_1 = "" + r.charAt(i);
				result_2 = "" + r.charAt(i + 1);

				if ((result_1.matches(reg_1) == true)
						&& (result_2.matches(reg_2) == true)) {
					sum++;
				}

			}

			System.out.println("文件具体内容:"+r);
			System.out.println("该文件共有" + sum + "个单词,不信你自己数数看...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (readText != null)
					readText.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		ReadWords.ByteRead();
	}

}
