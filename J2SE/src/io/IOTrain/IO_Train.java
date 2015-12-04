package io.IOTrain;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

public class IO_Train {
	
	/*
	 * �������Ļ�������:
	 * 1����������Դ�����ݻ�(����Ŀ��)---��ʵ��Ϊ����ȷ���������������
	 * 2����ȷ�����������Ƿ��Ǵ��ı�����---��ʵ��Ϊ����ȷ�ַ��������ֽ���
	 */
	
	public static void main(String[] args) throws IOException {

		IO_Train io = new IO_Train();

		String URL = "H:/MyEclipseWorkSpace/A_IO_operation/src/IOtrain/IO_Train.java";
		String URL_Copy = "./data/Copy.txt";
		String URl_write = "./data/Write.txt";

		// io.CharRead(URL);

		// io.ByteRead(URL);

		// io.CharRead(URL);

		// InputStream readText = new FileInputStream(URL);
		// OutputStream copyText = new FileOutputStream(URL_Copy);
		// io.Copy(readText, copyText);

		// io.ByteWrite(URl_write);
		// io.CharWrite(URl_write);
	}
	
	//�ֽ���---��---����:
	public void ByteRead(String URL){
		
		/*
		 * �ֽ�����ֻ�ܶ�ȡӢ���ַ���ԭ�����£�
		 * Javaƽ̨����UTF-16(Unicode)���룬һ���ַ�ռ2���ֽ�(����Ӣ�ģ����������ַ�).
		 * Java�µ��ַ�����2���ֽڵģ�FileInputStream.read()һ��ֻ�ܶ�ȡһ���ֽڣ�
		 * ������ΪӢ���ַ�2�ֽڵ�ǰ8λ����0�����÷������Զ�ȥ��ǰ8λ��0��������൱�ڶ�ȡһ���ֽ�
		 * �������ַ���һ���Զ�ȡ�����ֽڣ���Ϊ��ǰ8λ���ᶼ��0�����Ը÷�������Ӣ���ַ�û����
		 * ���ǲ��ܴ����������ַ������
		 */
		
		InputStream readText = null;
		//BufferedInputStream readText = null;
		
		try {
			readText = new BufferedInputStream(new FileInputStream(URL));
			/*
			 * ѧϰ��λ�ȡ�ļ���ַ�ķ���
			 */
			int result;
			System.out.println(""+readText.available()+"\t"+readText.read());
			while ((result = readText.read())!= -1){
				/*
				 * read()������Ҫ�쳣����(read()����������ͨ���ֽ��������һ���Զ�ȡ����ֽڲ���)
				 * һ����ֻ���������ȡһ���ֽ�
				 * û�ж�������-1
				 * �ж�������һ��0-255֮�������Ӧ���Ƕ�Ӧ����?
				 */
				System.out.print((char)result);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (readText != null)
					readText.close();
				    /*
				     * ��һ��Ҫ��
				     */
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//�ֽ���---д---����:
	public void ByteWrite(String URL){
		
		/*
		 * �Ѿ��û�������װ���ֽ��������´�����ֽ��ַ�����...
		 * ������������:���û���û������Ļ�,�����һ�����ݾͻ�дһ�����ݣ������ڴ������������I/O����ʱ�ǳ�Ӱ������Ч��...
		 * �������������ǰ�������д��һ��������,�Ȼ���������,�ٰ�����д���ļ������Ч�ʾʹ�������...
		 */
		OutputStream writeText = null;
		try {
			writeText = new BufferedOutputStream(new FileOutputStream(URL,true));
			/*
			 * ��һ��boolean�����ǿ����Ƿ�׷����ԭ���ĵ������
			 * ��дĬ����false,û������ں��棬���Ǹ���
			 * ������������ԭ�������������ݶ����û�����
			 * ���д����ļ����������û����ݻ���Ԫ���ݵĻ��Ͳ�����һζ�ذѼ���д������ݵ���׷�ӵ�ԭ�����ݺ��棬
			 * �����ԭ��������ȫ�����������µ�����һ������д�뵽�ĵ���
			 * ������󻺳�������Ķ������Ԫ����
			 */
			writeText.write(99);
			/*
			 * �÷������������int�ͻ�д���Ӧ���ַ�
			 * һ��÷����Ĳ����Ƿ��ֽڵ��ֽ����飨���ֽ�������һ�����ʹ�ã�
			 * ���ǳ��õĶ����ַ������ֽ���ֻ�����������ʹ�õ�
			 */
			writeText.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				writeText.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void Copy(InputStream in, OutputStream out) {
		// һ�θ��ƹ��ܵĴ���
		// ���Ҷ������Ƕ��ֽ����������Ч���ϵ����
		byte[] Byte = new byte[1024];
		/*
		 * ��Ϊ�÷�����ȡ�����ֽ�������Ҫ�����ֽ�����䵱��ư��Ϊһ���Զ�ȡ�Ĳ������ݸ��÷���ͬ��������ַ����Ļ���Ӧ�ö����ַ�����
		 * �����ֱ�����ϻ�����,������ֻ�Ƿ����Ժ��Լ���ϰ�����������÷�����...
		 */
		int len = -1;
		try {
			while ((len = in.read(Byte)) != -1) {
				/*
				 * �ж������صľ���һ�������� û�ж�������-1 ��Ҫ̫���ķ�������ʵ�ʺ��壬���Ǵ�����뷨������
				 * �����ﷵ�ص���ʵ�ʶ������ֽ���
				 */
				System.out.println("" + in.available() + "\t" + in.read());
				out.write(Byte, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ʵ��������������ص��ǲ��Ե�
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	//�ַ���---��---����:
	public void CharRead(String URL){
		/*
		 * �ַ�����ֱ��һ���Զ�ȡһ���ַ�
		 * ��Ϊ�������ֽ��豸��������Ҫѧϰ�ֽ�������Ȼ���Ƕ�ϲ�����ַ���������Щ���Ҳ��Ҫ�õ��ֽ���
		 */
		//Reader readText = null;
		BufferedReader readText = null;
		try {
			readText = new BufferedReader(new FileReader(URL));
			int result;
			while ((result = readText.read())!= -1){
				System.out.print((char)result);
				/*
				 * readText.flush();��Ȼ������û��ˢ�հ���ֻҪ���������ˢ�հ���
				 * BufferedReader������һ��������readLine()�ܺ���
				 * ������ʱ��ÿ�����Ѿ������ɲ�ͬ�����͵����õ�ĳЩ�ܷ���Ĳ���
				 */
				//String line = readText.readLine();
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (readText != null)
					readText.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//�ַ���---д---����:
	public void CharWrite(String URL){
		
		Writer writeText = null;
		char[] Char = {'c','h','i','n','a'};
		try{
			writeText = new BufferedWriter(new FileWriter(URL,true));
			//writeText.write(100);//��ת������Ӧ���ַ�
			//writeText.write(""+100);
			writeText.write(Char,0,Char.length);
			writeText.flush();
			/*
			 * ֻ�л�����������������⣬һ����������һ��һ��Ҫˢ��һ��
			 * ����Ҫÿ�ζ�ˢ�գ����򻹲��粻�û����������Ч��
			 */
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		finally{
			try {
				if(writeText != null)
					writeText.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
