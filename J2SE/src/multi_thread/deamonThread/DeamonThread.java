package multi_thread.deamonThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DeamonProcess implements Runnable {

	@Override
	public void run() {
		System.out.println("进入守护线程" + Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程" + Thread.currentThread().getName());
	}

	private void writeToFile() throws Exception {
		File filename = new File("f:" + File.separator + "deamon.txt");
		OutputStream os = new FileOutputStream(filename, true);
		int cunt = 0;
		while (cunt < 999) {
			os.write(("\r\nword").getBytes());
			System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入了word" + cunt++);
			Thread.sleep(1000);
		}
		os.close();
	}
}

public class DeamonThread {

	public static void main(String[] args) {
		System.out.println("程序进入了主线程" + Thread.currentThread().getName());
		DeamonProcess deamonProcess = new DeamonProcess();
		Thread t = new Thread(deamonProcess);
		t.setDaemon(true);
		t.start();

		Scanner sc = new Scanner(System.in);
		sc.next();

		System.out.println("程序推出了主线程" + Thread.currentThread().getName());

	}

}
