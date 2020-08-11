package hwjava07_광주_2반_남우진;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p);
	public ArrayList<Product> list();
	public Product list(int num);
	public ArrayList<Product> list(String name);
	public ArrayList<Product> listTV();
	public ArrayList<Product> listRefri();
	public ArrayList<Product> RefriUpper400L();
	public ArrayList<Product> TVUpper50inch();
	public void ChangePrice(int id,int price);
	public void delete(int num);
	public int priceAll();
}
