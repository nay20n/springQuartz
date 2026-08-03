package com.ny.quartz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ny.dto.MemberDto;
import com.ny.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class) // 이 테스트는 스프링과 함께 실행하겠다는 선언.
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

public class MemberServiceTest {
	@Autowired
	MemberService mSvc; 
	
	// 로그인
	@Test
	public void testLoginCheck() {
		// 1. 
		String id = "YG";
		String pw = "12345";
		
		// 2.
		boolean result = mSvc.loginCheck(id, pw);
		
		// 3.
		assertTrue("맞지 않은 id 또는 pw ",result);
	}
	
	// 회원가입
	@Test
	@Transactional
	public void testSignUp() {
		// 1.
		String id = "test";
		String pw = "1234523";
		String name = "테스트";
		
		//2.
		mSvc.signUp(id, pw, name);
		
		//3. 실제로 삽입한 id가 존재하는지 확인
		boolean result = mSvc.loginCheck(id, pw);
		assertTrue("존재하는 id가 아닙니다.",result);
	}
	
	// 회원 정보 가져오기
	@Test
	public void testGetInfo(){
		// 1.
		String id = "test";
		
		//2.
		MemberDto dto = mSvc.getInfo(id);
		
		//3. 가져온 dto가 null이면 안됨.
		assertNotNull("null이면 안됨.", dto);
		System.out.println(dto.getId());
	}
	
	// point 수정
	@Test
	@Transactional
	public void testModifyPoint(){
		// 1.
		String id = "kny";
		int addedPoints = 300000;
		
		//2.
		mSvc.modifyPoint(id, addedPoints);
		
		//3. 가져온 정보가 수정되었ㄲ는지 
		MemberDto dto = mSvc.getInfo(id);
		System.out.println(dto.getPoint());
	}
	
	// 모든멤버의 정보 가져오기 
	@Test
	public void testGetInfos() {
		// 1.
		
		//2.
		List<MemberDto> dtos = mSvc.getInfos();
		
		//3.
		assertNotNull("null이면 안됨.", dtos);
		System.out.println(dtos);
	}
	
	// 멤버 삭제 
	@Test
	@Transactional
	public void testDeleteMember() {
		// 1.
		String id = "테스트Id";
		
		//2.
		mSvc.deleteMember(id);
		
		//3.
		MemberDto dto = mSvc.getInfo(id);
		assertNull("null이여야함.", dto);
	}
	
	// 멤버 수정
	@Test
	@Transactional
	public void testModifyMember() {
		// 1.
		String id = "kny";
		String pw = "1234";
		String name="dd";
		int point = 2000;
		
		//2.
		mSvc.modifyMember(id, pw, name, point);
		
		//3.
		MemberDto dto = mSvc.getInfo(id);
		assertNotNull("null이면 안됨..", dto);
		System.out.println(dto.getName());
	}
	
	// 포인트 하나씩 올리기 
	@Test
	//@Transactional
	public void updateAllPoint() {
		// 1.
		//2.
		mSvc.updateAllPoint();
		//3.
	}
}
