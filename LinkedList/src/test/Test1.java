package test;

class AA {
	
	void m1() {
		System.out.println("A->m1()");
	}
}

class BB extends AA {
	
	int m1(int x, int y) {
		System.out.println("B->m2()");
		return 5;
	}
	
	void m1() {
		System.out.println("B->m2()");
	}
}

public class Test1 {

	
	public static void main(String... args) {
		
		Test1 t = new Test1();
		
		//t.m2(10.0f);
		
		t.m("XYZ", "");
		
	}
	
	
	private void m(String x) {
		System.out.println("m1(String x)");
	}
	
	private void m(String ... x) {
		System.out.println("m1(String ... x)");
	}
	
	private void m2(float x) {
		System.out.println("m1(float x)");
	}
	
	private void m2(Object x) {
		System.out.println("m1(object x)");
	}
	
}
