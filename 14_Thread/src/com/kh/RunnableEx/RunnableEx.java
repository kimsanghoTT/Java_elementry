package com.kh.RunnableEx;
/*
	Runnable
	- Thread 대신 여러개를 가져오거나 상속받을 때 사용하는 인터페이스
*/	

public class RunnableEx implements Runnable {

	public void run() {
		System.out.println("스레드 실행중");
		
		try {
			
			
			Thread.sleep(3000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("스레드 종료");
		
	}
}
