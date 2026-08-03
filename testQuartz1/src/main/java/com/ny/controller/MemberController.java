package com.ny.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ny.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mSvc;
	
	//로그인 페이지 이동
	@RequestMapping("/Login")
	public String login() {
		return "Login";
	}
	// 로그인
	@PostMapping("/Login")
	public String loginAction(String id, String pw, RedirectAttributes rttr, HttpSession session) {
		
		if("admin".equals(id)) { // 관리자 계정일 때
			session.setAttribute("loginId", id);
			return "redirect:/MemberList";
		}
		
		boolean loginResult = mSvc.loginCheck(id, pw);
		if(loginResult) { // 로그인 성공
			session.setAttribute("loginId", id);
			return "redirect:/Main";
		}
		rttr.addFlashAttribute("msg", "아이디/비밀번호를 다시 확인하세요");
		return "redirect:/Login";
	}
	// 로그아웃
	@GetMapping("/Logout")
	public String logoutAction(RedirectAttributes rttr, HttpSession session) {
		session.removeAttribute("loginId");
		rttr.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/Login";
	}
	
	
	//회원가입 페이지 이동
	@RequestMapping("/SignUp")
	public String signUp() {
		return "SignUp";
	}
	// 회원가입
	@PostMapping("/SignUp")
	public String signUpAction(String id, String pw, String name, RedirectAttributes rttr) {
		boolean result = mSvc.signUp(id, pw, name);
		if(result) {
			rttr.addFlashAttribute("msg", "가입되었습니다. 로그인 해주세요.");
			return "redirect:/Login";
		} else {
			rttr.addFlashAttribute("msg", "가입의 실패하였습니다.");
			return "SignUp";
		}
	}
	// 회원 삭제 
	@GetMapping("/deleteMember")
	public String deleteMember(String id) {
		mSvc.deleteMember(id);
		return "redirect:/MemberList";
	}
}
