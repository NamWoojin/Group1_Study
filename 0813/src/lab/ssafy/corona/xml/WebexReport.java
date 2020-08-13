package lab.ssafy.corona.xml;

public class WebexReport {
	private String title;
	private String link;
	private String date;
	private String description;
	private String bloggername;
	private String bloggerlink;
	private String postdate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBloggername() {
		return bloggername;
	}
	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}
	public String getBloggerlink() {
		return bloggerlink;
	}
	public void setBloggerlink(String bloggerlink) {
		this.bloggerlink = bloggerlink;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	@Override
	public String toString() {
		return "WebexReport [title=" + title + ", link=" + link + ", date=" + date + ", description=" + description
				+ ", bloggername=" + bloggername + ", bloggerlink=" + bloggerlink + ", postdate=" + postdate + "]";
	}
	
}