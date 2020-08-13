package hwjava07_광주_2반_남우진;

public class Product {
	int id;
	String name;
	int price;
	int count;
	
	public Product(int id, String name, int price, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	
}
