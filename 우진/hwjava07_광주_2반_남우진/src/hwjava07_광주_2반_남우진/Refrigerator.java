package hwjava07_광주_2반_남우진;


public class Refrigerator extends Product{
	private int volume;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Refrigerator(int id, String name, int price, int count, int volume) {
		super(id, name, price, count);
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Refrigerator [volume=" + volume + ", Id=" + getId() + ", Name=" + getName() + ", Price="
				+ getPrice() + ", Count=" + getCount() +"]";
	}
	

}
