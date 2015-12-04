package xmlOperation;


import java.io.File;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XPathOperation {
	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		File xmlFile = new File("./data/student.xml");
		try {
			Document document = reader.read(xmlFile);
			Element rootElement = document.getRootElement();

			// ͨ��XPath�����ҽڵ�

			// ��������
			String XPath = "/root/student[@id='5']";
			Element studentElement = (Element) document.selectSingleNode(XPath);
			String id = studentElement.attributeValue("id");
			String stu_name = studentElement.elementText("stu_name");
			String stu_age = studentElement.elementText("stu_age");
			String stu_sex = studentElement.elementText("stu_sex");
			String stu_content = studentElement.elementText("stu_content");
			System.out.println(id + "\t" + stu_name + "\t" + stu_age + "\t"+ stu_sex + "\t" + stu_content);
			//rootElement.remove(studentElement);
			
			
			// ���������Ա�Ϊ�еĽڵ�
			XPath = "/root/student[stu_sex='��']";
			List<Element> childList = document.selectNodes(XPath);
			for (Element studentElementX : childList) {
				id = studentElementX.attributeValue("id");
				stu_name = studentElementX.elementText("stu_name");
				stu_age = studentElementX.elementText("stu_age");
				stu_sex = studentElementX.elementText("stu_sex");
				stu_content = studentElementX.elementText("stu_content");
				System.out.println(id + "\t" + stu_name + "\t" + stu_age + "\t"
						+ stu_sex + "\t" + stu_content);
			}
			// ���������Ա�ΪŮ�Ľڵ㣬��������Ϊadmin
			XPath = "/root/student[stu_sex='Ů' and stu_name='admin']";
			childList = document.selectNodes(XPath);
			for (Element studentElementX : childList) {
				id = studentElementX.attributeValue("id");
				stu_name = studentElementX.elementText("stu_name");
				stu_age = studentElementX.elementText("stu_age");
				stu_sex = studentElementX.elementText("stu_sex");
				stu_content = studentElementX.elementText("stu_content");
				System.out.println(id + "\t" + stu_name + "\t" + stu_age + "\t"
						+ stu_sex + "\t" + stu_content);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
		}
	}
}

