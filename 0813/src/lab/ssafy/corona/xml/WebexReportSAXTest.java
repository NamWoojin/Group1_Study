package lab.ssafy.corona.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebexReportSAXTest {
	public static void main(String[] args) {

		File file = new File("blog.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			VirusReportSaxHandler handler = new VirusReportSaxHandler();
			saxParser.parse(file, handler);

			VirusReport vr = handler.getVirusReport();
			System.out.println(vr);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}