package com.ssafy;

public class MyFuncIFTest {

	public static void main(String[] args) {
		{
			int a = 10, b = 20;
			MyFuncIF obj = new MyFuncIFImpl();
			int result = obj.add(a, b);
			System.out.println(result);
		}
		{
			int a = 10, b = 20;
			MyFuncIF obj = new MyFuncIF() {

				@Override
				public int add(int i, int j) {
					return i + j;
				}
			};
			int result = obj.add(a, b);
			System.out.println(result);
		}
		{
			int a = 10, b = 20;
			MyFuncIF obj = (i, j) -> i + j;
			int result = obj.add(a, b);
			System.out.println(result);
		}
		{
			MyFunc.m((i, j) -> i + j);
			MyFunc.m((i, j) -> i * j);
			MyFunc.m((i, j) -> i - j);
		}
	}
}

class MyFunc{
	static void m(MyFuncIF p) {
		System.out.println(p.add(5, 3));
	}
}