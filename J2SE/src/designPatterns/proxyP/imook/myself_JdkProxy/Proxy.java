package designPatterns.proxyP.imook.myself_JdkProxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Proxy {

	/**
	 * �Լ�ģ��ʵ�ֵ�jdk��̬����
	 * 
	 * ��̬����ʵ�ֵ�˼·��
	 * 
	 * 1������һ��Դ��(��̬��������)
	 * 
	 * 2������Դ��(JDK Compiler API�������µ���(��̬������))
	 * 
	 * 3���������load���ڴ浱�У������µĶ���(�������)
	 * 
	 * 4��return�������
	 */

	public static Object newProxyInstance(Class<?> infce,InvocationHandler h) throws Exception {
		
		//���������ַ�����
		
		String rt = "\r\n";
		
		String methodsStr = "";
//		for (Method m : infce.getMethods()) {
//			methodsStr = methodsStr +
//			" 	@Override" + rt +
//			" 	public void " + m.getName() + "() {" + rt +
//			" 		long starttime = System.currentTimeMillis();" + rt +
//			" 		System.out.println(\"������ʼ��ʻ....\");" + rt +
//			" 		m." + m.getName() + "();" + rt +
//			" 		long endtime = System.currentTimeMillis();" + rt +
//			" 		System.out.println(\"����������ʻ....  ������ʻʱ�䣺\" " + rt +
//			" 				+ (endtime - starttime) + \"���룡\");" + rt +
//			" 	}" + rt + rt;
//			
//		}
//      ����ע�⵽ʵ�ֵ����ʱ��Ĵ���ҵ�������д���ģ���ΰ�ҵ���������������Ա����Ի���
//      ���ʵ�ֶ����������ⷽ��ʵ�ֶ�̬�����أ�
		
		// ����취��ʹ���������������������������þ��Ǵ���ĳ�����ĳ������
		for (Method m : infce.getMethods()) {
			methodsStr = methodsStr +
			" 	@Override" + rt +
			" 	public void " + m.getName() + "() {" + rt +
			" 		try{" + rt +
			" 			Method md = " +infce.getName()+".class.getMethod(\""+m.getName()+"\");" + rt +
			" 			h.invoke(this,md);" + rt +
			" 		}catch(Exception e){e.printStackTrace();}" + rt +
			" 	}" + rt + rt;
		}
		
		String src = 
//		" package designPatterns.proxyP.imook.myself_JdkProxy;" + rt + rt +
//		
//		" public class $Proxy0 implements " + infce.getName() + "{" + rt + rt +
//		
//		" 	private " + infce.getName() + " m;" + rt + rt +
//		
//		" 	public $Proxy0(" + infce.getName() + " m) {" + rt +
//		" 		super();" + rt +
//		" 		this.m = m;" + rt +
//		" 	}" + rt + rt +
//		
//		    methodsStr + 
//		    
//		" }";
		
		// ���ĺ��src��

		/**
		 * ������Ҫ���׵������InvocationHandler�����Ѿ���װ����Ҫ���Ǵ���Ĵ��������
		 * 
		 * ���������̬�����Ĵ�������Ȼ��Ҫʵ�����ǵĽӿڵģ���������Ŀ�����������Ҳ��Moveable���͵ģ������Ժ��������
		 */
		" package designPatterns.proxyP.imook.myself_JdkProxy;" + rt + rt +
		
		" import java.lang.reflect.Method;" + rt + rt +
		" import designPatterns.proxyP.imook.myself_JdkProxy.InvocationHandler;" + rt + rt +//��Ҫ����InvocationHandler
		
		" public class $Proxy0 implements " + infce.getName() + "{" + rt + rt +
		
//		" 	private " + infce.getName() + " m;" + rt + rt +(��Ϊ�����Ѿ���InvocationHandler�����װ�˱�����Ķ�����)
		
		" 	private InvocationHandler h;" + rt + rt +//��Ҫ��ȡ�����InvocationHandler����
		
		" 	public $Proxy0(InvocationHandler h) {" + rt +
		" 		super();" + rt +
		" 		this.h = h;" + rt +
		" 	}" + rt + rt +
		
		    methodsStr + 
		    
		" }";
		
		// ==============================================================================
		
		//���ɴ����ַ����ļ���
		
		/**
		 * System.getProperty("user.dir");
		 * 
		 * ��������>
		 * 
		 * F:\workspace\myeclipse\J2SE
		 */
		String fileName = System.getProperty("user.dir")
				+ "/bin/designPatterns/proxyP/imook/myself_JdkProxy/$Proxy0.java";

		File file = new File(fileName);

		/**
		 * commons-io��jar�����ṩ��һ���ࣺ
		 */

		FileUtils.writeStringToFile(file, src);
		
		// ==============================================================================
		
		// ��ʼ�������ɵ�java���룺

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
				null, null);

		// ��ȡjava�ļ���
		Iterable<? extends JavaFileObject> units = fileMgr
				.getJavaFileObjects(fileName);

		// ָ����������
		CompilationTask task = compiler.getTask(null, fileMgr, null, null,
				null, units);

		// ���б��룺
		task.call();

		// �ر���Դ��
		fileMgr.close();
		
		// ==============================================================================

		// ������õ�class�ļ�load���ڴ浱�У�
		// ע�⣺�����������ɵ�class�ļ��Ƿ�����binĿ¼����ģ����Կ���ֱ��ʹ�ý��м��ص��ڴ�ClassLoader
		// ���Ȼ�ȡ�����������
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class<?> cl = loader
				.loadClass("designPatterns.proxyP.imook.myself_JdkProxy.$Proxy0");

		// System.out.println(cl.getName());
		
		// ==============================================================================
		
		// ���������ࣺ
		Constructor<?> ctr = cl.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}

}
