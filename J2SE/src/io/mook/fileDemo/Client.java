package io.mook.fileDemo;

import java.io.File;
import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException {

		// FileUtils.listDirectory(new File("F:\\book"), 0);

		FileUtils.travelFiles(new File(
				"F:\\workspace\\myeclipse\\A_Servlet_KeyPoint\\WebRoot"));

		// System.out.println("pathSeparator！！>" + File.pathSeparator);
		// System.out.println("pathSeparatorChar！！>" + File.pathSeparatorChar);
		// System.out.println("separator！！>" + File.separator);
		// System.out.println("separatorChar！！>" + File.separatorChar);

	}

}
