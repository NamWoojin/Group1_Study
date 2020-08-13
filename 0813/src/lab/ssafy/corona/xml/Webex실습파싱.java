package lab.ssafy.corona.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
 import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import lab.ssafy.corona.xml.VirusReport;

public class Webex실습파싱 {

	public static void main(String[] args) {

		File file = new File("blog.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		String date = "";
		try {
			
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			System.out.println("Root element : " + root.getNodeName());

			NodeList childNodes = root.getChildNodes();

			for(int i = 0; i < childNodes.getLength(); i++){
				Node node = childNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					
					Element element = (Element) node;
					String nodeName = element.getNodeName();
					switch( nodeName ) {
						case "channel" 	: 
							NodeList dateChildNodes = element.getChildNodes();
							for(int j = 0; j < dateChildNodes.getLength(); j++){
								Node childNode = dateChildNodes.item(j);
								if(childNode.getNodeType() == Node.ELEMENT_NODE){
									Element childElement = (Element) childNode;
									String childTextContent = childElement.getTextContent();
									String childNodeName = childElement.getNodeName();
									switch( childNodeName ) {
									case "item" 		: 
										System.out.println("item : "); 
										date += childTextContent; 
										NodeList dateChildNodes2 = childElement.getChildNodes();
										for(int k = 0; k < dateChildNodes2.getLength(); k++){
											Node childNode2 = dateChildNodes2.item(k);
											if(childNode.getNodeType() == Node.ELEMENT_NODE){
												Element childElement2 = (Element) childNode2;
												String childTextContent2 = childElement2.getTextContent();
												String childNodeName2 = childElement2.getNodeName();
												switch( childNodeName2 ) {
												case "title" 	: 
													System.out.println("\ttitle : " + childTextContent2); 
													date = childTextContent2; 
													break;
												case "link" 	: 
													System.out.println("\tlink : " + childTextContent2); 
													date += childTextContent2; 
													break;
												case "description" 	: 
													System.out.println("\tdescription : " + childTextContent2); 
													date += childTextContent2; 
													break;
												case "bloggername" 	: 
													System.out.println("\tbloggername : " + childTextContent2); 
													date += childTextContent2; 
													break;
												case "bloggerlink" 	: 
													System.out.println("\tbloggerlink : " + childTextContent2); 
													date += childTextContent2; 
													break;
												case "postdate" 	: 
													System.out.println("\tpostdate : " + childTextContent2); 
													date += childTextContent2; 
													break;
												}
											}
										}
									break;
								}
							}
						}
						break;
					}
				}
			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
	}
}