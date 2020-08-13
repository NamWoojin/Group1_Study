package hwjava07_광주_2반_남우진;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrImpl implements IProductMgr {
	private ArrayList<Product> products;

	private static IProductMgr Instance;
	ArrayList<Product> product;

	private ProductMgrImpl() {
		product = new ArrayList<Product>();
		products = new ArrayList<>();
	}

	public static IProductMgr getInstance() {
		if (Instance == null) {
			Instance = new ProductMgrImpl();
		}
		return Instance;
	}

	@Override
	public void add(Product p) {	//상품 추가
		products.add(p);
	}

	@Override
	public ArrayList<Product> list() {	//상품 정보 전체 검색
		return products;
	}

	@Override
	public Product list(int num) {	//상품 번호로 상품 검색
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd.getId() == num)
				return pd;
		}
		return null;
	}

	@Override
	public ArrayList<Product> list(String name) {	//상품 이름으로 상품 검색
		ArrayList<Product> tempList = new ArrayList<>();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd.getName().contains(name))
				tempList.add(pd);
		}
		return tempList;
	}

	@Override
	public ArrayList<Product> listTV() {	//TV정보 검색
		ArrayList<Product> tempList = new ArrayList<>();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd instanceof TV)
				tempList.add(pd);
		}
		return tempList;
	}

	@Override
	public ArrayList<Product> listRefri() {	//냉장고 정보 검색
		ArrayList<Product> tempList = new ArrayList<>();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd instanceof Refrigerator)
				tempList.add(pd);
		}
		return tempList;
	}

	@Override
	public void delete(int num) {	//상품 번호로 상품 삭제
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd.getId() == num)
				iter.remove();

		}
	}

	@Override
	public int priceAll() {	//전체 재고 상품 금액
		int all = 0;
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			all += pd.getCount() * pd.getPrice();
		}
		return all;
	}

	@Override
	public ArrayList<Product> RefriUpper400L() {
		ArrayList<Product> tempList = new ArrayList<>();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd instanceof Refrigerator && ((Refrigerator) pd).getVolume() >= 400)
				tempList.add(pd);

		}
		
		return tempList;
	}

	@Override
	public ArrayList<Product> TVUpper50inch() {
		ArrayList<Product> tempList = new ArrayList<>();
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product pd = iter.next();
			if (pd instanceof TV && ((TV) pd).getInch() >= 50)
				tempList.add(pd);

		}
		
		return tempList;
	}
	@Override
	public void ChangePrice(int id, int price) {
		for(int i = products.size()-1;i>=0;--i) {
			if(products.get(i).getId() == id)
				products.get(i).setPrice(price);
		}
	}
}
