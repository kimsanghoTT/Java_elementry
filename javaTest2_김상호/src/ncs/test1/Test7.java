package ncs.test1;

public class Test7 {

	public static void main(String[] args) {
		
		int 정수배열[] = new int[10];
		int sub = 0;
		for(int i = 0; i<10; i++) {
			정수배열[i] = (int)(Math.random() * 51 +50);

			
		}
		for(int num : 정수배열) {
			System.out.print(num + " ");
		}

	}
}
