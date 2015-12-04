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
	 * 流操作的基本规律:
	 * 1、明白数据源和数据汇(数据目的)---其实是为了明确输入流还是输出流
	 * 2、明确操作的数据是否是纯文本数据---其实是为了明确字符流还是字节流
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
	
	//字节流---读---操作:
	public void ByteRead(String URL){
		
		/*
		 * 字节流，只能读取英文字符，原因如下：
		 * Java平台采用UTF-16(Unicode)编码，一个字符占2个字节(不论英文，还是中文字符).
		 * Java下的字符都是2个字节的，FileInputStream.read()一次只能读取一个字节，
		 * 但是因为英文字符2字节的前8位都是0，而该方法会自动去掉前8位是0的情况，相当于读取一个字节
		 * 而中文字符得一次性读取两个字节，因为其前8位不会都是0，所以该方法处理英文字符没问题
		 * 但是不能处理有中文字符的情况
		 */
		
		InputStream readText = null;
		//BufferedInputStream readText = null;
		
		try {
			readText = new BufferedInputStream(new FileInputStream(URL));
			/*
			 * 学习如何获取文件地址的方法
			 */
			int result;
			System.out.println(""+readText.available()+"\t"+readText.read());
			while ((result = readText.read())!= -1){
				/*
				 * read()方法需要异常处理(read()方法还可以通过字节数组进行一次性读取多个字节操作)
				 * 一次性只从流里面读取一个字节
				 * 没有读到返回-1
				 * 有读到返回一个0-255之间的数，应该是对应的码?
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
				     * 流一定要关
				     */
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//字节流---写---操作:
	public void ByteWrite(String URL){
		
		/*
		 * 已经用缓冲流包装过字节流和上下代码的字节字符流了...
		 * 缓冲流的作用:如果没有用缓冲流的话,程序读一个数据就会写一个数据，这样在处理数据量大的I/O操作时非常影响程序的效率...
		 * 缓冲流的作用是把数据先写入一个缓冲区,等缓冲区满了,再把数据写到文件里，这样效率就大大提高了...
		 */
		OutputStream writeText = null;
		try {
			writeText = new BufferedOutputStream(new FileOutputStream(URL,true));
			/*
			 * 另一个boolean参数是控制是否追加在原来文档后面的
			 * 不写默认是false,没有添加在后面，而是覆盖
			 * 可以这样做的原因是这样的数据都是用户数据
			 * 如果写入的文件不仅仅是用户数据还有元数据的话就不可以一味地把继续写入的数据单单追加到原来数据后面，
			 * 必须把原来的数据全部读出来和新的数据一起重新写入到文档里
			 * 比如对象缓冲流出理的对象就有元数据
			 */
			writeText.write(99);
			/*
			 * 该方法参数如果是int型会写入对应的字符
			 * 一般该方法的参数是放字节的字节数组（与字节输入流一起搭配使用）
			 * 我们常用的都是字符流，字节流只在特殊情况下使用到
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
		// 一段复制功能的代码
		// 并且对上面那段字节流代码进行效率上的提高
		byte[] Byte = new byte[1024];
		/*
		 * 因为该方法读取的是字节所以需要定义字节数组充当“瓢”为一次性读取的参数传递给该方法同理，如果是字符流的话就应该定义字符数组
		 * 最好是直接套上缓冲流,这里我只是方便以后自己复习流还有这种用法罢了...
		 */
		int len = -1;
		try {
			while ((len = in.read(Byte)) != -1) {
				/*
				 * 有读到返回的就是一个正整数 没有读到返回-1 不要太关心返回数的实际含义，这是错误的想法！！！
				 * 但这里返回的是实际读到的字节数
				 */
				System.out.println("" + in.available() + "\t" + in.read());
				out.write(Byte, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 实际在这里面把流关掉是不对的
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
	
	//字符流---读---操作:
	public void CharRead(String URL){
		/*
		 * 字符流，直接一次性读取一个字符
		 * 因为键盘是字节设备，所以需要学习字节流，虽然我们都喜欢用字符流，但有些情况也需要用到字节流
		 */
		//Reader readText = null;
		BufferedReader readText = null;
		try {
			readText = new BufferedReader(new FileReader(URL));
			int result;
			while ((result = readText.read())!= -1){
				System.out.print((char)result);
				/*
				 * readText.flush();当然输入流没有刷空啊！只要输出流才有刷空啊！
				 * BufferedReader身上有一个方法是readLine()很好用
				 * 所以有时候得看情况把句柄定义成不同的类型得以用到某些很方便的操作
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
	
	
	//字符流---写---操作:
	public void CharWrite(String URL){
		
		Writer writeText = null;
		char[] Char = {'c','h','i','n','a'};
		try{
			writeText = new BufferedWriter(new FileWriter(URL,true));
			//writeText.write(100);//会转化成相应的字符
			//writeText.write(""+100);
			writeText.write(Char,0,Char.length);
			writeText.flush();
			/*
			 * 只有缓冲流会出现这种问题，一遍操作的最后一次一定要刷空一次
			 * 但不要每次都刷空，否则还不如不用缓冲流来提高效率
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
