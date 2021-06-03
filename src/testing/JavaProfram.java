package testing;

public class JavaProfram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 0;
		int b = 1;

		System.out.println(a);
		System.out.println(b);

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum = a + b;
			a = b;
			b = sum;
			System.out.println(sum);
		}

	}

}
