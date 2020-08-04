package com.ssafy;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr proM = ProductMgr.getInstance();
		boolean endFlag = false;
		while(!endFlag) {
			System.out.println("<<Abc ������ �븮�� ��������>>\n1. ��ǰ �߰�\n2. ��ǰ ��ü ��ȸ\n3. ��ǰ ��ȣ �˻�\n4. Ư�� ���� ���� ��ǰ �˻�\n5. ��ǰ ����\n0. ����");
			int answer = sc.nextInt();
			switch(answer) {
			case 1:
				System.out.println("��ǰ�� ��ȣ�� �̸�, ���ݰ� ��� ���� �Է����ּ���.");
				proM.add(new Product(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt()));
				System.out.println("��ǰ�� �߰��Ǿ����ϴ�.\n");
				break;
			case 2:
				proM.list();
				break;
			case 3:
				System.out.println("��ȸ�� ��ǰ�� ��ǰ��ȣ�� �Է����ּ���.");
				proM.list(sc.nextInt());
				break;
			case 4:
				System.out.println("��ȸ�� ��ǰ ������ �ִ밪�� �����ּ���.");
				proM.priceList(sc.nextInt());
				break;
			case 5:
				System.out.println("�����Ϸ��� ��ǰ�� ��ǰ��ȣ�� �Է����ּ���.");
				proM.delete(sc.nextInt());
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				endFlag = true;
				break;
			}
		}
		
		
		sc.close();
	}

}
