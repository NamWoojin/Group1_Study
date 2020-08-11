package hwjava07_광주_2반_남우진;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IProductMgr proM = ProductMgrImpl.getInstance();
		boolean endFlag = false;
		while (!endFlag) {
			System.out
					.println("<<Abc 디지털 대리점>>\n\n1. 상품 추가\n2. 상품 조회\n3. 상품 가격 변경\n4. 상품 삭제\n5. 전체 재고 상품 금액 조회\n0. 종료");
			int answer = sc.nextInt();
			switch (answer) {
			case 1:
				System.out.println("추가할 상품을 선택하세요.\n1. TV\n2. 냉장고");
				int N = sc.nextInt();
				if (N == 1) {
					System.out.println("추가할 TV의 Id, 이름, 가격, 수량, 인치, 디스플레이 타입을 입력해주세요.");
					proM.add(new TV(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next()));
					System.out.println("추가되었습니다.\n");
				} else if (N == 2) {
					System.out.println("추가할 냉장고의 Id, 이름, 가격, 수량, 용량을 입력해주세요.");
					proM.add(new Refrigerator(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
					System.out.println("추가되었습니다.\n");
				}

				break;
			case 2:
				System.out.println(
						"1. 전체 상품 조회\n2. 상품 번호 조회\n3. 상품명 조회\n4. TV 목록 조회\n5. 냉장고 목록 조회\n6. 50인치 이상 TV 목록 조회\n7. 400리터 이상 냉장고 목록 조회");
				int K = sc.nextInt();

				switch (K) {
				case 1:
					print(proM.list());
					break;
				case 2:
					System.out.println("조회할 상품의 번호를 입력하세요.");
					System.out.println(proM.list(sc.nextInt()).toString());
					break;
				case 3:
					System.out.println("조회할 상품명을 입력하세요.");
					print(proM.list(sc.next()));
					break;
				case 4:
					print(proM.listTV());
					break;
				case 5:
					print(proM.listRefri());
					break;
				case 6:
					print(proM.TVUpper50inch());
					break;
				case 7:
					print(proM.RefriUpper400L());
					break;
				}
				break;
			case 3:
				System.out.println("가격을 변경하려는 상품의 Id와 변경할 가격을 입력하세요.");
				proM.ChangePrice(sc.nextInt(), sc.nextInt());
				break;
			case 4:
				System.out.println("삭제할 상품의 Id를 입력하세요.");
				proM.delete(sc.nextInt());
				break;
			case 5:
				System.out.println("전체 재고 상품의 금액은 " + proM.priceAll() + "원 입니다.");
				break;
			case 0:
				System.out.println("종료합니다.");
				endFlag = true;
				break;
			}
		}
		sc.close();
	}

	private static void print(ArrayList<Product> pds) {
		Iterator<Product> iter = pds.iterator();
		while (iter.hasNext())
			System.out.println(iter.next().toString());
	}

}
