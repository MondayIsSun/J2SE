package xmlOperation.imoocXML_read.B_saxTest.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import xmlOperation.imoocXML_read.B_saxTest.entity.Book;
import xmlOperation.imoocXML_read.B_saxTest.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {

		// ��ȡһ��SAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			// ͨ��factory��ȡSAXParser��ʵ��
			SAXParser parser = factory.newSAXParser();

			// ����SAXParserHandler����
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("./xmlData/books.xml", handler);
			System.out.println("~��~��~������" + handler.getBookList().size() + "����");

			for (Book book : handler.getBookList()) {
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
				System.out.println("----finish----");
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
