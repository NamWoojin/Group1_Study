package com.ssafy;

public class ProductMgr {
	private Product[] products;
	int index;
	
	private static ProductMgr instance;
	private ProductMgr() {
		products = new Product[100];
		index = 0;
	}
	public static ProductMgr getInstance() {
		if(instance == null)
			instance = new ProductMgr();
		return instance;
	}
	
	public void add(Product p) {
		products[index] = p;
		++index;
	}
	public void list() {
		for(int i = 0;i<index;++i) {
			System.out.println(products[i].toString());
		}
	}
	public void list(int num) {
		for(int i = 0;i<index;++i) {
			if(products[i].getId() == num)
				System.out.println(products[i].toString());
		}
	}
	public void delete(int num) {
		for(int i = 0;i<index;++i) {
			if(products[i].getId() == num) {
				for(int j = i+1;j<index;++j)
					products[j-1] = products[j];
				--index;
			}
		}
	}
	public void priceList(int price) {
		for(int i = 0;i<index;++i) {
			if(products[i].getPrice()<= price)
				System.out.println(products[i].toString());
		}
	}
}
