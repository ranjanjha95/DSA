package test;

interface A {

	default void m1() {
		System.out.println("A->m1");
	}

}

public class Java8InterfaceTest implements A {

	public void m1() {
		System.out.println("Java8InterfaceTest -> m1");
		A.super.m1();
	}
	
	public void m2() {
		System.out.println("Java8InterfaceTest -> m2");
		A.super.m1();
	}

	public static void main(String[] args) {

		Java8InterfaceTest obj = new Java8InterfaceTest();

		obj.m2();

	}

}
