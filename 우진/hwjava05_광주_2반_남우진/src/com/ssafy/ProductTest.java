package com.ssafy;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr proM = ProductMgr.getInstance();
		boolean endFlag = false;
		while(!endFlag) {
			System.out.println("<<Abc 디지털 대리점 재고관리기>>\n1. 상품 추가\n2. 상품 전체 조회\n3. 상품 번호 검색\n4. 특정 가격 이하 상품 검색\n5. 상품 삭제\n0. 종료");
			int answer = sc.nextInt();
			switch(answer) {
			case 1:
				System.out.println("상품의 번호와 이름, 가격과 재고 수를 입력해주세요.");
				proM.add(new Product(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt()));
				System.out.println("상품이 추가되었습니다.\n");
				break;
			case 2:
				proM.list();
				break;
			case 3:
				System.out.println("조회할 상품의 상품번호를 입력해주세요.");
				proM.list(sc.nextInt());
				break;
			case 4:
				System.out.println("조회할 상품 가격의 최대값을 적어주세요.");
				proM.priceList(sc.nextInt());
				break;
			case 5:
				System.out.println("삭제하려는 상품의 상품번호를 입력해주세요.");
				proM.delete(sc.nextInt());
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				endFlag = true;
				break;
			}
		}
		
		
		sc.close();
	}

}
