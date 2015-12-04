package designPatterns.proxyP.msb.compiler;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import designPatterns.proxyP.msb.dynamicProxy.Moveable;
import designPatterns.proxyP.msb.dynamicProxy.Tank;

public class Test1 {
	
	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static void main(String[] args) throws Exception{
		
		// =================================================================================
		
		String rt = "\r\n";
		
		String src = 
			"package com.bjsxt.proxy;" +  rt +
			"public class TankTimeProxy implements Moveable {" + rt +
			"    public TankTimeProxy(Moveable t) {" + rt +
			"        super();" + rt +
			"        this.t = t;" + rt +
			"    }" + rt +
			
			"    Moveable t;" + rt +
							
			"    @Override" + rt +
			"    public void move() {" + rt +
			"        long start = System.currentTimeMillis();" + rt +
			"        System.out.println(\"starttime:\" + start);" + rt +
			"        t.move();" + rt +
			"        long end = System.currentTimeMillis();" + rt +
			"        System.out.println(\"time:\" + (end-start));" + rt +
			"    }" + rt +
			"}";
		
		// System.getProperty("user.dir")实际上是拿到项目的根路径——>即J2SE工程在硬盘上的路径
		String fileName = System.getProperty("user.dir") 
							+ "/src/designPatterns/proxyP/msb/TankTimeProxy.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		// =================================================================================
		
		// compile——>java当中的编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		// =================================================================================

		// load into memory and create an instance
		// 上面的是自己想办法动态生成一个类——>在硬盘就是有个class文件与之对应

		// 有了class之后要怎么创建这个class的类呢？
		// 首先需要把这个class先load到内存当中(即加载类)
		// 加载到内存当中以后才能进一步创建它的对象

		// 这个地方还有一点需要注意的是：我们可以使用classLoader来load某个类到内存当中，
		// 但是这种方式只是适用于class文件是在classPath里面的(bin目录下)
		// 而这个地方我们是随意指定了这个class文件生成的路径，所以没办法使用classLoader来加载某个类

		// 下面介绍的方式就是通用的方法(URLClassLoader)来load某个class到内存当中
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") +"/src")};
		// 上面这种方式也可以直接从网络上去load类到自己的本地内存里
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.designPatterns.msb.proxyP.TankTimeProxy");
		System.out.println(c);
		
		// =================================================================================
		
		// load完某个类以后就可以使用反射机制来生成这个类的对象了
		Constructor ctr = c.getConstructor(Moveable.class);
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		m.move();
		
	}
}
