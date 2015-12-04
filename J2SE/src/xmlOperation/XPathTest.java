package xmlOperation;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XPathTest {

	/*
	 * DOM4J֧��XPath��ѯ���� 1��XPath����XML�ĵ�������Ϣ������ 2��XPathͨ��---Ԫ��---��---����---���в���
	 * 3��XPath����DOM4J���ҽڵ�Ĺ��� 4��ʹ��XPath���뵼����Ӧ��jar��(jaxen-1.1-beta-6.jar)
	 */

	/*
	 * XPath�﷨��Ҫ:1��---/students/student---ͨ������·��(ָ��root�ڵ㿪ʼ����)
	 * ��ȡstudents���ڵ������е�ֱ���ӽڵ�studentԪ�ض���
	 * 2��---students/student---ͨ�����·��(������)��ȡstudents���ڵ������е�ֱ���ӽڵ�studentԪ�ض���
	 * 3��---//name---��ʾ����nameԪ�ض���,������λ��4��---//@id---��ʾ��ȡ���е�id���Զ���
	 * 5��---//student[@id]---��ȡ���д�id���Ե�studentԪ�ض���
	 * 6��---//student[@id='002']---��ȡ����id���Ե���002��studentԪ�ض���
	 * 7��---//student[age>20]---��ȡ������Ԫ��age��ֵ����20��studentԪ�ض���
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {

		// ��ȡ������:
		SAXReader reader = new SAXReader();

		// ��ȡ��������XML�ļ�:
		File xmlFile = new File("./data/student.xml");

		try {
			// ����������xml�ļ�,������Document�ĵ�����:
			Document document = reader.read(xmlFile);

			// ��ȡroot�ڵ�:
			Element rootElement = document.getRootElement();

			// ͨ��XPathֱ�Ӷ�λ����Ԫ��:
			// ��������:
			String xpath = "/root/student[@id='4']";
			Element studentElement = (Element) document.selectSingleNode(xpath);
			String id = studentElement.attributeValue("id");
			String stuName = studentElement.elementText("stu_name");
			String stuAge = studentElement.elementText("stu_age");
			String stuSex = studentElement.elementText("stu_sex");
			String cdata = studentElement.elementText("stu_content");
			System.out.println(id + "\t" + stuName + "\t" + stuAge + "\t"
					+ stuSex + "\t" + cdata);
			System.out
					.println("------------------------------------------------");

			// ���������Ա�Ϊ�еĽڵ�:
			xpath = "/root/student[stu_sex='��']";
			List<Element> childList = document.selectNodes(xpath);
			for (Element everyElement : childList) {
				id = everyElement.attributeValue("id");
				stuName = everyElement.elementText("stu_name");
				stuAge = everyElement.elementText("stu_age");
				stuSex = everyElement.elementText("stu_sex");
				cdata = everyElement.elementText("stu_content");
				System.out.println(id + "\t" + stuName + "\t" + stuAge + "\t"
						+ stuSex + "\t" + cdata);
			}
			System.out
					.println("------------------------------------------------");

			// ���������Ա�ΪŮ��������Ϊ�����Ľڵ�:
			xpath = "/root/student[stu_sex='Ů' and stu_name='����']";
			/*
			 * "/root/student[stu_sex='Ů' and stu_name='����']"---�߼���
			 * "/root/student[stu_sex='Ů' or stu_name='����']";---�߼���
			 * "/root/student[stu_sex='Ů' not stu_name='����']";---�߼���
			 */
			childList = document.selectNodes(xpath);
			for (Element everyElement : childList) {
				id = everyElement.attributeValue("id");
				stuName = everyElement.elementText("stu_name");
				stuAge = everyElement.elementText("stu_age");
				stuSex = everyElement.elementText("stu_sex");
				cdata = everyElement.elementText("stu_content");
				System.out.println(id + "\t" + stuName + "\t" + stuAge + "\t"
						+ stuSex + "\t" + cdata);
			}
			System.out
					.println("------------------------------------------------");

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
