package com.ssafy.news;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list;
	
	public List<News> getNewsList(String url){
		File file = new File(url);
		if(list == null)
			connectNews(url);
		
	   
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			NewsDAOSAXImplSAXHandler handler = new NewsDAOSAXImplSAXHandler();
			saxParser.parse(url, handler);
			list = handler.getNews();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public News search(int index) {
		return null;
	}
	
	private void connectNews(String url) {
		list = new ArrayList<News>();
;	}
}
