package com.ny.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny.dao.MemberDao;
import com.ny.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao;
	
	@Override
	public boolean loginCheck(String id, String pw) {
		return mDao.loginCheck(id, pw);
	}

	@Override
	public boolean signUp(String id, String pw, String name) {
		return mDao.signUp(id,pw,name) == 1;
	}

	@Override
	public MemberDto getInfo(String id) {
		MemberDto dto = mDao.getInfo(id);
		return dto;
	}
	
	@Override
	public void modifyPoint(String id, int addedPoints) {
		// 본래의 포인트
		int point = mDao.getPoint(id);
		mDao.modifyPoint(id, point+addedPoints);
	}

	@Override
	public List<MemberDto> getInfos() {
		return mDao.getInfos();
	}

	@Override
	public void deleteMember(String id) {
		mDao.deleteMember(id);
	}

	@Override
	public void modifyMember(String id, String pw, String name, int point) {
		mDao.modifyMember(id, pw, name, point);
	}

	@Override
	public int updateAllPoint() {
		List<MemberDto> list = mDao.getInfos();
		for(MemberDto dto: list) {
			modifyPoint(dto.getId(), +1);
		}
		return list.size();
	}
	
}
