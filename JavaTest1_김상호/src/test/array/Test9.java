package test.array;

public class Test9 {

	public static void main(String[] args) {
		
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		int max = array[0][0];
		int min = array[0][0];
		for(int i = 0; i <array.length; i++) {
			for(int j = 0; j<array.length; j++) {
				if(max< array[i][j]) {
					max = array[i][j];
				}
				if(min > array[i][j]) {
					min = array[i][j];
				}
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
