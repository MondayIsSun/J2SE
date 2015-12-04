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
		
		// System.getProperty("user.dir")ʵ�������õ���Ŀ�ĸ�·������>��J2SE������Ӳ���ϵ�·��
		String fileName = System.getProperty("user.dir") 
							+ "/src/designPatterns/proxyP/msb/TankTimeProxy.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		// =================================================================================
		
		// compile����>java���еı�����
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		// =================================================================================

		// load into memory and create an instance
		// ��������Լ���취��̬����һ���ࡪ��>��Ӳ�̾����и�class�ļ���֮��Ӧ

		// ����class֮��Ҫ��ô�������class�����أ�
		// ������Ҫ�����class��load���ڴ浱��(��������)
		// ���ص��ڴ浱���Ժ���ܽ�һ���������Ķ���

		// ����ط�����һ����Ҫע����ǣ����ǿ���ʹ��classLoader��loadĳ���ൽ�ڴ浱�У�
		// �������ַ�ʽֻ��������class�ļ�����classPath�����(binĿ¼��)
		// ������ط�����������ָ�������class�ļ����ɵ�·��������û�취ʹ��classLoader������ĳ����

		// ������ܵķ�ʽ����ͨ�õķ���(URLClassLoader)��loadĳ��class���ڴ浱��
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") +"/src")};
		// �������ַ�ʽҲ����ֱ�Ӵ�������ȥload�ൽ�Լ��ı����ڴ���
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.designPatterns.msb.proxyP.TankTimeProxy");
		System.out.println(c);
		
		// =================================================================================
		
		// load��ĳ�����Ժ�Ϳ���ʹ�÷�����������������Ķ�����
		Constructor ctr = c.getConstructor(Moveable.class);
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		m.move();
		
	}
}
