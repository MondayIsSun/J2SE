package xmlOperation.imoocXML_write.D_jdom_create;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTestCreate {

	private void createXML() {

		// 1.����һ�����ڵ�
		Element rss = new Element("rss");
		// 2.Ϊ�ڵ��������
		rss.setAttribute("version", "2.0");
		// 3.����һ��document����
		Document document = new Document(rss);

		Element channel = new Element("channel");
		rss.addContent(channel);
		Element title = new Element("title");
		title.setText("<![CDATA[�Ϻ��ƶ���������ҵ�ٽ�������ʽ���� ]]>");
		channel.addContent(title);

		Format format = Format.getCompactFormat();
		format.setIndent("");
		format.setEncoding("GBK");

		// 4.����XMLOutputter�Ķ���
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			// 5.����outputer��document����ת����xml�ĵ�
			outputer.output(document, new FileOutputStream(new File("rssnews.xml")));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JDOMTestCreate creater = new JDOMTestCreate();
		creater.createXML();
	}

}
