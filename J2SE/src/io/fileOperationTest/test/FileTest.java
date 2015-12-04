package io.fileOperationTest.test;

import java.io.File;
import java.io.IOException;

public class FileTest {

	/*
	 * P19 ������ѧϰFile���ͬʱ��java�����е�·��������.
	 */

	/*
	 * File��������ͼ��:File������Ƕ��ļ�ϵͳ��---�ļ�---�Լ�---�ļ���---���ж���ķ�װ
	 * �Դﵽͨ�������˼���������ļ��Լ��ļ���...
	 * 
	 * ��Java�У�������File������ʾһ���ļ���������ע��������ļ������������ļ��������ļ��У�
	 * 
	 * ��Java�б�ʾ·����ʱ��,'\\'��'/'
	 */

	public static void main(String[] args) throws IOException {

		// ����һ���ļ���:
		File file_0 = new File("H:\\Dropbox\\file_0");
		// ������һ����û�취�������ļ������ļ���,���������file.mkdir()��һ����ܴ�����ʵʵ���ڵ��ļ���
		if (!file_0.exists()) {
			// ��������ڸ��ļ���
			file_0.mkdir();// �½������ļ���
		}

		// ��������ļ���:
		File file_1 = new File(
				"H:\\Dropbox\\file_1\\file_1_2\\file_1_2_3\\file_1_2_3_4");
		if (!file_1.exists()) {// ��������ڸ��ļ���
			file_1.mkdirs();// ����ļ���һ��
		}

		// File���½���ͨ���ļ�:
		File f_0 = new File("H:\\Dropbox\\file_0\\f_0.txt");
		f_0.createNewFile();
		/*
		 * ֻ�������������ϲ���ʵʵ���ڵش�����һ���ļ� ��Ϊ�Ǵ����ļ��������ļ���,�������û������ִ��ǰ��Ĵ����ļ��еĴ���,��ô�ᱨ
		 * "java.io.IOException: ϵͳ�Ҳ���ָ����·��"�쳣
		 */

		// ��ȡ�ļ����ļ��е�����,�������ļ������ļ�����ôҪ������Ա���������ļ������ļ�����:
		System.out.println("��ȡ�ļ����ļ��е�����:" + f_0.getName());

		// ����File�����װ��·����ʲô���ǻ�ȡ����·��(�����ļ����ļ��д�����Ӳ���ϵ�����λ��):
		System.out.println("��ȡ�ļ����ļ��еľ���·��:" + f_0.getAbsolutePath());

		// ��ʱFile�����װ��·����ʲô��ȡ�ľ���ʲô:
		System.out.println("��ȡ��ʱ��װ�ļ����ļ���ʱ������·��:" + f_0.getPath());

		// ��ȡFile�����װ�ļ����ļ��еĸ�Ŀ¼:
		System.out.println("��ȡFile�����װ�ļ����ļ��еĸ�Ŀ¼:" + f_0.getParent());

		// ��ȡ�ļ����ļ��еĴ�С:
		System.out.println("��ȡ�ļ��Ĵ�С:" + f_0.length());

		// ��ȡ�ļ����ļ������һ���޸ĵ�ʱ��:
		System.out.println("��ȡ�ļ����ļ������һ���޸ĵ�ʱ��:" + f_0.lastModified());

		/*
		 * ���������9�д������������֪ʶ��:
		 * 1��Java���̵������·���Ļ�׼Ŀ¼��ָ���Java�������ڵ�Ŀ¼(����Web���̵�·������һ�㿴ʹ�õķ�����)
		 * 2��(./)������ǵ�ǰĿ¼���ǵ�ǰ���Java�������ڵ�Ŀ¼; (../)������ǵ�ǰĿ¼����һ��Ŀ¼; (/)�����ϼ�Ŀ¼;
		 */
		// ע��:---'./'---����ĺ���:
		File f_1 = new File("./f_1.txt");
		f_1.createNewFile();
		// System.out.println(f_1.getAbsolutePath());

		// ���������к��������е�Ч����һ����:
		File f_2 = new File("f_2.txt");
		f_2.createNewFile();
		// System.out.println(f_2.getAbsolutePath());

		// ע��:---'../'---����ĺ���:
		File f_3 = new File("../f_3.txt");
		f_3.createNewFile();
		// System.out.println(f_3.getAbsolutePath());

		// ע��:---'/'---����ĺ���:
		// File f_4 = new File("/f_4.txt");
		// f_4.createNewFile();

		// ɾ���ļ����ļ��еĲ���(file_0��file_1):
		/*
		 * ע��:�����ļ���ֻ��ɾ���������ݵĿ��ļ��� ���ڴ������ݵ��ļ��У�����ֱ��ɾ��������Ҫ��������ɾ��
		 * һ�仰����:File.delete()����ɾ��ĳ���ļ����߿�Ŀ¼
		 */
		// if(f_0.exists()){
		// //�ж��Ƿ�Ϊ�ļ�,���ļ�����ֱ��ɾ��:
		// if(f_0.isFile()){
		// f_0.delete();
		// }else if (f_0.is) {
		//
		// }
		// }

	}

}
