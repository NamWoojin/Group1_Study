package hwjava07_광주_2반_남우진;

public class TV extends Product{
	private int inch;
	private String displayType;
	
	public TV(int id, String name, int price, int count, int inch, String displayType) {
		super(id, name, price, count);
		this.inch = inch;
		this.displayType = displayType;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + ", displayType=" + displayType + ", Id=" + getId() + ", Name=" + getName()
				+ ", Price=" + getPrice() + ", Count=" + getCount() +"]";
	}

}
