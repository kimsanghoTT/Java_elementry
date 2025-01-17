package com.kh.AddressEx;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressEx3 {

	public static void main(String[] args) {
		try {
			//getByName은 영어주소와 숫자주소를 한번에 가져옴
			InetAddress 주소이름 = InetAddress.getByName("www.google.com");
			System.out.println("getByName으로 구글 가져온 이름 : " + 주소이름);
			
			//getLocalHost를 이용해서 내 집주소를 가져오고 집주소에 대한 상세정보확인	
			//내 집주소에 대한 영어주소이름, 내 컴퓨터 숫자주소
			InetAddress 내집주소 = InetAddress.getLocalHost();
			System.out.println("내 집주소 : " + 내집주소);
			
			//한 컴퓨터에서 2개 이상의 컴퓨터에 동시에 파일을 전송하는 방법
			//멀티캐스트 주소 여부 확인
			//byte[] 주소를 활용한 객체 가져오기
			//루프백 주소 : 현재 컴퓨터 자체를 가리키고 외부 연결을 하지않고 내 컴퓨터 사용
			byte[] ipAddress = {127,0,0,1};
			System.out.println(내집주소);
			InetAddress byAddress = InetAddress.getByAddress(ipAddress);
			System.out.println(byAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//나의 컴퓨터 이름과 자리번호 확인하기
		try {
			InetAddress 내컴 = InetAddress.getLocalHost();
			System.out.println(내컴);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
