package test.controller;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9숫자 입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("1~9숫자 입력2 : ");
		int num2 = sc.nextInt();
		
		int sum = num1 + num2;
		int abs = num1 - num2;		
		int times = num1 * num2;
		int div = num1 / num2;
		
		System.out.println("합 : " + sum);
		System.out.println("차 : " + abs);
		System.out.println("곱 : " + times);
		if(num2 == 0 ||  div < 0) {
			System.out.println("나누기 : 0");
		}else {
			System.out.println("나누기 : " + div);

		}
	}
}
