package com.ny.dao;

import java.util.List;

import com.ny.dto.MemberDto;

public interface MemberDao {
	/**
	 * 로그인 확인
	 * @param id
	 * @param pw
	 * @return 로그인 성공 시 true
	 */
	boolean loginCheck(String id, String pw);
	
	/**
	 * 회원 삽입
	 * @param id
	 * @param pw
	 * @param name
	 * @return 삽입된 행 
	 */
	int signUp(String id, String pw, String name);
	
	/**
	 * 회원 정보 가져오기
	 * @param id : 가져올 회원의 id
	 * @return : 가져온 회원의 정보들
	 */
	MemberDto getInfo(String id);
	
	/**
	 * 회원의 포인트 가져오기
	 * @param id
	 * @return : 가져온 포인트
	 */
	int getPoint(String id);
	
	/**
	 * 포인트수정 함수
	 * @param id : 수정할 사람의 id
	 * @param point : 바꿀 point
	 */
	void modifyPoint(String id, int point);
	
	/**
	 * 모든 멤버의 정보 가져오기
	 * @return 모든 멤버의 정보
	 */
	List<MemberDto> getInfos();
	
	/**
	 * 멤버 삭제 
	 * @param id : 삭제할 멤버의 id
	 */
	void deleteMember(String id);
	
	/**
	 * 멤버 정보 수정
	 * @param pw : 바꿀 pw
	 * @param name : 바꿀 name
	 * @param point : 바꿀 point
	 * @param id : 바꾸고 싶은 id
	 */
	void modifyMember(String id, String pw, String name, int point);
}
