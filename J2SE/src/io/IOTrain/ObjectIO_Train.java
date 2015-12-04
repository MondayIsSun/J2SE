package io.IOTrain;

import java.io.*;


public class ObjectIO_Train {

	public static void main(String[] args)  {
		
		Employee e1 = new Employee(10,"Marry");
		Employee e2 = new Employee(9,"Carry");
		Employee e3 = new Employee(11,"Harry");
		Employee e4 = new Employee(8,"Karry");
		Employee e5 = new Employee(12,"Larry");
		
		
		//写入对象：
		String URl_write = "./data/Write.txt";
		//OutputStream ObjWrite = null;
		ObjectOutputStream ObjWrite = null;
		/*因为ObjectOutputStream身上有writeObject()和readObject()方法
		 */
		try {
			ObjWrite = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(URl_write)));
			ObjWrite.writeObject(e1);
			ObjWrite.writeObject(e2);
			ObjWrite.writeObject(e3);
			ObjWrite.writeObject(e4);
			ObjWrite.writeObject(e5);
			ObjWrite.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally{
			try {
				ObjWrite.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		//读出对象：
		ObjectInputStream ObjRead = null;
		Object obj = null;
		Employee emp = null;
		try {
			ObjRead = new ObjectInputStream(new BufferedInputStream(new FileInputStream(URl_write)));
			while((obj = ObjRead.readObject()) != null){
				emp = (Employee)obj;
				System.out.println(emp);
			}
		}
		//记住各种异常的包含关系，各种异常代码的放置位置
		catch(EOFException ex){
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				ObjRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	

}
