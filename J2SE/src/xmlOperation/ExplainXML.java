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
	 * SUN�Լ��ṩ�Ľ���XML�ķ���:
	 * 
	 * 1��DOM�ǰ�����XMl�ļ������ڴ�����ȥ��ɶ�XML�ļ��Ľ���
	 * 
	 * 2��SAXֻ���Ǹ��������XML�ı���ֵ�޷������ڵ�,��������SAXֻ�ܶ�����д
	 * 
	 * �ⲿJar������XML:
	 * 
	 * 1��JDOM 2��DOM4J(���Ǳ�Java�ļ��õ�Jar��)
	 */

	public static void main(String[] args) {

		/*
		 * ���������ַ�ʽ����XML�ļ�,������������: 1����ȡ������ 2������XML�ļ� 3����ȡDocument�ĵ����� 4����ȡ���ڵ�
		 * 5��ͨ�����ڵ����������µ��ӽڵ�
		 */

		/*
		 * ȥDOM4J�Ĺ���ȥ���ض�Ӧ��Jar��
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

	// ��XML�ļ���---��---����:
	@SuppressWarnings("unchecked")
	public static void readXML() {

		// 1����ȡ������:
		SAXReader reader = new SAXReader();
		// DOMReader reader = new DOMReader();

		// 2���û�ȡ�Ľ���������XML�ļ�,������һ��Document���ĵ�Ԫ��:
		File xmlFile = new File("./data/student.xml");

		// InputStream xmlFileInputStream = ExplainXML.class
		// .getResourceAsStream("./data/student.xml");

		/*
		 * Java���̡�Web���������·������:
		 * ����·��:����·�����������ҳ�ϵ��ļ���Ŀ¼��Ӳ���ϵ�������·��(����������е��ļ����Ǵ����Ӳ���ϵ�) ���·��:�����ĳ����׼Ŀ¼��
		 * ·��(����ֻҪ��������׼Ŀ¼�ͺܺ��������·����)
		 * Java��Ŀ�е��ļ������·�����������Ŀ�ĸ�Ŀ¼,web��Ŀ�е��ļ���·���Ӳ�ͬ��web����������ͬ
		 * (����:tomcat�������tomcat��װĿ¼\bin)
		 */

		try {
			// ��ʱ��������Դ���Լ���������
			org.dom4j.Document document = reader.read(xmlFile);

			// 3��ͨ��Document��ȡ���ڵ�:
			Element rootElement = document.getRootElement();

			// 4��ͨ�����ڵ��ȡ���ڵ�������ӽڵ�:
			List<Element> childList = rootElement.elements();
			// List<Element> childList = rootElement.elements("all");
			System.out.println("��ǰXML�ļ�:" + xmlFile.getName() + "���ڵ�������ӽڵ���Ŀ="
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

	// ��XML�ļ���---��---����:
	public static void addXML() {

		// 1����ȡ������:
		SAXReader reader = new SAXReader();

		// 2����ȡ����������XML�ļ�:
		File xmlFile = new File("./data/student.xml");
		// ���Java��Ŀ�е�"/"��ʾJava��Ŀ�ĸ�Ŀ¼,�����Java��Ŀ���Ծ���:com.xmlOperation���Java��Ŀ�����Ŀ¼...
		// "./"��ʾ��ǰ����·��,"../"��ʾ��ǰĿ¼����һ��Ŀ¼...???
		// System.out.println(xmlFile);

		// 3������XML�ļ�������Document�ĵ�����:
		try {
			Document document = reader.read(xmlFile);
			// System.out.println(document);

			// 4����ȡ���ڵ�:
			Element rootElement = document.getRootElement();
			// System.out.println(rootElement.attributeCount());

			// 5������һ��Ԫ�ز����ӵ����ڵ���ȥ:
			Date date = new Date();
			long time = date.getTime();
			Element newElement = rootElement.addElement("newElement_" + time);

			// 6��������Ԫ�ص��ӽڵ�:
			Element name = newElement.addElement("name");
			name.setText("the new element");

			Element content = newElement.addElement("content");
			content.addCDATA("this is CDATA's text");

			Element student_10 = rootElement.addElement("student");
			student_10.addAttribute("id", "10");
			Element stu_name = student_10.addElement("stu_name");
			stu_name.setText("����");

			// 7���������ɵ�XML���ݸ��µ�ԭ����XML�ļ���
			// ������ʽ
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// д��ȥ:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// ��������Ҳ�ᱨ���Ҳ�ʹ�ô���İ�
			xmlWriter.write(document);
			xmlWriter.close();
			// ��һ��Ҫ�ǵùر�!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��XML�ļ���---ɾ---����:
	public static void deleteXML() {
		// 1����ȡ������:
		SAXReader reader = new SAXReader();

		// 2����ȡ��������xml�ļ�:
		File xmlFile = new File("./data/student.xml");

		try {
			// 3������xml�ļ�,������Document�ĵ�����:
			Document document = reader.read(xmlFile);

			// 4��ͨ��Document��ȡ���ڵ�:
			Element rootElement = document.getRootElement();

			// 5��ͨ�����ڵ��ȡ������ӽڵ�,�����������������Щ�ӽڵ����Ͳ�����:
			@SuppressWarnings("unchecked")
			List<Element> childElements = rootElement.elements();
			for (Element perElement : childElements) {
				String id = perElement.attributeValue("id");
				if (id != null && id.equals("10")) {
					rootElement.remove(perElement);
				}
			}

			// 6���������ɵ�XML���ݸ��µ�ԭ����XML�ļ���
			// ������ʽ
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// д��ȥ:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// ��������Ҳ�ᱨ���Ҳ�ʹ�ô���İ�
			xmlWriter.write(document);
			xmlWriter.close();
			// ��һ��Ҫ�ǵùر�!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��XML�ļ���---��---����:
	public static void updateXML() {
		// 1����ȡ������:
		SAXReader reader = new SAXReader();

		// 2����ȡ��������xml�ļ�:
		File xmlFile = new File("./data/student.xml");

		try {
			// 3������xml�ļ�,������Document�ĵ�����:
			Document document = reader.read(xmlFile);

			// 4��ͨ��Document��ȡ���ڵ�:
			Element rootElement = document.getRootElement();

			// 5��ͨ�����ڵ��ȡ������ӽڵ�,�����������������Щ�ӽڵ����Ͳ�����:
			Date date = new Date();
			long time = date.getTime();
			@SuppressWarnings("unchecked")
			List<Element> childElements = rootElement.elements();
			for (Element perElement : childElements) {
				String id = perElement.attributeValue("id");
				if (id != null && id.equals("2")) {
					Element stu_name = perElement.element("stu_name");
					stu_name.setText("���Ǹ��¹���ֵ_" + time);

					// CDATA�ڵ�ĸ��²�����������ɾ��,�����,�����ַ�ʽ�ﵽ�޸ĵ�Ч��:
					Element stu_content = perElement.element("stu_content");
					// �Ƴ�
					perElement.remove(stu_content);
					// ����
					stu_content = perElement.addElement("stu_content");
					stu_content.addCDATA("�޸Ĺ�����ڿ�" + time);

					break;
				}
			}

			// 6���������ɵ�XML���ݸ��µ�ԭ����XML�ļ���
			// ������ʽ
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			outputFormat.setEncoding("GBK");
			outputFormat.setIndent("\t");
			// д��ȥ:
			Writer writer = new FileWriter(xmlFile);
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
					writer, outputFormat);
			// ��������Ҳ�ᱨ���Ҳ�ʹ�ô���İ�
			xmlWriter.write(document);
			xmlWriter.close();
			// ��һ��Ҫ�ǵùر�!

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
