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
		
		//��ȡ������
		SAXReader reader = new SAXReader();
		
		//��ȡ��������XMl�ļ�
		File xmlFile = new File("./data/student.xml");
		
		try {
			//�ý�����������ȡ����XML�ļ�����ȡ������XML�ļ����document����
			Document document = reader.read(xmlFile);
			/* һ������ڴ�������ļ�����Ҫ�����쳣
			 * ����ոտ�ʼ�����ڴ�������ļ�
			 * ���Կ�ʼ�����쳣
			 */
			
			//��ȡroot���ڵ�
			Element rootElement = document.getRootElement();
			
			//ͨ�����ڵ�������µ��ӽڵ�
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
		// 1:��ȡ������
		SAXReader reader = new SAXReader();

		// 2��������Ҫ����XML�ļ�,������һ��Document���ĵ�Ԫ��
		File xmlFile = new File("./data/student.xml");

		try {
			Document document = reader.read(xmlFile);

			// 3��ͨ��Document�ڵ��ȡ���ڵ�
			Element rootElement = document.getRootElement();

			// 4��ͨ�����ڵ��ȡ���ڵ�������ӽڵ�
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

			// 4������һ��StudentԪ��,���Ҹ��ӵ�RootElement��
			Element studentElement = rootElement.addElement("student");
			studentElement.addAttribute("id", "889");

			// 5�������ӽڵ㣬�����ӽڵ���ΪStudent����Ԫ��
			Element stu_name = studentElement.addElement("stu_name");
			stu_name.setText("�����ӵ�Stu_name");

			Element stu_age = studentElement.addElement("stu_age");
			stu_age.setText("10");

			Element stu_sex = studentElement.addElement("stu_sex");
			stu_sex.setText("��");

			Element stu_content = studentElement.addElement("stu_content");
			stu_content.addCDATA("CATE�е�ֵ*&(^^%*f89123<aa>M<bb><Mcc>");

			// �������ɵ�XML��������д�ص�XML�ļ��С�
			// ������ʽ
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
					stu_name.setText("�޸�����");

					Element stu_sex = studentElement.element("stu_sex");
					stu_sex.setText("Man");

					// CDATA�Ľڵ������ɾ��������ӣ��ﵽ�޸ĵĽ��
					Element stu_content = studentElement.element("stu_content");
					// �Ƴ�
					studentElement.remove(stu_content);
					// ����
					stu_content = studentElement.addElement("stu_content");
					stu_content.addCDATA("�޸Ĺ�����ڿ�123123123asdfasdf&");

					break;
				}
			}
			// ����д�ص�XML�ļ��С�
			// �������ɵ�XML��������д�ص�XML�ļ��С�
			// ������ʽ
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
			// ����д�ص�XML�ļ��С�
			// �������ɵ�XML��������д�ص�XML�ļ��С�
			// ������ʽ
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
