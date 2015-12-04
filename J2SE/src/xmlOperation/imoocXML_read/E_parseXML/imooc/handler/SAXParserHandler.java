package xmlOperation.imoocXML_read.E_parseXML.imooc.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xmlOperation.imoocXML_read.E_parseXML.imooc.entity.Book;

public class SAXParserHandler extends DefaultHandler {

	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	int bookIndex = 0;

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			bookIndex++;
			book = new Book();
			String value = attributes.getValue("id");
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				if (attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			bookList.add(book);
			book = null;
		}
		else if (qName.equals("name")) {
			book.setName(value);
		}
		else if (qName.equals("author")) {
			book.setAuthor(value);
		}
		else if (qName.equals("year")) {
			book.setYear(value);
		}
		else if (qName.equals("price")) {
			book.setPrice(value);
		}
		else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String temp = new String(ch, start, length);
		if (!temp.trim().equals("")) {
			value = temp;
		}
	}
}
