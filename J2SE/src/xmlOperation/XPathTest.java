package xmlOperation;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XPathTest {

	/*
	 * DOM4J支持XPath查询语言 1、XPath是在XML文档查找信息的语言 2、XPath通过---元素---和---属性---进行查找
	 * 3、XPath简化了DOM4J查找节点的过程 4、使用XPath必须导入相应的jar包(jaxen-1.1-beta-6.jar)
	 */

	/*
	 * XPath语法简要:1、---/students/student---通过绝对路径(指从root节点开始查找)
	 * 获取students根节点下所有的直接子节点student元素对象
	 * 2、---students/student---通过相对路径(？？？)获取students根节点下所有的直接子节点student元素对象
	 * 3、---//name---表示所有name元素对象,不考虑位置4、---//@id---表示获取所有的id属性对象
	 * 5、---//student[@id]---获取所有带id属性的student元素对象
	 * 6、---//student[@id='002']---获取所有id属性等于002的student元素对象
	 * 7、---//student[age>20]---获取所有子元素age的值大于20的student元素对象
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {

		// 获取解析器:
		SAXReader reader = new SAXReader();

		// 获取待解析的XML文件:
		File xmlFile = new File("./data/student.xml");

		try {
			// 解析器解析xml文件,并返回Document文档对象:
			Document document = reader.read(xmlFile);

			// 获取root节点:
			Element rootElement = document.getRootElement();

			// 通过XPath直接定位查找元素:
			// 查找属性:
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

			// 查找所有性别为男的节点:
			xpath = "/root/student[stu_sex='男']";
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

			// 查找所有性别为女并且名字为张三的节点:
			xpath = "/root/student[stu_sex='女' and stu_name='张三']";
			/*
			 * "/root/student[stu_sex='女' and stu_name='张三']"---逻辑与
			 * "/root/student[stu_sex='女' or stu_name='张三']";---逻辑或
			 * "/root/student[stu_sex='女' not stu_name='张三']";---逻辑非
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
