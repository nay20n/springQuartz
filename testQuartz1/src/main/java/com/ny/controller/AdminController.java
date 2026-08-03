package com.ny.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ny.common.Quartz;
import com.ny.dto.MemberDto;
import com.ny.service.MemberService;

@Controller
public class AdminController {
	@Autowired
	MemberService mSvc;
	@Autowired
	Quartz quartz;
	
	@RequestMapping("/MemberList")
	public String memberList(HttpSession session, Model model, RedirectAttributes rttr) {
		String loginId = (String)session.getAttribute("loginId");
		
		if(!("admin".equals(loginId))) {
			return "redirect:/Main";
		} else if(session == null || loginId==null) {
			rttr.addFlashAttribute("msg", "로그인 페이지로 넘어갑니다.");
			return "redirect:/Login";
		}
		
		List<MemberDto> dtos = mSvc.getInfos();
		model.addAttribute("dtos", dtos);
		
		return "AdminMemberList";
	}
	
	@RequestMapping("/modifyMember")
	public String memberModify(String id, HttpSession session, RedirectAttributes rttr, Model model) {
		String loginId = (String)session.getAttribute("loginId");
		
		if(!("admin".equals(loginId))) {
			return "redirect:/Main";
		} else if(session == null || loginId==null) {
			rttr.addFlashAttribute("msg", "로그인 페이지로 넘어갑니다.");
			return "redirect:/Login";
		}
		
		MemberDto dto = mSvc.getInfo(id);
		model.addAttribute("dto", dto);
		return "AdminMemberModify";
	}
	
	@PostMapping("/modifyMember")
	public String memberModifyAction(String id, String pw, String name, int point, RedirectAttributes rttr) {
		mSvc.modifyMember(id, pw, name, point);
		rttr.addFlashAttribute("msg", "수정되었습니다.");
		return "redirect:/MemberList";
	}
	
	@GetMapping("/startScheduler")
	public String startScheduler() throws Exception {
		quartz.startScheduler();
		return "redirect:/MemberList";
	}
	
	@GetMapping("/endScheduler")
	public String endScheduler() throws Exception {
		quartz.shutdownScheduler();
		return "redirect:/MemberList";
	}
	
}
