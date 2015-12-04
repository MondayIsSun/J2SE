package io.mook.ioTrain.charStreamOP;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
	public static void main(String[] args) throws IOException {

		// 注意：他的方便之处是不需要指定编码了
		// 但是并不是说你不需要去关心文件编码问题了，而是这两个对象默认就是使用的项目默认的编码进行处理的
		// 如果不是默认的项目的文件同样会出现乱码问题，那么这个时候就得使用FileInputStream和InputStreamReader处理了

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
