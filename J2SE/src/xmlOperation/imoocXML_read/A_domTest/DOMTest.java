package xmlOperation.imoocXML_read.A_domTest;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//������������import��Ϣ
//import java.io.IOException;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NamedNodeMap;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;

public class DOMTest {

	/**
	 * ʹ��javaԭ���ķ�ʽ ---> Dom�ķ�ʽ����XML
	 */

	public static void main(
			String[] args) {

		// 1������һ��DocumentBuilderFactory�Ķ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// 2������DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();

			// 3��ͨ��DocumentBuilder�����parser��������books.xml�ļ�����ǰ��Ŀ��
			// ע�⵼org.w3c.dom.Document
			Document document = db.parse("./xmlData/books.xml");

			// ��ȡ����book�ڵ�ļ���
			NodeList bookList = document.getElementsByTagName("book");

			// ͨ��nodelist��getLength()�������Ի�ȡbookList�ĳ���
			System.out.println("һ����" + bookList.getLength() + "����");

			// ����ÿһ��book�ڵ�
			for (int i = 0; i < bookList.getLength(); i++) {

				System.out.println("=================���濪ʼ������" + (i + 1) + "���������=================");

				// ͨ�� item(i)���� ��ȡһ��book�ڵ㣬nodelist������ֵ��0��ʼ
				Node book = bookList.item(i);

				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("�� " + (i + 1) + "���鹲��" + attrs.getLength() + "������");

				// ����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item(index)������ȡbook�ڵ��ĳһ������
					Node attr = attrs.item(j);
					// ��ȡ������
					System.out.print("��������" + attr.getNodeName());
					// ��ȡ����ֵ
					System.out.println("--����ֵ" + attr.getNodeValue());
				}

				// ǰ�᣺�Ѿ�֪��book�ڵ�����ֻ����1��id����
				// ��book�ڵ����ǿ������ת����ת����Element����
				// Element book = (Element) bookList.item(i);
				// ͨ��getAttribute("id")������ȡ����ֵ
				// String attrValue = book.getAttribute("id");
				// System.out.println("id���Ե�����ֵΪ" + attrValue);

				// ����book�ڵ���ӽڵ�
				NodeList childNodes = book.getChildNodes();
				System.out.println("��" + (i + 1) + "���鹲��" + childNodes.getLength() + "���ӽڵ�");

				// ����childNodes��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				// �ر�ע�⣬��ʵ����Ҳ�ǽڵ㣬����������������ͼ��
				// ���о������ַ�ʽ����xml��ѿհ���ϢҲ������һ���ڵ�Ŷ --->�ڵ�nodeName�ķ���ֵ��#text ---> �����Ϊʲô��ӡ��������Ϣ��9���ڵ�
				for (int k = 0; k < childNodes.getLength(); k++) {
					// ���ֳ�text���͵�node�Լ�element���͵�node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// ��ȡ��element���ͽڵ�Ľڵ���
						System.out.print("��" + (k + 1) + "���ڵ�Ľڵ�����" + childNodes.item(k).getNodeName());
						// ��ȡ��element���ͽڵ�Ľڵ�ֵ
						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getFirstChild().getNodeValue());
						// System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getTextContent());
					}
				}
				System.out.println("======================����������" + (i + 1) + "���������=================");
			}
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}