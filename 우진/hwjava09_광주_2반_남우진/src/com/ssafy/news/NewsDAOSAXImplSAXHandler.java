package com.ssafy.news;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImplSAXHandler extends DefaultHandler {
	StringBuilder b;
	boolean flag;
	News n = new News();
	List<News> list = new ArrayList<>();
	private boolean btitle;
	private boolean bdesc;
	private boolean blink;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
		if (qName.equals("title")) {
			btitle = true;
		} else if (qName.equals("description")) {
			bdesc = true;
		}

		else if (qName.equals("link")) {
			blink = true;
		}

		b = new StringBuilder();

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		b.append(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (btitle) {
			n.setTitle(b.toString());
			btitle = false;
		} else if (blink) {
			n.setLink(b.toString());
			blink = false;
		} else if (bdesc) {
			n.setDesc(b.toString());
			flag = true;
			bdesc = false;
		}
		if (flag) {
			list.add(n);
			flag = false;
			n = new News();
		}

	}

	public List<News> getNews() {
		return new ArrayList<News>(list);
	}
}