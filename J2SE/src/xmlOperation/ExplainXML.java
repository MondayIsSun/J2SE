package xmlOperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;

public class ExplainXML {

	/*
	 * SUN自己提供的解析XML的方案:
	 * 
	 * 1、DOM是把整个XMl文件读到内存里面去完成对XML文件的解析
	 * 
	 * 2、SAX只那那个读到这个XML文本的值无法读到节点,更致命的SAX只能读不能写
	 * 
	 * 外部Jar包解析XML:
	 * 
	 * 1、JDOM 2、DOM4J(这是本Java文件用的Jar包)
	 */

	public static void main(String[] args) {

		/*
		 * 无论是哪种方式解析XML文件,基本步骤如下: 1、获取解析器 2、解析XML文件 3、获取Document文档对象 4、获取根节点
		 * 5、通过根节点来操作底下的子节点
		 */

		/*
		 * 去DOM4J的官网去下载对应的Jar包
		 */

		addXML();
		readXML();
		System.out
				.println("------------------------------------------------------");
		deleteXML();
		readXML();
		System.out
				.println("------------------------------------------------------");
		updateXML();
		readXML();
		System.out
				.println("------------------------------------------------------");

	}

	// 对XML文件的---查---操作:
	@SuppressWarnings("unchecked")
	public static void readXML() {

		// 1、获取解析器:
		SAXReader reader = new SAXReader();
		// DOMReader reader = new DOMReader();

		// 2、用获取的解析器解析XML文件,并返回一个Document的文档元素:
		File xmlFile = new File("./data/student.xml");

		// InputStream xmlFileInputStream = ExplainXML.class
		// .getResourceAsStream("./data/student.xml");

		/*
		 * Java工程、Web工程下面的路径问题:
		 * 绝对路径:绝对路径就是你的主页上的文件或目录在硬盘上的真正的路径(计算机中所有的文件都是存放在硬盘上的) 相对路径:相对于某个基准目录的
		 * 路径(所以只要清楚这个基准目录就很好掌握相对路径了)
		 * Java项目中的文件的相对路径是相对于项目的根目录,web项目中的文件的路径视不同的web服务器而不同
		 * (比如:tomcat是相对于tomcat安装目录\bin)
		 */

		try {
			// 有时候错误会来源于自己包导错了
			org.dom4j.Document document = reader.read(xmlFile);

			// 3、通过Document获取根节点:
			Element rootElement = document.getRootElement();

			// 4、通过根节点获取根节点下面的子节点:
			List<Element> childList = rootElement.elements();
			// List<Element> childList = rootElement.elements("all");
			System.out.println("当前XML文件:" + xmlFile.getName() + "根节点下面的子节点数目="
					+ childList.size());

			for (Element everyElement : childList) {
				String id = everyElement.attributeValue("id");
				String stuName = everyElement.elementText("stu_name");
				String stuAge = everyElement.elementText("stu_age");
				String stuSex = everyElement.elementText("stu_sex");
				String cdata = everyElement.elementText("stu_content");
				System.out.println(id + "\t" + stuName + "\t" + stuAge + "\t"
						+ stuSex + "\t" + cdata);

				// System.out.println(everyElement);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	// 对XML文件的---增---操作:
	public static void addXML() {

		// 1、获取解析器:
		SAXReader reader = new SAXReader();

		// 2、获取到待解析的XML文件:
		File xmlFile = new File("./data/student.xml");
		// 理解Java项目中的"/"表示Java项目的根目录,就这个Java项目而言就是:com.xmlOperation这个Java项目的最顶层目录...
		// "./"表示当前工程路径,"../"表示当前目录的上一层目录...???
		// System.out.println(xmlFile);

		// 3、解析XML文件并返回Document文档对象:
		try {
			Document document = reader.read(xmlFile);
			// System.out.println(document);

			// 4、获取根节点:
			Element rootElement = document.getRootElement();
			// System.out.println(rootElement.attributeCount());

			// 5、创建一个元素并附加到根节点中去:
			Date date = new Date();
			long time = date.getTime();
			Element newElement = rootElement.addElement("newElement_" + time);

			// 6、创建该元素的子节点:
			Element name = newElement.addElement("name");
			name.setText("the new element");

			Element content = newElement.addElement("content");
			content.addCDATA("this is CDATA's text");

			Element student_10 = rootElement.addElement("student");
			student_10.addAttribute("id", "10");
			Element stu_name = student_10.addElement("stu_name");
			stu_name.setText("老罗");

			// 7、将最后完成的XML内容跟新到原来的XML文件中
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// 写回去:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// 导包错误也会报错且不使用错误的包
			xmlWriter.write(document);
			xmlWriter.close();
			// 流一定要记得关闭!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 对XML文件的---删---操作:
	public static void deleteXML() {
		// 1、获取解析器:
		SAXReader reader = new SAXReader();

		// 2、获取待解析的xml文件:
		File xmlFile = new File("./data/student.xml");

		try {
			// 3、解析xml文件,并返回Document文档对象:
			Document document = reader.read(xmlFile);

			// 4、通过Document获取根节点:
			Element rootElement = document.getRootElement();

			// 5、通过根节点获取下面的子节点,接下来就是你想对这些子节点做和操作了:
			@SuppressWarnings("unchecked")
			List<Element> childElements = rootElement.elements();
			for (Element perElement : childElements) {
				String id = perElement.attributeValue("id");
				if (id != null && id.equals("10")) {
					rootElement.remove(perElement);
				}
			}

			// 6、将最后完成的XML内容跟新到原来的XML文件中
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// 写回去:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// 导包错误也会报错且不使用错误的包
			xmlWriter.write(document);
			xmlWriter.close();
			// 流一定要记得关闭!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 对XML文件的---改---操作:
	public static void updateXML() {
		// 1、获取解析器:
		SAXReader reader = new SAXReader();

		// 2、获取待解析的xml文件:
		File xmlFile = new File("./data/student.xml");

		try {
			// 3、解析xml文件,并返回Document文档对象:
			Document document = reader.read(xmlFile);

			// 4、通过Document获取根节点:
			Element rootElement = document.getRootElement();

			// 5、通过根节点获取下面的子节点,接下来就是你想对这些子节点做和操作了:
			Date date = new Date();
			long time = date.getTime();
			@SuppressWarnings("unchecked")
			List<Element> childElements = rootElement.elements();
			for (Element perElement : childElements) {
				String id = perElement.attributeValue("id");
				if (id != null && id.equals("2")) {
					Element stu_name = perElement.element("stu_name");
					stu_name.setText("这是更新过的值_" + time);

					// CDATA节点的更新操作必须是先删除,再添加,以这种方式达到修改的效果:
					Element stu_content = perElement.element("stu_content");
					// 移除
					perElement.remove(stu_content);
					// 增加
					stu_content = perElement.addElement("stu_content");
					stu_content.addCDATA("修改过后的内空" + time);

					break;
				}
			}

			// 6、将最后完成的XML内容跟新到原来的XML文件中
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// 写回去:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// 导包错误也会报错且不使用错误的包
			xmlWriter.write(document);
			xmlWriter.close();
			// 流一定要记得关闭!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
