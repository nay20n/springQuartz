package com.ny.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 인수가 다 있는 생성자
@NoArgsConstructor // 인수가 없는 생성자
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	int point;
}
