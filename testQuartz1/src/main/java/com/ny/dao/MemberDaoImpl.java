package com.ny.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ny.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw",pw);
		int cnt = sqlSession.selectOne("com.ny.mapper.MemberMapper.loginCheck", map);
		
		return cnt > 0;
	}

	@Override
	public int signUp(String id, String pw, String name) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw",pw);
		map.put("name",name);
		return sqlSession.insert("com.ny.mapper.MemberMapper.signUp", map);
	}

	@Override
	public MemberDto getInfo(String id) {
		MemberDto dto = sqlSession.selectOne("com.ny.mapper.MemberMapper.getInfo", id);
		return dto;
	}
	@Override
	public int getPoint(String id) {
		return sqlSession.selectOne("com.ny.mapper.MemberMapper.getPoint", id);
	}

	@Override
	public void modifyPoint(String id, int point) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("point", point);
		sqlSession.update("com.ny.mapper.MemberMapper.modifyPoint", map);
	}

	@Override
	public List<MemberDto> getInfos() {
		return sqlSession.selectList("com.ny.mapper.MemberMapper.getInfos");
	}

	@Override
	public void deleteMember(String id) {
		sqlSession.delete("com.ny.mapper.MemberMapper.deleteMember", id);
	}

	@Override
	public void modifyMember(String id, String pw, String name, int point) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw",pw);
		map.put("name", name);
		map.put("point", point);
		System.out.println(point);
		sqlSession.update("com.ny.mapper.MemberMapper.modifyMember", map);
	}


}
