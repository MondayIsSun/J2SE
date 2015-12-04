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
	 * 自己模拟实现的jdk动态代理：
	 * 
	 * 动态代理实现的思路：
	 * 
	 * 1、声明一段源码(动态产生代理)
	 * 
	 * 2、编译源码(JDK Compiler API，产生新的类(动态代理类))
	 * 
	 * 3、将这个类load到内存当中，产生新的对象(代理对象)
	 * 
	 * 4、return代理对象
	 */

	public static Object newProxyInstance(Class<?> infce,InvocationHandler h) throws Exception {
		
		//构建代码字符串：
		
		String rt = "\r\n";
		
		String methodsStr = "";
//		for (Method m : infce.getMethods()) {
//			methodsStr = methodsStr +
//			" 	@Override" + rt +
//			" 	public void " + m.getName() + "() {" + rt +
//			" 		long starttime = System.currentTimeMillis();" + rt +
//			" 		System.out.println(\"汽车开始行驶....\");" + rt +
//			" 		m." + m.getName() + "();" + rt +
//			" 		long endtime = System.currentTimeMillis();" + rt +
//			" 		System.out.println(\"汽车结束行驶....  汽车行驶时间：\" " + rt +
//			" 				+ (endtime - starttime) + \"毫秒！\");" + rt +
//			" 	}" + rt + rt;
//			
//		}
//      但是注意到实现到这个时候的代码业务代码是写死的，如何把业务代码独立出来可以被个性化？
//      如何实现对任意类任意方法实现动态代理呢？
		
		// 解决办法是使用事务处理器对象，事务处理器的作用就是处理某个类的某个方法
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
		
		// 更改后的src：

		/**
		 * 首先需要明白的是这个InvocationHandler当中已经分装了需要我们代理的代理对象了
		 * 
		 * 但是这个动态产生的代理类仍然是要实现我们的接口的，这样做的目的是这个代理也是Moveable类型的，方便以后代理的组合
		 */
		" package designPatterns.proxyP.imook.myself_JdkProxy;" + rt + rt +
		
		" import java.lang.reflect.Method;" + rt + rt +
		" import designPatterns.proxyP.imook.myself_JdkProxy.InvocationHandler;" + rt + rt +//需要导入InvocationHandler
		
		" public class $Proxy0 implements " + infce.getName() + "{" + rt + rt +
		
//		" 	private " + infce.getName() + " m;" + rt + rt +(因为我们已经在InvocationHandler里面分装了被代理的对象了)
		
		" 	private InvocationHandler h;" + rt + rt +//需要获取到这个InvocationHandler对象
		
		" 	public $Proxy0(InvocationHandler h) {" + rt +
		" 		super();" + rt +
		" 		this.h = h;" + rt +
		" 	}" + rt + rt +
		
		    methodsStr + 
		    
		" }";
		
		// ==============================================================================
		
		//生成代码字符串文件：
		
		/**
		 * System.getProperty("user.dir");
		 * 
		 * ————>
		 * 
		 * F:\workspace\myeclipse\J2SE
		 */
		String fileName = System.getProperty("user.dir")
				+ "/bin/designPatterns/proxyP/imook/myself_JdkProxy/$Proxy0.java";

		File file = new File(fileName);

		/**
		 * commons-io的jar包呢提供了一个类：
		 */

		FileUtils.writeStringToFile(file, src);
		
		// ==============================================================================
		
		// 开始编译生成的java代码：

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
				null, null);

		// 获取java文件：
		Iterable<? extends JavaFileObject> units = fileMgr
				.getJavaFileObjects(fileName);

		// 指定编译任务：
		CompilationTask task = compiler.getTask(null, fileMgr, null, null,
				null, units);

		// 进行编译：
		task.call();

		// 关闭资源：
		fileMgr.close();
		
		// ==============================================================================

		// 将编译好的class文件load到内存当中：
		// 注意：由于我们生成的class文件是放置在bin目录下面的，所以可以直接使用进行加载到内存ClassLoader
		// 首先获取到类加载器：
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class<?> cl = loader
				.loadClass("designPatterns.proxyP.imook.myself_JdkProxy.$Proxy0");

		// System.out.println(cl.getName());
		
		// ==============================================================================
		
		// 产生代理类：
		Constructor<?> ctr = cl.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}

}
