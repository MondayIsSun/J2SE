package xmlOperation.imoocXML_write.C_dom4j_create;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {

	private void createXML() {
		// 1.����document���󣬴�������xml�ĵ�
		Document document = DocumentHelper.createDocument();
		// 2.�������ڵ�rss
		Element rss = document.addElement("rss");
		// 3.��rss�ڵ������version����
		rss.addAttribute("version", "2.0");
		// 4.�����ӽڵ㼰�ڵ�����
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![CDATA[�Ϻ��ƶ���������ҵ�ٽ�������ʽ���� ]]>");
		// 5.��������xml�ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		// 6.����xml�ļ�
		File file = new File("src/res/rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			// �����Ƿ�ת�壬Ĭ��ֵ��true������ת��
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOM4JTest().createXML();
	}

}
