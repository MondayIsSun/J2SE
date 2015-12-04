package xmlOperation;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLoperation {
	
	@SuppressWarnings("unchecked")
	public void readXML(){
		
		//获取解析器
		SAXReader reader = new SAXReader();
		
		//获取待解析的XMl文件
		File xmlFile = new File("./data/student.xml");
		
		try {
			//用解析器解析获取到底XML文件并获取解析完XML文件后的document对象
			Document document = reader.read(xmlFile);
			/* 一般操作内存以外的文件都需要处理异常
			 * 这里刚刚开始操作内存以外的文件
			 * 所以开始处理异常
			 */
			
			//获取root根节点
			Element rootElement = document.getRootElement();
			
			//通过根节点操作底下的子节点
			List<Element> childList = rootElement.elements("student");
			System.out.println(childList.size());
			for (Element studentElement : childList) {
				String id = studentElement.attributeValue("id");
				String stu_name = studentElement.elementText("stu_name");
				String stu_age = studentElement.elementText("stu_age");
				String stu_sex = studentElement.elementText("stu_sex");
				String stu_content = studentElement.elementText("stu_content");
				System.out.println(id + "\t" + stu_name + "\t" + stu_age + "\t"+ stu_sex + "\t" + stu_content);
			}
		} 
		catch (DocumentException e) {
			e.printStackTrace();
		} 
		finally {
		}
		
	}
	
	
	
	
	
	
	@SuppressWarnings("unused")
	private static void readSingle() {
		// 1:获取解析器
		SAXReader reader = new SAXReader();

		// 2：解析器要解析XML文件,并返回一个Document的文档元素
		File xmlFile = new File("./data/student.xml");

		try {
			Document document = reader.read(xmlFile);

			// 3：通过Document节点获取根节点
			Element rootElement = document.getRootElement();

			// 4：通过根节点获取根节点下面的子节点
			List<Element> childList = rootElement.elements("student");
			System.out.println(childList.size());
			for (Element studentElement : childList) {
				String id = studentElement.attributeValue("id");
				if (id != null && id.equals("6")) {
					String stu_name = studentElement.elementText("stu_name");
					String stu_age = studentElement.elementText("stu_age");
					String stu_sex = studentElement.elementText("stu_sex");
					String stu_content = studentElement.elementText("stu_content");
					System.out.println(id + "\t" + stu_name + "\t" + stu_age+ "\t" + stu_sex + "\t" + stu_content);
				}

			}

		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	
	
	
	
	public void addXML() {
		
		SAXReader reader = new SAXReader();
		
		File xmlFile = new File("./data/student.xml");
		
		try {
			Document document = reader.read(xmlFile);
			
			Element rootElement = document.getRootElement();

			// 4：创建一个Student元素,并且附加到RootElement中
			Element studentElement = rootElement.addElement("student");
			studentElement.addAttribute("id", "889");

			// 5：创建子节点，并把子节点做为Student的子元素
			Element stu_name = studentElement.addElement("stu_name");
			stu_name.setText("新增加的Stu_name");

			Element stu_age = studentElement.addElement("stu_age");
			stu_age.setText("10");

			Element stu_sex = studentElement.addElement("stu_sex");
			stu_sex.setText("男");

			Element stu_content = studentElement.addElement("stu_content");
			stu_content.addCDATA("CATE中的值*&(^^%*f89123<aa>M<bb><Mcc>");

			// 将最后完成的XML内容重新写回到XML文件中。
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			
			//Writer writer = new FileWriter(xmlFile);
			//XMLWriter xmlWriter = new XMLWriter(writer, outputFormat);
			XMLWriter xmlWriter = new XMLWriter(new FileWriter(xmlFile), outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public void updateXML() {
		
		SAXReader reader = new SAXReader();

		File xmlFile = new File("./data/student.xml");

		try {
			Document document = reader.read(xmlFile);

			Element rootElement = document.getRootElement();

			List<Element> childList = rootElement.elements("student");
			System.out.println(childList.size());
			for (Element studentElement : childList) {
				String id = studentElement.attributeValue("id");
				if (id != null && id.equals("6")) {
					Element stu_name = studentElement.element("stu_name");
					stu_name.setText("修改名称");

					Element stu_sex = studentElement.element("stu_sex");
					stu_sex.setText("Man");

					// CDATA的节点必须先删除，再添加，达到修改的结果
					Element stu_content = studentElement.element("stu_content");
					// 移除
					studentElement.remove(stu_content);
					// 增加
					stu_content = studentElement.addElement("stu_content");
					stu_content.addCDATA("修改过后的内空123123123asdfasdf&");

					break;
				}
			}
			// 重新写回到XML文件中。
			// 将最后完成的XML内容重新写回到XML文件中。
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			Writer writer = new FileWriter(xmlFile);
			XMLWriter xmlWriter = new XMLWriter(writer, outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
	
	
	
	
	
	
	public void deleteXML() {
		
		SAXReader reader = new SAXReader();

		File xmlFile = new File("./data/student.xml");

		try {
			Document document = reader.read(xmlFile);

			Element rootElement = document.getRootElement();

			@SuppressWarnings("unchecked")
			List<Element> childList = rootElement.elements("student");
			System.out.println(childList.size());
			for (Element studentElement : childList) {
				String id = studentElement.attributeValue("id");
				if (id != null && id.equals("6")) {
					rootElement.remove(studentElement);
					break;
				}
			}
			// 重新写回到XML文件中。
			// 将最后完成的XML内容重新写回到XML文件中。
			// 创建格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			Writer writer = new FileWriter(xmlFile);
			XMLWriter xmlWriter = new XMLWriter(writer, outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	
	
	
	
	
	public static void main(String[] args) {
		
		XMLoperation XML_operation = new XMLoperation();
		
		//XML_operation.addXML();
		//XML_operation.updateXML();
		XML_operation.readXML();
		//XML_operation.readSingle();
		//XML_operation.deleteXML();
		//XML_operation.readXML();
	}
	
}
