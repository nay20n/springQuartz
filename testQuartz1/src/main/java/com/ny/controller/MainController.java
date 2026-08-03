package com.ny.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ny.dto.MemberDto;
import com.ny.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	MemberService mSvc;
	
	@RequestMapping("/Main")
	public String login(HttpSession session, RedirectAttributes rttr, Model model) {
		String loginId = (String)session.getAttribute("loginId");
		
		if(session != null && loginId!=null) {
			MemberDto dto = mSvc.getInfo(loginId);
			model.addAttribute("dto", dto);
			return "Main";
		}
		rttr.addFlashAttribute("msg", "로그인 페이지로 넘어갑니다.");
		return "redirect:/Login";
	}
	
	@RequestMapping("/buyContent")
	public String buyContent(HttpSession session, RedirectAttributes rttr, int addedPoints) {
		String loginId = (String)session.getAttribute("loginId");
		mSvc.modifyPoint(loginId, -addedPoints);
		return "redirect:/Main";
	}
	
	@RequestMapping("/getPoint")
	public String getPoint(HttpSession session, RedirectAttributes rttr, int ranNum) {
		String loginId = (String)session.getAttribute("loginId");
		mSvc.modifyPoint(loginId, ranNum);
		return "redirect:https://koreaisacademy.com";
	}
	
	
	
}
