package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {

	public CharacterController() {
		// TODO Auto-generated constructor stub
	}
	//문자열이 비어있을 떄 예외상황 문구 만들기
	public int countAlpha(String s) throws CharCheckException{
		
		if(s == null || s.isEmpty()) {
			throw new CharCheckException("입력된 문자열이 비어 있습니다.");
		}
		
		if(s.contains(" ")) {
			throw new CharCheckException("입력된 문자열에 공백이 포함되어 있습니다.");
		}
			//match = 있는지 확인
		if(s.matches(".*[0-9_].*")) {
			throw new CharCheckException("입력된 문자열에 숫자, 밑줄이 포함되어 있습니다.");
		}
		//알파벳이 들어오면 무엇인지 확인
		int count = 0;
		
		for(int i = 0; i<s.length(); i++) {
			char c=s.charAt(i);
			//		소문자 a~z				대문자 A~Z
			if((c >= 'a' && c <='z') || (c >= 'A' && c <='Z')) {
				count++;
			}
		}
		return count;

	}
	
	
}
